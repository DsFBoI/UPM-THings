public class CC_02_Carrera{
    static int n = 0;   //Variables in which the operations are going to be done
    static int M = 10;  //
    static int N = 20;
    public static class Incr extends Thread{//Increasing Thread
        int val;
        public Incr(int val){
            this.val = val;
        }
        public void run(){
            n++;

        }
     }
    public static class Decr extends Thread{//Decreasing Thread
        int val;
        public Decr(int val){
            this.val = val;
        }

        public void run(){
            n--;

        }
    }
    public static void main(String[] args) {
        int i = 0;
        while(i < M ){
            Thread incr = new Thread();
            Thread decr = new Thread();
            for(int j = 0;j < N ; j++ ){
                incr = new Thread(new Incr(j));;
                decr = new Thread(new Decr(j));;
                incr.start();
                decr.start();
                
               
            }

            
            i++;
        }

       
        System.out.println(n);
        
    }
}
