package db.stats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.AdministradorConexion;
import db.map.JugadorBD;
import model.Equipo;
import model.Jugador;

public class Estadisticas {
	/**
	 * M�todo que debe devolver el listado de los jugadores que no han estado en ning�n equipo 
	 * en el a�o recibido como par�metro
	 * @param anio
	 * @return
	 */
	public static List<Jugador> getJugadoresNoHanEstadoEnEquipo(int anio){

		/* Sacamos todos los datos de los jugador_milita_equipo, tambien creamos tres listas que nos ayudaran a hacer una comparacion de listaas basica,
		primero el resultado que sera la lista donde delvolveremos los jugadores,jugadores es la lista que contiene todos los jugadores y por ultimo 
		jugadores2 que sera una array list que almacene todos los jugadores que han participado en el año dado */
		String sql = "SELECT * FROM jugador_milita_equipo;";
		List<Jugador> result = new ArrayList();
		List<Jugador> jugadores = JugadorBD.getAll();
		List<String> jugadores2 = new ArrayList();

        PreparedStatement st = null;
        ResultSet rs = null;
       

        try {
			/*ejecutamos la query si hay algun error se va a los catch */
            st = AdministradorConexion.prepareStatement(sql);
            rs = st.executeQuery();

            while(rs.next()) {
				/*Primero se deben cumplir condiciones para almacenar el nif del jugador, se tiene que cumplir qu el año de fecha fin se mayor que el año dado o
				que este siga en activo, y la otra que la fecha de iniciio sea anterior al año, de ahi sacamos que este ha milatado durante ese año */
            	if((rs.getDate("fecha_fin")==null || rs.getDate("fecha_fin").toLocalDate().getYear()>=anio ) && rs.getDate("fecha_inicio").toLocalDate().getYear() <= anio ) {
            		jugadores2.add(rs.getString("nif_jugador"));
            		
            	}
            }
        
            
           
            
            for(Jugador e : jugadores ) {
				/*Despues gracias a la lista sacada podemos ir descartando de la lista completa que habiamos saca en la lista jugadores, 
				usamos la funcion contains que significa que si contiene el elemento dado en la lisa delvuelve true si no false, esto lo 
				usmaos que cada vez que esta nos de false es decir que no haya militado en el equipo lo almacene en el resultado */
            	if(!jugadores2.contains(e.getNif())) {
            		
            		result.add(e);
            	}
            }
            
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        }
        catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } finally {
			/*cerramos el sattement y la query para evitar errores */
            try {
                if(st!=null) {
                    st.close();
                }
                if(rs!=null) {
                    rs.close();
                }
            }
            catch(SQLException e) {
                System.err.println("Error al liberar los recursos:");
                System.err.println(e.getMessage());
            }
        }
		
		
		return result;
	}
		
	
	/**
	 * M�todo que devuelve el n�mero de equipos del mismo club m�ximo en los que alg�n jugador ha estado
	 * @return
	 */
	public static int getNumeroMaximoEquiposDelMismoClubHaEstadoUnJugador(){

		/*Para esta query utilizaremos dos tablas tanto jugador_milita_equipo como la tabla equipo, estas tienen en comun la licencia del equipo,
		 aparte de esto la ordenaremos para facilitar todo, primero por el nif luego el club en el que esta el equipo y por ultimo el equipo en el que juega.
		 
		 Creamos aparte de eso un contador que ira contando el numero de equipos del mismo club, el max que es el numero maximo de equipos del mismo club en los
		 que ha estado un jugador, y nifAntiguo, clubantiguo y equipo antiguo, cuya ocupacion es almacenar los datos previos usados para comparar.
		 */
		String sql = "SELECT * FROM jugador_milita_equipo,equipo WHERE equipo.licencia = jugador_milita_equipo.licencia_equipo ORDER BY jugador_milita_equipo.nif_jugador,equipo.nombre_club,equipo.licencia;";
		
		
		int contador = 0;
		int max = 0;
		String nifAntiguo= "";
		String clubAntiguo = "";
		int equipoAntiguo = 0;
		
	

        PreparedStatement st = null;
        ResultSet rs = null;
       

        try {

			/*Preparamos el statement y query */
            st = AdministradorConexion.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {

				/*Primero es un comparador de nifs para ver si en la query hemos saltado a otro jugador, de ahi si el contado del anterior ha sido mayor 
				que el maximo este se almacena en max y se reincia*/
            	if(!nifAntiguo.equals(rs.getString("nif_jugador"))) {
            		if(contador > max){
    					max = contador;
    				}
            		contador = 1;
            		
            		
            	}
				/*si este no es el caso se mira el club en el que esta su nuevo equipo si es no es el mismo volvemos a ver si contador es mayor y se reinicia el contador */
            	else if(!clubAntiguo.equals(rs.getString("equipo.nombre_club"))) {
            		if(contador > max){
    					max = contador;
    				}
            		contador= 1;
  
            	}
				/* Por ultimos si el equipo no es el mismo, se suma 1 al contador significando que es un equipo del mismo club en el que no habia estado previamente */
            	else if(equipoAntiguo != rs.getInt("equipo.licencia")) {
        			contador++;
        		
        		}
            	/*Se actualizan los valores */
            	
            	nifAntiguo = rs.getString("nif_jugador");
            	equipoAntiguo = rs.getInt("equipo.licencia");
            	clubAntiguo = rs.getString("equipo.nombre_club");
            	
            }
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        }catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } finally {
			/*se cierra tanto statement como query */
            try {
                if(st!=null) {
                    st.close();
                }
                if(rs!=null) {
                    rs.close();
                }
            }
            catch(SQLException e) {
                System.err.println("Error al liberar los recursos:");
                System.err.println(e.getMessage());
            }
        }
		
		
		
		return max;
	}
	
	
	/**
	 * M�todo que debe devolver el listado de los jugadores que han estado en el mayor n�mero de equipos
	 * del mismo club 
	 * @return
	 */
	public static List<Jugador> getJugadoresMasEquiposMismoClub(){
		/*Un ejercicio muy parecido al previo, donde de hecho se reutiliza el codigo ya que uno de los paramaentros en este caso max será el la funcion previa
		de aqui el nuevo statement sera practicamente similar, lo unico que cambia es el orden que esta vez ira  equipo.nombre_club,jugador_milita_equipo.nif 
		y equipo.licencia los parametros tampoco cambiaran el unico cambio es el max  que he mencionado antes el resto siguen iguales, el unico parametro nuevo 
		es el resultado que pasa a ser una lista de jugadores*/
			List<Jugador> result = new ArrayList();
			String sql = "SELECT * FROM jugador_milita_equipo,equipo WHERE equipo.licencia = jugador_milita_equipo.licencia_equipo ORDER BY  equipo.nombre_club,jugador_milita_equipo.nif_jugador,equipo.licencia;";


	        PreparedStatement st = null;
	        ResultSet rs = null;
	        
	        int contador = 0;
			int max = getNumeroMaximoEquiposDelMismoClubHaEstadoUnJugador();
			String nifAntiguo= "";
			String clubAntiguo = "";
			int equipoAntiguo = 0;
				    
	       

	        try {
				/*se prepara el statement y la query */
	            st = AdministradorConexion.prepareStatement(sql);
	            rs = st.executeQuery();
	            
	            while(rs.next()) {
					/* si el nif es nuevo se chequea si este contador del jugador previo al nuevo es igual al maximo,si esto se cumple se añade a la lista resultante
					se reinicia tambien el contador*/
	            	if(!nifAntiguo.equals(rs.getString("nif_jugador"))) {
	            		if(contador == max){
	    					result.add(JugadorBD.getById(nifAntiguo));
	    				}
	            		contador = 1;
	            		
	            		
	            	}
					/*el contador tambien se reincia si se cambia de club y no es igual al previo */
	            	else if(!clubAntiguo.equals(rs.getString("equipo.nombre_club"))) {
	            		contador= 1;
      
	            	}
					/*si se cumple lo previo y se cumple que es un equipo diferente este suma 1 a su contador */
	            	else if(equipoAntiguo != rs.getInt("equipo.licencia")) {
            			contador++;
            		
            		}
	            	
	            	/* se actualizan los valores nuevos */
	            	
	            	nifAntiguo = rs.getString("nif_jugador");
	            	equipoAntiguo = rs.getInt("equipo.licencia");
	            	clubAntiguo = rs.getString("equipo.nombre_club");
	            	
	            }
	        }catch(SQLException e) {
	            System.err.println("Error al ejecutar");
	            System.err.println(e.getMessage());
	        }catch(Exception e) {
	            System.err.println("Error al ejecutar");
	            System.err.println(e.getMessage());
	        } finally {
				/*se cierran el statement y la query */
	            try {
	                if(st!=null) {
	                    st.close();
	                }
	                if(rs!=null) {
	                    rs.close();
	                }
	            }
	            catch(SQLException e) {
	                System.err.println("Error al liberar los recursos:");
	                System.err.println(e.getMessage());
	            }
	        }
	        
		return result;
	}

	/**
	 * M�todo que debe devolver el listado de los jugadores que han estado en el equipo recibido como
	 * par�metro el a�o (anio)
	 * @param equipo
	 * @param anio
	 * @return
	 */
	public static List<Jugador> getJugadoresEquipoAnio(Equipo equipo, int anio) {
		/*Es un codigo muy parecido al ejercicio 1 de este programa, este es contrario al anterior pero con una condicion que es el equipo,
		se hace como el previo, misma query con tres listas, pero en este caso jugadores 2 se almacena los dnis que cumplen militancia en ese año y 
		con una condicion mas que es que militen en el equipo dado  */

		String sql = "SELECT * FROM jugador_milita_equipo;";
		List<Jugador> result = new ArrayList();
		List<Jugador> jugadores = JugadorBD.getAll();
		List<String> jugadores2 = new ArrayList();

        PreparedStatement st = null;
        ResultSet rs = null;
        int hola = Integer.parseInt(equipo.getLicencia());
       

        try {
            st = AdministradorConexion.prepareStatement(sql);
            rs = st.executeQuery();
            

            while(rs.next()) {

            	/*condiciones similares al primer ejercicio pero añadiendo una condicion mas que es la del equipo*/
				 
            	if((rs.getDate("fecha_fin")==null || rs.getDate("fecha_fin").toLocalDate().getYear()>=anio ) && rs.getDate("fecha_inicio").toLocalDate().getYear() <= anio && rs.getInt("licencia_equipo") == hola) {
            		jugadores2.add(rs.getString("nif_jugador"));
            		
            	}
            }
           
            /*La lista resultante es jugdores2 pero esta solo coniene los dnis, con lo que hacemos un comparador con la lista jugadores que 
			los añade si el dni del jugaor coincide con laaguno de los de la lista de jugadores 2*/
            for(Jugador e : jugadores ) {
            	if(jugadores2.contains(e.getNif())) {
            		
            		result.add(e);
            	}
            }
           
            
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
            
        }
        catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } finally {
			/* cierra tanto el statement como la query */
            try {
                if(st!=null) {
                    st.close();
                }
                if(rs!=null) {
                    rs.close();
                }
            }
            catch(SQLException e) {
                System.err.println("Error al liberar los recursos:");
                System.err.println(e.getMessage());
            }
        }
		
		
		return result;
	}
}
