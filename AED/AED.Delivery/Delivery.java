package aed.delivery;

import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.graph.DirectedAdjacencyListGraph;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.map.HashTableMap;
import es.upm.aedlib.set.HashTableMapSet;
import es.upm.aedlib.set.Set;
import java.util.Iterator;

public class Delivery<V> {

  // Construct a graph out of a series of vertices and an adjacency matrix.
  // There are 'len' vertices. A negative number means no connection. A non-negative
  // number represents distance between nodes.
	 V[] places;
	 Integer[][] gmat;
	 DirectedGraph<V,Integer> res;
	 

  public Delivery(V[] places, Integer[][] gmat) {
	  this.places = places;
	  this.gmat = gmat;
	  this.res = new DirectedAdjacencyListGraph<V,Integer>();
	  HashTableMap<Integer,Vertex<V>> check = new HashTableMap<>();
	  for(int x = 0; x < places.length;x++) {
		  check.put(x,  res.insertVertex(places[x]));
		  
	  }
	  for(int i = 0 ;  i < places.length; i++) {
		  for(int  j = 0 ;  j<places.length; j++) {
			  
			  if(gmat[i][j] != null && gmat[i][j] > 0) {
				  
				  res.insertDirectedEdge(check.get(i), check.get(j), gmat[i][j]);
			  }
			  
		  }
		  
	  }
  }
  
  // Just return the graph that was constructed
  public DirectedGraph<V, Integer> getGraph() {
	  
	  return res;
  }

  // Return a Hamiltonian path for the stored graph, or null if there is noe.
  // The list containts a series of vertices, with no repetitions (even if the path
  // can be expanded to a cycle).
  public PositionList <Vertex<V>> tour() {
	  PositionList<Vertex<V>> resu = new NodePositionList<>();//resu almacena el patha que luego sera devuelto y copiado en resu2
	  PositionList<Vertex<V>> resu2 = new NodePositionList<>(); //resu2 tomara el valor devuelto or la funcion recursiva tour
	  for(Vertex<V> aux : res.vertices()) { 
		  /*in this for each we check the path to all vertexs and when its found and has the same length
		   * as the previous list it returns it */
		
	  resu2 = tour(res,aux,resu);
	  	if(resu2!=null) {
	  		break;
	  	}
	  }
	  return resu2;
  }

  

private PositionList<Vertex<V>> tour(DirectedGraph<V, Integer> g, Vertex<V> from,PositionList<Vertex<V>> path) {
	if (path.size() == places.length-1) {	//checks that path.size() has the same length as 'places'
		path.addLast(from);					//basic case
		return path;
	}
	Iterator<Edge<Integer>> it = g.outgoingEdges(from).iterator();// We do an iterator of the edges for the edge weigth to be more managable
	
	PositionList<Vertex<V>> result = null;	//initialize the result
	while(it.hasNext() && result == null) {	// conditions 
		Edge<Integer> aux = it.next();		    //aux variable to save the next value of the iterator
		Vertex<V> end = g.endVertex(aux); 	  //we take the final vertex of the edge
		
		if(!end.equals(g.startVertex(aux)) && !path.ContainsVertex(path,end)){// if the iteartor node its not equal to aux and its not in the list
			path.addLast(from);// it is added to the PositionList
			result = tour(g,end,path); // and we activate the recursion
			
			if(result == null) {// if it is null it is removed from the position list
				path.remove(path.last());
			}
		}
	}
	return result;
}

private static <V,E> boolean pathContainsVertex(PositionList<Vertex<V>> path,Vertex<V> v) {// auxiliar function to check if we have already visited the vertex 
	for (Vertex<V> vertice : path) {
		if (v.equals(vertice) || v.equals(vertice)) {
			return true; 
		}
	} 
	return false;
}


public int length(PositionList<Vertex<V>> path) {
	int suma = 0;//final value
	Position<Vertex<V>> cursor = path.first();//cursor
    return length(path,suma,cursor);//recursivity initiator
  }

  private int length(PositionList<Vertex<V>> path, int suma, Position<Vertex<V>> cursor) {
	if(cursor == path.last()) {	// if is the last its equal to the cursor it gives back the result 
		return suma;			//base case
	}
	Position<Vertex<V>> siguiente = path.next(cursor);				//we go to next value of the cursor
	for(Edge<Integer> e : res.outgoingEdges(cursor.element()) ) {	// we check all the edges going out of the cursor
		if(res.endVertex(e)==siguiente.element()) {					// if one of the edges is in the list it adds it to the total and it breaks the for each
			suma += e.element();									
			break;
		}
	}
	cursor = siguiente;												// cursor advances
	return length(path,suma,cursor);
}

public String toString() {
    return "Delivery";
  }
}
