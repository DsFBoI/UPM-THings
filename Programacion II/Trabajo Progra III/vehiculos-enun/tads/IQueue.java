package tads;

/**
 * Una fila, queue, es una estructura de datos tipo FIFO (First In First Out).
 * Permite insertar elementos (al final de la fila) y quitarlos (del principio)
 * 
 * Nota: En algunos métodos se lanza una RuntimeException, el tipo concreto de
 * la excepción depende de la implementación, siempre que sea una derivada de
 * RuntimeException.
 * 
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la fila
 */
public interface IQueue<E> {

  /**
   * Comprueba si la fila está vacía.
   * 
   * @return verdadero si la fila está vacía, falso en caso contrario
   */
  boolean isEmpty();

  /**
   * Comprueba si la fila está llena. Este observador solo tiene sentido
   * en filas acotadas (con un límite o capacidad máxima en el número de elementos). 
   * En filas no acotadas (por ejemplo, mediante las implementadas con cadenas enlazadas) 
   * no tiene sentido y siempre se devuelve falso
   * 
   * @return verdadero si la fila está llena, falso en caso contrario
   */
  boolean isFull();

  /**
   * Inserta un nuevo elemento al final de la fila.
   * 
   * @post. La fila tiene un elemento más al final
   * 
   * @param valor el nuevo valor insertado
   * @throws RuntimeException si la fila está llena
   */
  void push(E valor);

  /**
   * Devuelve el primer elemento de la fila.
   * 
   * @post. La fila no se modifica
   * 
   * @throws RuntimeException si la fila está vacía
   * @return El primer elemento de la fila
   */
  E peek();

  /**
   * Elimina el primer elemento de la fila
   * 
   * @post. La fila tiene un elemento menos
   * 
   * @throws RuntimeException si la fila está vacía
   */
  void pop();
}
