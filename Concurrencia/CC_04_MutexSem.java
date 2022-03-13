import es.upm.babel.cclib.Semaphore;

public class CC_04_MutexSem {
     /*---------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //Variables

    static int n = 0;                   //Nº para modificar
    static int N = 2000;                //Nº de repeticiones
    static Semaphore s1 = new Semaphore(N);    //Controls the order
    static Semaphore s2 = new Semaphore(0);       

    /*---------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //Increasing Thread

    public static class Incr extends Thread{
        int val;
        public Incr(int val){
            this.val = val;     //gives the thread a value
        }
        public void run(){//Modification of run
            s1.await();
            n++;
            s2.signal();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //Decreasing Thread

    public static class Decr extends Thread{//Decreasing Thread
        int val;
        public Decr(int val){
            this.val = val;     //gives the thread a value
        }

        public void run(){//Modification of run
            s2.await();
            n--;

        }
    }

    /*---------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //MAIN

    public static void main(String[] args) throws InterruptedException {
        Thread[] incr = new Thread[N];
        Thread[] decr = new Thread[N];
        for(int i = 0 ; i < N ; i++){
            //DECLARATIONS of types of threads
            incr[i] = new Incr(i);
            decr[i] = new Decr(i);
            //STARTS functions
            incr[i].start();
            decr[i].start();
            //JOIN functions
            incr[i].join();
            decr[i].join();
           
        }

        System.out.println("n = " + n);
    }
}
