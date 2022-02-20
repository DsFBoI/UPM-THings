/*
 * author: Clara Benac Earle
 * author: Daniel Sánchez
 * 
 * creation date: 7/10/2019
 * last modification: 21/10/2020
 * 
 * Program the following exercises using recursion
 * 
 */ 


class A7Recursion{
  
  /* FUNCTION: power(integer base, exponent) -> integer
   * PRE: base > 0, exponent >= 0
   * POST: the result is the base to the power of the exponent
   * EXAMPLES:
   *    power(1,0) -> 1
   *    power(2,1) -> 2
   *    power(2,2) -> 4
   *    power(3,2) -> 9
   */ 
  static int power (int base, int expo){
    if (expo==0||base ==1)
      return 1;
      else
        return base *  power(base,expo-1 );
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
  static int fibonacci(int n){
    if (n==0)
     return 0;
     else if(n==1)
     return 1 ;
     else 
     return fibonacci(n-1)+ fibonacci(n-2);
  }
  
  
  /* FUNCTION: numberDigits(integer n) -> natural
   * PRE: true
   * POST: the result is the number of digits of n
   * EXAMPLES:
   *    numberDigits(264) -> 3
   *    numberDigits(23489) -> 5
   */
  static int numberDigits(int digit){
    if(digit==0||digit==1||digit==2||digit==3||digit==4||digit==5||digit==6||digit==7||digit==8||digit==9)
    return 1;
      else
        return 1+ numberDigits(digit/10);


  }
  
  
  
  /* FUNCTION: sumInterval(integer a, b) -> integer
   * PRE: a, b >= 0, a <= b
   * POST: the result is the sum of all integer numbers
   * in the interval [a,b]
   * EXAMPLES:
   *    sum(2,4) -> 9
   */ 
  static int sumInterval(int a, int b){
    if (a>b)
      return 0;
      else
       return b + sumInterval(a, b-1);


  }
  
  
  /* FUNCTION: productInterval(integer a, b) -> integer
   * PRE: a, b > 0, a <= b
   * POST: the result is the product of all integer 
   * numbers in the interval [a,b]
   * EXAMPLES:
   *    productInterval(2,4) -> 24
   */  
  static int productInterval(int a, int b){
    if (a>b)
      return 1;
      else
       return b * productInterval(a, b-1);

  }
  
  
  /* FUNCTION: sumEvenInterval(integer a, b) -> integer
   * PRE: a, b >= 0, a <= b
   * POST: the result is the sum of all even integer
   * numbers in the interval [a,b]
   * EXAMPLES:
   *    sumEvenInterval(2,4) -> 6
   */
  static int sumEvenInterval(int a, int b){
    if (a>b)
      return 0;
      else if (b%2==1)
        return b-1 + sumEvenInterval(a, b-2);
        else
          return b + sumEvenInterval(a, b-2);

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
  static int revnumber=0;
  static int reverse(int number){
    
    if (number<=0){
      int result=revnumber;
      revnumber= 0;
      return result;
    }
      else  revnumber=revnumber*10+(number%10);
        return reverse(number/10);
      
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
  static boolean isPalindromic(int number){
    if (reverse(number)==number)
      return true;
      else
      return false; 

  
  }
  
  
  /* FUNCTION:  (integer n) → text
   * PRE: n > 0
   * POST: the result is a line with n asterisks
   * EXAMPLES:
   *    lineAst(1) -> "*"
   *    lineAst(3) -> "***"
   */
  static String lineAst (int a){
    if (a<=0)
      return " ";
      else
        return "*" + lineAst(a-1);

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
  static String a="";
  static String triangleAst (int m){
  
    if(m == 0){
      a="";
      return "";
     }         
      else
        a = a + "*";
        System.out.println(a);
        return triangleAst(m-1);
        
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
  static int elefante=1; 
  static String Songele="Un elefante se balanceaba sobre la tela de una araña y como veía que no se caía fue a llamar a otro elefante.";
  static String elephantSong (int song){
    if (song<=0){
      Songele="Un elefante se balanceaba sobre la tela de una araña y como veía que no se caía fue a llamar a otro elefante.";
      elefante = 1;
      return "";
    }

      
      else {
        System.out.println(Songele);
        elefante=elefante+1;
        Songele=elefante +" elefantes se balanceaban sobre la tela de una araña y como veían que no se caían fueron a llamar a otro elefante.";
        return elephantSong (song-1);
      }

}
  
  
  
  
  public static void main(String [] args){
    System.out.println("Function Power:");
    System.out.println(power(1, 0)==1);
    System.out.println(power(2, 1)==2);
    System.out.println(power(2, 2)==4);
    System.out.println(power(3, 2)==9);
    System.out.println(power(3, 3)==27);
    System.out.println("Function Fibonacci:");
    System.out.println(fibonacci(0)==0);
    System.out.println(fibonacci(1)==1);
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
