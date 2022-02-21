//import stdlib.*;
public class ColDeContactos{ 
  



  private Contacto[] elementos;
  private int longitud;

  public Contacto[] getElementos() {
      return elementos;
  }

  
  public int getLongitud() {
      return longitud;
  }
 
  
  public ColDeContactos (){
    elementos = new Contacto[30];
    longitud = 0;
  }


  public ColDeContactos (int maxNumContactos)
  {
    elementos = new Contacto[maxNumContactos];
    longitud = 0;
  }

  public String toString (){
    String resultado = "";
    for (int i = 0; i < longitud; i++)
      resultado = resultado + elementos[i] + "\n"; //uno por linea
    return resultado;
  }


  public int size (){
    return longitud;
  }


  public Contacto get (int pos){
    return elementos[pos];
  }


  public void set (int pos, Contacto elem){
    elementos[pos] = elem;
  }


  public void add (Contacto elem){
    elementos[longitud] = elem;
    longitud = longitud + 1;
  }

  public void add (int pos, Contacto elem){
    for (int i = longitud; i > pos; i--)
      elementos[i] = elementos[i-1];
    elementos[pos] = elem;
    longitud = longitud + 1;
  }


  public int indexOf (Contacto elem){
    int i = 0;
    boolean esta = false;
    while (i < longitud && !esta)
      if (elem.equals(elementos[i]))
      esta = true;
    else
      i = i + 1;
    return (esta)? i : -1;
  }

  public void removeElementAt (int pos){
    for (int i = pos; i < longitud-1; i++)
      elementos[i] = elementos[i+1];
    longitud = longitud - 1;
  }


  public void remove (Contacto elem){
    int pos = indexOf(elem);
    boolean encontrado;
    if (pos >= 0) 
      removeElementAt(pos); 
  }

   
  public int maxSize ()
  {
    return elementos.length;
  }
  public static void main(String[] args) {
  
  }
  
}