import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Semaphore;
import es.upm.babel.cclib.Almacen;

// TODO: importar la clase de los semáforos.

/**
 * Implementación de la clase Almacen que permite el almacenamiento
 * FIFO de hasta un determinado número de productos y el uso
 * simultáneo del almacén por varios threads.
 */
class AlmacenN implements Almacen {

   /*-----------------------------------------------------------------------------------------------------------------------------*/
   // Declaration of thye necesary Semaphores an variables

   private int capacidad = 0;
   private Producto[] almacenado = null;
   private int nDatos = 0;
   private int aExtraer = 0;
   private int aInsertar = 0;
   private Semaphore espacio;
   private Semaphore productos;
   private Semaphore available;

   public AlmacenN(int n) {
      capacidad = n;
      almacenado = new Producto[capacidad];
      nDatos = 0;
      aExtraer = 0;
      aInsertar = 0;
      //Initialize the semaphores
      espacio = new Semaphore(n);
      productos = new Semaphore(0);
      available = new Semaphore(1);

      
   }


   /*-----------------------------------------------------------------------------------------------------------------------------*/
   //ALMACENAR

   public void almacenar(Producto producto) {


      // Operation of the semphores to syncronize them

      espacio.await();
      available.await();


      // Critical section

      almacenado[aInsertar] = producto;
      nDatos++;
      aInsertar++;
      aInsertar %= capacidad;


      // Operation to let extraer advance

      productos.signal();
      available.signal();
   }

   /*-----------------------------------------------------------------------------------------------------------------------------*/
   //EXTRAER

   public Producto extraer() {
      Producto result;

      //operation to block almacenar while extraer is operating
      productos.await();
      available.await();

      // Critical section
      result = almacenado[aExtraer];
      almacenado[aExtraer] = null;
      nDatos--;
      aExtraer++;
      aExtraer %= capacidad;

       //Operations to let almacenar work

      espacio.signal();
      available.signal();

      return result;
   }
}
