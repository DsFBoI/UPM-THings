public class CC_01_Threads{
	
	static int N = 20;
	static int T = 1500;
	
	private static class MyThread extends Thread{
		int val; //numero del thread
		
		public MyThread(int val){
			this.val=val;
		
		}
		
		public void run() {
			//INICIO DE THREAD
			try {
				Thread.sleep(T);//sleep
		
			}
		
			catch (InterruptedException e) {// si no se puede ejecutar imprime el trace
				e.printStackTrace();
		
			}
			System.out.println("Numero de thread : " + this.val);
		}
		
		
	}
	public static void main(String[] args) {
		
		for(int i = 1; i <= N ; i++ ) {
			Thread thread = new Thread(new MyThread(i));
			thread.start();
			
		try {
			
			thread.join(); // COMPRUEBA QUE NO SE SOLAPEN LOS THREADS
		}
		
		catch(InterruptedException e) {//EXCEPTION DEL ERROR

			
			e.printStackTrace();
			return;
		}
		}
		System.out.println("FIN");
	}
}
