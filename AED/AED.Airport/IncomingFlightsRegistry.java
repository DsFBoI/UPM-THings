package aed.airport;



import es.upm.aedlib.Entry;
import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.priorityqueue.*;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;


/**
 * A registry which organizes information on airplane arrivals.
 */

public class IncomingFlightsRegistry {
	private HeapPriorityQueue<Long,String> list;
	private HashTableMap<String,Long> list2;
	

  /**
   * Constructs an class instance.
   */
  public IncomingFlightsRegistry() {//utilizamos una cola de prioridad y un Hash Table
	  this.list = new HeapPriorityQueue<Long,String>();
	  this.list2 = new HashTableMap<String,Long>();
	  
	  
  }
  
  
  
 
	  
  
  
   

  /**
   * A flight is predicted to arrive at an arrival time (in seconds).
   */
  public void arrivesAt(String flight, long time) {
	  
	  if(list.isEmpty()) {// if the list is empty it introduces the flight in ther ordered queue 
		  list.enqueue(time,flight);
	  }
	  else {
		  if(flight.equals(list.first().getValue())) {// if its equal to the first element of the queue it dequeues it and updates the values of the flight
			  list.dequeue();
			  list.enqueue(time, flight);
				 
			 }
		  else {
			  if(list2.containsKey(flight)) {
				  
				  // if list2 contains the key it searchs it in the HashTable and replaces the key value(the time)
				  for(Entry<Long,String> e : list) {
					  if (e.getValue().equals(flight)) {
						  list.replaceKey(e, time);
						  break;
					  }
					 }
			  }
			  else {
				  //if its not in the HashTable it enqueues it
				  
				  list.enqueue(time, flight);
			  
			  }
		  }
		
	  }
	  list2.put(flight, time);
	  //it adds the flight to the hash table and also updates it if necesary
	  
	  
	  
	 
  }

  /**
   * A flight has been diverted, i.e., will not arrive at the airport.
   */
  public void flightDiverted(String flight) {
	  if(list2.containsKey(flight)) {
		  //The flight is in the HashTable
		  
		 if(flight.equals(list.first().getValue())) {
			 
			 //if its the First one in the queue its dequeued
			 list.dequeue();
			 
		 }
		 
		 else {
			 
			 //if its not the first element its enques it and it deques it two times more for it to eliminate the element from the flight table 
       Entry<Long,String> nuevo = list.enqueue(list2.get(flight),flight);
			 list.remove(nuevo);
			 list.remove(nuevo);
		 
		 }
		 
		 list2.remove(flight);// the flight is removed from the hash table
	  }
  }

  /**
   * Returns the arrival time of the flight.
   * @return the arrival time for the flight, or null if the flight is not predicted
   * to arrive.
   */
  public Long arrivalTime(String flight) {
	// searches the value in the HashTable
    return list2.get(flight);
  }

  /**
   * Returns a list of "soon" arriving flights, i.e., if any 
   * is predicted to arrive at the airport within nowTime+180
   * then adds the predicted earliest arriving flight to the list to return, 
   * and removes it from the registry.
   * Moreover, also adds to the returned list, in order of arrival time, 
   * any other flights arriving withinfirstArrivalTime+120; these flights are 
   * also removed from the queue of incoming flights.
   * @return a list of soon arriving flights.
   */
  
 
	  
  public PositionList<FlightArrival> arriving(long nowTime) {
	
	  PositionList<FlightArrival> vuelos = new NodePositionList<FlightArrival>();
	  long aux = nowTime+180;// marks the range of the 
	  	  while(!list.isEmpty() && (list.first().getKey()<= nowTime+180||list.first().getKey() <=aux)) {
	  		 
	  		  	if((list.first().getKey()<= nowTime+180||list.first().getKey() <=aux) && list.first().getKey()>= nowTime) {
	  		  		
	  		  		// if the queue isn't empty y and the flight passes all the requirements, it is added to the list and it is eliminated from the queue and HashTable
	  		  		vuelos.addLast( new FlightArrival(list.first().getValue(),list.first().getKey()));
	  		  		list2.remove(list.first().getValue());
	  		  		list.remove(list.first());		  	
	  		  		if(!vuelos.isEmpty()) {
	  		  			aux = vuelos.first().element().getRight()+120;
	  		  		}	  
	  		  	}
	  		  	else if(list.first().getKey()< nowTime) {
	  		  		//if it doesn't pass the requirements its removed from the queue and the HashTable but its not added to the list
	  		  		
	  		  		list2.remove(list.first().getValue());
	  		  		list.remove(list.first());	
	  		  	}
	  
	  		 
	  	  }
	  
	  
	  
	  return vuelos;// Returns the list.
  }
  
}
