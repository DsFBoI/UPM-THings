//Hay que importar stdlib lo que pasa es que estoy en visual studio y no hace falta ponerlo
//Autor Daniel Sanchez Ferrari
public class Contacto_2 {
    private String nombre;
    private Telefono tf1;
    private Telefono tf2;
    private Telefono tf3;
    private String email;
    private Telefono tf = new Telefono();
    Contacto_2(){}
    Contacto_2(String nombre, Telefono tf1, Telefono tf2, Telefono tf3,String email){
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.email = email;
        this.nombre = nombre;
    }

    public String toString(){
        return("nombre:" + nombre +'\n' + tf1 +'\n' + tf2 +'\n' + tf3 + '\n' + "email:" + email);    
    }

    public String nombre(){
        return nombre;
    }

    public Telefono telefono_1(){
        return tf1;
    }

    public Telefono telefono_2(){
        return tf2;
    }

    public Telefono telefono_3(){
        return tf3;
    }

    public String email(){
        return email;
    }

    public void ponerNombre(String nombre2){
        nombre = nombre2;
    }

    public void ponerTelefono_1(Telefono telefono_1){
        tf1 = telefono_1;
    }

    public void ponerTelefono_2(Telefono telefono_2){
        tf2 = telefono_2;
    }

    public void ponerTelefono_3(Telefono telefono_3){
        tf3 = telefono_3;
    }

    public void ponerEmail(String email2){
        email = email2;
    }

    public boolean equals (Contacto_2 x){
        return email == x.email && tf1 == x.tf1 && tf2 == x.tf2 && tf3 == x.tf3 && nombre == x.nombre;
    }
    
    public Contacto_2 Clone(){
        Contacto_2 copia = new Contacto_2(nombre,tf1,tf2,tf3,email);
        return copia;
    }

    public String linea(){
        return "[" + nombre + " ; " + tf1 + " ; "+ tf2 + " ; "+ tf3 + " ; " + email + "]" ;
    } 

    public Contacto_2 leer(){
        Contacto_2 x;
        x = new Contacto_2();
        x.nombre = StdIn.readString();
        x.tf1 = tf.leer();
        x.tf2 = tf.leer();
        x.tf3 = tf.leer();
        x.email = StdIn.readString();
        return x;
    }

}
