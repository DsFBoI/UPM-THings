package vehiculos;
public class VehiculoPasajeros extends Vehiculo{

    static final double PRECIO_POR_PLAZA_Y_DIA = 1.5;

    private int plazas;

    VehiculoPasajeros(String Matricula, int plazas){
        super(Matricula);
        this.plazas = plazas;
    }

    public double precioAlquiler(int dias){
        double precioAlqu = super.precioAlquiler(dias) + PRECIO_POR_PLAZA_Y_DIA * (dias + plazas);
        return precioAlqu;
    }
    
    public int plazas(){
        return plazas;
    }

    public String toString() {
    
        return "Matricula: " + matricula() + '\n' + "nº de plazas: " + plazas() + '\n';
    }
}
