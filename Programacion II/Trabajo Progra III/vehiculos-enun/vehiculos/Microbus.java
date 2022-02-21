package vehiculos;

public class Microbus extends VehiculoPasajeros {


    static final double PRECIO_POR_PLAZA = 2;

    public Microbus (String Matricula, int plazas){
        super(Matricula,plazas);
    }

    public double precioAlquiler(int dias){
        double precioAlqu = super.precioAlquiler(dias) +  PRECIO_POR_PLAZA * plazas();
        return precioAlqu;
    }

    public String toString() {
        return super.toString();
    }
}
