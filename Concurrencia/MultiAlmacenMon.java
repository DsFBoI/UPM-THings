import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Monitor;
import es.upm.babel.cclib.MultiAlmacen;

// importar la librería de monitores


class MultiAlmacenMon implements MultiAlmacen {
    private int capacidad = 0;
    private Producto almacenado[] = null;
    private int aExtraer = 0;
    private int aInsertar = 0;
    private int nDatos = 0;

   // TODO: declaración de atributos extras necesarios
   // para exclusión mutua y sincronización por condición
    private Monitor mutex;

    private volatile boolean poner;
    private volatile boolean tomar;
    

   // Para evitar la construcción de almacenes sin inicializar la
   // capacidad 
   private MultiAlmacenMon() {
   }

   public MultiAlmacenMon(int n) {
      almacenado = new Producto[n];
      aExtraer = 0;
      aInsertar = 0;
      capacidad = n;
      nDatos = 0;

      // TODO: inicialización de otros atributos
      mutex = new Monitor();

      poner = false;
      tomar = false;

   }

   private int nDatos() {
         return nDatos;
   }
   
   private int nHuecos() {
      return capacidad - nDatos;
   }

   public void almacenar(Producto[] productos) {

      // TODO: implementación de código de bloqueo para 
      // exclusión muytua y sincronización condicional 

      // PRE: Longitud(s) <= [MAX /2]

      if(productos.length > this.capacidad/2){
          return;
      }

      //CPRE: Hay sitio en el buffer para dejar la secuencia
      if(nHuecos() < productos.length){
          return;
      }

      //CPRE: Longitud(self + s) <= MAX

      if((productos.length + almacenado.length) > capacidad){
          return;
      }

        tomar = true;
        mutex.enter();

        while(!poner);
    
      // Sección crítica

      for (int i = 0; i < productos.length; i++) {
         almacenado[aInsertar] = productos[i];
         nDatos++;
         aInsertar++;
         aInsertar %= capacidad;
      }

      // TODO: implementación de código de desbloqueo para
      // sincronización condicional y liberación de la exclusión mutua  
      mutex.leave();
      tomar = false;
   }

   public Producto[] extraer(int n) {
      Producto[] result = new Producto[n];

      // TODO: implementación de código de bloqueo para exclusión
      // mutua y sincronización condicional 

      //PRE: n <= [MAX /2]

      if(n > this.capacidad/2){
          return null;
      }

      //CPRE: Hay suficientes elementos en el multibuffer

      if(n > nDatos){
          return null;
      }

      //CPRE: Longitud(self) >= n

      if( this.almacenado.length < n ){
          return null;
      }
    
      poner = true;
      mutex.enter();
      while(!tomar);

      // Sección crítica
      for (int i = 0; i < result.length; i++) {
         result[i] = almacenado[aExtraer];
         almacenado[aExtraer] = null;
         nDatos--;
         aExtraer++;
         aExtraer %= capacidad;
      }

      // TODO: implementación de código de desbloqueo para
      // sincronización condicional y liberación de la exclusión mutua  

      mutex.leave();
      poner = false;
      return result;
   }
}
