package NETWORK;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatTest {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(5051);
			System.out.println("접속대기 중.....");
			
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속되었습니다.");
			
			SendThread st = new SendThread(socket);
			ReceiveThread rt = new ReceiveThread(socket);
			
			st.start();
			rt.start();
			
		}catch(Exception e) {}
		finally {
			try {
				serverSocket.close();
			}catch(Exception e) {}
		}

	}

}
