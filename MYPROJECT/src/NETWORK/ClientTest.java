package NETWORK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 간단한 클라이언트 프로그램

public class ClientTest {

	public static void main(String[] args) {
		// 일반소켓 선언
		Socket socket = null;
		
		// 접속 (접속하려는 다른 클라이언트의 네트워크 주소, 포트번호 필요)
		try {
			socket = new Socket("192.168.18.123", 5050);
			
			BufferedReader reader = new BufferedReader(
									new InputStreamReader(
									socket.getInputStream()));

			PrintWriter writer = new PrintWriter(
								socket.getOutputStream());
			
			// 상대방에게 알려준다.
			writer.println("클라리언트 접속했어요");
			writer.flush();
			System.out.println(reader.readLine());
		} catch (Exception e) {
			
		}finally {
			try {
				socket.close();
			}catch(Exception e) {}
		}
			
	}

}
