//Hay que importar stdlib lo que pasa es que estoy en visual studio y no hace falta ponerlo
//Autor Daniel Sanchez Ferrari
public class Contacto {
    private String nombre;
    private String tf;
    private String email;
    Contacto(){}
    Contacto(String nombre, String tf, String email){
        this.tf = tf;
        this.email = email;
        this.nombre = nombre;
    } 
    public String getTf() {
        return tf;
    }
    public String getEmail() {
        return email;
    }
    public String getNombre() {
        return nombre;
    }

    public String toString (){
        return ("nombre:" + nombre +'\n' + "telefono:" + tf + '\n' + "email:" + email);
    }
    
    public String nombre(){
        return nombre;
    }

    public String tf(){
        return tf;
    }

    public String email(){
        return email;
    }

    public void ponerNombre(String nombre2){
        nombre = nombre2;
    }

    public void ponerTf(String tf2){
        tf = tf2;
    }

    public void ponerEmail(String email2){
        email = email2;
    }

    public boolean equals (Contacto x){
        return email == x.email && tf == x.tf && nombre == x.nombre;
    }

    public Contacto Copia(){
        Contacto copia;
        copia = new Contacto(nombre,tf,email);
        return copia;
    }

    public String linea(){
        return "[" + nombre + " ; " + tf + " ; " + email + "]" ;
    } 

    public Contacto leer(){
        Contacto x;
        x = new Contacto();
        x.nombre = StdIn.readString();
        x.tf = StdIn.readString();
        x.email = StdIn.readString();
        return x;
    }

}
