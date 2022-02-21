//Autor Daniel Sanchez Ferrari
public class Contacto_2Test {
    public static Contacto_2 con1,con2,con3;
    static void resetear(){
        con1 = new Contacto_2("Daniel",TelefonoTest.tf1 ,TelefonoTest.tf2 ,TelefonoTest.tf3 , "danielsf02@gmail.com");
        con2 = new Contacto_2();
        con3 = new Contacto_2();
    }


    static void Funciones(){
        System.out.println(con1.toString());
        System.out.println(con1.nombre());
        System.out.println(con1.telefono_1());
        System.out.println(con1.telefono_2());
        System.out.println(con1.telefono_3());
        System.out.println(con1.email());
        System.out.println(con1.linea());
    }

    static void FuncionesPoner(){
        Telefono nuevo_1 = new Telefono("9999","Casa");
        Telefono nuevo_2 = new Telefono("8888","Trabajo");
        Telefono nuevo_3 = new Telefono("7777","Movil");
        con2.ponerEmail("pepe@gmail.com");
        con2.ponerTelefono_1(nuevo_1);
        con2.ponerTelefono_2(nuevo_2);
        con2.ponerTelefono_3(nuevo_3);
        con2.ponerNombre("Pepe");
        System.out.println(con2.toString());

    }

    static void EqualsYClone(){
        System.out.println(con1.equals(con1.Clone()));
        System.out.println(con2.equals(con1));
        
    }
    static void leer(){
        con3 = con3.leer();
        System.out.println(con3.toString());
    }


    public static void main(String[] args) {
        TelefonoTest.resetear();
        resetear();
        Funciones();
        FuncionesPoner();
        EqualsYClone();
        leer();
    }
}
