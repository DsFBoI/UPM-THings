package aed.individual4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;

public class MultiSetListIterator<E> implements Iterator<E> {
  PositionList<Pair<E,Integer>> list;

  Position<Pair<E,Integer>> cursor;
  int counter;
  Position<Pair<E,Integer>> prevCursor;

  public MultiSetListIterator(PositionList<Pair<E,Integer>> list) {
    this.list = list;
    cursor = list.first();
    //prevCursor = list.prev(cursor);
    counter =1;
    
    
  }
  
  
  /*private void exist (Position<Pair<E,Integer>> cursor) throws NoSuchElementException {
	  
	  if (cursor == null) {
		  throw new NoSuchElementException();
	  }
	  
  }
  */
  
  public boolean hasNext() {
    if(list.isEmpty()||cursor == null) {//comprobamos que el cursor no es null ya que en la funcion next() vamos a avanzar el cursor lo que va ha hacer que esto se comprueve
    	return false;
    }
    /*if(cursor!=null) {
    	result = true;
    }*/
    return cursor != null ;// devolvera true si no se cumple lo de arriba que es la 
  }
  
  
  
  

  public E next() {
	if ( cursor==null || cursor.element() ==null) {//check de que tanto el cursor como su elemento no sean null
		  throw new NoSuchElementException();
	}
    if(cursor.element().getRight() > counter){ // este ese el caso si las veces que se repite el valor en la lista es mayor que uno
    	counter++;  
    	prevCursor = cursor;
    }
    else {//caso contrario al anterior si es si las veces que se repite son <= 1
    	counter = 1;
    	prevCursor = cursor;
    	cursor = list.next(cursor);
    }
    return prevCursor.element().getLeft();
  }
  
  
  
  public void remove() {
	  if(list.isEmpty()||prevCursor == null){ // check de que la lista no este vacia o la posicion en la que estamos
		  throw new IllegalStateException();
	  }
	  else if(prevCursor.element().getRight()>1) {// si la veces que se repite son menores que uno pues esta se reduce una repeticion y si esta cerca de un next el counter tambien se tiene que reducir 1
	  		prevCursor.element().setRight(prevCursor.element().getRight()-1);
	  		counter--;
	  		
	  }
	  else {// el caso que el pair solo tenga una repeticion
		  list.remove(prevCursor);
	  }
	  prevCursor = null; //llamando a null el prevcursor hacemos que no se pueda repetir dos veces seguidas un remove()
  }
}
