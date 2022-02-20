package aed.individual5;

import es.upm.aedlib.Pair;
import es.upm.aedlib.map.*;


public class TempUtils {
  public static Map<String,Integer> maxTemperatures(long startTime,long endTime,TempData[] tempData){
	
	  
	
	Map<String,Integer> result = new HashTableMap<String, Integer>();

	for(int i = 0;i<tempData.length;i++) {
		
		if(tempData[i].getTime()>=startTime && tempData[i].getTime()<=endTime ) {//aqui pasa el filtro si el tiempo del TempData marcado esta en el intervalo de tiempo
			if(result.containsKey(tempData[i].getLocation())) {//comprobamos si la key esta en el resultado
				if(result.get(tempData[i].getLocation())<tempData[i].getTemperature()) {//y si esta vemo s i la temperatura del TempData es mayor que la almacenada en el mapa
					result.remove(tempData[i].getLocation());
					result.put(tempData[i].getLocation(), tempData[i].getTemperature());
				}
			}
			else {//si no esta en el mapa se anade
				
				result.put(tempData[i].getLocation(), tempData[i].getTemperature());
			}
		}
	}
    return result;
  }


  public static Pair<String,Integer> maxTemperatureInComunidad(long startTime,long endTime,String region,
                                                               TempData[] tempData,
                                                               Map<String,String> comunidadMap) {
	  Pair<String,Integer> resultPair = null ;//creamos el resultado
	  for(int i = 0; i<tempData.length;i++) {
		  if(tempData[i].getTime()>=startTime && tempData[i].getTime()<=endTime ) {//mismo caso que en el ej 1
			
			  if(comunidadMap.get(tempData[i].getLocation()).equals(region)) {//vemos si el lugar de tempdata esta en la region
				  
				  if(resultPair == null || tempData[i].getTemperature()>resultPair.getRight()) {//si no tenemos un resultado o se cumple los requesitos anteriores y el nuevo de temperatura pues marcamos un nuevo resultado
					  
					  resultPair = new Pair<String,Integer>(tempData[i].getLocation(),tempData[i].getTemperature());
			 }
		  }
	  }

	  }	

    return resultPair;
  }

}
