public class A7Iteration {/*
    * author: Clara Benac Earle
    * author: Daniel Sánchez
    * 
    * creation date: 7/10/2019
    * last modification: 21/10/2020
    * 
    * Program the following exercises using recursion
    * 
    */ 

     
    /* FUNCTION: power(integer base, exponent) -> integer
    * PRE: base > 0, exponent >= 0
    * POST: the result is the base to the power of the exponent
    * EXAMPLES:
    *    power(1,0) -> 1
    *    power(2,1) -> 2
    *    power(2,2) -> 4
    *    power(3,2) -> 9
    */ 
    static int power(int b,int e){
        int result=1;
        for(int i=b;e>0;e--){
            result=result*i;
        }
            return result;



    }
     /* FUNCTION: fibonacci(integer n) -> integer
      * PRE: n >= 0
      * POST: the result is the Fibonacci number in the n 
      * position of the Fibonacci sequence of numbers
      * EXAMPLES:
      *    fibonacci(0) -> 0
      *    fibonacci(1) -> 1
      *    fibonacci(4) -> 3
      */
    static int fibonacci(int f){
        int result=0;
        int first=0;
        int second=1;
        if (f==second)
        return 1;
        for (int i=1; i < f ; i++){
            result=first+second;
            first=second;
            second=result;
        }
        return result;

    }
     
     /* FUNCTION: numberDigits(integer n) -> natural
      * PRE: true
      * POST: the result is the number of digits of n
      * EXAMPLES:
      *    numberDigits(264) -> 3
      *    numberDigits(23489) -> 5
      */
    static int numberDigits(int n){
        int result=0;
        for (int i=0; i!=n; n=n/10){
            result=result+1;
        }
        return result;
    }
     
     
     /* FUNCTION: sumInterval(integer a, b) -> integer
      * PRE: a, b >= 0, a <= b
      * POST: the result is the sum of all integer numbers
      * in the interval [a,b]
      * EXAMPLES:
      *    sum(2,4) -> 9
      */ 
      static int sumInterval(int a, int b){
          int result=0;
          for (int i=0;a<=b && b>=i;b--){
            result=result+b;
          }
          return result;
      }
    
     
     
     /* FUNCTION: productInterval(integer a, b) -> integer
      * PRE: a, b > 0, a <= b
      * POST: the result is the product of all integer 
      * numbers in the interval [a,b]
      * EXAMPLES:
      *    productInterval(2,4) -> 24
      */  
      static int productInterval(int a, int b){
        int result=1;
        for (int i=0;a<=b && b>=i;b--){
          result=result*b;
        }
        return result;
    }



     /* FUNCTION: sumEvenInterval(integer a, b) -> integer
      * PRE: a, b >= 0, a <= b
      * POST: the result is the sum of all even integer
      * numbers in the interval [a,b]
      * EXAMPLES:
      *    sumEvenInterval(2,4) -> 6
      */
      static int sumEvenInterval(int a, int b){
        int result=0;
        for (;b%2==1;b=b-1){}
        for (int i=0;a<=b && b>=i && b%2==0;b=b-2){ 
            result=result+b;
            }
        return result;
    }
     
     /* FUNCTION: reverse(int num) -> int
      * PRE: num >= 0
      * POST: the result is an integer which contains the same digits
      * as num but in reverse order
      * EXAMPLES:
      *   reverse(123) -> 321
      *   reverse(5) -> 5
      *   reverse(56789) -> 98765
      * 
      */ 
      static int reverse(int num){
        int result=0;
        for(int i=0; num>i; num=num/10){
            result=(result*10)+(num%10);
        }
        return result;

      }
   
     /* FUNCTION: isPalindromic(int num) -> boolean
      * PRE: num >= 0
      * POST: the result is true if num is a palindromic number and 
      * returns false otherwise
      * EXAMPLES:
      *   isPalindromic(5) -> true
      *   isPalindromic(343) -> true
      *   isPalindromic(4554) -> true
      *   isPalindromic(4564) -> false
      */ 
      static boolean isPalindromic(int num){
        int result=0;
        int num2=num;
        for(int i=0; num>i; num=num/10){
            result=(result*10)+(num%10);
            }
            return result==num2;
        }
   
     /* FUNCTION:  (integer n) → text
      * PRE: n > 0
      * POST: the result is a line with n asterisks
      * EXAMPLES:
      *    lineAst(1) -> "*"
      *    lineAst(3) -> "***"
      */
      static String lineAst(int num){
      String stars="";
      for (int i= 0 ;num!=i; num--){
          stars=stars+"*";
            }
        return stars;
        }
     
     /* FUNCTION: triangleAst(integer n) → text
      * PRE: n > 0
      * POST: the result is a right triangle with a 
      * base of n asterisks
      * EXAMPLES:
      *   triangleAst(1) -> "*"
      *   triangleAst(3) → "*"
      *                    "**"
      *                    "***" 
      */
      static String triangleAst(int num){
        String stars="*";
        for (int i= 0 ;num!=i; num--){
            System.out.println(stars);
            stars=stars+"*";
              }
          return "";
          }
  
     /* FUNCTION: elephantSong(integer num) -> text
      * PRE: num > 0
      * POST: the result is a text containing the lyrics of the 
      * elephant song in Spanish, that is, "Un elefante se 
      * balanceaba sobre la tela de una araña..." until 
      * the number of elephants is num
      * Example:
      *    elephantSong(3) = "Un elefante se balanceaba sobre la tela de una 
      *    araña y como veía que no se caía fue a llamar a otro elefante. 2 
      *    elefantes se balanceaban sobre la tela de una araña y como veían 
      *    que no se caían fueron a llamar a otro elefante. 3 elefantes se 
      *    balanceaban sobre la tela de una araña y como veían que no se caían 
      *    fueron a llamar a otro elefante"
      */
      static String elephantSong(int song){
          String elesong="Un elefante se balanceaba sobre la tela de una araña y como veía que no se caía fue a llamar a otro elefante.";
          int elephant=1;
          for  (int i=0; song!=i; song--){
              System.out.println(elesong);
              elephant=elephant+1;
              elesong= elephant + " elefantes se balanceaban sobre la tela de una araña y como veían que no se caían fueron a llamar a otro elefante.";
              
            }
            return "";
      }

    
     
     
     
     
     public static void main(String [] args){
        System.out.println("Function Power:");
        System.out.println(power(2, 3));
        System.out.println(power(2, 4));
        System.out.println(power(3, 2));
        System.out.println(power(3, 3));
        System.out.println("Function Fibonacci:");
        System.out.println(fibonacci(0)==0);
        System.out.println(fibonacci(1)==1);
        System.out.println(fibonacci(2)==1);
        System.out.println(fibonacci(3)==2);
        System.out.println(fibonacci(4)==3);
        System.out.println(fibonacci(5)==5);
        System.out.println("Function NumberDigits:");
        System.out.println(numberDigits(264)==3);
        System.out.println(numberDigits(23489)==5);
        System.out.println(numberDigits(123456789)==9);
        System.out.println("Function SumInterval:");
        System.out.println(sumInterval(2,4)==9);
        System.out.println(sumInterval(2,5)==14);
        System.out.println(sumInterval(2,6)==20);
        System.out.println(sumInterval(2,7)==27);
        System.out.println(sumInterval(2,8)==35);
        System.out.println(sumInterval(2,9)==44);
        System.out.println("Function Product Interval:");
        System.out.println(productInterval(2,4)==24);
        System.out.println(productInterval(2,5)==120);
        System.out.println(productInterval(2,6)==720);
        System.out.println(productInterval(2,7)==5040);
        System.out.println(productInterval(2,8)==40320);
        System.out.println("Function SumEvenInterval:");
        System.out.println(sumEvenInterval(1,7)==12);
        System.out.println(sumEvenInterval(2,4)==6);
        System.out.println(sumEvenInterval(2,14)==56);
        System.out.println(sumEvenInterval(6,8)==14);
        System.out.println(sumEvenInterval(3,17)==70);
        System.out.println("Function reverse:");
        System.out.println(reverse(7254)==4527);
        System.out.println(reverse(95467)==76459);
        System.out.println(reverse(1298)==8921);
        System.out.println(reverse(12)==21);
        System.out.println(reverse(8943)==3498);
        System.out.println("Function IsPalindromic");
        System.out.println(isPalindromic(2772));
        System.out.println(isPalindromic(2773));
        System.out.println(isPalindromic(5995));
        System.out.println(isPalindromic(76567));
        System.out.println(isPalindromic(2));
        System.out.println(isPalindromic(55));
        System.out.println("Function LineAst");
        System.out.println(lineAst(1));
        System.out.println(lineAst(2));
        System.out.println(lineAst(3));
        System.out.println(lineAst(4));
        System.out.println(lineAst(24));
        System.out.println("Function TriangleAst");
        System.out.println(triangleAst(3));
        System.out.println(triangleAst(4));
        System.out.println(triangleAst(5));
        System.out.println(triangleAst(6));
        System.out.println("Function ElephantSong:");
        System.out.println(elephantSong(3));
        System.out.println(elephantSong(7));
        System.out.println(elephantSong(5));
        System.out.println(elephantSong(4));






     }




}
    

