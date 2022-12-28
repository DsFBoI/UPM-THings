import java.io.*;
import java.util.*;

public class AnalizadorSintactico{

    final static Tokens hola = new Tokens(0, 0);
    static String linea = "";
    static String[] linea2;
    static String token = "";
    static String atrib = "";
    static String parse = "Des";
    static String noter = "";
    static int parentesis = 0;
    static int llaves = 0;
    static int cont_lineas = 1;

    static Stack<String> pila = new Stack<String>();
    static List<String> terminales = new ArrayList<String>(){
        { /* Palabras reservadas */
            add("if");
            add("let");
            add("int");
            add("input"); 
            add("return");
            add("boolean"); 
            add("string");
            add("while");
            add("false");
            add("true");
            add("print");
            add("function");
            add("akey");
            add("ckey");
            add("id"); 
            add("entera"); 
            add("cad"); 
            add("apar");
            add("cpar");
            add("ig2");
            add("eq");
            add("asig");
            add("pcoma");
            add("sum");
            add("neg");
            add("akey");
            add("ckey");
        }
    };
    
    public static void casoS(String token){
        switch(token){
            /* S -> let D E ; */
            case "let":
                parse += " 5";
                pila.push("S");
                pila.push("pcoma");
                pila.push("E");
                pila.push("D");
                break;
            case "if":
            /* S -> if(A) */
                parse += " 1";
                pila.push("S");
                pila.push("cpar");
                pila.push("A");
                pila.push("apar");
                break;
            case "return":
            /* S -> return N; */
                parse += " 2";
                pila.push("S");
                pila.push("pcoma");
                pila.push("N");
                break;
            case "id":
            /* S ->  id Y;*/
                parse += " 3";
                pila.push("S");
                pila.push("pcoma");
                pila.push("Y");
                break;
            case "input":
            /* S -> input id; */
                parse += " 4";
                pila.push("S");
                pila.push("pcoma");
                pila.push("id");
                break;
            case "while":
            /* S -> while (A){ */
                parse += " 6";
                pila.push("S");
                pila.push("akey");
                pila.push("cpar");
                pila.push("A");
                pila.push("apar");
                break;
            case "print":
            /* S -> print W; */
                parse += " 7";
                pila.push("S");
                pila.push("pcoma");
                pila.push("W");
                

                break;
            case "function":
            /* S -> function id G(H) */
                parse += " 8";
                pila.push("S");
                pila.push("cpar");
                pila.push("H");
                pila.push("apar");
                pila.push("G");
                pila.push("id");
                break;
            default:
                pila.push("S");
        }
    }

    public static void casoA(String token){
        if(token.equals("neg")){
            /* A -> !B */
            parse += " 10";
            pila.push("B");
            pila.push("neg");
        }
        else if(token.equals("id")){
            /* A -> idC */
            parse += " 11";
            pila.push("C");
            pila.push("id");
        }
    }

    public static void casoK(String token){
        switch(token){
            case "entera":
            /* K -> entera */
                parse += " 16";
                pila.push("entera");
                break;
            case "cad":
            /* K -> cad */
                parse += " 17";
                pila.push("cad");
                break;
            case "id":
            /* K -> id */
                parse += " 15";
                pila.push("id");
                break;
        }
    }
    
    public static void casoE(String token){
        switch(token){
            case "int":
            /* E -> int */
                parse += " 19";
                pila.push("int");
                break;
            case "boolean":
            /* E -> boolean */
                parse += " 20";
                pila.push("boolean");
                break;
            case "string":
            /* E -> string */
                parse += " 21";
                pila.push("string");
                break;
        }
    }

    public static void casoF(String token){
        switch(token){
            case "id":
            /* F -> idI */
                parse += " 23";
                pila.push("I");
                pila.push("id");
                break;
            case "cad":
            /* F -> cadI */
                parse += " 22";
                pila.push("I");
                pila.push("cad");
                break;
            case "entera":
            /* F -> enteraI */
                parse += " 24";
                pila.push("I");
                pila.push("entera");
                break;
        }
    }

    public static void casoN(String token){
        switch(token){
            case "id":
            /* N -> idL */
                parse += " 27";
                pila.push("L");
                pila.push("id");
                break;
            case "entera":
            /* N -> enteraL */
                parse += " 28";
                pila.push("L");
                pila.push("entera");
                break;
            case "cad":
            /* N -> cad */
                parse += " 29";
                pila.push("cad");
                break;
            case "apar":
            /* N -> (N) */
                parse += " 31";
                pila.push("cpar");
                pila.push("N");
                pila.push("apar");
                break;
            default: 
            /* N -> lambda */
                parse += " 30";
            //falta el caso de lambda
        }
    }

    public static void casoT(String token){
        switch(token){
            case "entera":
            /* T -> enteraL */
                parse += " 32";
                pila.push("L");
                pila.push("entera");
                break;
            case "false":
            /* T -> false */
                parse += " 33";
                pila.push("false");
                break;
            case "true":
            /* T -> true */
                parse += " 34";
                pila.push("true");
                break;
            case "id":
            /* T -> idU */
                parse += " 35";
                pila.push ("U");
                pila.push("id");
                break;
            case "neg":
            /* T -> !M */
                parse += " 36";
                pila.push("M");
                pila.push("neg");
                break;
            case "cad":
            /* T -> cad */
                parse += " 37";
                pila.push("cad");   
                break;

        }
    }

    public static void casoM(String token){
        switch(token){
            case "true":
            /* M -> true */
                parse += " 38";
                pila.push("true");
                break;
            case "false":
            /* M -> false */
                parse += " 39";
                pila.push("false");
                break;
            case "id":
            /* M -> id */
                parse += " 40";
                pila.push("id");
                break;
        }
    }

    public static void casoG(String token){
        switch(token){
            /* G -> int */
            case "int":
                parse += " 42";
                pila.push("int");
                break;

            case "boolean":
            /* G -> booelan */
                parse += " 43";
                pila.push("boolean");
                break;

            case "string":
            /* G -> string */
                parse += " 44";
                pila.push("string");
                break;

            default:
            /* G -> lambda */
                parse += " 41";
                break; 
        }
    }
    
    public static void casoH(String token){
        switch(token){
            case "int":
            /* H -> int id J */
                parse += " 45";
                pila.push("J");
                pila.push("id");
                pila.push("int");
                

                break;
            case "string":
            /* H -> string id J */
                parse += " 46";
                pila.push("J");
                pila.push("id");
                pila.push("string");
                
                break;
            case "boolean":
            /* H -> boolean id J */
                parse += " 47";
                pila.push("J");
                pila.push("id");
                pila.push("boolean");
                
                break;
            default:
            /* H -> lambda */
                parse += " 48";
                break;
        }

    }
    
    public static void casoY(String token){
        switch(token){
            case "asig":
            /* Y -> %=V */
                parse += " 51";
                pila.push("V");
                pila.push("asig");
                break;
            case "eq":
            /* Y -> =T */
                parse += " 52";
                pila.push("T");
                pila.push("eq");
                break;
        }
    }

    public static void casoV(String token){
        switch(token){
            case "entera":
            /* V -> entera */
                parse += " 53";
                pila.push("entera");
                break;
            case "id":
            /* V -> id */
                parse += " 54";
                pila.push("id");
                break;
        }
    }

    private static void casoW(String token) {
        if(token.equals("apar")){
            /* W -> (F) */
            parse += " 55";
            pila.push("cpar");
            pila.push("F");
            pila.push("apar");
            equiparar(token, pila.peek());
        }
        else{
            /* W -> F */
            parse += " 56";
            pila.push("F");
            leerToken(token, pila.pop());
        }
    }

    private static void caseU(String token) {
        if(token.equals("apar")){
            /* U -> (Q) */
            parse += "  58";
            pila.push("cpar");
            pila.push("Q");
            pila.push("apar");
        }else if(token.equals("sum")){
            /* U -> +R */
            pila.push("R");
            pila.push("sum");
            parse += " 59";
        }
        else if(token.equals("ig2")){
            /* U -> ==K */
            parse += " 60";
            pila.push("K");
            pila.push("ig2");
        }
        else{
            /* U -> lambda */
            parse += " 57";
        }
    }

    private static void caseQ(String token) {
        if(token.equals("id")){
            /* Q -> id O */
            parse += " 61";
            pila.push("O");
            pila.push("id");
        }
    }

    private static void casoO(String token) {
        if(token.equals("coma")){
            parse+= " 62";
            pila.push("Q");
            pila.push("coma");
        }
        else{
            parse+= " 63";
        }
    }

    private static void caseR(String token) {
        switch(token){
            case "apar":
            /* R -> (R) L */
                parse = parse + " 66";
                pila.push("L");
                pila.push("cpar");
                pila.push("R");
                pila.push("apar");
                
                break;
            
            case "entera":
             /* R -> entera L */
                parse = parse + " 64";
                pila.push("L");
                pila.push("entera");
                break;
            
            case "id":
            /* R -> id L */
                parse = parse + " 65";
                pila.push("L");
                pila.push("id");
                break;
            
        }
    }
    
    private static void caseL(String token) {
        switch(token){
            case "sum":
            /* L -> +R */
                parse = parse + " 67";
                pila.push("R");
                pila.push("sum");
                break;
            
            default:
            /* L -> lambda */
                parse += " 68";
                break;
        }
    }
    
    private static void equiparar(String token, String estado) {
        if(token.equals(estado)){
            pila.pop(); 
        }
        else{
            atrib = estado;
            if(token.equals("pcoma")){

                errores(4);
            }
            else{
                errores(1);
            }
            
        }
    }

    public static void leerToken(String token, String estado){
        if(terminales.contains(estado)){
            
            equiparar(token,estado);
            
        }
        else{
            switch(estado){
                case "S":
                    casoS(token);
                    cont_lineas++;
                    break;
                case "A":
                    casoA(token);
                    equiparar(token, pila.peek());
                    break;
                case "B":
                    parse += " 12";
                    pila.push("id");
                    equiparar(token, pila.peek());
                    break;
                case "C":
                    if(token.equals("ig2")){
                        parse += " 13";
                        pila.push("K");
                        pila.push("ig2");
                    }else{
                        parse += " 14";
                    }
                    
                    equiparar(token, pila.peek());
                    break;
                case "K":
                    casoK(token);
                    equiparar(token, pila.peek());
                    break;
                case "D":
                    parse += " 18";
                    pila.push(token);
                    equiparar(token, pila.peek());
                    break;
                case "E" : 
                    casoE(token);
                    equiparar(token, pila.peek());
                    break;
                case "F" :
                    casoF(token);
                    equiparar(token, pila.peek());
                    break;
                case "I":
                    if(token.equals("sum")){
                        parse += " 25";
                        pila.push("F");
                        pila.push("sum");
                        
                    }
                    else{
                        parse += " 26";
                        

                    }
                    equiparar(token, pila.peek());
                    break;
                    //else error
                case "N":
                    casoN(token);
                    equiparar(token, pila.peek());
                    break;
                case "T":
                    casoT(token);
                    equiparar(token, pila.peek());
                    break;
                case "M":
                    casoM(token);
                    equiparar(token, pila.peek());
                    break;
                case "G":
                    casoG(token);
                    equiparar(token, pila.peek());
                    break;
                case "H":
                    casoH(token);
                    equiparar(token, pila.peek());
                    break;
                case "J":
                    if(token.equals("coma")){
                        parse = parse + " 49";
                        pila.push("H");
                        pila.push("coma");
                    }
                    else{
                        parse += " 50";
                    }
                    equiparar(token, pila.peek());
                    break;
                case "Y":
                    casoY(token);
                    equiparar(token, pila.peek());
                    break;
                case "V": 
                    casoV(token);
                    equiparar(token, pila.peek());
                    break;
                case "W":
                    casoW(token);
                    break;
                case "O":
                    casoO(token);
                    equiparar(token, pila.peek());
                    break;
                case "Q":
                    caseQ(token);
                    equiparar(token, pila.peek());
                    break;
                case "U":
                    caseU(token);
                    equiparar(token, pila.peek());
                    break;
                case "R":
                    caseR(token);
                    equiparar(token, pila.peek());
                    break;
                case "L":
                    caseL(token);
                    equiparar(token, pila.peek());
                    break;
                
            }

        }
        
    }





    private static void errores(int a) {
        
        try(FileWriter fw = new FileWriter(new File("C:\\Users\\esthe\\Desktop\\upm\\tercero\\pdL\\practica\\primera entrega\\pruebas\\pruebas\\errores.txt"), true);){
            PrintWriter writer = new PrintWriter("C:\\Users\\esthe\\Desktop\\upm\\tercero\\pdL\\practica\\primera entrega\\pruebas\\pruebas\\errores.txt");
            writer.print("");
            writer.close();
            PrintWriter writer2 = new PrintWriter(fw);
           
            switch(a){
                case 1:
                    writer2.write("Error sintactico en linea se esperaba " + token + " se obtuvo: "+ atrib + " <linea "+ cont_lineas+">");
                    break;
                case 2:
                    if(llaves>0){
                        writer2.write(llaves + "Llaves no cerradas");
                    }else{
                        writer2.write(-llaves + "Cierres de llaves extras");
                    }
                    break;
                case 3:
                    if(parentesis>0){
                        writer2.write(parentesis + " Parentesis no cerradas");
                    }else{
                        writer2.write(-parentesis + " Parentesis extras");
                    }
                    break;
                case 4:
                    writer2.write("Falta de caracter ; en la linea "+cont_lineas);
                    break;
            
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static void main(String[] args) throws IOException {
        String lin;
        //creamos un clase tokens donde la ejecutaremos unicamente para sacar los tokens
        hola.main(args);
        
                
    	System.out.println("ejutando");
		try (FileReader fileReader = new FileReader("C:\\Users\\danel\\Downloads\\calse\\PDL\\Pruebas\\prueba.txt")) {
            BufferedReader br = new BufferedReader(fileReader);
            pila.push("$");
            pila.push("S");
            
			while(br != null){
               
                if(!terminales.contains(pila.peek()) ){
                    String pop = pila.pop();
                    lin = br.readLine();
                    if(lin == null){
                        parse += " 9";
                        break;
                    }
                    lin = lin.replace("<", "");
                    lin = lin.replace(">", ""); 
                    String[] split = lin.split(",");
                    token = split[0];
                    
                    leerToken(token, pop);

                }
                else{
                    lin = br.readLine();
                    if(lin == null){
                        parse += " 9";
                        break;
                    }
                    lin = lin.replace("<", "");
                    lin = lin.replace(">", "");
                    String[] split = lin.split(",");
                    token = split[0];
                    equiparar(pila.peek(),token);
                }
                switch(token){
                    case "apar":
                        ++parentesis;
                        break;
                    case "cpar":
                        --parentesis;
                        break;
                    case "akey":
                        ++llaves;
                        break;
                    case "ckey":
                        --llaves;
                        break;
                }
                

            }
            if(parentesis != 0){
                errores(2);
            }
            if(llaves != 0 ){
                errores(3);
            }
            try (FileWriter fw = new FileWriter(new File("C:\\Users\\danel\\Downloads\\calse\\PDL\\Pruebas\\parse.txt"), true);){
                
                PrintWriter writer2 = new PrintWriter(fw);

                writer2.write(parse);
                
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println(parse);
        }

            catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
    }
}