import java.util.function.Function;

/*
*author: Daniel Sánchez Ferrari
*date creation: 9/10/2020
*
*Assigment 5
*/

public class A5 {
    

    public static void main (String[] args) {
        // Exercise 1
        int i = StdIn.readInt();
        double dou = StdIn.readDouble();
        System.out.println("i:"+ i);
        System.out.println("d:"+ dou);

        //Exercise 2
        
        System.out.println(" square root of dou is: "+ Math.sqrt(dou));
        System.out.println(" The absolute value of dou is: "+Math.abs(dou));
        System.out.println(" The power of dou to another number is: "+ Math.pow(dou, 2));
        
        
        //Exercise 3
        double r = StdIn.readDouble();
        
        System.out.println("The are is: "+ Math.round( shapes.areaCircle(r)));
        //Exercise 4
        System.out.println (Math.random());
        //Exercise 5
        int last = StdIn.readInt();
        System.out.println("The last digit:"+ A4.lastDigit(last)); 

        
    }
    
}
