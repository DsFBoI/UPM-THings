package vehiculos;

public class Camion extends VehiculoCarga {
    
    public Camion(String Matricula, double pma){
        super(Matricula, pma);
    }


    public double precioAlquiler(int dias){
        double precioAlqu = super.precioAlquiler(dias) + 40;
        return precioAlqu;
    }

    public String toString() {
        return super.toString();
    }
}
