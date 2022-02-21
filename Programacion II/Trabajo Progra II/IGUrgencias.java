/**
 * Especificacion del TAD GUrgencias<br>
 * {@code GUrgencias = COL<IPaciente>}<br>
 * @since 22/4/2021
 * @version 1.0
 * @author JMB
 */
public interface IGUrgencias
{
 /**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto.
 */
  public String toString ();
/**
 * POST: resultado es cierto si el objeto esta vacio y, es falso e.o.c.
 */
  public boolean estaVacio ();
/**
 * PRE:  el objeto no esta vacio.
 * POST: resultado es el elemento del objeto:
 *       - El primero, si su prioridad es >0
 *       - El de menor edad, si la prioridad del primero es =0
 */
  public IPaciente primero();
/**
 * POST: a�ade el elemento "elem" al objeto 
 *       - Al final, si su prioridad es =0.
 *       - Por delante y en un orden decreciente, no estricto, de las
 *         prioridades, si su prioridad es >0.
 */
  public void insertar (IPaciente elem);
/**
 * POST: elimina el elemento del objeto:
 *       - El primero, si la prioridad del primero es >0
 *       - El de menor edad, si la prioridad del primero es =0
 */
  public void borrar ();

}