package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.AdministradorConexion;
import model.CategoriaCompeticion;
import model.Equipo;

public class CategoriaCompeticionBD {
	/**
	 * 
	 * @param categoriaCompeticion
	 * @return Obtiene de la base de datos la categor�a de competici�n con id igual al par�metro categoriaCompeticion, 
	 *    creando un objeto del tipo model.CategoriaCompeticion
	 */
	public static CategoriaCompeticion getById(int categoriaCompeticion) {

        /*Comenzamos creando un statement que implemetaremos mas tarde, tambien la ? se cambiara por el paramaetro deseado en el enunciado*/
		String sql = "SELECT * FROM categoria_competicion where categoria_competicion.id=?;";
		CategoriaCompeticion result = null;

        PreparedStatement st = null;
        ResultSet rs = null;
       

        try {
            
            /*Ejequtamos la query y si en algun proceso esta tiene un error salta a la sql exception , 
            pero si este error no esta relacionado con squl saltara a la exception normal*/
            st = AdministradorConexion.prepareStatement(sql);
            st.setInt(1, categoriaCompeticion);
            rs = st.executeQuery();

            /* Es una estructura que los otros programas creamos una clase que necesitemos y es esta la que devolvemos como resultado*/


            while(rs.next()) {
               result = new CategoriaCompeticion(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),rs.getInt("numero_max_equipos"));
            }
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        }catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        }finally {
            try {
                /*Cerramos tanto el statement como la query, ya que esto podria causar errores a la hora de ejecutar otras query*/
                if(st!=null) {
                    st.close();
                }
                if(rs!=null) {
                    rs.close();
                }
            }catch(SQLException e) {
                System.err.println("Error al liberar los recursos:");
                System.err.println(e.getMessage());
            }
        }
		
		
		
		return result;
	}
	
}
