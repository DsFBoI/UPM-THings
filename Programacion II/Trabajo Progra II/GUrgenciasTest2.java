/**
 * Prueba de la implementacion de GUrgencias<br>
 * @since 22/4/2021 > 28/4/21
 * @version 1.1
 * @author JMB
 */
public class GUrgenciasTest2  // en construcci�n
{
  static IPaciente p1;
  static IPaciente p2;
  static IPaciente p3;
  static IPaciente p4;
  static IPaciente p5;
  static IPaciente p6;
  static IPaciente p7;
  static IPaciente p8;
  static IPaciente p9;
  static IPaciente p10;

  static IGUrgencias cde0;
  static IGUrgencias cde1;
  static IGUrgencias cde5;
  static IGUrgencias cde10;
  
//  DECLARACIONES DE PRUEBAS  ---------------------------------------

  public static void resetear_Pacientes ()
  {
    p1 = new Paciente("Elinela",10,111);
    p2 = new Paciente("Pablo",20,222);
    p3 = new Paciente("Ida",30,333);
    p4 = new Paciente("Daniel",40,444);
    p5 = new Paciente("Sharif",50,555);
    p6 = new Paciente("Elinela",60,666);
    p7 = new Paciente("Pablo",70,777);
    p8 = new Paciente("Ida",80,888);
    p9 = new Paciente("Laura",90,999);
    p10 = new Paciente("Karla",100,100);
  }
  public static void clasificar_Pacientes ()
  {
    p1.setPrioridad(1);
    p2.setPrioridad(1);
    p3.setPrioridad(2);
    p4.setPrioridad(3);
    p5.setPrioridad(3);
    p6.setPrioridad(0);
    p7.setPrioridad(0);
    p8.setPrioridad(0);
    p9.setPrioridad(0);
    p10.setPrioridad(0);
  }
  
  public static void resetear_Registro ()
  {
    resetear_Pacientes();
    clasificar_Pacientes();
    cde0  = new GUrgencias();
    cde1  = new GUrgencias();
    cde5  = new GUrgencias();
    cde10 = new GUrgencias();
  }

  public static void cargar_Registro ()
  {
    cde1.insertar(p1);
    
    cde5.insertar(p9);  // No vitales
    cde5.insertar(p7);
    cde5.insertar(p6);
    cde5.insertar(p8);
    cde5.insertar(p10);
    
    cde10.insertar(p3);  // De todo
    cde10.insertar(p8);
    cde10.insertar(p2);
    cde10.insertar(p1);
    cde10.insertar(p5);
    cde10.insertar(p9);
    cde10.insertar(p7);
    cde10.insertar(p6);
    cde10.insertar(p4);
    cde10.insertar(p10);
  }

  public static void mostrar ()
  {
    System.out.println("cde0  -> " + cde0);
    System.out.println("cde1  -> " + cde1);
    System.out.println("cde5  -> " + cde5);
    System.out.println("cde10 -> " + cde10);
  }
  static void prueba1_primeroEnRegistroVacio () 
  {
    resetear_Registro();
    cargar_Registro();
    try 
    {
      System.out.println("Primero: " + cde0.primero());
    }
    catch (RuntimeException e) 
    {
      System.out.println ("ERROR --> No hay primero de COLA");
    }
  }
  static void prueba2_primeroEnRegistroVaciado ()
  {
    resetear_Registro();
    cargar_Registro();
    cde1.borrar();
    try 
    {
      System.out.println("Primero: " + cde1.primero());
    }
    catch (RuntimeException e) 
    {
      System.out.println ("ERROR --> No hay primero de COLA");
    }
  }
  static boolean prueba3_primero ()
  {
    resetear_Registro();
    cargar_Registro();
    IPaciente prueba3_1 = cde1.primero();   // p1
    IPaciente prueba3_2 = cde5.primero();   // p6
    IPaciente prueba3_3 = cde10.primero();  // p5
    cde5.insertar(p3);
    IPaciente prueba3_4 = cde5.primero();   // p3
    boolean prueba3 =
      prueba3_1.equals(p1) && prueba3_2.equals(p6) &&
      prueba3_3.equals(p5) && prueba3_4.equals(p3);
    if (!prueba3) mostrar();
    return prueba3;
  }
  static boolean prueba4_Insertar ()
  {
    resetear_Registro();
    cargar_Registro();
    
    cde0.insertar(p6);
    IPaciente prueba4_1 = cde0.primero();   // p6
    cde1.insertar(p5);
    cde1.insertar(p4);
    IPaciente prueba4_2 = cde1.primero();   // p5
    IPaciente joven = new Paciente("Meddur",20,222);
    joven.setPrioridad(0);
    cde5.insertar(joven);
    IPaciente prueba4_3 = cde5.primero();   // joven
    cde5.insertar(p1);
    cde5.insertar(p3);
    IPaciente prueba4_4 = cde5.primero();   // p3
    boolean prueba4 =
      prueba4_1.equals(p6) && prueba4_2.equals(p5) &&
      prueba4_3.equals(joven) && prueba4_4.equals(p3);
    if (!prueba4) mostrar();
    return prueba4;
  }
  static boolean prueba5_Borrar ()
  {
    resetear_Registro();
    cargar_Registro();
    
    cde0.borrar();                          // se queda como esta
    boolean prueba5_1 = cde0.estaVacio();
    cde1.borrar();                          // se vacia
    boolean prueba5_2 = cde1.estaVacio();
    cde5.borrar();
    cde5.borrar();
    cde5.borrar();
    IPaciente prueba5_3 = cde5.primero();   // p9
    for (int i = 1; i < 7; i++) cde10.borrar();
    IPaciente prueba5_4 = cde10.primero();  // p7
    boolean prueba5 =
      prueba5_1 && prueba5_2 &&
      prueba5_3.equals(p9) && prueba5_4.equals(p7);
    if (!prueba5) mostrar();
    return prueba5;
  }

//  PROGRAMA PRINCIPAL  ---------------------------------------------
  
  public static void main(String[] args)
  {
    resetear_Registro();
    cargar_Registro();
    mostrar();
    System.out.println("PRUEBA1_primeroEnRegistroVacio(): cde0  " );
    prueba1_primeroEnRegistroVacio();
    System.out.println("PRUEBA2_primeroEnRegistroVaciado(): cde1  " );
    prueba2_primeroEnRegistroVaciado();
    System.out.println("PRUEBA3_Primero(): " + prueba3_primero());
    System.out.println("PRUEBA4_Insertar(): " + prueba4_Insertar());
    System.out.println("PRUEBA5_Borrar(): " + prueba5_Borrar());
  }

}