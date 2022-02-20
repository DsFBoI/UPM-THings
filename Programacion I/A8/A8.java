public class A8 {   
    /*
    Visualize (collection of intergers colInt)->text
    Pre: colInt cannot be null
    Post: the result is a text cointaning the elememts of colInt separated with blanks
    */    
    //EXERCISE 4
    static String visualizeInt (int[] colInt){
        String result = "";
        for (int i= 0; i < colInt.length; i++){
            result = result+" "+colInt[i];
                }               
        return result;    
    }

    static String visualizeChar (char[] colChar){
        String result = "";
        for (int i= 0; i < colChar.length; i++){
            result = result+" "+colChar[i];
                }               
        return result;
            
    }
    //EXERCISE 5
    static String visualizeColection (int[] colInt){
        String result = "";
        for (int i= 0; i < colInt.length; i++){
            result = result+colInt[i]+",";
                }               
        return ("["+result+"]");    
    }
    //EXERCISE 6
    static int sumElements (int[] colInt){
        int result = 0;
        for (int i= 0; i < colInt.length; i++){
            result = result+colInt[i];
                }               
        return (result);
        }

    //EXERCISE 7
        static int sumEvenElements (int[] colInt){
            int result = 0;
            for (int i= 0; i < colInt.length;i++ ){
                if (colInt[i]%2==0)
                    result = result+colInt[i];
                    
                           
            }               
            return (result);
            }   
    
    //EXERCISE 8
    static int sumPosEven (int[] colInt){
        int result = 0;
        for (int i= 0; i < colInt.length; i=i+2){
            result = result+colInt[i];
            }               
        return (result);
    }
    
    
    
    //Exercise 9
    static int maxElem(int[] colInt){
        int result = 0;
        for (int i= 1; i < colInt.length;i++){
            if (colInt[i-1]>colInt[i])
                result= colInt[i-1];
            if (colInt[i-1]<colInt[i])   
                result = colInt[i];
            
        }
        return result;

    }
    //EXERCISE 10
    static boolean findElement(int[] colInt,int a){
        boolean result=false ;
        for (int i=0;i < colInt.length;i++){  
            if (colInt[i]== a)
            return true;
            
        }
        return result;
    }
    //EXERCISE 11
    static int minElem(int[] colInt){
        int result = 0;
        result=colInt[0];
        for (int i= 0; i < colInt.length;i++){
            
            if (result>colInt[i])
                result= colInt[i];
            
        }
        return result;

    }

    public static void main(String[] args) {
        int num = 222;
        int[] nums;
        nums= new int[5];
        nums[0]=3;
        nums[1]=4;
        nums[2]=6;
        nums[3]=3;
        nums[4]=8;
        int[] nums2 ={4,7,2,1,8,4,10};
        //EXERCISE 1
        System.out.println(num);
        // Q1 = 222
        System.out.println(nums);
        // Q2 = it returns an error in thsi case becasue we did not specify the size
        // Q3 = [I@71dac704 ,it gives a memory address
        // A VARIABLES OF TYPE ARREY STORES ONE MEMORY ADDRESS
        //EXERCISE 2
        System.out.println(nums);
        // Q4 = [I@71dac704 ,it gives an address in dynamic memory
        //EXERCISE 3
        char[] vowel = {'a','e','i','o','u'};
        System.out.println(vowel);
        // Q5 = We are given al the characters as an string together without space in between
        System.out.println("Function Visualize Int:");
        System.out.println(visualizeInt(nums));
        System.out.println(visualizeInt(nums2));
        System.out.println("Function Visualize Char:");
        System.out.println(visualizeChar(vowel));
        System.out.println("Function Visualize Colection:");
        System.out.println(visualizeColection(nums));
        System.out.println(visualizeColection(nums2));
        System.out.println("Function sumElements:");
        System.out.println(sumElements(nums));
        System.out.println(sumElements(nums2));
        System.out.println("Function sumPosEven:");
        System.out.println(sumPosEven(nums));
        System.out.println(sumPosEven(nums2));
        System.out.println("Function sumEvenElements:");
        System.out.println(sumEvenElements(nums));
        System.out.println(sumEvenElements(nums2));
        System.out.println("Function maxElem:");
        System.out.println(maxElem(nums));
        System.out.println(maxElem(nums2));
        System.out.println("Function findElement:");
        System.out.println(findElement(nums,3));
        System.out.println(findElement(nums,4));
        System.out.println(findElement(nums,6));
        System.out.println(findElement(nums,8));
        System.out.println(findElement(nums2,4));
        System.out.println(findElement(nums2,2));
        System.out.println(findElement(nums2,8));
        System.out.println(findElement(nums2,7));
        System.out.println(findElement(nums2,1));
        System.out.println(findElement(nums2,3));
        System.out.println("Function minElem:");
        System.out.println(minElem(nums));
        System.out.println(minElem(nums2));
        

    } 
}
