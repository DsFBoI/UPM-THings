import java.io.BufferedInputStream;
import java.util.Scanner;

public class p622 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(new BufferedInputStream(System.in, 1 * 1024))){
               
            int nCasos = in.nextInt();
            while(nCasos!= 0){
            int suma = 0;

            for(int i = 0 ; i<nCasos; i++){
                int dato = in.nextInt();
                suma+= dato;

            }
            int notap = in.nextInt();
            int fin = notap * (nCasos+1);
            fin = fin-suma;
            if(fin > 10){
                System.out.println("IMPOSIBLE");

            }
            else if(fin<0){
                System.out.println("IMPOSIBLE");
            }
            else{
                System.out.println(fin);
            }
            nCasos = in.nextInt();
            }
            

            
        }
        catch(Exception e){
            System.exit(1);
        }
    }
}
