package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class WBDataBase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WBDataBase frame = new WBDataBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public WBDataBase() {
		setTitle("데이터베이스 P/G");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextArea text = new JTextArea();
		text.setBounds(23, 85, 516, 320);
		contentPane.add(text);
		
		JButton btn = new JButton("검색");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB에 접근하려면 무조건 필요한 작업
				try {
					// JDBC드라이버 연결
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					
					// DB connection객체 생성
					Connection conn = DriverManager.getConnection(
							// 내 pc에있는 DB에 연결하겠다.ip,포트번호
							"jdbc:sqlserver://127.0.0.1:1433;"
							+"databaseName = Madang;"
							+"user=mduser;"
							+"password=mdpass;"
							+"encrypt=true;"
							+"trustServerCertificate=true;");
					
					// SQL실행쿼리가 들어있는 클래스
					Statement stmt = conn.createStatement();
					
				// DB쿼리에 대한 결과를 담는 클래스		DML구문 적는 메서드??클래스???
					ResultSet rset = stmt.executeQuery("SELECT * FROM BOOK");
					
					// DB값 읽어오기
					// 해당 튜플의				1,2,3,4번째 속성값을 들고온다
					while(rset.next()) {
						text.append(rset.getInt(1) + " / "+
								rset.getString(2) + " / "+
								rset.getString(3)+ " / "+
								rset.getInt(4)+"\n");
					
					}
					rset.close();
					stmt.close();
					// 닫아주지 않으면 다른사람이 접근을 못함
					conn.close();
					
				}catch(Exception e1) {}
			}
		});
		
		
		btn.setBounds(444, 35, 97, 23);
		contentPane.add(btn);
		
	}
}
