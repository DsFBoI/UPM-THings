/**
 * Prueba de Agenda<br>
 * @version 1.0     
 * @author Javier Galve
 */
public class AgendaTest
{
  public static Agenda agenda0;
  public static Agenda agenda1;
  public static Agenda agenda2;
  public static Agenda agenda3;
  public static Agenda agenda5;
  
  public static void resetear(){
    ContactoTest.resetear();

     agenda0 = new Agenda();

     agenda1 = new Agenda();
     agenda1.anhadirContacto(ContactoTest.c1);

     agenda2 = new Agenda();
     agenda2.anhadirContacto(ContactoTest.c1);
     agenda2.anhadirContacto(ContactoTest.c2);

     agenda3 = new Agenda();
     agenda3.anhadirContacto(ContactoTest.c1);
     agenda3.anhadirContacto(ContactoTest.c2);
     agenda3.anhadirContacto(ContactoTest.c3);
    
    agenda5 = new Agenda();
    agenda5.anhadirContacto(ContactoTest.c1);
    agenda5.anhadirContacto(ContactoTest.c2);
    agenda5.anhadirContacto(ContactoTest.c3);
    agenda5.anhadirContacto(ContactoTest.c4);
    agenda5.anhadirContacto(ContactoTest.c5);  
  }
  static void mostrar ()
  {
    System.out.println("agenda0 = \n" + agenda0);
    System.out.println("agenda1 = \n" + agenda1);
    System.out.println("agenda2 = \n" + agenda2);
    System.out.println("agenda3 = \n" + agenda3);
    System.out.println("agenda5 = \n" + agenda5);
  }
  public static boolean test1buscarNombre ()
  {
    resetear();
    return agenda2.buscarNombre("Gumersindo").equals(ContactoTest.c2);
  }
  public static boolean test2buscarNombre ()
  {
    resetear();
    return agenda2.buscarNombre("Luciano") == null;
  }
  public static boolean test3buscarNombre ()
  {
    resetear();
    return agenda5.buscarNombre("Ermisinda").equals(ContactoTest.c4);
  }
  public static boolean testBuscarNombre ()
  {
    return 
      test1buscarNombre() &&
      test2buscarNombre() &&
      test3buscarNombre();
  }
  public static boolean test1buscarTelefono ()
  {
    resetear();
    return agenda2.buscarTelefono("222").equals(ContactoTest.c2);
  }
  public static boolean test2buscarTelefono ()
  {
    resetear();
    return agenda1.buscarTelefono("333") == null;
  }
  public static boolean test3buscarTelefono ()
  {
    resetear();
    return agenda5.buscarTelefono("444").equals(ContactoTest.c4);
  }
  public static boolean testBuscarTelefono ()
  {
    return 
      test1buscarTelefono() &&
      test2buscarTelefono() &&
      test3buscarTelefono();
  }
  public static void testModificarContacto ()
  {
    resetear();
    System.out.println("agenda3 = \n" + agenda3);
    System.out.println("agenda3.modificarContacto(Sandalio, 000);" + "\n");
    agenda3.modificarContacto("Sandalio", "000");    
    System.out.println("agenda3 = \n" + agenda3);
  }
  public static void testQuitar ()
  {
    resetear();
    System.out.println("\n" + "agenda3 = \n" + agenda3);
    System.out.println("agenda3.quitar(c3);" + "\n");
    agenda3.quitar(ContactoTest.c3);    
    System.out.println("agenda3 = \n" + agenda3);
  }
  public static void main (String[] args)
  {
    
    resetear();
    mostrar();
    System.out.println(agenda2.buscarNombre("333") == null);
    System.out.println(agenda5.nombresContactos());
    //
    System.out.println("testBuscarNombre() = " +
                        testBuscarNombre() + "\n");
    //
    System.out.println("testBuscarTelefono() = " +
                        testBuscarTelefono() + "\n");
    //
    testModificarContacto();
    //
    testQuitar();
  }
}