package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.AdministradorConexion;
import model.Equipo;
import model.Jugador;

public class EquipoBD {
	/**
	 * Obtiene de la base de datos el equipo con licencia igual al par�metro licenciaEquipo, 
	 *    creando un objeto del tipo model.Equipo
	 * @param licenciaEquipo
	 * @return
	 */
	public static Equipo getById(String licenciaEquipo) {

         /*Comenzamos creando un statement que implemetaremos mas tarde, tambien la ? se cambiara por el paramaetro deseado en el enunciado*/

		String sql = "SELECT * FROM equipo WHERE equipo.licencia= ?;";
		Equipo result = null ;

        PreparedStatement st = null;
        ResultSet rs = null;
       

        try {

            /*Ejequtamos la query y si en algun proceso esta tiene un error salta a la sql exception , 
            pero si este error no esta relacionado con squl saltara a la exception normal*/
            st = AdministradorConexion.prepareStatement(sql);
            st.setString(1, licenciaEquipo);
            rs = st.executeQuery();

            /* Es una estructura que los otros programas creamos una clase que necesitemos y es esta la que devolvemos como resultado*/


            while(rs.next()) {
               result = new Equipo(rs.getString("licencia"),rs.getString("nombre"),rs.getInt("telefono"),rs.getString("equipo.nombre_club"),rs.getInt("id_categoria_edad"),rs.getInt("id_categoria_competicion"));
            }
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } 
        catch(Exception e) {
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
