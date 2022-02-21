package tads;

/**
 * Implementación de un TAD Lista basada en un array.
 *
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la lista
 */
public class ArrayList<E> implements IList<E> {
  private static final int MAX_ELEMENTOS = 32;
  private Object[] elementos;
  private int longitud;

  public ArrayList() {
    elementos = new Object[MAX_ELEMENTOS];
    longitud = 0;
  }

  public String toString() {
    String resultado = "[";
    for (int i = 0; i < longitud; i++) {
      resultado = resultado + elementos[i].toString();
      if (i < longitud - 1)
        resultado = resultado + ", ";
    }
    resultado = resultado + "]";
    return resultado;
  }

  public void add(int index, E element) {
    if (index < 0 || index > size())
      throw new RuntimeException("Indice " + index + " fuera de rango");
    for (int i = longitud; i > index; i--)
      elementos[i] = elementos[i - 1];
    elementos[index] = element;
    longitud = longitud + 1;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size())
      throw new RuntimeException("Indice " + index + " fuera de rango");
    return (E) elementos[index];
  }

  public int size() {
    return longitud;
  }

  public void set(int index, E element) {
    if (index < 0 || index >= size())
      throw new RuntimeException("Indice " + index + " fuera de rango");
    elementos[index] = element;
  }

  public int indexOf(E element) {
    int i = 0;
    boolean esta = false;
    while ((i < longitud) && !esta)
      if (element.equals(elementos[i]))
        esta = true;
      else
        i = i + 1;
    return (esta) ? i : -1;
  }

  public void remove(int index) {
    if (index < 0 || index >= size())
      throw new RuntimeException("Indice " + index + " fuera de rango");
    for (int i = index; i < longitud - 1; i++)
      elementos[i] = elementos[i + 1];
    longitud = longitud - 1;
  }

  public void remove(E elem) {
    int pos = indexOf(elem);
    if (pos > -1)
      remove(pos);
  }

  public IList<E> subList(int fromIndex, int toIndex) {
    if (toIndex - fromIndex + 1 > size())
      throw new RuntimeException();
    if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
      throw new RuntimeException();
    IList<E> resultado = new ArrayList<E>();
    int j = 0;
    for (int i = fromIndex; i < toIndex; i += 1) {
      resultado.add(j, get(i));
      j += 1;
    }
    return resultado;
  }
}
