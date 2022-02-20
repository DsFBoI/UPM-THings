public class A12 {
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

    //sorting in numeriacal order
    static int[] Sorting(int [] a){
        int[] b= new int[a.length];
        int t = 0;
        for(int i  = 0; i<=maxElem(a); i++){
            for (int j = 0; j<a.length; j++){
                if (a[j] == i){
                    b[t]=a[j];
                    t++;
                }
            }
        }
        return b;
    }


    static boolean binarySearch(int[] a,int n){
        int[] b = Sorting(a);
        int max = a.length - 1;
        int min = 0;
        boolean result = false;
        int d = max/2;
        for(int i = 0; i<b.length && !result; i++){
            if (b[d]==n){
                System.out.println(b[d]+" is on the list yeaahhhhhh");
                result = true;
            }
            else if(b[d]<n){
                System.out.println("No, "+b[d]+" is a bigger number");
                min=d;
                d=min+((max-min)/2);
            }
            else if(a[d]>n){
                System.out.println("No, "+b[d]+" is a smaller number");
                max=d;
                d=d/2;
            }
        }
        return result;
    }

    
    
    
    
    static String visualizeInt (int[] colInt){
        String result = "";
        for (int i= 0; i < colInt.length; i++){
            result = result+" "+colInt[i];
                }               
        return result;    
    }
    public static void main(String[] args) {
        int[] a ={4,3,2,1,5};
        int[] b ={3,2,2,5,6};
        int[] c ={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
        int[] d ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        System.out.println(visualizeInt(Sorting(a)));
        System.out.println(visualizeInt(Sorting(b)));
        System.out.println(binarySearch(a,4));
        System.out.println(binarySearch(c,89));
        System.out.println(binarySearch(d,14));
        
    }
}
