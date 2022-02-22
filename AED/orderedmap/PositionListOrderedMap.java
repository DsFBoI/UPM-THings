package aed.orderedmap;

import java.util.Comparator;

import es.upm.aedlib.Entry;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.positionlist.NodePositionList;

public class PositionListOrderedMap<K,V> implements OrderedMap<K,V> {
    private Comparator<K> cmp;
    private PositionList<Entry<K,V>> elements;
  
    /* Acabar de codificar el constructor */
    public PositionListOrderedMap(Comparator<K> cmp) {
	this.cmp = cmp;
	this.elements = new NodePositionList<Entry<K,V>>();
    }

    /* Ejemplo de un posible método auxiliar: */
  
    /* If key is in the map, return the position of the corresponding
     * entry.  Otherwise, return the position of the entry which
     * should follow that of key.  If that entry is not in the map,
     * return null.  Examples: assume key = 2, and l is the list of
     * keys in the map.  For l = [], return null; for l = [1], return
     * null; for l = [2], return a ref. to '2'; for l = [3], return a
     * reference to [3]; for l = [0,1], return null; for l = [2,3],
     * return a reference to '2'; for l = [1,3], return a reference to
     * '3'. */
    private void Keyvalid(K key )throws IllegalArgumentException {
    	if(key ==null) {
    		throw new IllegalArgumentException();
    	}
    }
    
    
    private Position<Entry<K,V>> findKeyPlace(K key) {
    	Position<Entry<K,V>> pointer = elements.first();
    	boolean found = false;
    	while(pointer != null &&  !found) {
    		if(cmp.compare(pointer.element().getKey(), key)==0 || cmp.compare(pointer.element().getKey(), key) < 0) {
    			found = true;
    		}
    		else {
    			 pointer = elements.next(pointer);
    		}
    		
    	}
    	
	return pointer;
    }

    /* Podéis añadir más métodos auxiliares */
  
    public boolean containsKey(K key) {
    	Keyvalid(key);
    	boolean result = false;
    	Position<Entry<K,V>> aux = findKeyPlace(key);
    	if(aux != null && aux.element().getKey().equals(key)) {
    		result = true;
    	}
	return result;
    }
  
    public V get(K key) {
    	Keyvalid(key);
    	V result = null;
    	Position<Entry<K,V>> aux = findKeyPlace(key);
    	if(aux != null && aux.element().getKey().equals(key)) {
    		result = aux.element().getValue();
    	}
    	
    	
	return result;
    }
  
    public V put(K key, V value) {
    	Keyvalid(key);
    	Entry<K,V> newentry = new EntryImpl<K,V>(key,value);
    	V result = null;
    	Position<Entry<K,V>> aux = findKeyPlace(key);
    	
    	
    	if(elements.isEmpty()) {
    		elements.addFirst(newentry);
    	}
    	else if(aux != null && cmp.compare(aux.element().getKey(), key) == 0) {
    		result = aux.element().getValue();
    		elements.set(aux, newentry);
    		
    	}
    	else if(aux != null && cmp.compare(aux.element().getKey(), key) < 0) {
    		elements.addBefore(aux, newentry);
    	}
    	else {
    		elements.addLast(newentry);
    	}
    	
    	
	return result;
    }
  
    public V remove(K key) {
	 Keyvalid(key);
	 Position<Entry<K,V>> aux = findKeyPlace(key);
	 V result = null;
	 if(aux != null && aux.element().getKey().equals(key)) {
		 result = elements.remove(aux).getValue();
	 }
	 return result;
    }
  
    public int size() {
	return elements.size() ;
    }
  
    public boolean isEmpty() {
	return elements.isEmpty();
    }
  
    public Entry<K,V> floorEntry(K key) {
    	Keyvalid(key);
    	Entry<K,V> result = null;
    	Position<Entry<K,V>> aux = findKeyPlace(key);
    	if(aux != null) {
    		if( cmp.compare(aux.element().getKey(), key) <= 0) {
    			result = aux.element();
    		}
    	}
	return result;
    }
  
    public Entry<K,V> ceilingEntry(K key) {
    	Keyvalid(key);
    	Entry<K,V> result = null;
    	Position<Entry<K,V>> aux = elements.first();
    	boolean found = false;
    	while (aux!=null && !found) {
    		if(cmp.compare(aux.element().getKey(), key) >= 0) {
    			result = aux.element();
    		}
    		aux = elements.next(aux);
    	}	
	return result;
    }
  
    public Iterable<K> keys() {
    	
    	Position<Entry<K,V>> pointer = elements.first();
    	PositionList<K> result = new NodePositionList<>();
    	while(pointer != null) {
    		result.addLast(pointer.element().getKey());
    		pointer = elements.next(pointer);
    	}
    	
	return result;
    }
  
    public String toString() {
	return elements.toString();
    }
 
  
}
