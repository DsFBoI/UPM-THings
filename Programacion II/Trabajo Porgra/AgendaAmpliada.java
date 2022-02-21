//Hay que importar stdlib lo que pasa es que estoy en visual studio y no hace falta ponerlo
//Autor Daniel Sanchez Ferrari
public class AgendaAmpliada {

    static Agenda leer(String archivo) {

        Agenda nueva1 = new Agenda();
        In in = new In(archivo);
        String[] conts = in.readAllLines();
        for (int i = 0; i < conts.length; i++){
            String cont = conts[i];
            String[] elem = cont.split(";");
            nueva1.anhadirContacto(new Contacto(elem[0], elem[1], elem[2]));
        }

        return nueva1;

        
    }


    static void escribir(Agenda ax, String archivo){
        
        Out outputS = new Out(archivo);
        for (int i = 0; i < ax.size(); i ++){
            outputS.println(ax.get(i).linea());
        }

        outputS.close();


    }

    static void ordenar(Agenda x){

        String[] conts = new String[x.size()];
        for ( int i = 0; i < x.size(); i++){
            conts[i] = x.get(i).linea();
            java.util.Arrays.sort(conts);
        }

        for ( int i = 0; i < conts.length; i ++){
            String[] data = conts[i].split(";");
            x.set(i, new Contacto(data[0], data[1], data[2]));
        }


    }




}