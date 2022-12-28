import json
from math import sin, cos, atan2, sqrt, radians
import networkx as net


def parse(data):
    with open(data, 'r') as f:
        dataDict = json.load(f)
        f.close()
    return dataDict


class AlgoritmoAEstrella:
    def __init__(self, origen, destino, criterio):
        super().__init__()
        self.origen = origen
        self.destino = destino
        self.criterio = criterio
        self.net = net.Graph()
        self.actual = None

        estacionesParse = parse('coordenadas.json')  # en coordenadas ponemos la info del archivo coordenadas

        self.estaciones = []
        for n in estacionesParse:
            self.estaciones.append(n['Estacion'])  # aqui se ponen solo las estaciones

        aristasParse = parse('aristas.json')  # en aristas ponemos la info de las aristas

        self.aristas = []
        for n in aristasParse:
            self.aristas.append((n['Origen'], n['Destino'], n['Criterio'][criterio]))

        self.openlst = []
        self.closedlst = []
        self.deflst = []

    def inicializacion(self):
        self.net.add_nodes_from(self.estaciones)
        self.net.add_weighted_edges_from(self.aristas)  # añadimos las aristas como aristas que unen las estaciones
        self.net.nodes[self.origen]['G'] = 0
        self.net.nodes[self.origen]['F'] = 0  # inicializo

        coords = parse('coordenadas.json')
        for n in coords:
            self.net.nodes[n['Estacion']]['Coord'] = [n['Latitud'], n['Longitud']]

        return self.algoritmo()


    def getTodo(self, actual, hijo):  # esta funcion hace la H, la G y la F

            #esta parte te calcula la H
        coordAct = self.net.nodes[self.destino]['Coord']  # pillo las cordenadas del actual
        coordHijo = self.net.nodes[hijo]['Coord']  # same version hijo

        latAct = radians(coordAct[0])
        lonAct = radians(coordAct[1])
        lonHj = radians(coordHijo[1])
        latHj = radians(coordHijo[0])

        lonDif = lonHj - lonAct
        latDif = latHj - latAct

        n = sin(latDif / 2) ** 2 + cos(latHj) * cos(latAct) * sin(lonDif / 2) ** 2
        d = 2 * atan2(sqrt(n), sqrt(1 - n))
        H = 6371 * d

        G = self.net[actual][hijo]['weight']

        self.net.nodes[hijo]['G'] = self.net.nodes[actual]['G'] + G
        self.net.nodes[hijo]['H'] = self.net.nodes[actual]['G'] + H
        self.net.nodes[hijo]['F'] = self.net.nodes[hijo]['G'] + self.net.nodes[hijo]['H']

    def vuelta(self, actual, origen): # metodo recursivo, vamos yendo del destino al origen a traves de padres
        self.deflst.append(actual)
        if actual != origen:
            self.vuelta(self.net.nodes[actual]['Padre'], origen)

    def algoritmo(self):
        self.openlst.append(self.origen)

        while len(self.openlst) > 0:
            self.act = self.openlst[0]
            if len(self.openlst) > 1:
                for i in self.openlst:  # obtenemos la menor F
                    if self.net.nodes[self.act]['F'] > self.net.nodes[i]['F']:
                        self.act = i
            self.openlst.remove(self.act)
            self.closedlst.append(self.act)

            if self.act == self.destino:  # hemos llegado al final
                self.openlst.clear()  # al vaciar openlst el while se acabara y salimos del bucle

            else:
                adyList = list(self.net[self.act])  # hago una lista de los nodos adyacentes del nodo actual
                for vecino in adyList:
                    if self.openlst.count(vecino) == 0 and self.closedlst.count(vecino) == 0:
                        self.getTodo(self.act, vecino)
                        self.net.nodes[vecino]['Padre'] = self.act
                        self.openlst.append(vecino)

                    elif self.openlst.count(vecino) > 0:
                        if self.net.nodes[vecino]['G'] < self.net.nodes[self.act]['G']:
                            self.getTodo(self.act, vecino)
                            self.net.nodes[vecino]['Padre'] = self.act

        self.vuelta(self.act, self.origen)
        self.deflst.reverse()  # ponemos la lista al reves, ya que deflst tiene del destino a origen y queremos al reves
        return self.final()

    def final(self):
        distancia = 0  # aqui se tiene la distancia total del origen al destino
        transbordo = 0  # igual pero con transbordos
        origenFin = None
        destinoFin = None
        primero = True
        aristasParse = parse('aristas.json')

        for n in self.deflst:
            if primero:
                origenFin = n
                primero = False

            else:
                destinoFin = n
                for j in aristasParse:
                    if (j['Origen'] == origenFin and j['Destino'] == destinoFin)or (j['Origen'] == destinoFin and j['Destino'] == origenFin):
                        distancia += j['Criterio']['Distancia']
                        transbordo += j['Criterio']['Transbordo']
                origenFin = destinoFin

        return self.deflst, distancia, transbordo








