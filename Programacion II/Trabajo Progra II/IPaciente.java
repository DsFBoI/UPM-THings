/**
 * Especificación del TAD Paciente<br>
 * @since 22/4/2021
 * @version 1.0
 * @author JMB
 */
public interface IPaciente
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
  public String toString ();
/**
 * POST: resultado es cierto si "pp" es identico al objeto y, es
 *       falso e.o.c.
 */
  public boolean equals (Object pp);
/**
 * POST: resultado es el nombre del objeto
 */
  public String getNombre ();
/**
 * POST: resultado es la prioridad del objeto
 */
  public int getPrioridad ();
/**
 * POST: resultado es la edad del objeto
 */
  public int getEdad();
/**
 * POST: resultado es el numero de la SS del objeto
 */
  public int getSS ();
/**
 * POST: modifica la prioridad del objeto por "nueva".
 */
  public void setPrioridad (int nueva);
}