package aed.individual6;

import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.Entry;
import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.map.HashTableMap;


public class Suma {
	//creamos una funcion que recoja tods los elementos que se pueden alcanzar desde un vertice y que estos lo meta en una hashtable que usaremos luego
	private static <E> HashTableMap<Vertex<Integer>,Integer> reachableVertices (DirectedGraph<Integer,E> g, Vertex<Integer> startVertex) {
		HashTableMap<Vertex<Integer>,Integer> vertices = new HashTableMap<Vertex<Integer>, Integer>();
		visit(g, startVertex, vertices);
		return vertices;
	}
	//funcion que se hace de forma recursiva que va visitando los vertices que aun no se hayan vistado es decir, que esten en la lista de visitados
	private static <E> void visit(DirectedGraph<Integer,E> g,Vertex<Integer> vertex,HashTableMap<Vertex<Integer>,Integer> vertices) {
		if (vertices.containsKey(vertex)) {
			return;
		}
		vertices.put(vertex,vertex.element());
		for (Edge<E> edge : g.outgoingEdges(vertex)) {
			visit(g, g.endVertex(edge), vertices);
		}
		}
	//esta funcio vimos una muy similar en clase con lo cual el codigo es basdo en base a esa
  public static <E> Map<Vertex<Integer>,Integer> sumVertices(DirectedGraph<Integer,E> g) {
	  HashTableMap<Vertex<Integer>,Integer> res = new HashTableMap<Vertex<Integer>, Integer>();//tabla de respuestas
	  
	  if(g.isEmpty()) {
		  //si esta vacio devuelve el resultado
		return res;  
	  }
	  
	  for(Vertex<Integer> e : g.vertices()) {
		  /* va a vistar cada vertice del grafo g y los vamos a meter en una hash table, 
		   * despues con otra funcion auxiliar debemos sumar los elemenetos recogidos en la hash table*/
		  HashTableMap<Vertex<Integer>, Integer> visit = reachableVertices(g,e); 
		  int suma = sumaelme(visit);
		  res.put(e, suma);// y lo anade al resultado
		  
	  }
	  return res;
  }

private static int sumaelme(HashTableMap<Vertex<Integer>, Integer> visit) {
	// Esta es la funcion auxiliar que hacemos es para sumar todo los elementos de una HashTable que usamos arriba.	
	int suma = 0;
	for(Entry<Vertex<Integer>,Integer> a: visit) {
		suma += a.getValue();
	}
	return suma;
}


}
