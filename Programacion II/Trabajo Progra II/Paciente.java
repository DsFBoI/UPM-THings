/**
 * Implementaci�n del TAD Paciente<br>
 * {@code ED = TUPLA(Cadena,Entero) = (nombre,telefono)}<br>
 * @since 22/4/2021
 * @version 1.
 * @author JMB
 */
public class Paciente implements IPaciente
{
  private String nombre;
  private int prioridad;
  private int edad;
  private int numeroSS;

  public Paciente (String nomb, int años, int numSS)
  {
    nombre = nomb;
    prioridad = 0;
    edad = años;
    numeroSS = numSS;}
  public String toString ()
  {
    return "(" + nombre + "," + prioridad + "," +
                 edad + "," + numeroSS + ")";
  }
  public boolean equals (Object pp)
  {
    Paciente otro = (Paciente) pp;
    return nombre.equals(otro.nombre) && (numeroSS == otro.numeroSS) &&
           (prioridad == otro.prioridad) && (edad == otro.edad);
  }
  public String getNombre ()
  {
    return nombre;
  }
  public int getPrioridad ()
  {
    return prioridad;
  }
  public int getEdad ()
  {
    return edad;
  }
  public int getSS ()
  {
    return numeroSS;
  }
  public void setPrioridad (int nueva)
  {
    prioridad = nueva;
  }
}