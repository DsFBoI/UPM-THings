package pruebas;
import vehiculos.*;
import empresa.*;
/**
 * Tester de la empresa de alquiler de vehículos.
 *
 * @author Javier Galve
 */
public class EmpresaTest
{  
  public static Empresa e1, e2, e3;
  
  public static Coche c1, c2, c3;
  public static Microbus m1, m2, m3;
  public static Furgoneta f1, f2;
  public static Camion cm1, cm2;
  
  public static Peticion p1, p2, p3, p4, p5, p6, p7, p8;

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
    c3 = new Coche("9I", 5);
    m3 = new Microbus("10J", 8);
    
    p1 = new Peticion("111", Vehiculo.COCHE, 1); 
    p2 = new Peticion("222", Vehiculo.COCHE, 1); 
    p3 = new Peticion("333", Vehiculo.MICROBUS, 1); 
    p4 = new Peticion("444", Vehiculo.MICROBUS, 1); 
    p5 = new Peticion("555", Vehiculo.FURGONETA, 1); 
    p6 = new Peticion("666", Vehiculo.FURGONETA, 1); 
    p7 = new Peticion("777", Vehiculo.CAMION, 1); 
    p8 = new Peticion("888", Vehiculo.CAMION, 1); 

    e1 = new Empresa(new Vehiculo[]{c1, c2, m1, m2, f1, f2, cm1, cm2, c3, m3}, 
                     new Peticion[]{p1, p2, p3, p4, p5, p6, p7, p8, p1, p1, p1, p1});
    e2 = new Empresa(new Vehiculo[]{c1, c2, m1, m2, f1, f2, cm1, cm2, c3, m3}, 
                     new Peticion[]{});
    e3 = new Empresa(new Vehiculo[]{}, 
                     new Peticion[]{p1, p2, p3, p4, p5, p6, p7, p8, p1, p1, p1, p1});
  }
  public static void test_carga ()
  {
    resetear();
    System.out.println("empresa e1: \n" + e1);
    e1.cargarFlota();    
    System.out.println("empresa e1: \n" + e1);    
  }
  public static void test1_alquilarVehiculos ()
  {
    resetear();
    System.out.println("empresa e1: \n" + e1);
    e1.cargarFlota();    
    e1.alquilarVehiculos();
    System.out.println("empresa e1: \n" + e1);    
  }
  public static void test2_alquilarVehiculos ()
  {
    resetear();
    System.out.println("empresa e3: \n" + e3);
    e3.cargarFlota();    
    e3.alquilarVehiculos();
    System.out.println("empresa e3: \n" + e3);    
  }
  public static void test1_mejorCliente ()
  {
    resetear();
    System.out.println("empresa e1: \n" + e1);
    System.out.println("mejor cliente: " + e1.mejorCliente()); 
    System.out.println("empresa e1: \n" + e1);
  }
  public static void test2_mejorCliente ()
  {
    resetear();
    System.out.println("empresa e2: \n" + e2);
    try
    {
      System.out.println("mejor cliente: " + e2.mejorCliente());    
    }
    catch (RuntimeException e)
    {
      System.out.println("No hay ninguna peticion de alquiler.");
    }
  }
  public static void main (String[] args)
  {
    test_carga ();
    test1_alquilarVehiculos();
    test2_alquilarVehiculos();
    test1_mejorCliente();
    test2_mejorCliente();
  }
} 
  