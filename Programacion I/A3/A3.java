public class A3 {
    static final int DAYS_WEEK = 7;
    static final float PI = (float) 3.1416;
    static final String GROUP = "2M";
        public static void main(final String[] args) {
            // 1
            final int howdy = 4;
            System.out.println(howdy);

            final boolean hi = true;
            System.out.println(hi);

            final char hello = 'a';
            System.out.println(hello);

            // 2
            int num = 5;
            System.out.println(num); // 1
            num = num * 2;
            System.out.println(num); // 2
            // Q1: The value of num in first line is 5
            // Q2: The value of line 2 is 10
            // double num = 2.5; // 1
            // num = 2.5; // 2
            System.out.println(num);
            // Q3: An error pops up beacuse num is already declared
            // Q4: An error pops up because we can't convert a double to an int
            int n1 = 8;
            final int n2 = n1;
            System.out.println(n2); // 1
            n1 = 34;
            System.out.println(n1); // 2
            System.out.println(n2); // 3
            // Q5: it is 8, because when given the second value to n1 we dont give it
            // intructions to change n2 that is why it stills the same
            int n3 = 8;
            int n4 = 5;
            // specification
            // PRE : n3 = 8 , n4 = 5
            n4 = n3;
            n3 = n4;
            System.out.println(n3);
            System.out.println(n4);
            // POST : n3 = 5 , n4 = 8
            // Q6: No, because when given the order n4=n3, n4 trnsforms into 8 so the next
            // order n3=n4 you are telling that n3=8

            // 3

            System.out.println(num * 3);
            final double realNum = 2.5;
            System.out.println(realNum - 0.2);
            System.out.println(" num : " + num);
            System.out.println(" realNum : " + realNum);
            System.out.println(" is realNum bigger than num ? " + (realNum > num)); // 1
            System.out.println(" is num different from 8? " + (num != 8)); // 2
            System.out.println(-num); // 3
            // Q7: The result is false
            // Q8: The result is true
            // Q9: -10
            // Q10:
            // System.out.println(num-2==8);
            // System.out.print(num+2 != 12);

            // 4
            final boolean log1 = true;
            final boolean log2 = false;
            System.out.println(!log1); // 1
            final boolean result = log1 && log2; // 2
            System.out.println(result);
            System.out.println(log1 || log2); // 3
            System.out.println(log1 || log2 && log1); // 4
            System.out.println(log1 && !log2); // 5
            // Q11: the result is true
            // Q12: the value will be false
            // Q13: the result is true
            // Q14: the result is true
            // Q15: the result is true
            // Q16:
            // boolean fyf= true;
            // System.out.println(fyf == log1);
            // System.out.println(fyf == log2);
            // System.out.println(fyf != log1);
            // System.out.println(fyf != log2);

            // 5
            final char car1 = 'A';
            char car2 = 'C';
            System.out.println(" char substraction : " + (car2 - car1)); // 1
            car2 = 'a';
            System.out.println(" char substraction : " + (car2 - car1)); // 2
            System.out.println(" char substraction : " + (car2 + 99)); // 3
            String text = "Hi ";
            text = text + "Pepe" + "." + " How are you ? ";
            System.out.println(text); // 4
            final String nS = "234";
            System . out . println ( nS + 99); // 5
            // Q17: 2, It is using their ASCII value to do the substraction
            // Q18: 32, The value of car 1 has changed and now is using the value of 'a' insted of 'A'
            // Q19: 196, We have added 99 to the ASCII value of 'car 2'
            // Q20:We are shown teh value of text that was previuolsy determined by a series of strings. Firstly difined as one word bur then revalued by concatenating other strings
            // Q21: Because we are turning the 99 into an string and addding it to ns which was definde previously as an string
            // Q22:
            // char car3 = 'Y';
            // System . out . println (car1 * car3);
            
            //6
            
            int x , y , z ;
            x = y = z = 6;
            System . out . println ( "z : " + z );
            System . out . println ( "y : " + y );
            System . out . println ( "x : " + x );
            // Q23: It means that x, y and z have the same alue in this case 6. The expresion will be read from right to left.
            // Q24: The value of y would not affect as the order "x=25" is after x=y=z=6 so the only variable that changes is x 

            
            //7


            int num2 = 20;
            System . out . println ( " num2 : " + num2 );
            num2 ++;
            System . out . println ( " increment : " + num2 ); // 1
            num2 --;
            System . out . println ( " decrement : " + num2 ); // 2
            num2 += 3;
            System . out . println ( " increment 3: " + num2 ); // 3
            // Q25: the value of num2 is 21 as with ++ we sum 1 to it's original value
            // Q26: the value of num2 is 20 as we substract one of the new value of num2 = 21
            // Q27: the value of num2 is 23 as we sum 3 to the value that was previuosly subtracted
            // Q28: num2 -= 5;
            // Q29: 
            // num2 += 56;
            // num2 -= 78;
            // num2 +=156;
            // System.out.println(num2);
            System . out . println (  "The value of num2 is :"  + num2 ++);
            System . out . println (  "The value of num2 is :"  + num2 ); // 1
            // Q30: the value of num2 is 24 beacuse in the previous line we have summed 1 to num2
            
            // 8
            System.out.println(PI);
            System.out.println(DAYS_WEEK);
            System.out.println(GROUP);

            // 9
            int n = 8;
            System . out . println (" it is even ? " + n + ": " + ( n % 2 == 0));
            // Q31: It means taht when dividing the number end if the remainder is 0 the program will be true
            
            
            //9
            int xl = 14;
            System.out.println(( xl % 2 == 0)); 
            
            
            
            int C = 15;
            System.out.println((C*9/5)+32);


            int h = 1;
            int m =30;
            int s = 50;
            System.out.println(h*3600 + m*60 + s);

            //10
             int radius = 7; 
             radius+=2;
             System.out.printf("The area of the circle with the radius given + 2 is:");
             System.out.println(PI * radius * radius);

             int x1 = 3;
             int x2 = 5;
             int x3 = 4;
             int x4 = x1 * x1;
             int x5 = x3 * x3;
             int x6 = x2 * x2;
             System.out.println("Pythagorean triples is if the multiplication of the larger number by itself is equal to the sum of the other multiplied by it selfs .For example 3,4 and 5:");
             System.out.println((x4+x5)==x6);


            
        


    }

    
}
