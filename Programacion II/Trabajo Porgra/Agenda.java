//Autor Daniel Sanchez Ferrari
public class Agenda {
    private ColDeContactos cdc = new ColDeContactos();
    Agenda(){}

    
    public String toString(){
        return cdc.toString();
    }

    public boolean estavacia(){
        return cdc.size() == 0;    
    }

    public boolean estallena(){
        return cdc.size() == cdc.maxSize();  
    }

    public void anhadirContacto(Contacto x){
        cdc.add(x);
    }

    public int size(){
        return cdc.size();
    }

    public Contacto get(int position){
        return cdc.get(position);
    } 

    public void set(int pos , Contacto elem){
        cdc.set(pos, elem);
    }

    public String nombresContactos(){
        String a = "";
        for(int i = 0; i<cdc.size();i++){
           a = a + cdc.get(i).getNombre() + '\n';
        }
        return a;
    }

    public Contacto buscarNombre(String a){
        Contacto b;
        boolean found = true;
        b = null;
        for ( int  i = 0 ; i < cdc.size() && found; i++ ){
            if (cdc.get(i).getNombre() == a){
                b = get(i);
                found = false;

            }
        }
        return b;
    }


    public Contacto buscarTelefono(String a){
        Contacto b;
        b = null;
        boolean found = true;
        for ( int  i = 0 ; i < cdc.size() && found; i++ ){
            if (cdc.get(i).getTf() == a){
                b = get(i);
                found = false;
            }
        }
        return b;
    }

    public void modificarContacto(String nombre, String tf){
        boolean found = true;
        for ( int  i = 0 ; i < cdc.size() && found; i++ ){
            if (cdc.get(i).getNombre() == nombre){
                cdc.get(i).ponerTf(tf);
                found = false;
            }
        }
    }

    public void quitar (Contacto x){
        boolean found = true;
        for ( int  i = 0 ; i < cdc.size() && found; i++ ){
            if(x.equals(cdc.get(i))){
                cdc.removeElementAt(i);
                found = false;
            }
        }
    }

    



    
}
