package polytech;

import java.io.*;

public class FileTestPG {

	public static void main(String[] args) {
		
		try {
			//파일생성 및 열기위한 인스턴스         파일이름
			FileWriter fw = new FileWriter("test.csv");
			
			// 파일에 쓰기
			fw.write("0,1,2,3,4,5,6,7,8,9\n");
			fw.write("10,11,12,13,14,15,16,17,18,19\n");
			
			// 파일 닫기
			fw.close();
			
		}catch(IOException e) {
			// 어떤 에러가 생겼는지 알려준다.
			System.out.println(e);
		}
		
		int i;
		char c;
		
		try {
			FileReader fr = new FileReader("test.csv");
			while((i = fr.read())!= -1){
				c = (char)i;
				System.out.print(c);
			}
			fr.close();			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
