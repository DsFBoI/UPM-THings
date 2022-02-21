package vehiculos;
public class Vehiculo {
    
    private String Matricula;
    public static final int COCHE = 0, MICROBUS = 1, FURGONETA = 2, CAMION = 3;
    static final  double PRECIO_POR_DIA = 50.0;
    

    public Vehiculo(String matricula){
        Matricula = matricula;
    }

    public double precioAlquiler(int dias){
        double precioAlqu = PRECIO_POR_DIA * dias;
        return precioAlqu;
    }

    public String matricula(){
     return Matricula;
    }

    public String toString() {
        return "Matricula: " + Matricula;
    }
}
