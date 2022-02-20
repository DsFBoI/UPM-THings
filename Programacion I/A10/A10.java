import javax.lang.model.util.ElementScanner6;

/*
 * author: Clara Benac Earle
 * author:
 * 
 * creation date: 23/11/2020
 * last modification: 26/11/2020
 * Assignment 10
 */ 

class A10{
  
  /* FUNCTION: posElem(collection of integers col, integer elem) -> integer
   * PRE: col is no null
   * POST: the result is the position (index) of elem in col. 
   * If elem is not in col, then the result is -1
   * If elem appears more than once, the postion is the first 
   * one from left to right
   * EXAMPLES:
   *    posElem([2,5,7,2,5],7) -> 2
   *    posElem([2,5,7,2,5],2) -> 0
   *    posElem([2,5,7,2,5],6) -> -1
   */ 
  static int posElemI(int[] col, int a){
    boolean check= true;
    int result = 0;
    for(int i = 0 ; i < col.length && check; i ++){
        if (col[i]!= a){
            result ++;
        }
        else{
            check = !check;
        }
    }
    if(result == col.length) {
        result =- 1;
    }
    return result;
  }
  
  
  static int posElemR(int[] col, int a){
    return posElemAux(col,a,0);
  }
  
  
  static int posElemAux(int[] col, int a,int index){
    if(index==col.length)
      return -1;
    
    else if (col[index]==a)
      return index;
    
    else
      return posElemAux(col, a, index+1);
  }
  
  /* FUNCTION: isBalanced(Collection of caracteres col) -> boolean 
   * PRE: col is not null.
   * POST: the result is true if the parenthesis are well balanced 
   * and false otherwise
   * EXAMPLES:
   *  isBalanced(['(','(',')',')']) -> true
   *  isBalanced(['(','a','b',')','(','c','d',')']) -> true
   *  isBalanced(['(','(','c','d',')']) -> false
   *  isBalanced(['(','(','c','d',')',')',')']) -> false
   */ 

  static boolean isBalancedI (char[] col){
      int counter = 0;
      for (int i = 0 ; i < col.length  ; i++){
          if (col[i] == '('){
              counter++;
          }
            else if (col[i]==')'){
                counter--;;
            }
              }      
      return counter == 0;
    }
  static boolean isBalancedR(char[] a){
    return isBalancedAux(a, 0, 0);
  }
  static boolean isBalancedAux (char[] a, int counter,int index){
    if (index == a.length && counter == 0)
      return true;
    else if (index == a.length && counter != 0)
      return false;
    else{
      if (counter < 0)
        return false;
      else if (a[index]=='(')
        return isBalancedAux(a, counter + 1, index + 1);
      else if (a[index]==')')
        return isBalancedAux(a, counter - 1, index + 1);
      else
        return isBalancedAux(a, counter, index+1);
    }
  }

  /* FUNCTION: mostFrequentNumber(Collection of integers col) -> integer 
   * PRE: col is not null. Forall i, col[i] IN [0..9]  
   * POST: the result is the number that appears the most in col 
   * EXAMPLES:  
   *  mostFrequentNumber([2,4,1,5,1,5,1]) -> 1 
   *  mostFrequentNumber([5,2,2]) -> 2 
   *  mostFrequent([5,2,2,3,3]) -> 2 
   */ 
  static int mostFrequentNumberI (int[] a){
    int counter = 0;
    int[] list;
    int result = 0;
    int result2 = 0;
    list= new int[10];
    for (int i = 0; i < a.length; i++){
      if (a[i]==0){
        list[0]++;
      }
      if (a[i]==1){
        list[1]++;
      }
      if (a[i]==2){
        list[2]++;
      }
      if (a[i]==3){
        list[3]++;
      }
      if (a[i]==4){
        list[4]++;
      }
      if (a[i]==5){
        list[5]++;
      }
      if (a[i]==6){
        list[6]++;
      }
      if (a[i]==7){
        list[7]++;
      }
      if (a[i]==8){
        list[8]++;
      }
      if (a[i]==9){
        list[9]++;
      }

    }
    for (int b = 0; b < list.length && counter<list.length;b++,counter++){
      if (result<list[b]){  
        result = list[b];
        result2  =  counter;
      }
        
    }
    return result2;
  }
  
  
  public static void main(String[] args){
    //Tests
    int[] a = {2,5,7,2,5};
    char[] b = {'(','(',')',')'};
    char[] c = {'(','a','b',')','(','c','d',')'};
    char[] d = {'(','(','c','d',')'};
    char[] e = {'(','(','c','d',')',')',')'};
    int[] f = {2,4,1,5,1,5,1};
    int[] g = {5,2,2};
    int[] h = {5,2,2,3,3};
    int[] i = {5,2,2,3,3,4,4,4};
    System.out.println(posElemI(a, 7));
    System.out.println(posElemI(a, 2));
    System.out.println(posElemI(a, 6));
    System.out.println(posElemR(a, 7));
    System.out.println(posElemR(a, 2));
    System.out.println(posElemR(a, 6));
    System.out.println(isBalancedI(b));
    System.out.println(isBalancedI(c));
    System.out.println(isBalancedI(d));
    System.out.println(isBalancedI(e));
    System.out.println(isBalancedR(b));
    System.out.println(isBalancedR(c));
    System.out.println(isBalancedR(d));
    System.out.println(isBalancedR(e));
    System.out.println(mostFrequentNumberI(a));
    System.out.println(mostFrequentNumberI(f));
    System.out.println(mostFrequentNumberI(g));
    System.out.println(mostFrequentNumberI(h));
    System.out.println(mostFrequentNumberI(i));

    
  }
  
}
