public class A9 {
    //EXERCISE 1
    static int countAsterisks(char[] ast){
        int counter=0;
        for (int i = 0;i < ast.length; i++){
            if (ast[i] =='*')
            counter++;        
       }
        return counter;
    }
    //EXERCISE 2
    static boolean findChar (char[] find, char a){
        boolean result = false;
        for (int i = 0; i < find.length && result==false ; i++){
            if (find[i] == a)
                result = true;
        }
        return result;
    } 
    //EXERCISE 3 
    static boolean allN (int[] find, int a){
        boolean result = true;
        int i = 0;
        while (i < find.length && result == true ){
            if (find[i] != a)
                result = false;
            i++;
        }
        return result;
    }
    //EXERCISE 4
    static boolean allC (char[] find, char a){
        boolean result = true;
        int i = 0;
        while (i < find.length && result == true ){
            if (find[i] != a)
                result = false;
            i++;
        }
        return result;       
    }
    //EXERCISE 5
    static int[] copy(int[] og){
        int[] copy;
        String a = "";
        copy = new int[og.length];
        for(int i = 0;i < og.length; i++){
            copy[i] = og[i];
            a = a + copy[i];
        }
        System.out.println("The result of teh copy is (because the copy given is a directory) :"+a);
        System.out.println("The result is as a directory is:");
        return copy;
    }
    //This code was made to make next exercises easier
    static char[] copy2(char[] og){
        char[] copy;
        copy = new char[og.length];
        for(int i = 0; i < og.length; i++){
            copy[i] = og[i];
        }
        return copy;
    }

    //EXERCISE 6
    //It is a string just for ascetically pkeasing reasons if we wre toput it as a char[] we will have to substitute the Strig by Char and 
    // take out all the extra code for it to print as shown in reverse
    static String invert(char[] og){
        String b = "";
        char[] a = copy2(og);
        for (int i = 0; i < og.length - 1 ; i++){
            a[i] = og[og.length - 1 - i];
            b = b + a[i] + ",";
        }
        a[og.length - 1] = og[0];
        b="["+b+a[og.length - 1]+"]";
        return b;

    }
    //EXERCISE 7
    //It is a string just for ascetically pkeasing reasons if we wre toput it as a char[] we will have to substitute the Strig by Char and 
    // take out all the extra code for it to print as shown in reverse
    static String invert2(char[] og){
        char[] list;            
        int t = og.length;
        String result="";
        list = new char[og.length];
        for(int i = 0 ; i < og.length-1 ; i++ ){
            t--;
            list[i] = og[t];
            result = result+list[i]+",";
        }
        list[og.length-1] = og[0];
        result="["+result+list[og.length-1]+"]";
        return result;
    }
    static char[] reverse(char[] og){
        char[] list;            
        int t=og.length;
        list = new char[og.length];
        for(int i=0 ; i<og.length ; i++ ){
            t--;
            list[i] = og[t];
        }
        return list;
    }
    //EXERCISE 8
    static boolean isPalindrome(char[] og){
        boolean result = true;
        char[] b = copy2(og);
        char[] a = reverse(og); 
        for(int i = 0 ;i < og.length && result == true ;i ++)
            if (b[i] != a[i]){
                result = false;
            }   
        return result;      
    }
    //EXERCISE 9
    static boolean equals(int[] a,int[] b){
        boolean result = true;
        if (a.length == b.length){
            for(int i = 0; i < a.length && result == true;i++){
                if (b[i]!=a[i])
                result=false;
            }
        }
        if (a.length != b.length){
            result = false;
        }
        return result;
    }
    //EXERCISE 10
    static String eliminateOdd(int[] a){
        int count = 0;
        String result = "";
        for (int i = 0; i < a.length; i++){
            if (a[i]%2 == 0)
                count++;
        }
        int [] b;
        b=new int[count];
        int r = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i]%2 == 0){
                b[r]=a[i];
                // result= result+ b[r]+",";
                r++;
            }
        }
        for (int z=0;z<b.length-1;z++){
            result = result + b[z] + ",";

        }
        result= "[" + result + b[b.length-1] + "]";
        return result;
    }
    public static void main(String[] args) {
        char[] example1 = {'*','a','f','z','*','*','t'};
        int[] example2={1,2,3,4,5};
        int[] example6={1,2,3,4,5,6,7,8,9,10};
        int[] example3={1,1,1,1,1};
        int[] example5={1,1,1,1,1};
        char[] example4 = {'a','a','a','a','a','a','a'};
        System.out.println("Count asterisk:");
        System.out.println(countAsterisks(example1));
        System.out.println("Find Char:");
        System.out.println(findChar(example1, 't'));
        System.out.println(findChar(example1, 'z'));
        System.out.println(findChar(example1, 'b'));
        System.out.println("all N:");
        System.out.println(allN(example2,1));
        System.out.println(allN(example3, 1));
        System.out.println(allN(example3, 2));
        System.out.println("all C:");
        System.out.println(allC(example4,'a'));
        System.out.println(allC(example4, 'b'));
        System.out.println(allC(example1, 'a'));
        System.out.println("Copy:");
        System.out.println(copy(example2));
        System.out.println(copy(example3));
        System.out.println(copy(example5));
        System.out.println(copy2(example1));
        System.out.println(copy2(example4));
        System.out.println("Invert1:");
        System.out.println(invert(example1));
        System.out.println(invert(example4));
        System.out.println("Invert2:");
        System.out.println(invert2(example1));
        System.out.println(invert2(example4));
        System.out.println("Is Palindrome:");
        System.out.println(isPalindrome(example1));
        System.out.println(isPalindrome(example4));
        System.out.println("Equals:");
        System.out.println(equals(example2,example3));
        System.out.println(equals(example3,example5));
        System.out.println("Eliminate Odd:");
        System.out.println(eliminateOdd(example2));
        System.out.println(eliminateOdd(example6));

        
    }
}
