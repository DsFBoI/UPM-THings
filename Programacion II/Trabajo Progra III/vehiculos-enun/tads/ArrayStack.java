package tads;

/**
 * Implementación del TAD Pila mediante un array.
 *
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la pila
 */
public class ArrayStack<E> implements IStack<E> {
  private int longitud;
  private Object[] elementos;
  private static final int MAX_ELEMENTOS = 32;

  public ArrayStack() {
    longitud = 0;
    elementos = new Object[MAX_ELEMENTOS];
  }

  public boolean isEmpty() {
    return longitud == 0;
  }

  @SuppressWarnings("unchecked")
  public E peek() {
    return (E) elementos[longitud - 1];
  }

  public void pop() {
    if (longitud >= 1) {
      longitud = longitud - 1;
    }
  }

  public boolean isFull() {
    return longitud >= elementos.length;
  }

  public void push(E elemento) {
    if (isFull())
      throw new RuntimeException("push: pila llena");
    else {
      elementos[longitud] = elemento;
      longitud = longitud + 1;
    }
  }

  public String toString() {
    String resultado = "[";
    for (int i = longitud - 1; i >= 0; i--) {
      resultado += elementos[i];
      if (i != 0)
        resultado += ", ";
    }
    return resultado + "]";
  }
}