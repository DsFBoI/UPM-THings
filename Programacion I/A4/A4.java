/*
 * A4.java
 * 
 * 
 * author: Clara Benac Earle
 * author: Daniel Sánchez
 * 
 * creation date: 25/09/2020
 * 
 */ 


class A4 {
  
  // Implement the FA that are specified in this file and
  // answer the questions
  
  /*
   * FUNCTION: cmToMetres (|N cm) -> |N
   * PRE: cm > 0
   * POST: the result is the amount cm (in centimetres)
   * converted to metres
   * EXAMPLES:
   * cmToMetres(1000) -> 10
   *
   */
  static int cmToMetres (int cm) {
    return cm / 100;
  }
  static double cmToMetres (double cm) {
    return cm / 100;
  }

  // Answer the following questions after implementing cmToMetres
  // Q1: Do you think this implementation of cmToMetres is a good one?
  // If the answer is no, why?
  // Q1: No as it only works with intergers and when you input a numbeer lower tah 100 the result will be 0

  // If you think the implementation of cmToMetres can be improved, write
  // a specification and an implementation of the function that is correct

  /*
   * FUNCTION: isEven (Integer num) -> boolean PRE: true POST: the result is true
   * if num is even and false otherwise EXAMPLES: isEven(0) -> true isEven(1) ->
   * false isEven(-5) -> false isEven(22) -> true
   * 
   */
  static boolean isEven (int num) {
    return num % 2 == 0;

  }

  // Answer the following questions after implementing isEven

  // Q2: How would you implement a function that returns true
  // if a number is odd?
  // Q2: Changing the 0 of %2==0 to %2==1

  /*
   * FUNCTION: isMultiple (|N n,m) -> boolean PRE: m cannot be 0 POST: the result
   * is true if n is multiple of m and false otherwise EXAMPLES: isMultiple (10,5)
   * -> true isMultiple (7,12) -> false
   * 
   */
  static boolean isMultiple (int m,int n) {
    return m%n==0;
  }
  /*
   * 
   * FUNCTION: lastDigit (Integer num) -> Integer PRE: true POST: the result is
   * the last digit in num Examples: lastDigit(234) -> 4 lastDigit(3) -> 3
   * 
   */
  static int lastDigit (int numb){
    return numb%10;

  }

  /*
   * FUNCTION: numWithoutLastDigit(|N num) -> |N PRE: true POST: the result is num
   * without the last digit Examples: numWithoutLastDigit(578) -> 57
   * numWithoutLastDigit(2847) -> 284
   */
  static int numWithoutLastDigit (int numbe){
    return numbe/10;

  }

  /*
   * 
   * FUNCTION: implication(Boolean p,q) -> Boolean PRE: true POST: the result is
   * the logic implication, if p then q Examples: implication(true,true) -> true
   * implication(true,false) -> false implication(false,true) -> true
   * implication(false,false) -> true
   * 
   */
  static boolean implication (boolean p, boolean q){
    return !p||q;
  }

  /*
   * FUNCTION: convertToSeconds (|N, h, m,s) -> |N PRE: h, m, s >= 0 POST: the
   * result is the amount of seconds corresponding to h hours, m minutes and s
   * secondse Examples: convertToSeconds(1,0,0) -> 3600 convertToSeconds(0,1,0) ->
   * 60 convertToSeconds(0,0,1) -> 1 convertToSeconds(2,20,50) -> 8450
   */
  static int convertToSeconds (int h, int min, int s){
    return h*3600 + min*60 + s;

  }
  //Exercise 1
  static int salary (int year){
    return ((2020-year)/5)*100 + 1500;
  }
  //Exercise 2
  static boolean isVowel (char vow){
    return vow ==97||vow == 111||vow ==101||vow ==105||vow ==117;

  }
  // Exercise 3
  static boolean isVowelOrConsonant (char vowe){
    return (Character.isLetter(vowe));

  }
  //Exercise 4
  static double price (int a, int b, int c){
    return ((a-b)*c+b*c)*345.7;
  }
  //Exercise 5
  static boolean Lucky7 (int e, int d) {
    return (e+d==7)||(e-d==7);

  }


  public static void main(String [] args) {
    // Test your code here
    System.out.println(cmToMetres(1000));
    System.out.println(cmToMetres(40.0));
    System.out.println(isEven(30));
    System.out.println(isEven(15));
    System.out.println(isMultiple(10,5));
    System.out.println(isMultiple(10,3));
    System.out.println(lastDigit(456));
    System.out.println(numWithoutLastDigit(5432));
    System.out.println(implication(false, false));
    System.out.println(convertToSeconds(4,30,15));
    System.out.println(salary(1980));
    System.out.println(salary(2010));
    System.out.println(isVowel('a'));
    System.out.println(isVowel('l'));
    System.out.println(isVowelOrConsonant('l'));
    System.out.println(isVowelOrConsonant('?'));
    System.out.println(price(5, 3, 4));
    System.out.println(Lucky7(3, 4));
    System.out.println(Lucky7(12, 5));

  }
}
