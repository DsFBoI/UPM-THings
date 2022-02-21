package pruebas;
import vehiculos.*;
/** 
 * Pruebas de la clase Vehiculo y sus hijas.
 * 
 * @author Javier Galve
 */
public class VehiculoTest
{
  public static Coche c1;
  public static Coche c2;

  public static Microbus m1;
  public static Microbus m2;

  public static Furgoneta f1;
  public static Furgoneta f2;

  public static Camion cm1;
  public static Camion cm2;
  
  public static Vehiculo v1;
  public static Vehiculo v2;
  
  public static void resetear ()
  {
    c1 = new Coche("1A", 2);
    c2 = new Coche("2B", 4);   

    m1 = new Microbus("3C", 10);
    m2 = new Microbus("4D", 7);

    f1 = new Furgoneta("5E", 4);
    f2 = new Furgoneta("6F", 8);

    cm1 = new Camion("7G", 2);
    cm2 = new Camion("8H", 4);

    v1 = new Vehiculo("9I");
    v2 = new Vehiculo("0J");
  }
  public static void mostrar ()
  {
    System.out.println("c1 = " + c1);
    System.out.println("c2 = " + c2);
    System.out.println("m1 = " + m1);
    System.out.println("m2 = " + m2);
    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);
    System.out.println("cm1 = " + cm1);
    System.out.println("cm2 = " + cm2);
    System.out.println("v1 = " + v1);
    System.out.println("v2 = " + v2);
  }
  static boolean test_precioAlquiler ()
  {
    return 
      c1.precioAlquiler(2) == 106 && c2.precioAlquiler(2) == 109 && 
      m1.precioAlquiler(2) == 138 && m2.precioAlquiler(2) == 127.5 && 
      f1.precioAlquiler(2) == 180 && f2.precioAlquiler(2) == 260 && 
      cm1.precioAlquiler(2) == 180 && cm2.precioAlquiler(2) == 220 && 
      v1.precioAlquiler(2) == 100 && v2.precioAlquiler(2) == 100;

      
  }
  public static void main (String[] args) 
  {
    resetear();
    mostrar();
    System.out.println("test_precioAlquiler() = " + test_precioAlquiler()); 
  }
  
}