/**
 * Implementaci�n del TAD GUrgencias<br>
 * {@code ED = TUPLA(ppo,fin)=(Nodo,Nodo)}<br>
 * @since 22/4/2021
 * @version 1.0
 * @author JMB
 */
public class GUrgencias implements IGUrgencias
{

  private Nodo<IPaciente> ppo;   // Indice al primero
  private Nodo<IPaciente> fin;   // Indice al ultimo

  public GUrgencias ()
  {
    ppo = null;
    fin = null;
  }
  public String toString ()
  {
    String resultado = "<";
    Nodo<IPaciente> aux = ppo;
    int contador = 0;
    while (aux != null)
    {
      contador = contador + 1;
      resultado = resultado + aux.elemento;
      if (aux.siguiente != null) resultado = resultado + ",";
      aux = aux.siguiente;
    }  
    resultado = resultado + ">";
    return "(" + contador + "," + resultado + ")";
  }
  public boolean estaVacio ()
  {
    return ppo == null;
  }

// TIPO BUSQUEDA ----------------------------------------------------

  private class Par{
    Nodo<IPaciente> anterior;
    Nodo<IPaciente> actual;
    
    Par (Nodo<IPaciente> pp1, Nodo<IPaciente> pp2)
    {
      anterior = pp1;
      actual   = pp2;
    }
  }
  /**
   * POST: resultado es el Par(anterior,actual) del elemento de
   *       menor edad del objeto.
   */    
  private Par elDeMenorEdad (){
    Nodo<IPaciente> minAnterior = null;
    Nodo<IPaciente> minActual = null;
    int minEdad = 200;
    Nodo<IPaciente> anterior = ppo;
    Nodo<IPaciente> actual = ppo;
    while (actual != null)
    {
      int edadActual = actual.elemento.getEdad();
      if (edadActual < minEdad)
      {
        minAnterior = anterior;
        minActual = actual;
        minEdad = edadActual; 
      }
      anterior = actual;
      actual = actual.siguiente;
    }
    return new Par(minAnterior,minActual);
  }

//  -----------------------------------------------------------------
  
  public IPaciente primero(){
    if(ppo == null) {
      return null;
    }
    else{
      return ppo.elemento;
    }
  }


  public void insertar (IPaciente elem){
    Nodo<IPaciente> nuevo = new Nodo<IPaciente>(elem, null);
    if (ppo == null){
      ppo = new Nodo<IPaciente>(elem, null);
      fin = ppo;

    }
    else if(elem.getPrioridad() != 0 && elem.getPrioridad() > ppo.elemento.getPrioridad() || elem.getPrioridad() == 0 && elem.getEdad() < ppo.elemento.getEdad()) { 
      nuevo .siguiente = ppo;
      ppo = nuevo;
    }
    else{
      Nodo<IPaciente> aux = ppo;
      boolean encontrado = false ; 
      while(aux != null && !encontrado){
        if (aux.siguiente == null){
          aux.siguiente = nuevo;
          fin = aux.siguiente;
          encontrado = true;
        }
        else if(elem.getPrioridad() != 0 && elem.getPrioridad() > aux.siguiente.elemento.getPrioridad() || elem.getPrioridad() == 0 && elem.getEdad() < aux.siguiente.elemento.getEdad()){
          nuevo.siguiente = aux.siguiente;
          aux = aux.siguiente;
          encontrado = true;
        }
        aux = aux.siguiente;
      }

    }
      
    }  

  public void borrar (){
    if (ppo != null){
      ppo = ppo.siguiente;
    }
  }

}