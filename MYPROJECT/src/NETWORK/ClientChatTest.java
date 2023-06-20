package NETWORK;

import java.net.Socket;

public class ClientChatTest {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.18.123", 5051);
			System.out.println("채팅방에 접속함 ㅅㄱ");
			
			SendThread st = new SendThread(socket);
			ReceiveThread rt = new ReceiveThread(socket);
			
			st.start();
			rt.start();
			
		}catch(Exception e) {}
			
	}

}
