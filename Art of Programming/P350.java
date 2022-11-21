import java.io.BufferedInputStream;
import java.util.Scanner;

public class P350 {




    public static void main(String[] args) {

        //try with resources
        try(Scanner sc = new Scanner(new BufferedInputStream(System.in,1*1024))){// manera de iniciar el scanner para introducir datos mediante un buffer

            // lee primero
            int a =  sc.nextInt();
            int b = sc.nextInt();



            while(!(a == 0 && b == 0)){
                System.out.println(String.format("%4d %4d", a,b));//String.format = formateo de salida(muy parecido a scanf y printf de c)
                
                // avanza el cursor al siguiente y lee el siguiente digito
                a =  sc.nextInt();
                b = sc.nextInt();

            }

        }

        catch( Exception e ){
            System.exit(1);
        }
    }
}
