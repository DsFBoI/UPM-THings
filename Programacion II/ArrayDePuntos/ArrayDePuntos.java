public class ArraysDePuntos {
    static String toString(Punto[] puntos){
        String s = "[";
        for  ( int i = 0; i<puntos.length; i += 1){
            if ( i != 0 ){
            s += ",";
            }
            s += puntos[i].toString();
            
        
        }
        return s + "]";
    }
    public static void main(String[] args) {
        Punto p0 = new Punto (0, 0);
        Punto p1 = new Punto (1, 1);
        Punto p2 = new Punto (8, 6);
        // Punto[] puntos = new Punto[]{p0, p1, p2};
        // System.out.println(toString(puntos));
        Punto[] puntos_2 = new Punto[5];
        puntos_2[0] = p0;
        puntos_2[1] = p1;
        System.out.println(toString(puntos_2));
        Punto[] puntos_3 = new Punto[]{};
        System.out.println(toString(puntos_3));

    }
}
