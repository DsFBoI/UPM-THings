package tads;

/**
 * Una fila, queue, es una estructura de datos tipo FIFO (First In First Out).
 * Permite insertar elementos (al final de la fila) y quitarlos (del principio)
 * 
 * Esta implementación usa un buffer circular acotado para implementar la fila.
 * 
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la fila
 */
public class ArrayQueue<E> implements IQueue<E> {

  private static final int MAX_ELEMENTOS = 32;
  private int size = 0;
  private boolean turnAround = false;
  private int first = 0;
  private int last = 0;

  private Object[] buffer = new Object[MAX_ELEMENTOS];

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size >= MAX_ELEMENTOS;
  }

  /**
   * Inserta un nuevo elemento al final de la fila.
   * 
   * @post. La fila tiene un elemento más al final
   * 
   * @param value el nuevo valor insertado
   * @throws RuntimeException si la fila está llena
   */
  public void push(E value) {
    if ( size + 1 > MAX_ELEMENTOS ) {
      throw new RuntimeException("Full Queue");
    }

    if (isEmpty()) {
      turnAround = false;
      first = 0;
      last = 0;
    } else {
      if (!turnAround && last >= MAX_ELEMENTOS) {
        turnAround = true;
        last = 0;
      } else if (turnAround && last >= first) {
        throw new RuntimeException("Full Queue, should not be possible to get here");
      }
    }
    buffer[last] = value;
    ++last;
    ++size;
  }

  /**
   * Devuelve el primer elemento de la fila.
   * 
   * @post. La fila no se modifica
   * 
   * @throws RuntimeException si la fila está vacía
   * @return El primer elemento de la fila
   */
  
  public E peek() {
    if (isEmpty()) {
      throw new RuntimeException("Empty Queue");
    }
    @SuppressWarnings("unchecked")
    E result = (E) buffer[first]; 
    return result;
  }

  public void pop() {
    ++first;
    if (first >= MAX_ELEMENTOS) {
      first = 0;
      turnAround = false;
    }
    --size;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(String.format("(size %d):", size));
    result.append("[");
    if (size > 0) {
      result.append(buffer[first]);
    }
    for (int i = 1; i < size; ++i) {
      result.append(", ");
      result.append(buffer[(i + first) % MAX_ELEMENTOS]);
    }
    result.append("]");
    return result.toString();
  }

}
