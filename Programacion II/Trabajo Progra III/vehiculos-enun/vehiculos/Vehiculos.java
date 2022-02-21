package vehiculos;
import tads.*;
/** 
 * Colecci�n de vehiculos dados de alta en la empresa.
 * 
 * @author Javier Galve
 */
public class Vehiculos extends ArrayList<Vehiculo>{
  /** 
   * Constructor de Vehiculos.
   */
  public Vehiculos () {
    super();
  }
  /** 
   A�ade un veh�culo a la lista, poni�ndolo
   al final para respetar el orden de llegada.
   */
  public void registrarVehiculo (Vehiculo v) {
      add(size(), v);
  }
  /** 
   * POST: Devuelve el vehiculo con <matricula> o null en caso
   *       de no encontrarlo. 
   */
  public Vehiculo buscaVehiculo (String matricula) {
    Vehiculo result = null;
    boolean found = false;
    for(int i = 0 ; i<super.size() && !found; i++){
      if (super.get(i).matricula() == matricula){
        found= true;
        result = super.get(i);
      }
    }
    return result;
  }


  /** 
   * PRE: Hay al menos un vehiculo con <matricula> en la lista de veh�culos.
   * POST: resultado es el precio del alquiler del vehiculo con <matricula> y 
           durante un periodo de varios <dias>.
   * throws: RuntimeException en caso que no haya ning�n vehiculo con esta
             matricula en la lista de veh�culos.
   */
  public double precioAlquiler (String matricula, int dias) {
    Vehiculo result = buscaVehiculo(matricula);
    double finalprice ;
    if(result == null){
      throw new RuntimeException("No hay ningun coche con esa Matricula");
    }
    else{
      finalprice = result.precioAlquiler(dias);
    }

    return finalprice;
  } 
  /**
   POST: resultado es una cadena de caracteres con todos los 
         veh�culos registrados y sus precios en funci�n del numero 
         de <dias>.
   */
  public String mostrarTodosLosPrecios (int dias){
    String Resultado = "[ ";
    for (int  i= 0; i<super.size() ; i++){
      Vehiculo V = super.get(i);
      Resultado = Resultado +   V.precioAlquiler(dias) + '\n';
    }
  return Resultado + "]";
  }
}
