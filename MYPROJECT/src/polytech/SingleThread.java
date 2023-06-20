package polytech;

import java.io.IOException;

public class SingleThread{

	public static void main(String[] args) {
		
		// thread 1 1초 주기로 출력
		int i = 0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i++;
			
			if(i == 10) {
				System.out.println("10초!!!!");
				break;
			}else {
				System.out.println(i + "초 입니다.....");
			}
		}
		
		// thread2
		char alp;
		
		for(alp = 'A'; alp <= 'Z'; alp++) {
			System.out.print(alp + " ");
			try {
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
		
		// thread3
		int j;
		int sum = 0;
		
		for(j=1; j <= 1000; j++) {
			sum += j;
		}
		System.out.println("1부터 100까지의 합은 " + sum + "입니다.");

	}

}
