public class PuntoOps {
    static boolean estaEnOrigen (Punto p) {
    return p.getX() == 0.0 && p.getY() == 0.0;
  }
  static double distancia (Punto p1, Punto p2) {
    return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
  }

}
