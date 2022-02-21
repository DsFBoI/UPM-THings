/**
 * Prueba de AgendaAmpliada<br>
 * @version 1.0     
 * @author Javier Galve
 */
public class AgendaAmpliadaTest
{
  public static void pruebaLeerAgenda ()
  {
    Agenda agenda = AgendaAmpliada.leer("E:\\Trabajo Porgra\\agenda.txt");
    System.out.println("agenda = \n" + agenda);
  }
  public static void pruebaEscribirAgenda ()
  {
    Agenda agenda = AgendaAmpliada.leer("E:\\Trabajo Porgra\\agenda.txt");
    AgendaAmpliada.escribir(agenda, "E:\\Trabajo Porgra\\copiaAgenda.txt");
  }
  public static void pruebaOrdenarAgenda ()
  {
    Agenda agenda = AgendaAmpliada.leer("E:\\Trabajo Porgra\\agenda.txt");
    System.out.println("agenda = \n" + agenda);
    System.out.println("ordenar(agenda);");
    AgendaAmpliada.ordenar(agenda);
    System.out.println("agenda = \n" + agenda);
  }
  public static void main (String[] args)
  {
    pruebaLeerAgenda();
    //
    pruebaEscribirAgenda(); 
    //
    pruebaOrdenarAgenda();
  }
}