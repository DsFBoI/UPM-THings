package pruebas;
import vehiculos.Vehiculo;
import empresa.Peticion;
/** 
 * Pruebas de la clase Peticion.
 * 
 * @author Javier Galve
 */
public class PeticionTest
{
  public static Peticion p1, p2, p3, p4, p5, p6, p7, p8;

  public static void resetear ()
  {
    p1 = new Peticion("111", Vehiculo.COCHE, 1); 
    p2 = new Peticion("222", Vehiculo.COCHE, 1); 

    p3 = new Peticion("333", Vehiculo.MICROBUS, 1); 
    p4 = new Peticion("444", Vehiculo.MICROBUS, 1); 

    p5 = new Peticion("555", Vehiculo.FURGONETA, 1); 
    p6 = new Peticion("666", Vehiculo.FURGONETA, 1); 
    
    p7 = new Peticion("777", Vehiculo.CAMION, 1); 
    p8 = new Peticion("888", Vehiculo.CAMION, 1); 
  }
  public static void mostrar ()
  {
    System.out.println("p1 = " + p1);
    System.out.println("p2 = " + p2);
    System.out.println("p3 = " + p3);
    System.out.println("p4 = " + p4);
    System.out.println("p5 = " + p5);
    System.out.println("p6 = " + p6);
    System.out.println("p7 = " + p7);
    System.out.println("p8 = " + p8);
  }
  public static void main (String[] args) 
  {
    resetear();
    mostrar();
  }  
}