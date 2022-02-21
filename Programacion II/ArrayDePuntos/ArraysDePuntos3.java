import java.awt.Color;
public class ArraysDePuntos3 {
    public static void iniciarGraficos(){
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(-10,10);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
    }
    static Color colorAlea(){
        return new Color(aleatorio(255),aleatorio(255),aleatorio(255));
    }
    static int aleatorio (int n) 
    { 
      return (int)(Math.random() * Math.abs(n));
    }
    static int aleatorio (int a, int b) 
    { 
      return (int)(Math.random() * Math.abs(b-a+1)) + a;
    }
    static Punto puntoAlea(){
       return new Punto(aleatorio(-10,10), aleatorio(-10,10), colorAlea());
    }
    
    static String toString (Punto[] puntos){
        String s = "";
        for (int i = 0; i<puntos.length ; i += 1){
            s += puntos[i] + " ";
        }
        return s;
    }
    static void pintar ( int n){
        for ( int i = 1 ;  i <= n ; i+=1){
            puntoAlea().pintar();
        }
    }
    static void pintar (Punto[] puntos)
    {
      for (int i=0; i<=puntos.length; i+=1)
        puntos[i].pintar();
    }
    static Punto[] genera (int n){
        Punto[] puntos = new Punto[n];
        for (int i = 0; i <= n-1 ; i += 1)
            puntos[i] = puntoAlea();
        return puntos;
        
    }
    public static void main(String[] args) {
        iniciarGraficos();
        Punto[] puntos_3 = genera(10000);
        pintar(puntos_3);
        pintar(100);
    }

}
