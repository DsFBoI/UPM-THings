package pruebas;
import vehiculos.*;

/** 
 * Pruebas de la clase Vehiculos.
 * 
 * @author Javier Galve
 */

public class VehiculosTest
{
  
  public static Coche c1, c2;
  public static Microbus m1, m2;
  public static Furgoneta f1, f2;
  public static Camion cm1, cm2;
  public static Vehiculo v1, v2;
  public static Vehiculos vs1, vs2, vs3;
  
  public static void resetear ()
  {
    VehiculoTest.resetear();
    c1 = VehiculoTest.c1;
    c2 = VehiculoTest.c2;   

    m1 = VehiculoTest.m1;
    m2 = VehiculoTest.m2;

    f1 = VehiculoTest.f1;
    f2 = VehiculoTest.f2;

    cm1 = VehiculoTest.cm1;
    cm2 = VehiculoTest.cm2;
    
    vs1 = new Vehiculos();
    vs1.registrarVehiculo(c1);
    vs1.registrarVehiculo(f2);
    
    vs2 = new Vehiculos();
    vs2.registrarVehiculo(c2);
    vs2.registrarVehiculo(cm1);
    vs2.registrarVehiculo(cm2);
     
    vs3 = new Vehiculos();
    vs3.registrarVehiculo(c1);
    vs3.registrarVehiculo(m1);
    vs3.registrarVehiculo(f1);
    vs3.registrarVehiculo(m2);
   
  }
  public static boolean test_buscaVehiculo ()
  {
    resetear();
    return 
      vs1.buscaVehiculo("1A").equals(c1) && vs1.buscaVehiculo("6F").equals(f2) && 
      vs2.buscaVehiculo("2B").equals(c2) && vs2.buscaVehiculo("7G").equals(cm1) && 
      vs2.buscaVehiculo("8H").equals(cm2) && vs3.buscaVehiculo("1A").equals(c1) && 
      vs3.buscaVehiculo("3C").equals(m1) && vs3.buscaVehiculo("5E").equals(f1) && 
      vs3.buscaVehiculo("4D").equals(m2);
  }
  public static void test_mostrarTodosLosPrecios ()
  {
    resetear();
    System.out.println("vs1 = \n" + vs1.mostrarTodosLosPrecios(2));
    System.out.println("vs2 = \n" + vs2.mostrarTodosLosPrecios(4));
    System.out.println("vs3 = \n" + vs3.mostrarTodosLosPrecios(3));
  }
  public static void main (String args[])
  {   
    resetear();
    System.out.println("test_buscaVehiculo(): " + test_buscaVehiculo() + "\n");
    test_mostrarTodosLosPrecios();
  }
} 