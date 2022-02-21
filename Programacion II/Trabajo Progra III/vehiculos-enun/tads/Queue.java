package tads;

/**
 * Una fila, queue, es una estructura de datos tipo FIFO (First In First Out).
 * Permite insertar elementos (al final de la fila) y quitarlos (del principio)
 * 
 * Esta implementación usa "cadenas enlazadas" para implementar la fila.
 * 
 * Nota: Algunos métodos requieren que la fila no esté vacía. Si esta precondición
 * no se cumple se lanza una NullPointerException 
 * 
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la fila
 */
public class Queue<E> implements IQueue<E> {

  private Node<E> first = null;
  private Node<E> last = null;

  public boolean isEmpty() {
    return first == null;
  }

  public boolean isFull() {
    return false;
  }

  public void push(E valor) {
    if (isEmpty()) {
      first = new Node<>(valor, null);
      last = first;
    } else {
      last.next = new Node<>(valor, null);
      last = last.next;
    }
  }

  public E peek() {
    return first.element;
  }

  public void pop() {
    first = first.next;
  }
  
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("[");
    Node<E> iter = first;
    while (iter != null) {
      result.append(iter.element);
      if (iter.next != null) {
        result.append(", ");
      }
      iter = iter.next;
    }
    result.append("]");
    return result.toString();
  }

}
