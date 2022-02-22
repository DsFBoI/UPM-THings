package aed.recursion;


import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.indexedlist.*;
import es.upm.aedlib.positionlist.*;


public class Utils {

  

public static int multiply(int a, int b) {
	  int sign =1;
	  int sum = 0;
	  if (a<0 ) {
		  sign = -1;
	  }
    return sign* multiply(a, b,sum);
  }

private static int multiply(int a, int b , int sum) {
	if (a==0) {
		  return sum;
	  }
	  if (a%2 != 0) {
		  sum = sum + b;
	  }
	return multiply(a/2, b*2,sum) ;
}

public static <E extends Comparable<E>> int findBottom(IndexedList<E> l) {
	
    return l.indexOf(findBottom(l,l.get(0), l.get(l.size()-1))) ;
  }
	
private static <E extends Comparable<E>> E findBottom(IndexedList<E> l, E start, E end) {
	  int  m = (l.indexOf(start)+l.indexOf(end))/2;
	  if (l.get(m).compareTo(l.get(m+1))<0 && l.get(m).compareTo(l.get(m-1))<0) {
		  return l.get(m);
	  }
	  else if(l.get(l.indexOf(start)).compareTo(l.get(l.indexOf(start)+1))<0){
		  return start;
	  }
	  else if (l.get(l.indexOf(end)).compareTo(l.get(l.indexOf(end)-1))<0) {
		  return end;
	  }
	  else if(l.get(m).compareTo(l.get(m+1))<0 ) {
		  end = l.get(m);
		  return findBottom(l,start, end);
	  }
	  
	  start = l.get(m);
	  return findBottom(l,start, end);
	
}

public static <E extends Comparable<E>> NodePositionList<Pair<E,Integer>>
    joinMultiSets(NodePositionList<Pair<E,Integer>> l1,
		  NodePositionList<Pair<E,Integer>> l2) {
	if (l1==null||l2 == null) {
		return null;
	}
	Position<Pair<E,Integer>> l1_cursor = l1.first();
	Position<Pair<E,Integer>> l2_cursor = l2.first();
	NodePositionList<Pair<E,Integer>> result = new NodePositionList<Pair<E,Integer>>();
    return joinMultiSets(l1, l2,l1_cursor,l2_cursor, result);
  }

private static <E extends Comparable<E>> NodePositionList<Pair<E, Integer>> joinMultiSets(NodePositionList<Pair<E, Integer>> l1,
		NodePositionList<Pair<E, Integer>> l2, Position<Pair<E, Integer>> l1_cursor,
		Position<Pair<E, Integer>> l2_cursor, NodePositionList<Pair<E, Integer>> result) {
	
	if(l1_cursor == null && l2_cursor==null) {
		return result;
	}
	if(l1_cursor == null) {
		result.addLast(l2_cursor.element());
		return joinMultiSets(l1,l2,l1_cursor,l2.next(l2_cursor),result);
	}
	if(l2_cursor == null) {
		result.addLast(l1_cursor.element());
		return joinMultiSets(l1,l2,l1.next(l1_cursor),l2_cursor,result);
	}
	
	
	
	if(l1_cursor.element().getLeft().compareTo(l2_cursor.element().getLeft()) == 0) {
		
		result.addLast(l1_cursor.element());
		result.last().element().setRight(l1_cursor.element().getRight()+l2_cursor.element().getRight());
		return joinMultiSets(l1,l2,l1.next(l1_cursor),l2.next(l2_cursor),result);
	}
	
	if(l1_cursor.element().getLeft().compareTo(l2_cursor.element().getLeft()) < 0) {
		result.addLast(l1_cursor.element());
		return joinMultiSets(l1,l2,l1.next(l1_cursor),l2_cursor,result);
	}
	

	
		
	result.addLast(l2_cursor.element());
		
	return joinMultiSets(l1,l2,l1_cursor,l2.next(l2_cursor),result);
}


}
