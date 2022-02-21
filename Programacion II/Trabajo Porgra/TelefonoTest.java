//Autor: Daniel Sanchez Ferrari
public class TelefonoTest {
    public static Telefono tf1, tf2, tf3;
    static void resetear(){
        tf1 = new Telefono("1111", "Casa");
        tf2 = new Telefono("2222", "Trabajo");
        tf3 = new Telefono("3333", "Movil");
    }

    static void toStringtest(){
        System.out.println(tf1.toString());
        System.out.println(tf2.toString());
        System.out.println(tf3.toString());
        
        
    }

    public static void main(String[] args) {
        resetear();
        toStringtest();
        

    }
}
