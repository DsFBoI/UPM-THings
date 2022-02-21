package tads;

/**
 * Implementación de un TAD Stack basada en una cadena simplemente enlazada.
 *
 * Una pila, stack, es una estructura de datos tipo FILO (First In Last Out).
 * Permite insertar elementos (al final de la pila) y quitarlos (del final)
 * 
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la pila
 */
public class Stack<E> implements IStack<E> {

  private Node<E> head;

  public Stack() {
    head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void push(E element) {
    head = new Node<E>(element, head);
  }

  public void pop() {
    if (!isEmpty())
      head = head.next;
  }

  public E peek() {
    return head.element;
  }

  public boolean isFull() {
    return false;
  }

  public String toString() {
    String resultado = "[";
    Node<E> iter = head;
    while (iter != null) {
      resultado += iter.element;
      if (iter.next != null)
        resultado += ", ";
      iter = iter.next;
    }
    resultado += "]";
    return resultado;
  }
}