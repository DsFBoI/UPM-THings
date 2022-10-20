
import java.io.*;
import java.util.*;

public class Tokens {
    /*DECLARACION DE VARIABLES */
	Object cod;
	Object atr; 
    /* Palabra(almacena la palabra que estamos leyendo)
     * Resultado(si es un numero es lo que almacena el resultado)
     * contador asigna los ids
     */
    static String palabra = "";
    static int resultado = 0;
    static int contador = 0;
    static boolean checkpalabra = false;
    /*
     * hacemos listas para las palabras reservadas(palreserv) 
     * para las palabras que son ids(listaids) 
     * para las palrabras que ya han sido usadas(listacheck)
     */
    static List<String> listacheck = new ArrayList<>();
    static List<String> listaid = new ArrayList<>();
    static List<String> palreserv = new ArrayList<String>(){
        { /* Palabras resrvadas */
            add("if");
            add("let");
            add("int");
            add("input");
            add("return");
            add("boolean");
            add("String");
            add("string");
            add("while");
            add("else");
            add("false");
            add("true");
            add("print");
            add("function");
        }
    };
   
    
	public Tokens(Object cod, Object atr) {
		this.cod = cod; 
        this.atr = atr;
        
	}
	  
    public static int estado(int estado,char car){
        final char eof = (char)-1;
        /* Switch que marcara los estados */
        switch(estado) {
        case 0: 
        	/* automata el caso O */
            if(car == ' ' ||car == '\n' ||car == '\t' ||car == '\r' ||car == '\b'|| car == '	' ){ 	//delimitadores 
                return 0;

            }
            if(car == '/'){
                /* Automata 0->1 */
                return 1;

            }
            if(car == '\''){ 
                /* Automata 0->3 */
                return 3;

            }
            if (car == '(') {
                /* Automata 0->116 */
                escToken("apar", "-");
                return 0;

            }
            if (car == ')') {
                /* Automata 0->117 */
                escToken("cpar", "-");
                return 0;

            }
            if (car == '{') {
                /* Automata 0->114 */
                escToken("akey", "-");
                return 0; 

            }
            if (car == '}') {
                /* Automata 0->115 */
                escToken("ckey", "-");
                return 0;
     
            }
            if (car == ':') {  
                /* Automata 0->113 */    
                escToken("dp", "-");
                return 0; 

            }
            if (car == ';') {
                /* Automata 0->112 */
                escToken("pcoma", "-");
                return 0; 

            }
            if (car == ',') {
                /* Automata 0->111 */
                escToken("coma", "-");
                return 0; 

            }
            if (car == '!') {
                /* Automata 0->106 */
                escToken("neg", "-");
                return 0; 

            }
            if (car == '+') {
                /* Automata 0->107 */
                escToken("sum", "-");
                return 0; 
            }
            if (car == '=') {
                /* Automata 0->6 */
                return 6;

            }
            if (car == '%') {
                /* Automata 0->7 */
                return 7;

            }
            if (car == eof) {
                /* Automata 0->118 */
                escToken("EOF", "-");
                return 0;

            }
            if(Character.toString(car).matches("[0-9]")){ 
                /* Automata 0->4 */
            	resultado += car;
                return 4;

			}
            if(Character.toString(car).matches("[a-zA-Z]")){
                /* Automata 0->5 */
            	palabra += car;
                return 5;
			}
        case 1:
            if(car == '/'){
                /* Automata 1->2 */
            	return 2; 

            }
        case 2:
            if(car == '\n'){
                /* Automata 2->0 */
            	return 0; 

            } 
            else{
                /* Automata 2->2 */
                return 2;

            } 
        case 3:
            if(car != '\''){
                /* Automata 3->3 */
            	return 3; 

            }
            else{
                /* Automata 3->103 */
            	escToken("cadena","lexema");
                return 0; 

            }
        case 4: 
        	if(Character.toString(car).matches("[0-9]")){ 
                /* Automata 4->4 */
        		resultado = resultado*10 + car;
        		return 4;

			}
        	if (car == ' ' ||car == '\n' ||car == '\t' ||car == '\r' ||car == '\b'|| car == ';' ){
                /* Automata 4->104 */
                escToken("cte_entera", "valor");
                
        	    return 0; 

            }
        case 5:
        	if(Character.toString(car).matches("[a-zA-Z]")){
                /* Automata 5->5 */
                palabra += car;
                return 5;

			}
            else if(Character.toString(car).matches("[0-9]")){ 
                /* Automata 5->8 */
            	palabra += car;
                return 8;

			}
        	
        	else{
                /* Automata 5->105 */
                String hola = "";
                hola += contador;
                escToken("id", hola); 
                return 0;
            }
        case 6:
            if (car == '=') {
            /* Automata 6->109 */
            escToken("ig2", "-");
            return 0;  	 
            }   
        	else{
                /* Automata 6->108 */
                escToken("eq", "-");    
                return 0; 
            }
        	

        case 7:
        	if (car == '=') {
                /* Automata 7->110 */
                escToken("asig", "-");
                return 0;
            	
            }
        
        case 8:
            if(Character.toString(car).matches("[0-9]") || Character.toString(car).matches("[a-zA-Z]") ){
                /* Automata 8->8 */
                palabra += car;
                return 8;

            }
            else if(car == ' ' ||car == '\n' ||car == '\t' ||car == '\r' ||car == '\b' ){
                /* Automata 8->102 */
                String hola = "";
                hola += contador;
                
                escToken("id", hola ); 
                return 0; 
               

            }
             
    }    
	return 0;  
   }
   /*funcion para comprobar si es una palbra reservada */
    public static boolean check(String pal){
        boolean res = false;
        if(palreserv.contains(pal)) {
        	res = true;
        }
        return res;
    }

    
 /*funcion escribir token */
  public static void escToken(String cod,String atributo){
    	PrintWriter writer = null;
        checkpalabra = check(palabra);
		try {
			String ruta = "C:\\Users\\danel\\Downloads\\clase\\Pdl\\Prueba\\prueba.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
			FileWriter fw = new FileWriter(file, true);
			writer = new PrintWriter(fw);
            if (checkpalabra){ 
                /*si es una palabra reservada */       
                if(!listacheck.contains(palabra)){
                    /*si no esta en la lista de palabras ya escritas se escribe y la almecena en esta lista */
                	writer.write("<" + palabra + ",->\n");
                	listacheck.add(palabra);
                    checkpalabra = false;
                    
                }
                
            }
            else{   
                /*si no es una palabra reservada  */     
                if(cod.equals("id")){
                    /*si tiene codigo id  */
                    if(!listaid.contains(palabra)){
                        /*si no esta en la lista de palabras ya escritas se escribe y la almecena en esta lista  */
                        contador++;
                        writer.write("<" + cod + " "+ palabra + "," + atributo + ">\n");
                        listaid.add(palabra);
                    }

                }
                else if(!listacheck.contains(cod)){
                    /*si no tiene codigo id */
                    writer.write("<" + cod + "," + atributo + ">\n");
                    listacheck.add(cod);
                }
            
                
            }
            /*rinicia palabra y resultado */
            palabra = "";
            resultado = 0;
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
		if(writer!= null) {
			writer.close();
		}
        
    }
    public static void main(String[] args) {
    	int EstadoAct = 0;
    	/*
    	Scanner reader = new Scanner(System.in);
        System.out.println("ingrese el camino donde tiene el txt que quiere enviar: ");
        String path = null; 
        path = reader.nextLine(); 
        */
    	System.out.println("ejutando");
		try (FileReader fileReader = new FileReader("C:\\Users\\danel\\Downloads\\clase\\Pdl\\Prueba\\PIdG114.txt")) {

			int caracterleido = fileReader.read();
			while(caracterleido != -1) {
                /* Lector de carcateres */
				char car = (char) caracterleido;
                EstadoAct = estado(EstadoAct, car);
                if(EstadoAct == 0 && car!='\''){
                    /*en el cas de que el estado sea 0 ya que vuelve de un estado final se hace de nuevo 
                    para los casos de tokens pegados y en especia las cadenas que daba error*/
                    EstadoAct = estado(EstadoAct, car);
                }
                /*leemos el siguiente caracter */
                caracterleido = fileReader.read();  
			}
			
		}
		catch (IOException e) {
			System.out.println("Error al leer el archivo");
	       System.exit(1);
	    }
		
	}
}
