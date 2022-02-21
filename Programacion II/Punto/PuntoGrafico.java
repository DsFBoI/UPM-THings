public class PuntoGrafico {
    public static void iniciarGraficos(){
        StdDraw.setScale(-100 ,100);
        StdDraw.setPenRadius(0.03);

    }
    public static void animarPunto(Punto p){
        StdDraw.clear();
        p.pintar();
        p.mover(5,5);
        StdDraw.show();
        StdDraw.pause(200);
    }
    public static void animacion(){
        Punto p = new Punto(0, 2);
        iniciarGraficos();
        StdDraw.pause(1000);
        for(int i = 1; i <= 100; i++){
            animarPunto(p);
        }
    }
    public static void main(String[] args) {
        animacion();
    }

}
