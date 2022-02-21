package empresa;
import tads.*;
import vehiculos.*;
/**
 * Empresa de alquiler de vehículos.
 *
 * @author Daniel Sánchez Ferrari
 */
public class Empresa
{
  private Vehiculos vehiculos;
  private IList<IQueue<Vehiculo>> flota;
  private IQueue<Peticion> peticiones;
  private Vehiculos asignados;
  private IQueue<Peticion> listaDeEspera;
  
  private static Vehiculos cargaVehiculos (Vehiculo[] vs){
    Vehiculos vehiculos = new Vehiculos();
	  for (int i = 0; i < vs.length; i++)
	    vehiculos.registrarVehiculo(vs[i]);
    return vehiculos;
  }
  private static IQueue<Peticion> cargaPeticiones (Peticion[] ps){
    IQueue<Peticion> peticiones = new Queue<Peticion>();
	  for (int i = 0; i < ps.length; i++)
	    peticiones.push(ps[i]);
    return peticiones;
  }
  /**
   Constructor de la Empresa.
   */
  public Empresa (Vehiculo[] vs, Peticion[] ps){
    vehiculos = cargaVehiculos(vs);
    peticiones = cargaPeticiones(ps);
    flota = new ArrayList<IQueue<Vehiculo>>();
    asignados=new Vehiculos();
    listaDeEspera=new Queue<Peticion>();
    for (int i = Vehiculo.COCHE; i <= Vehiculo.CAMION; i++){
      flota.add(i, new Queue<Vehiculo>());
    }
   
  }
  /**
   Carga la <flota> de vehiculos a partir de <vehiculos>
   (ver enunciado).
   */
  public void cargarFlota (){
    for(int i=0; i<vehiculos.size(); i++){
      if(vehiculos.get(i) instanceof Coche){
        flota.get(Vehiculo.COCHE).push(vehiculos.get(i));
      }
      else if(vehiculos.get(i) instanceof Microbus){
        flota.get(Vehiculo.MICROBUS).push(vehiculos.get(i));
      }
      else if(vehiculos.get(i) instanceof Furgoneta){
        flota.get(Vehiculo.FURGONETA).push(vehiculos.get(i));
      }
      else if(vehiculos.get(i) instanceof Camion){
        flota.get(Vehiculo.CAMION).push(vehiculos.get(i));
      }
    }
  }
  /**
   Alquila los vehiculos a partir de las <peticiones> 
   extrayéndolos de la <flota> y los pone en <asignados>.
   Las peticiones que no se pueden atender se encolan en
   la <listaDeEspera> (ver enunciado). 
   */
  public void alquilarVehiculos (){
    
    while(!peticiones.isEmpty()){
      Peticion aux = peticiones.peek();  
      peticiones.pop();
      if (flota.get(aux.codigo()).isEmpty()){
        listaDeEspera.push(aux);
      }
      else{
        asignados.registrarVehiculo(flota.get(aux.codigo()).peek());
        flota.get(aux.codigo()).pop();
      }
    }
  
 }
  /*
   Para implementar mejorCliente podemos utilizar
   la clase interna privada Contador y las operaciones
   posicion y actualizar.
   Contador modela la frecuencia de aparición de 
   un String llamado elemento.
  */

  private class Contador 
  {
    String elemento;
    int frecuencia;             
    Contador (String elemento) 
    {
      this.elemento = elemento;
      frecuencia = 0;
    } 
  }  
 /**
  lf es una lista de frecuencias que cuenta el número de
  apariciones del dni de un cliente.
  POST: 
    resultado tiene la posición que ocupar el dni 
    en la lista de frecuencias lf.
    En caso de no estar en la lista, el resultado 
    es -1.
  */
  private int posicion (String dni, IList<Contador> lf){
    int i = 0;
    boolean esta = false;
    while (i < lf.size() && !esta)
      if (dni.equals(lf.get(i).elemento))
        esta = true;
      else
        i = i + 1;
    return esta? i : -1;
  }
 /**
  Actualiza la lista de frecuencias lf con el dni.
  */
  private void actualizar (String dni, IList<Contador> lf) {
  
    if (posicion(dni, lf) != -1){
      lf.get(posicion(dni, lf)).frecuencia ++;
    }
    else{
    lf.add(lf.size(), new Contador(dni));
  }
    
  }
  /**
   PRE: !peticiones.isEmpty()
   POST: resultado tiene el DNI del cliente que más peticiones
         de vehículos ha hecho.
   throws RuntimeException si peticiones.isEmpty() 
   (ver enunciado). 
   */
  public String mejorCliente (){
    IList<Contador> lf = new ArrayList<Contador>();// Creation of the frecuncy list.
    ArrayList<Peticion> auxiliar = new ArrayList<Peticion>();// An auxiliar list that will help us to mantain peticiones and not lose some of the info.
    
    if (peticiones.isEmpty()){

      throw new RuntimeException("No hay peticiones:");
    }

    else{ 
      
      while(!peticiones.isEmpty()){

       auxiliar.add(auxiliar.size(),peticiones.peek());
       peticiones.pop();

      }

      for (int i = 0 ; i<auxiliar.size() ; i++){

        peticiones.push(auxiliar.get(i));

        actualizar(auxiliar.get(i).dni(), lf);

      }

      Contador Result = lf.get(0);//The result is here as we had to create the lf first and it is easier for the next loop
      for(int j = 1; j<lf.size(); j++){

        if (Result.frecuencia < lf.get(j).frecuencia){
          Result= lf.get(j);

        }
      }
    return Result.elemento;
  }
   

  }
  /**
   POST: resultado es una cadena de caracteres con todos 
         los datos de la empresa.
   */
  public String toString (){
    String s = new String();
    s += "vehiculos: \n" + vehiculos.toString() + "\n";
    for (int i = Vehiculo.COCHE; i <= Vehiculo.CAMION; i+=1) 
    {
      s += " flota" + i + ": " + flota.get(i).toString() + "\n";
    }
    s += "peticiones: \n" + peticiones.toString() + "\n";
    s += "asignados: \n" + asignados.toString() + "\n";
    s += "listaDeEspera: \n" + listaDeEspera.toString() + "\n";
    return s;
  }
} 
  