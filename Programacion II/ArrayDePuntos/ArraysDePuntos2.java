public class ArraysDePuntos2 {
      static void iniciarGraficos ()
      {
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(-10, 10);    
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.02);
      }
      static String toString (Punto[] puntos)
      {
        String s = "";
        for (int i=0; i<puntos.length; i+=1)
          s += puntos[i] + " ";
        return s;
      }
      static void pintar (Punto[] puntos)
      {
        for (int i=0; i<puntos.length; i+=1)
          puntos[i].pintar();
      }
      public static void main (String[] args) 
      {
        PuntoTest_3.resetear();
        Punto[] puntos = new Punto[]{PuntoTest_3.p0, PuntoTest_3.p1, PuntoTest_3.p2};
        System.out.println(toString(puntos));
        //
        iniciarGraficos();
        pintar(puntos);
      } 
    }
    

