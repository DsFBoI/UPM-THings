package aed.airport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import es.upm.aedlib.positionlist.*;


public class Tests {
	@Test
	public void Propiedad1(){
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		airport.arrivesAt("avion",1050);
		airport.arrivesAt("avion",1200);
		assertEquals(1200, airport.arrivalTime("IBE3835"));
	}
	
	@Test
	public void Porpiedad2() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		PositionList<FlightArrival> nuevo = new NodePositionList<>();
		airport.arrivesAt("avion1",1050);
		airport.arrivesAt("avion2",1200);
		nuevo.addLast(new FlightArrival("avion2",1200));
		
		assertEquals(nuevo, airport.arriving(0));
	}
	

	
}
