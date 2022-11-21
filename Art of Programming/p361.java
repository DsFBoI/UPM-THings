import java.io.BufferedInputStream;
import java.util.Scanner;

public class p361 {

    private static boolean isPosibleResul = false;

    private static void isPosible(int resul, int acumulated, int[] operators, int pos) {

        if (pos == 4) {
            if (resul == acumulated) {
                isPosibleResul = true;
            }
            return;
        }
        isPosible(resul, acumulated + operators[pos + 1], operators, pos + 1);
        isPosible(resul, acumulated - operators[pos + 1], operators, pos + 1);
        isPosible(resul, acumulated * operators[pos + 1], operators, pos + 1);
        if (operators[pos + 1] != 0 && acumulated % operators[pos + 1] == 0)
            isPosible(resul, acumulated / operators[pos + 1], operators, pos + 1);
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1024))) {

            while (sc.hasNextLine()) {

                int resul = Integer.parseInt(sc.nextLine());
                String[] operatorsAux = sc.nextLine().split(" ");
                int[] operators = new int[operatorsAux.length];

                for (int i = 0; i < operators.length; i++) {
                    operators[i] = Integer.parseInt(operatorsAux[i]);
                }

                isPosibleResul = false;
                isPosible(resul, operators[0], operators, 0);
                if (isPosibleResul)
                    System.out.println("SI");
                else
                    System.out.println("NO");
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }
}