import java.io.*;
import java.util.*;


public class Tabla_de_simbolos_lex {

    final static Tokens hola = new Tokens(0, 0);
    static HashMap<Integer, String> reversed;
    static String rutaW = "C:\\Users\\danel\\Downloads\\calse\\PDL\\Pruebas\\TablalLex.txt";



    public static void main(String[] args) throws IOException {
        hola.main(args);
        Map<String,Integer> mapog = hola.mapaid;
        PrintWriter writer = null;
        File file = new File(rutaW);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        try(FileWriter fw = new FileWriter(file, true)){

            writer = new PrintWriter(fw);
            writer.write("#0:\n");
            for(String key: mapog.keySet()){
            writer.write("*'"+key + "'\n----------------------------------\n");
            }
        }
        catch(IOException e){
            System.out.println("Error al leer el archivo");
            System.exit(1);
        }

    }
}