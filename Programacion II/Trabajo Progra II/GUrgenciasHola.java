public class GUrgenciasHola {
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

  public static void resetearPacientes ()
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
  public static void clasificarPacientes ()
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
  
  public static void resetearRegistro ()
  {
    resetearPacientes();
    clasificarPacientes();
    cde0  = new GUrgencias();
    cde1  = new GUrgencias();
    cde5  = new GUrgencias();
    cde10 = new GUrgencias();
  }

  public static void cargarRegistro ()
  {
    cde1.insertar(p1);
    
    cde5.insertar(p9);  // No vitales
    cde5.insertar(p7);
    cde5.insertar(p6);
    cde5.insertar(p8);
    cde5.insertar(p10);
    
    cde10.insertar(p3);  // De todo
    cde10.insertar(p4);
    cde10.insertar(p2);
    cde10.insertar(p1);
    cde10.insertar(p5);
    cde10.insertar(p9);
    cde10.insertar(p7);
    cde10.insertar(p6);
    cde10.insertar(p8);
    cde10.insertar(p10);
  }
}
