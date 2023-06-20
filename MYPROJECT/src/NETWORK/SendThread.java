package NETWORK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// sendThread구현
public class SendThread extends Thread {
	Socket socket;
	
	// 생성자
	SendThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in)); // 키보드로부터 입력을 받는다.

			PrintWriter writer = new PrintWriter(
							socket.getOutputStream());
			
			while(true) {
				String str = reader.readLine();
				if(str.equals("BYE")) break;
				writer.println(str);
				writer.flush();
			}
		}catch(Exception e) {}
		try {
			System.out.println("채티방 나감 ㅂㅂ");
			socket.close();
		}catch(Exception e) {}
	}
}
