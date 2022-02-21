public class CirculoTest {
    public static void iniciarGraficos(){
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(-10,10);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
    }

    public static void main(String[] args) {
        Circulo c0;
        Circulo c1;
        Circulo c2;
        c0 = new Circulo (new Punto(0,0),4);
        c1 = new Circulo (new Punto(1,2),8);
        c2 = new Circulo (new Punto(3,4),6);
        System.out.println("c0 = " + c0.toString());
        System.out.println("c1 = " + c1.toString());
        System.out.println("c2 = " + c2.toString());
        iniciarGraficos();
        c0.pintar();
        c1.pintar();
        c2.pintar();
        



    
}
}
