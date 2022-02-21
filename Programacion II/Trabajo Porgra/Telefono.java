//Hay que importar stdlib lo que pasa es que estoy en visual studio y no hace falta ponerlo
//Autor: Daniel Sanchez Ferrari
public class Telefono {
    private String tf;
    private String Indicativo;
    Telefono(){}
    
    Telefono(String telefono, String Indicativo){
        this.tf = telefono;
        this.Indicativo = Indicativo;
    }

    public String toString(){
        return Indicativo + ":" + tf;
    }

    public String tf(){
        return tf;
    }

    public String indicativo(){
        return Indicativo;
    }

    public void ponerTf(String tf2){
        tf = tf2;
    }

    public void ponerIndicativo(String indicativo){
        indicativo = Indicativo;
    }

    public boolean equals (Telefono x){
        return tf == x.tf && Indicativo == x.Indicativo;
    }

    public String linea(){
        return "[" +  Indicativo + " ; " + tf + "]" ;
    } 
    
    public Telefono leer(){
        Telefono x;
        x = new Telefono();
        x.Indicativo = StdIn.readString();
        x.tf = StdIn.readString();
        return x;
    }
}
