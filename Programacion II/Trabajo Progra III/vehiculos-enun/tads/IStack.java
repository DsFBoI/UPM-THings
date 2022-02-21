package tads;

/**
 * Especificación del TAD {@code IStack}.
 *
 * Representa una pila de elementos.
 *
 * @param <E> El tipo de los objetos que se van a almacenar en la fila
 */
public interface IStack<E> 
{
  /**
   * Comprueba si la pila está vacía.
   *
   * @post. {@code resultado} es {@code true} si la pila está vacía y 
   *        {@code false} en caso contrario.
   * @return verdadero si la pila está vacía, falso en caso contrario
   */
  boolean isEmpty ();

  /**
   * Devuelve el elemento que está en la cima de la pila sin eliminarlo y, por tanto,
   * sin modificar la pila.
   *
   * @pre. La pila no esta vacía.
   * @post. {@code resultado} es el elemento que está en la cima de la pila, la
   * pila conserva el mismo número de elementos.
   * @return el elemento que está en la cima de la pila.
   * @throws RuntimeException si la pila está vacía
   */
  E peek ();

  /**
   * Borra la cima de la pila.
   * Si la pila está vacía, no hace nada.
   */
  void pop ();
 
  /**
   * Añade el elemento {@code e} a la cima de la pila.
   *
   * @pre. La pila no está llena.
   * @post. La pila tiene un elemento más.
   * @param e el elemento que se añade a la pila.
   * @throws RuntimeException si la pila está llena.
   */   
  void push (E e);  

  /**
   * Comprueba si la pila está llena. Solo algunas pilas se llenan. Si
   * una pila está llena no se pueden insertar nuevos elementos. 
   *
   * @post. Cuando {@code resultado} es {@code false} se puede insertar
   * un nuevo elemento en la pila y viceversa. 
   * @return verdadero si la pila está llena y falso en caso contrario
   */
  boolean isFull ();

}