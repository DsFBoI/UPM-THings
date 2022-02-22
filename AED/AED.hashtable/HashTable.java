package aed.hashtable;

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Arrays;

import es.upm.aedlib.Entry;
import es.upm.aedlib.EntryImpl;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.InvalidKeyException;


/**
 * A hash table implementing using open addressing to handle key collisions.
 */
public class HashTable<K,V> implements Map<K,V> {
  Entry<K,V>[] buckets;
  int size;

  public HashTable(int initialSize) {
    this.buckets = createArray(initialSize);
    this.size = 0;
    
  }

  /**
   * Add here the method necessary to implement the Map api, and
   * any auxilliary methods you deem convient.
   */

  // Examples of auxilliary methods: IT IS NOT REQUIRED TO IMPLEMENT THEM
  
  @SuppressWarnings("unchecked") 
  private Entry<K,V>[] createArray(int size) {
   Entry<K,V>[] buckets = (Entry<K,V>[]) new Entry[size];
   return buckets;
  }

  // Returns the bucket index of an object
  private int index(Object key) {
    return key.hashCode() % buckets.length; //sacamos el index a partir del resto de dividir el hashcode con la length de la array
  }

  // Returns the index where an entry with the key is located,
  // or if no such entry exists, the "next" bucket with no entry,
  // or if all buckets stores an entry, -1 is returned.
  private int search(Object key) {
	  int place = index(key);//sacamos el index de la key
	  int res = -1;// iniciamos el resultado
	  boolean encontrado = false;
	  if(buckets[place] == null||buckets[place].getKey().hashCode()==key.hashCode()) {
		  return place;//si el valor dado por el index es null aka esta vacio devolvemos la posicion de ese lugar
	  }
	   
	  for(int i = 1;i<buckets.length && !encontrado;i++) {//si no vamos avanzando circular mente gracias al index en la array hasta encontrar un sitio null
		  place = index(++place);
		  if (buckets[place] == null|| buckets[place].getKey().hashCode()==key.hashCode()) {
			  res = place;
			  
		  }
	  }
    return res;//si no se ha encontrado un sitio null a lo largo de la lista se devuekve -1
  }
  
 

  // Doubles the size of the bucket array, and inserts all entries present
  // in the old bucket array into the new bucket array, in their correct
  // places. Remember that the index of an entry will likely change in
  // the new array, as the size of the array changes.
  private void rehash() {
	  Entry<K,V>[] nueva = buckets;//copiamos buckets
	  buckets = createArray(nueva.length*2);//creamos una nueva array con el doble de tamano
	  size = 0;// reiniciamos size
	  for(int i  = 0 ; i < buckets.length;i++) {
		  buckets[i] = null;//hacemos que bucket tenga todo null
		 
	  }
	  for(int i = 0;i<nueva.length;i++) {
		  if(nueva[i]!=null) {
		  int nuevo = search(nueva[i].getKey());//introducimos los valores que estan almacenados en la array copiada con el nuevo index.
		  buckets[nuevo] = nueva[i];
		  ++size;// sumamamos size siempre que se haga la itracion
		  }
	  }
	  
  }
  
  
 /* public void put(Entry<K,V> elem) {

	  int i  = search(elem.getKey());
	  if(i == -1) {
		  rehash();
		  put(elem);
	  }
	  else {
		  buckets[i] = elem;
	  }
	  
  }*/
private void isKey(Object key) throws InvalidKeyException {
	if (key == null) {
		throw new InvalidKeyException();// check si es una key
	}
}

public boolean containsKey(Object key) throws InvalidKeyException {
	isKey(key);
	int i = search(key);
	if(i==-1 || buckets[i]==null) {//busca la key con el metodo anterior y si no hay ninguna key con esa posicion o si la posicion es de value null retrunea false si no returnea true
		return false;
	}
	return true;
}


public Iterable<Entry<K, V>> entries() {//crea una position list y va anadiendo todos los valores no nulos a la position list mientras avanza
	PositionList<Entry<K,V>> list = new NodePositionList<>();
	for (int i = 0 ; i<buckets.length;++i) {
		if(buckets[i]!= null) {
			list.addLast(buckets[i]);
		}
	}
	return list;
}


public V get(K key) throws InvalidKeyException {
	isKey(key);
	int i = search(key);
	V result = null;
	
	if(i!=-1 &&buckets[i]!= null) {
		result = buckets[i].getValue();
	}// si el valor de la funcion busqueda no es igual a null y esta en la lista devuelve su valor
	return result;
}


public boolean isEmpty() {
	return size == 0;//si su size es 0 es que no hay elementos en el array aparte de nulls
}


public Iterable<K> keys() {//muy parecido a entries pero con keys, se recorre la arra y va anadiendo al final los valores de las keys
	PositionList<K> list = new NodePositionList<>();
	
	for (int i = 0 ; i<buckets.length;i++) {
		if(buckets[i]!= null) {
			list.addLast(buckets[i].getKey());
		}
	}
	return list;
}


public V put(K key, V val) throws InvalidKeyException {
	isKey(key);
	int i  = search(key);
	V prev = null;
	if(i == -1) {//si no hay un hueco llamas a rehash que duplica el tamano de la array
		 rehash(); 
		 int j = search(key);
		 buckets[j] = new EntryImpl<K, V>(key,val);//anade el valor mediante el int del search
		 ++size;
		 return prev;
	  }
	if(buckets[i]!=null) {
		 prev =  buckets[i].getValue();
		 //si no es null coge el resultado anterior y lo guarda en la variable prev
	}
	buckets[i] = new EntryImpl<K, V>(key,val);
	if(prev == null) {
	  size++; //si el resultado previo es null devuelve suma uno a size, es decir si no lo ha sustituido
	}
	  
	return prev;
}


public V remove(K key) throws InvalidKeyException {
	isKey(key);
	int loc = search(key);//buscamos donde esta el elemento a borrar
	V prev = null;// iniciamos lo que vamos a devolver
	if(loc!=-1 && buckets[loc]!= null) {//si ele elmento esta en la lista y no es null iniciamos el programa
		size--;// restamos uno a size
		prev = buckets[loc].getValue();// guardamos el valor anterior
		buckets[loc] = null;					//y hacemos una estructura muy parecida a rehash() 
		Entry<K,V>[] nueva = buckets;			//basicmanete copiamos la array y la vaciamos y 
		buckets = createArray(nueva.length);	//luego la rellenamos de nuevo reorganizando los valores anteriores
		for(int i  = 0 ; i < buckets.length;i++) {
			  buckets[i] = null;
		}
		for(int i = 0;i<nueva.length;i++) {
			if(nueva[i]!=null) {
				int nuevo = search(nueva[i].getKey());
				 buckets[nuevo] = nueva[i];
				 
			}
	  }
	}
	
	
	
	return prev;//devolvemos el valor que tenia el objeto borrado si ese era nulo se dovolvera nulo
}


public int size() {
	return size;
}

@Override
public Iterator<Entry<K, V>> iterator() {
PositionList<Entry<K, V>> list = new NodePositionList<>();
	
	for (int i = 0 ; i<buckets.length;i++) {
			list.addLast(buckets[i]);
	}
	return list.iterator();
}
  
}

