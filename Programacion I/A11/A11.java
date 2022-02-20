/*
 * author: DAniel Sanchez Ferrari
 * created: 03/12/2020
 * 
 * A11: bidimensional collections
 * 
 */ 

class A11{
  
  /* FUNCTION: sumElements(matrix of integer m) -> integer
   * PRE: m is not null
   * POST: the result is the addition of all elements in m. 
   * EXAMPLE:
   *   sumElements([[1,2],[3,4]]) -> 10
   *   sumElements([[2,2],[1,1]]) -> 6
   */ 
  static int sumElements(int[][] a){
    int result = 0;
    for (int i=0;i<a.length;i++ ){
      for(int f = 0; f<a[i].length; f++){
        result = result + a[i][f];
      }
    }
    return result;
  }
  
  
  
  
  
  
  
  /* FUNCTION: findN(matrix of integer m, int n) -> boolean
   * PRE: m is not null
   * POST: the result is true if n is in m and false otherwise
   * 
   * EXAMPLE:
   *   findN([[1,2],[3,4]],3) -> true
   *   findN([[1,2],[3,4]],5) -> false
   */ 
  static boolean findN(int[][] a,int b){
    boolean result= false;
    for (int i = 0; i < a.length && !result; i++ ){
      for(int f = 0; f < a[i].length && !result; f++){
        if (a[i][f]==b){
          result = true;
        }
      }
    }
    return result;
  }
  
  
  
  
  /* FUNCTION: equals(matrices of integer m1, m2) -> boolean
   * PRE: m1 and m2 are not null
   * POST: the result is true if m1 and m2 have the same elements
   * and in the same positions and false otherwise.
   * 
   * EXAMPLES:
   *   equals([[1,2],[3,4]],[[1,1],[2,2]]) -> false
   *   equals([[1,2],[3,4]],[[1,2],[3,4]]) -> true
   */ 
  static boolean equals(int[][] a ,int[][] b){
    boolean result = true;
    for(int t = 0; t<a[0].length; t++){
      if (a.length == b.length && a[t].length == b[t].length ){
        for(int i = 0; i < a.length && result; i++){
          for (int f = 0; f < a[i].length && result; f++){
            if (a[i][f] != b[i][f]){
              result = false;
            }
          }
        }
      }
      else{
        result = false;
      }
    }
    return result;
  }
  
  
  
  
  /* FUNCTION: sumMatrices(matrices of integer m1, m2) -> matrix of integers
   * PRE: m1 and m2 are not null. m1 and m2 have the same size
   * POST: the result is a matrix such that each element is the
   * addition of the corresponding elements in m1 ad m2
   * 
   * EXAMPLE:
   *   sumMatrices([[1,2],[3,4]],[[1,1],[2,2]]) -> [[2,3],[5,6]]
   */
  static int[][] sumMatrices(int[][]a ,int[][] b){
    int[][] c = new int[a.length][a[0].length];
    for(int t = 0 ; t<a[0].length ; t++){
      if (a.length == b.length && a[t].length == b[t].length){
        for(int i = 0;i < a.length;i++){
          for(int f = 0; f < a[i].length; f++){
            c[i][f]= a[i][f] + b[i][f];
          }
        }
      }
      else{
        return a;
      }
    }
    return c ;
  }
  
  
  
  
  /* FUNCTION: showMatrix(matrix of integer m) -> text
   * PRE: m is not null
   * POST: the result is a text containing the elements of a matrix. The
   * elements of each row are separated by a blank space and each row 
   * is in one line.
   * EXAMPLE:
   *   showMatrix([[1,2],[3,4]]) -> 1 2
   *                                3 4
   */
  static String showMatrix(int[][]a){
    String result = "";
    for (int i = 0; i< a.length ; i++){
      for (int f = 0; f < a[i].length; f++){
        result = result+a[i][f]+" ";
      }
      result= result + '\n';

    }
    return result;
  }
  
  
  
  /* FUNCTION: identity(int size) -> matrix of integer
   * PRE: size >= 0
   * POST: the result is the identity matrix of size n, that is, 
   * an n × n square matrix with ones on the main diagonal and zeros elsewhere.
   * EXAMPLE:
   *   identity(1) -> 1
   *   identity(3) -> 1 0 0 
   *                  0 1 0
   *                  0 0 1
   * 
   */
  static String identity(int a){
    int [][] b = new int[a][a];
    for (int i = 0; i<a;i++){
      b[i][i] = 1;
    }
    return showMatrix(b);
  }

  public static void main(String[] args){
    int[][] a={{1,2},{3,4}};
    int[][] b={{1,1},{2,2}};
    int[][] c={{2,4},{5,3}};
    int[][] d={{1,1},{2,2}};
    int[][] e={{1,1},{2}};
    System.out.println(sumElements(a)==10);
    System.out.println(sumElements(b)==6);
    System.out.println(sumElements(c)==14);
    System.out.println(findN(a, 2));
    System.out.println(findN(a, 6));
    System.out.println(findN(b, 1));
    System.out.println(findN(b, 3));
    System.out.println(findN(c, 4));
    System.out.println(findN(c, 1));
    System.out.println(equals(a, b));
    System.out.println(equals(d, b));
    System.out.println(equals(e, b));
    System.out.println(showMatrix(sumMatrices(a, b)));
    System.out.println(showMatrix(sumMatrices(e, b)));
    System.out.println(showMatrix(a));
    System.out.println(showMatrix(b));
    System.out.println(showMatrix(c));
    System.out.println(identity(2));
    System.out.println(identity(5));
    System.out.println(identity(7));    
  }
  
}
