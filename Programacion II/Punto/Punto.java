import java.awt.Color   ;
class Punto {
    private int x;
    private int y;
    private Color color;
    Punto(){}


    Punto (int x, int y){
        this.x = x;
        this.y = y;
        this.color = StdDraw.BLACK;
    }
    Punto (int x, int y, Color color) 
  {
    this.x = x;
    this.y = y;
    this.color= color;
  }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public Color getColor() {
        return color;
    }

    // String aString ()
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    boolean equals (Punto p){
        return x == p.x && y == p.y;
    }

    int distancia (Punto p){
        return Math.abs(x - p.x) + Math.abs ( y - p.y);
    }

    void mover (int dx, int dy){
        x += dx;
        y += dy; 
    }
    void pintar (){
        StdDraw.setPenColor(color);
        StdDraw.point(x , y);
    }
}
