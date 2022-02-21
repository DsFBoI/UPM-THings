public class Alumno implements IAlumno {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double PrimerParcial;
    private double SegundoParcial;

    Alumno(){}

    Alumno(String nom, String apell1, String apell2){
        nombre = nom;
        apellido1 = apell1;
        apellido2 = apell2;
        PrimerParcial = 0;
        SegundoParcial = 0;
    }

    public String toString (){
        return "nombre:"+ nombre + '\n'+ "Apellido 1:" + apellido1 + '\n' + "Apellido 2:" + apellido2 + '\n' + "Parcial 1" + PrimerParcial + '\n'+ "Parcial 2" + SegundoParcial + '\n';
    }
    /**
     * POST: resultado es cierto si "al" tiene el mismo nombre y
     *       apellidos que el objeto y, es falso e.o.c.
     */
      public boolean igualNombre (Alumno al){
          return nombre == al.nombre;
      }
    /**
     * POST: Devuelve el nombre completo del alumno con el 
     *       formato <apellido1 apellido2, nombre>
     */
      public String getNombreCompleto (){
          return apellido1+ " " + apellido2 + ", " + nombre;
      }
    /**
     * POST: resultado es la calificacion del primer parcial del objeto
     */
      public double getPrimerParcial (){
        return PrimerParcial;
      }
    /**
     * POST: resultado es la calificacion del segundo parcial del objeto
     */
      public double getSegundoParcial (){
          return SegundoParcial;
      }
    /**
     * POST: modifica la calificacion del primer parcial del objeto por "nota1"
     */
      public void setPrimerParcial (double nota1){
          PrimerParcial = nota1;
      }
    /**
     * POST: modifica la calificacion del segundo parcial del objeto por "nota2"
     */
      public void setSegundoParcial (double nota2){
          SegundoParcial = nota2;
      }
    /**
     * POST: resultado es la cadena construida por "getNombreCompleto", donde
     *       se han cambiado las vocales acentuadas por las equivalentes sin
     *       acentuar. Proporciona una clave para ordenaciones lexicograficas.
     */
    //   public String clave();
    private char sintilde (char letra){
        switch (letra){
            case 'Á' : return 'A';
            case 'É' : return 'E';
            case 'Í' : return 'I';
            case 'Ó' : return 'O';
            case 'Ú' : return 'U';
            case 'á' : return 'a';
            case 'é' : return 'e';
            case 'í' : return 'i';
            case 'ó' : return 'o';
            case 'ú' : return 'u';
            default : return letra;
        }
        
    }
    private String sinTildes(String frase){
        String Resultado = "";
        for (int i = 0; i < frase.length() ; i++){
            Resultado = Resultado + sintilde(frase.charAt(i));

        }
        return Resultado;
    }
    @Override
    public boolean igualNombre(IAlumno al) {
        return false;
    }

    @Override
    public String clave() {
        // TODO Auto-generated method stub
        return sinTildes(this.getNombreCompleto());
    }
    
}
