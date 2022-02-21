package vehiculos;

public class VehiculoCarga extends Vehiculo {

    static final double PRECIO_POR_TONELADA_DE_PMA = 20;

    private double pma;

    public VehiculoCarga(String matricula, double pma){
        super(matricula);
        this.pma = pma;

    }

    public double precioAlquiler(int dias){
        double precioAlqu = super.precioAlquiler(dias)+ PRECIO_POR_TONELADA_DE_PMA * pma;
        return precioAlqu;
    }


    public String toString() {
        return "La matricula es: " + matricula() +'\n' +"El PMA es:" + pma + '\n';
    }
}
