package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.AdministradorConexion;
import model.Club;
import model.Equipo;

public class ClubBD {
	/**
	 * Obtiene de la base de datos el club con nombre igual al par�metro nombreClub, 
	 *    creando un objeto del tipo model.Club
	 * @param nombreClub
	 * @return
	 */
	
	
	public static Club getById(String nombreClub) {
        /*Comenzamos creando un statement que implemetaremos mas tarde, tambien la ? se cambiara por el paramaetro deseado en el enunciado*/

		String sql = "SELECT * FROM club where club.nombre=?;";
		Club result = null;

        PreparedStatement st = null;
        ResultSet rs = null;
       

        try {
            /*Ejecutamos la query y si en algun proceso esta tiene un error salta a la sql exception , 
            pero si este error no esta relacionado con squl saltara a la exception normal*/
            st = AdministradorConexion.prepareStatement(sql);
            st.setString(1, nombreClub);
            rs = st.executeQuery();
            
             /* Es una estructura que los otros programas creamos una clase que necesitemos y es esta la que devolvemos como resultado*/


            while(rs.next()) {
               result = new Club(rs.getString("nombre"),rs.getString("calle"),rs.getInt("numero"),rs.getInt("piso"),rs.getInt("escalera"),rs.getInt("cp"),rs.getString("localidad"),rs.getString("telefono"),rs.getString("persona_contacto"));
            }
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } 
        
        finally {
            try {
               /*Cerramos tanto el statement como la query, ya que esto podria causar errores a la hora de ejecutar otras query*/

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
