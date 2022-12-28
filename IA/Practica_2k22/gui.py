import sys
from PyQt5.Qt import *
from QImageLabel import QImageLabel
from AlgoritmoAestrella import AlgoritmoAEstrella
from station import station
import json

# VARIABLES GLOBALES
# aqui metemos las diferentes lineas que hay del metro, en este caso estaran las lienas M1(Verde), M2(Rojo) y M3(Amarillo)
g_Lines = []
# Criterios para el algoritmo a estrella dara un camino dependiendo de los resultados
g_Criterios = ['Distancia', 'Transbordo']

#apertura de ficheros
def parse(data):
    with open(data, 'r') as f:
        dataDict = json.load(f)
        f.close()
    return dataDict


# esta funcion cargaremos todas las estaciones mediante su clase creada y su json que tiene los valores nombre,x ,y e
# y lo que queremos que mida el botton que ira en las cordenadas dadas en la imagen
def getStationsFromFile(filename):
    data = parse(filename)
    line_colors = [l['color'] for l in data['lines']]
    line_nodes = [l['nodes'] for l in data['lines']]
    list = []
    for i in range(3):
        nodes = []
        for n in line_nodes[i]:
            node = station(n['name'], n['x'], n['y'], n['rad'])
            nodes.append(node)
        list.append(nodes)
    return list, line_colors




class App(QDialog):

    def __init__(self):
        super().__init__()




        # Codigo para alinear tanto las cajas como los f
        self.setGeometry(10, 10, 0, 0)
        self.setFixedSize(self.size())

        # Modify these with the results from the A* Algorithm
        self.distancia = QLabel('0 Km')
        self.transbordos = QLabel('0')

        # Qt.Widgets que usaremos para marcar las cajas que habra en la representacion grafica
        # se declaran las comboBoxes que ens si son unas cajas de texto en las que ira el nombre de la estacion,
        # esta no saldra excepto la de critBox que nos hara
        self.fromLine = QComboBox()
        self.destLine = QComboBox()
        self.fromStation = QComboBox()
        self.destStation = QComboBox()
        self.crit = QComboBox()
        self.err = QErrorMessage(self)

        # Algoritmo
        self.A = None

        windowLayout = QGridLayout()

        # Panel general donde se pondra la imagen y la caja donde iran los datos a devolver
        self.preparePanel()
        windowLayout.addWidget(self.panel, 0, 0)

        self.setLayout(windowLayout)
        self.show()

    #funcion que prepara el panel y el layout que tomara la interfaz
    def preparePanel(self):
        # Layout Stuff
        self.panel = QGroupBox()
        layout = QGridLayout()

        self.x = 0
        self.y = 0
        station_data, g_Lines = getStationsFromFile('metro.json')

        #Hacemos un array de todas las estaciones disponibles
        self.stations = []
        for ln in station_data:
            nestacion = [""]
            for node in ln:
                nestacion.append(node.name)
            self.stations.append(nestacion)

        # Add items to ComboBoxes
        # Por defecto ponemos para la linea verde, ya se cambiara cuando se actualicen los comboboxes
        self.fromLine.addItems(g_Lines)
        self.destLine.addItems(g_Lines)
        self.fromStation.addItems(self.stations[0])
        self.destStation.addItems(self.stations[0])
        self.crit.addItems(g_Criterios)


        # Resultados y seleccion de criterios
        resultados = QGroupBox()
        resLayout = QGridLayout()
        self.crit.currentIndexChanged.connect(self.onComboUpdate)
        resLayout.addWidget(QLabel('Criterio: '), 0, 0)
        resLayout.addWidget(self.crit, 0, 1)

        resLayout.addWidget(QLabel('Distancia:'), 2, 0)
        resLayout.addWidget(self.distancia, 2, 1)
        resLayout.addWidget(QLabel('NºTransbordos:'), 3, 0)
        resLayout.addWidget(self.transbordos, 3, 1)
        resultados.setLayout(resLayout)
        layout.addWidget(resultados, 2, 0, 2, 4)

        #Imagen del Metro

        self.metroimg = QImageLabel(self, 'metro.jpg', station_data)
        layout.addWidget(self.metroimg, 0, 4, 7, 5)

        #Boton de Busqueda
        searchButton = QPushButton('Buscar')
        searchButton.clicked.connect(self.onClick)
        layout.addWidget(searchButton, 2, 0, 5, 4)

        self.panel.setLayout(layout)



    # onComboLineUpdate event wrapper
    def onComboLineUpdate(self):
        self.fromStation.clear()
        self.destStation.clear()
        self.fromStation.addItems(self.stations[self.fromLine.currentIndex()])
        self.destStation.addItems(self.stations[self.destLine.currentIndex()])


    # onComboUpdate event wrapper
    def onComboUpdate(self):

        # Prevents error that occurred when both comboboxes were cleared
        if self.fromStation.count() < 1 or self.destStation.count() < 1:
            return

        fromLn = self.fromLine.currentIndex()
        destLn = self.destLine.currentIndex()
        fromIdx = self.fromStation.currentIndex()
        destIdx = self.destStation.currentIndex()


        fromIdx -= 1
        destIdx -= 1

        if fromIdx >= 0:
            self.metroimg.MarcarOrg(fromLn, fromIdx)
        if destIdx >= 0:
            self.metroimg.MarcarDest(destLn, destIdx)

        self.metroimg.repaint()


    def onClick(self):
        criterio = self.crit.currentIndex()
        fromIdx = self.fromStation.currentIndex()
        destIdx = self.destStation.currentIndex()
        fromLn = self.fromLine.currentIndex()
        destLn = self.destLine.currentIndex()
        if fromIdx == 0 or destIdx == 0:
            self.err.showMessage("Elija una estación origen y una estacion destino.")
            return

        origen = self.stations[fromLn][fromIdx]
        destino = self.stations[destLn][destIdx]
        self.A = AlgoritmoAEstrella(origen, destino, g_Criterios[criterio])
        path, dist, trans = self.A.inicializacion()

        print("DEBUG: result is ", path, dist, trans)
        self.metroimg.reset()
        for i in range(len(path) - 2):
            name = path[i + 1]
            self.metroimg.selectStation(name)

        self.distancia.setText("%s Km" % f'{dist:.3f}')
        self.transbordos.setText("%d" % trans)

        self.metroimg.repaint()




if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = App()
    sys.exit(app.exec_())
