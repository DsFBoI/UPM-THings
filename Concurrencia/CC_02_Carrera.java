public class CC_02_Carrera{
    static int n = 0;   //Variable in which the operations are going to be done
    static int M = 10;  //Number of times that we want to do the Threads
    static int N = 2;   //Number of Increments and Drecreces we are going to do
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------*/

    //Increasing Thread

    public static class Incr extends Thread{
        int val;
        public Incr(int val){
            this.val = val;     //gives the thread a value
        }
        public void run(){
            n++;                //Modification of run

        }
     }
     
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------*/       
     //Decreasing Thread

    public static class Decr extends Thread{//Decreasing Thread
        int val;
        public Decr(int val){
            this.val = val;     //gives the thread a value
        }

        public void run(){      //Modification of run
            n--;

        }
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------*/

    // Main
    public static void main(String[] args) {
        for(int i = 0 ; i < M ; i++){
            Thread incr = new Thread();
            Thread decr = new Thread();
            for(int j = 0;j < N ; j++ ){
                incr = new Thread(new Incr(j));//Giving the threads the values of the thread they are on
                decr = new Thread(new Decr(j));
                incr.start();  //Start the thread with the run option
                decr.start();
                
               
            }

            for(int j = 0;j < N ; j++ ){
                try{//we have to do join to see if there is any exception on the threads when doind the previous process
                    incr.join();
                    decr.join();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                    System.out.println("\"ERROR\"");
                }
            }
    
        }       
        System.out.println("n = " + n);
        
    }
}
