package polytech;

import java.util.Scanner;

class SharedMemory{
	int x = 100;
	boolean isQuit = false;
}

class PlusThread extends Thread{
	SharedMemory shmem;
	
	public void run() {
		while(!shmem.isQuit) {
			System.out.println("x = " + shmem.x);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			shmem.x++;
			
			
		}
	}
}

class MinusThread extends Thread{
	SharedMemory shmem;
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		while(shmem.x != 0) {
			sc.nextLine();
			shmem.x --;
		}
		
		shmem.isQuit = true;
		System.out.println("Win");
		
	}
}




public class SharedMemoryTest {

	public static void main(String[] args) {
//		SharedMemory shobj = new SharedMemory();
//		
//		PlusThread pt = new PlusThread();
//		MinusThread mt = new MinusThread();
//		
//		pt.shmem = shobj;
//		mt.shmem = shobj;
//		
//		pt.start();
//		mt.start();
		
		int [] a = new int[8];
		int i = 0;
		int n = 11;
		while(n > 0) {
			a[i++] = n % 2;
			System.out.print("n : " + n);
			n /= 2;
			System.out.println(" n : " + n);
			
		}
		

	}

}
