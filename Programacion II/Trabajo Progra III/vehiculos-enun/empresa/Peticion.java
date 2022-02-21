package empresa;
/**
 * Petición de un Vehiculo para alquilar.
 *
 * @author Javier Galve
 */
public class Peticion
{
  private String dni;  //DNI del cliente que hace la petición.
  private int codigo;  //código del Vehiculo a alquilar 
                       //(ver códigos en clase Vehiculo).
  private int dias;

  public Peticion (String dni, int codigo, int dias)
  {
    this.dni = dni;
    this.codigo = codigo;
    this.dias = dias; 
  }
  public String toString ()
  {
    return "Peticion" + "(DNI=" + dni + " codigo=" + codigo + 
           " dias=" + dias +")";
  } 
  public String dni ()
  {
    return dni;
  } 
  public int codigo ()
  {
    return codigo;
  } 
  public Peticion clone ()
  {
    return new Peticion(dni, codigo, dias); 
  }  
} 
  