package NETWORK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 간단한 서버접속 프로그램

public class ServerTest {

	public static void main(String[] args) {
		
		// 서버프로그램 서버소켓 선언
		ServerSocket serverSocket = null;
		// 클라이언트용 일반소켓 선언
		Socket socket = null;
		
		// 서버소켓의 내부정보 할당 서버는 포트번호만 알고있음 된다.
		try {
			serverSocket = new ServerSocket(5050);
			System.out.println("접속대기 중.....");
			
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속되었습니다.");
			
			BufferedReader reader = new BufferedReader(
									new InputStreamReader(
									socket.getInputStream()));
			
			PrintWriter writer = new PrintWriter(
									socket.getOutputStream());
			
			// reader에 들어온 데이터를 서버화면에 그대로 출력한다.
			System.out.println(reader.readLine());
			// 클라이언트화면에 출력한다.
			writer.println("안녕하세요. 서버에 접속하셨습니다.");
			writer.flush();
					
		} catch (Exception e) {
			
		}finally {
			try {
				socket.close();
				serverSocket.close();
			}catch(Exception e) {}
		}
		
	}

}


