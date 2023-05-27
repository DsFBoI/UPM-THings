package db.map;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import db.AdministradorConexion;
import model.Jugador;

public class JugadorBD {
	/**
	 * Obtiene de la base de datos todos los jugador, 
	 *    devolviendo una lista de objetos del tipo model.Jugador
	 * @return
	 */
	
	
	public static List<Jugador> getAll() {

         /* Para este statement cogemos todas las categoria y las introducios en una lista,
        en este caso de Jugadores*/

		List<Jugador> result = new ArrayList();
		String sql = "SELECT * FROM jugador";

        PreparedStatement st = null;
        ResultSet rs = null;
        


        try {
            /* ejecuta el sattement proporcionado y de ahi si durante la funcion hay algun error este ira a los catch */
            st = AdministradorConexion.prepareStatement(sql);
            rs = st.executeQuery();

            while(rs.next()) {
               Jugador a = new Jugador(rs.getString("nif"),rs.getString("nombre"),rs.getString("apellido_1"),rs.getString("apellido_2"),rs.getDate("fecha_nacimiento").toLocalDate());
               result.add(a);
            }
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } 
        
        finally {
            /*se cierra el statement y la query si al cerrarlo surge un fallo este salta al catch */
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
	 * Obtiene de la base de datos el jugador con nif igual al par�metro nifJugador, 
	 *    creando un objeto del tipo model.Jugador
	 * @param nifJugador
	 * @return
	 */
	public static Jugador getById(String nifJugador) {
		
		String sql = "SELECT * FROM jugador where jugador.nif= ?";
		Jugador result = null;

        PreparedStatement st = null;
        ResultSet rs = null;
       

        try {
            st = AdministradorConexion.prepareStatement(sql);
            st.setString(1, nifJugador);
            rs = st.executeQuery();

            while(rs.next()) {
               result = new Jugador(rs.getString("nif"),rs.getString("nombre"),rs.getString("apellido_1"),rs.getString("apellido_2"),rs.getDate("fecha_nacimiento").toLocalDate());
            }
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        }catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } 
        
        finally {
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
