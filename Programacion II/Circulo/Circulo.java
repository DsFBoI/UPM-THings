class Circulo {
    private Punto centro;
    private double radio;
    Circulo (Punto centro, double radio){
        this.centro = centro;
        this.radio = radio;

    }
    public String toString (){
        return "(" + centro.toString() +", " + radio + ")";
    }
    
    void pintar(){
        StdDraw.circle(centro.getX(), centro.getY(), radio);
    }
    
}
