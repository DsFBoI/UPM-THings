import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Semaphore;
import es.upm.babel.cclib.Almacen;




class Almacen1 implements Almacen {
   
   
/*-----------------------------------------------------------------------------------------------------------------------------*/
   // Declaration of thye necesary Semaphores an variables
   private Producto almacenado = null;
   static Semaphore available = new Semaphore(1);
   static Semaphore Space = new Semaphore(1);
   static Semaphore Product = new Semaphore(0);
   public Almacen1() {
   }


/*-----------------------------------------------------------------------------------------------------------------------------*/
   //ALMACENAR

   public void almacenar(Producto producto) {
      // Operation of the semphores to syncronize them
      
      Space.await();
      available.await();
      

      // Critical section
      almacenado = producto;
      

      // Operation to let extraer advance
      available.signal();
      Product.signal();
  
      
   }


/*-----------------------------------------------------------------------------------------------------------------------------*/
   //EXTRAER

   public Producto extraer() {
      
      Producto result = null;
      
      //operation to block almacenar while extraer is operating
      Product.await();
      available.await();

      // Critical section
      result = almacenado;
      almacenado = null;

      //Operations to let  almacenar work
      
      available.signal();
      Space.signal();
  
      return result;
      
   }
}
