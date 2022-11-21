import java.io.BufferedInputStream;
import java.util.Scanner;

public class p224 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
            int numcor;
            while((numcor = in.nextInt())!= 0){
            int[] elem  = new int[numcor];
            int res = 0;
            int max=0;
            for(int i = 0; i<numcor ; i++){
                elem[i] = in.nextInt();
            }
            for(int i = 0; i<numcor;i++){
                int suma= 0 ;
                for(int j = i+1 ; j < numcor ; j++){
                    suma += elem[j];
                    if(suma>elem[i]){
                        break;
                    }
                    
                }
                if(suma == elem[i]){
                    if(suma>max){
                        res = i+1;
                        max = suma;
                    }
                    
                    break;
                }

            }
            if(res>0){
                System.out.println("SI "+ res);
            }
            else{
                System.out.println("NO");
            }
        }
        
        }catch (Exception e) {
            System.exit(0);
        }
    }
}
