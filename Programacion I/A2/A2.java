public class A2 {
    public static void main(final String[] args) {
        // 1
        System.out.println("****** literals ******");
        System.out.println(2);
        System.out.println(-2);
        System.out.println(2.5);
        System.out.println('a');
        System.out.println(true);
        System.out.println(false);
        System.out.println(" My name is Pepe");
        
        // Q1: we are shown a character in this case the character a
        // Q2: We are shown an string
        
        
        
        
        
        // 2
        System.out.println("****** arithmetic operations ******"); 
        System.out.println(3 + 5); // 1 
        System.out.println(4 - 2); // 2 
        System.out.println(3 * 5); // 3 
        System.out.println(6 / 4); // 4 
        System.out.println(4 % 2); // 5

        // Q3: The results of the operations are integer.
        // Q4: The result is 1, As it is an integer, when making operations with them the result shown is an integer.
        // Q5: The result is 0, what % is, is a module, so what it shows is that the number can be divided and subtraction is equal to 0




        // 3
        System.out.println("****** precedence ******"); 
        System.out.println(3 + 5 * 2); 
        System.out.println(3 + (5 * 2)); 
        System.out.println((3 + 5) * 2); 
        
        // Q6: We will be shown floats because in the operations we are using decimal numbers he integers will be transformed into floats




        // 4
        System.out.println("****** precedence ******"); 
        System.out.println(3 + 5 * 2); 
        System.out.println(3 + (5 * 2)); 
        System.out.println((3 + 5) * 2); 
        // Q7: We see that depending of the location of the parentheses certain operations will be done first



        // 5
        System.out.println("****** relational operators ******"); 
        System.out.println(3 < 5); System.out.println(4 > 2); 
        System.out.println(3 >= 3); System.out.println(3 == 3); 
        System.out.println(3 == 8); 
        System.out.println(3 != 8.3); 
        System.out.println(2 == 2.5); 
        System.out.println(2 > -1);

        // Q8: == means that a number is equal to another one
        // Q9: != means that an number is not equal to another number
        // Q10: in this case the results will be either true or false (Boolean) acording if the data given is true or false

        // 6
        System.out.println("****** logic operators ******"); 
        System.out.println(!true); 
        System.out.println(!false); 
        System.out.println(true && true); 
        System.out.println(true && false); 
        System.out.println(true || false); // Line 1 
        System.out.println(true || true); 
        //System.out.println(true || 5);
        // Q11: It means not/negation, in this case gives the oposite boolean result 
        // Q12: It means and it only works when there are 2 ands
        // Q13: It means or, this operator checks if one of the 2 booleans given is true
        // Q14: Bolleans (true or false)
        // Q15: Their is an error as or only works with both bolleans, and not with an interger and a bollean

        
        
        // 7
        System.out.println("****** character operators ******"); 
        System.out.println('a'); 
        System.out.println('\u0061'); // 1 
        System.out.println('\u0062'); 
        System.out.println('b' - 'a'); // 2 
        System.out.println('\u0041'); 
        System.out.println('a' - 'A'); 
        System.out.println('\u0031'); 
        System.out.println('a'+ 8); 
        System.out.println("My favorite letter is " + 'A'); // 3
        // Q16: We will be shown symbol related to the unicode
        // Q17: Becasue its opearating with their ASCII indexes
        // Q18: We are shown an string as the character transforms into a string
        
        
        
        // 8

        System.out.println("****** Strings operators ******"); 
        System.out.println("hi" + "pepe");  // 1 
        System.out.println("hi " + "pepe"); // 2 
        System.out.println("hi" + 2);       // 3 
        System.out.println("hi" + 2.3);     // 4
        // System.out.println("hi" - 5);
        // System.out.println("is 3 bigger than 5?:" + 3 > 5);


        // Q19: We are given a concatenated string in this case with no separation
        // Q20: It is a string in this case there is a space between words
        // Q21: The space in between added behind the 'hi'
        // Q22: We are given another string because the integer 2 is transformed into a string
        // Q23: We are given another string because the float 2.3 is transformed into a string
        // Q24: the operator - can not be use with strings, it is not as + which meaning is concatenate
        // Q25: System.out.println("Hi Pepe," + " how you?");
        // Q26: It gives u an error because is making the string as a whole and adding first the 3 to the the string
        // Q27: System.out.println("is 3 bigger than 5?:" + (3 > 5));
        System.out.println("is 3 smaller or equal to 3?:" + (3 <= 3)); 
        System.out.println("is 3 different from 3?:" + (3 != 3)); 
        System.out.println("is 3 bigger than 3.5?: " + (3 > 3.5));
        
        
        
        //9
        System.out.println("If i have a 7 i will pass programing, so in that case 7 is higher than a five and if i put 7>=5 we will be given:" + (7 >= 5));
        System.out.println("which means that "+"i have passed " + ":"+")");





    }
}
