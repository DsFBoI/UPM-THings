package tads;

/**
 * Especificación del TAD {@code IList}.
 *
 * Representa una lista de elementos con acceso por posición. {@code E} es la
 * clase a la que pertenecen los elementos de la lista. Se ha tomado el modelo
 * de la lista (interfaz {@code List}) de Java.
 *
 * Las dos características principales de este TAD son:
 * 
 * 1) Admite mutación en la colección. 2) Las operaciones son un subconjunto de
 * las de la lista de Java.
 *
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la Lista
 */
public interface IList<E> {

  /**
   * Inserta un elemento en la lista en una posición determinada.
   *
   * Coloca {@code element} en {@code index} y desplaza desde esa posición todos
   * los elementos una posición a la derecha.
   *
   * @param index el lugar donde se va a insertar
   * @param elem el nuevo elemento que se va a insertar 
   * @pre. {@code index in [0, size())}
   * @throws RuntimeException si el índice no está entre los límites indicados
   */
  public void add(int index, E elem);

  /**
   * Devuelve el elemento que está en la posición {@code index}.
   *
   * @param index el índice del elemento que se va a devolver (empezando en cero)
   * @pre. {@code index in [0, size())} 
   * @post. {@code resultado} es el elemento que ocupa la posición {@code index}
   * @throws RuntimeException si el índice no está entre los límites indicados
   * @return El elemento en la posición dada por index
   */
  public E get(int index);

  /**
   * Devuelve la longitud de la lista.
   *
   * @pre. {@code index in [0, size())} 
   * @post. {@code resultado} es el número de elementos que hay en la lista
   * @return el número de elementos actualmente en la lista
   */
  public int size();

  /**
   * Pone {@code elem} en la posición {@code index} de la lista, eliminando el
   * elemento que había en esa posición.
   * 
   * @param index el lugar donde se va a colocar el número elemento
   * @param elem el nuevo elemento de la lista
   * @pre. index in [0, size())
   * @post. get(index) == {@code elem}
   */
  public void set(int index, E elem);

  /**
   * Busca un elemento en la lista.
   *
   * @post. si existe: get(indexOf(elem)) == elem
   * @param elem el elemento a buscar en la lista
   * @return el índice que ocupa (empezando en cero) la primera ocurrencia de {@code elem} en la lista, -1 si no existe
   */
  public int indexOf(E elem);

  /**
   * Quita de la lista el elemento que está en la posicion {@code index}.
   *
   * @pre. {@code index} in [0, size())
   * @post. el tamaño de la lista se ha decrementado en uno
   * @param index el índice del elemento que se va a eliminar 
   * @throws RuntimeException si el índice no está entre los límites indicados
   */
  public void remove(int index);

  /**
   * Quita la primera ocurrencia de {@code elem} de la lista. Si no existe, no hace nada.
   * 
   * @post. Si existe el tamaño de la lista lista se decrementa en uno
   * @param elem el elemento a eliminar
   */
  public void remove(E elem);

  /**
   * Devuelve una vista de la porción del objeto entre las posiciones
   * {@code inicio} y {@code fin - 1}.
   *
   * @pre. {@code inicio >= 0 and fin <= size() and inicio <= fin}
   * @post. sublist(a, b).size() == b - a
   * @param inicio el índice del primer elemento de la lista resultante
   * @param fin, fin - 1 es el índice del último elemento de la lista resultante 
   * @throws RuntimeException si los índices no está entre los límites indicados
   * @return una lista con los elementos de la original en [inicio, fin)
   */
  public IList<E> subList(int inicio, int fin);
}
