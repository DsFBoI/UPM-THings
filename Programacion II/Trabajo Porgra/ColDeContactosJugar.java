/**
 * Pruebas informales de ColDeContactos<br>
 * @version 1.0   
 * @author Javier Galve
 */
public class ColDeContactosJugar
{
  
  public static void prueba01 ()
  {
    ColDeContactos vacia;
    vacia = new ColDeContactos();
    System.out.println("vacia = " + vacia);   
    System.out.println();
  }
  public static void prueba02 ()
  {
    ContactoTest.resetear();
    ColDeContactos lista02 = new ColDeContactos();
    lista02.add(ContactoTest.c1);
    lista02.add(ContactoTest.c2);
    lista02.add(ContactoTest.c3);
    System.out.println("lista02 = " + "\n" + lista02);   
  }
  public static void main (String[] args)
  {
    prueba01();
    prueba02();
  }

}