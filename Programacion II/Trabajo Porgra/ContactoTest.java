public class ContactoTest {
    public static Contacto c1, c2, c3, c4, c5, c6;
    
    static void resetear(){
        c1 = new Contacto("Abilio", "111", "abilio@abilio.es");
        c2 = new Contacto("Gumersindo", "222", "gumersindo@gumersindo.es");
        c3 = new Contacto("Sandalio", "333", "sandalio@sandalio.es");
        c4 = new Contacto("Ermisinda", "444", "ermisinda@ermisinda.es");
        c5 = new Contacto("Luzdivina", "555", "luzdivina@luzdivina.es");
        c6 = new Contacto("Tranquilina", "666", "tranquilina@tranquilina.es");
    }


    static void testVariables(){
        System.out.println("***Print de variables y el toString***");
        System.out.println(c1.toString());
        System.out.println(c1.nombre());
        System.out.println(c1.tf());
        System.out.println(c1.email());

    }


    static void PonerFunctionsTest(){
        System.out.println("***Poner Functions***");
        c2.ponerNombre("Pepe Perez");
        c2.ponerTf("65123929");
        c2.ponerEmail("pepe.perez@gmail.com");
        System.out.println(c2.toString());
    }

    static void CopiaTest(){
        System.out.println("***Copia:***");
        System.out.println(c1.Copia().toString());
        System.out.println(c2.Copia().toString());
        c4 = c1.Copia();
    }

    static void equalsTest(){
        System.out.println("***Equals:***");
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c4));
    }

    static void LineaTest(){
        System.out.println("***Linea:***");
        System.out.println(c1.linea());
        System.out.println(c2.linea()); 
    }

    static void LeerTest(){
        System.out.println("***Leer:***");
        c3 = c3.leer();
        System.out.println(c3.toString());
    }



    public static void main(String[] args) {
        resetear();
        testVariables();
        PonerFunctionsTest();
        CopiaTest();
        equalsTest();
        LineaTest();
        LeerTest();
    }

    
}
