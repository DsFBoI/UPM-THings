package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.AdministradorConexion;
import model.CategoriaEdad;
import model.Jugador;

public class CategoriaEdadBD {
	/**
	 * Obtiene de la base de datos todas las categor�a de edad devolviendo una lista de objetos CategoriaEdad 
	 * @return
	 */
	public static List<CategoriaEdad> getAll() {
        /* Para este statement cogemos todas las categoria y las introducios en una lista,
        en este caso de Categorias de Edad */
		List<CategoriaEdad> result = new ArrayList();
		String sql = "SELECT * FROM categoria_edad;";

        PreparedStatement st = null;
        ResultSet rs = null;

        
        try {
            /* ejecuta el sattement proporcionado y de ahi si durante la funcion hay algun error este ira a los catch */
            st = AdministradorConexion.prepareStatement(sql);
            rs = st.executeQuery(sql);

            while(rs.next()) {
              CategoriaEdad a = new CategoriaEdad(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),rs.getInt("edad_minima"),rs.getInt("edad_maxima"));
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
	 * 
	 * @param categoriaEdad
	 * @return Obtiene de la base de datos la categor�a de edad con id igual al par�metro categoriaEdad, 
	 *    creando un objeto del tipo model.CategoriaEdad
	 */
	public static CategoriaEdad getById(int categoriaEdad) {

        /*Comenzamos creando un statement que implemetaremos mas tarde, tambien creamos un el resto de elementos necesario*/

		String sql = "SELECT * FROM categoria_edad where categoria_edad.id="+categoriaEdad;
		CategoriaEdad result = null;

        PreparedStatement st = null;
        ResultSet rs = null;
       

        try {
            /*Ejecutamos la query y si en algun proceso esta tiene un error salta a la sql exception , 
            pero si este error no esta relacionado con squl saltara a la exception normal*/

            st = AdministradorConexion.prepareStatement(sql);
            rs = st.executeQuery(sql);

            /* Es una estructura que los otros programas creamos una clase que necesitemos y es esta la que devolvemos como resultado*/

            while(rs.next()) {
               result = new CategoriaEdad(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),rs.getInt("edad_minima"),rs.getInt("edad_maxima"));
               
            }

        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } 
        
        finally {

            /*Cerramos tanto el statement como la query, ya que esto podria causar errores a la hora de ejecutar otras query*/

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
	 * 
	 * @param ce
	 * @return Borra de la base de datos la categor�a de edad con id igual al identificador del objeto ce
	 */
	public static boolean deleteCategoria(CategoriaEdad ce) {

        /* Este stamente unicamente borra la categoria de edad dada por el usuario, mediante su funcion getId */
		String sql = "DELETE FROM categoria_edad where categoria_edad.id="+ce.getId();
		boolean result = false;

        PreparedStatement st = null;
        try {
            /* el elemento se elimina y si este a la hora de intentar encontrarlo es null,
             el resultado dara true significando que este se ha eleminado con exito,
             si hay algun error en el proceso este ira a los catch dependiendo del error*/

            st = AdministradorConexion.prepareStatement(sql);
            result = (getById(ce.getId())==null);
            
        } catch(SQLException e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        }catch(Exception e) {
            System.err.println("Error al ejecutar");
            System.err.println(e.getMessage());
        } 
        
        finally {
            try {
                /* aqui solo usamos el statement con lo que lo unico a cerrar es el statement*/ 
                if(st!=null) {
                    st.close();
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
	 * Este m�todo guarda en la base de datos (actualiza o crea) los objetos del tipo CategoriaEdad que recibe en
	 * la lista data
	 * Si el objeto CategoriaEdad tiene id igual a -1 (se ha creado en Java) se realiza un insert y se actualiza el
	 * id en el objeto
	 * Si el objeto tiene id (se ha recuperado de la bbdd) se hace un update
	 * @param data
	 */
	public static void saveAll(List<CategoriaEdad> data) {
		String queryInsert = "INSERT INTO categoria_edad (nombre, descripcion, edad_minima, edad_maxima) VALUES (?,?,?,?); " ;
		String queryUpdate = "UPDATE categoria_edad SET nombre=?, descripcion=?, edad_minima=?, edad_maxima=? WHERE id=?; " ;
		PreparedStatement psInsert = null, psUpdate = null;
		try {
			psInsert = AdministradorConexion.prepareStatement(queryInsert);
			psUpdate = AdministradorConexion.prepareStatement(queryUpdate);
			for (CategoriaEdad ce : data) {
				if (ce.getId()<0) {
					psInsert.setString(1, ce.getNombre());
					psInsert.setString(2, ce.getDescripcion());
					psInsert.setInt(3, ce.getEdadMinima());
					psInsert.setInt(4, ce.getEdadMaxima());
					//boolean done = 
					psInsert.execute();	
					ResultSet rs = psInsert.getGeneratedKeys();
					if (rs.next()) {
					  int newId = rs.getInt(1);
					  ce.setId(newId);
					}
				}
				else {
					psUpdate.setString(1, ce.getNombre());
					psUpdate.setString(2, ce.getDescripcion());
					psUpdate.setInt(3, ce.getEdadMinima());
					psUpdate.setInt(4, ce.getEdadMaxima());
					psUpdate.setInt(5, ce.getId());
					//boolean done = 
					psUpdate.execute();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (psInsert!=null && !psInsert.isClosed())
					psInsert.close();
				if (psUpdate!=null && !psUpdate.isClosed())
					psUpdate.close();
					
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
