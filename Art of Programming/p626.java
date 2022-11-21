

import java.io.BufferedInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class p626 {

    public static void main(String[] args) throws ParseException {

        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1024))) {

            int nCasos = Integer.parseInt(sc.nextLine());
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);

            while (nCasos > 0) {

                String[] dateAux = sc.nextLine().split("/");
                StringBuilder resul = new StringBuilder("29/02/");

                int day = Integer.parseInt(dateAux[0]);
                int month = Integer.parseInt(dateAux[1]);
                int year = Integer.parseInt(dateAux[2]); 

                int yearResul = -1;
                
                if ((year % 4 == 0)) {
                    if (month <= 2) {
                        if (month == 1 || (month == 2 && day < 29)) {
                            yearResul = year;
                        }
                    }
                }

                while (yearResul == -1) {
                    year++; 
                    if ((year % 4 == 0)) {
                        yearResul = year;
                    }
                }

                resul.append(yearResul);
                Date date = sdf.parse(resul.toString());
                
                System.out.println(sdf.format(date));
                nCasos--;
            }
        }
        catch(Exception e){
            System.exit(0);
        }
    }
}
