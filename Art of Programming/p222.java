import java.io.BufferedInputStream;
import java.util.Scanner;

public class p222 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
            while(in.hasNextInt()) {
                int x = in.nextInt();
                int n = in.nextInt();

                int res = 1;
                int acum = 1;
                for(int i = 0 ; i < n ; i++){
                    acum = (acum*x) % 1000007;
                    res = (res+acum) % 1000007;
                }

                System.out.println(res);
            }

        }catch (Exception e) {
            System.exit(0);
        }
    }
}
