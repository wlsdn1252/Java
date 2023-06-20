package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class WBDB2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WBDB2 frame = new WBDB2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WBDB2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField2 = new JTextField();
		textField2.setBounds(577, 10, 116, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(12, 101, 483, 335);
		contentPane.add(textArea1);
		
		JButton bookNameBt = new JButton("마당서점 보유 서적");
		bookNameBt.addActionListener(new ActionListener() {
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
					ResultSet rset = stmt.executeQuery("SELECT BOOKNAME FROM BOOK");
					
					// DB값 읽어오기
					// 해당 튜플의				1,2,3,4번째 속성값을 들고온다
					textArea1.setText("");
					while(rset.next()) {
						textArea1.append(rset.getString(1)+"\n");
					
					}
					rset.close();
					stmt.close();
					// 닫아주지 않으면 다른사람이 접근을 못함
					conn.close();
					
				}catch(Exception e1) {}
			}
		});
		bookNameBt.setBounds(39, 21, 145, 35);
		contentPane.add(bookNameBt);
		
		JButton customerBt = new JButton("마당서점 고객 정보");
		customerBt.addActionListener(new ActionListener() {
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
					ResultSet rset = stmt.executeQuery("SELECT NAME FROM Customer");
					
					// DB값 읽어오기
					// 해당 튜플의				1,2,3,4번째 속성값을 들고온다
					textArea1.setText("");
					while(rset.next()) {
						textArea1.append(rset.getString(1)+"\n");
					
					}
					rset.close();
					stmt.close();
					// 닫아주지 않으면 다른사람이 접근을 못함
					conn.close();
					
				}catch(Exception e1) {}
			}
		});
		customerBt.setBounds(212, 21, 159, 35);
		contentPane.add(customerBt);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(577, 41, 200, 115);
		contentPane.add(textArea);
		
		JButton booknameBt2 = new JButton("검색");
		booknameBt2.addActionListener(new ActionListener() {
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
					String search = textField2.getText();
					
				// DB쿼리에 대한 결과를 담는 클래스		DML구문 적는 메서드??클래스???
					ResultSet rset = stmt.executeQuery("SELECT BOOKNAME FROM BOOK WHERE BOOKNAME LIKE '%"+ search +"%'");
					
					// DB값 읽어오기
					// 해당 튜플의				1,2,3,4번째 속성값을 들고온다
					while(rset.next()) {
						textArea.append(rset.getString(1)+"\n");
					
					}
					rset.close();
					stmt.close();
					// 닫아주지 않으면 다른사람이 접근을 못함
					conn.close();
					
				}catch(Exception e1) {}
			}
		});
		booknameBt2.setBounds(702, 10, 77, 21);
		contentPane.add(booknameBt2);
		
		JLabel lblNewLabel = new JLabel("도서명 검색");
		lblNewLabel.setBounds(507, 11, 83, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이달의 도서 판매 순위");
		lblNewLabel_1.setBounds(577, 194, 128, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이달의 구매 고객 순위");
		lblNewLabel_2.setBounds(577, 316, 145, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(577, 219, 200, 83);
		contentPane.add(textArea2);
		
		JButton bookBt2 = new JButton("검색");
		bookBt2.addActionListener(new ActionListener() {
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
					ResultSet rset = stmt.executeQuery("select bookname, count(*), sum(saleprice)\r\n"
							+ "from book as b, orders as o\r\n"
							+ "where b.bookid = o.bookid\r\n"
							+ "group by b.bookname\r\n"
							+ "order by count(*) desc");
					
					// DB값 읽어오기
					while(rset.next()) {
						textArea2.append(rset.getString(1)+" "+rset.getInt(2) + "권 " +rset.getString(3)+"원\n");
					
					}
					rset.close();
					stmt.close();
					// 닫아주지 않으면 다른사람이 접근을 못함
					conn.close();
					
				}catch(Exception e1) {}
			}
		});
		bookBt2.setBounds(710, 191, 62, 18);
		contentPane.add(bookBt2);
		
		JTextArea textArea3 = new JTextArea();
		textArea3.setText("");
		textArea3.setBounds(577, 341, 200, 122);
		contentPane.add(textArea3);
		
		JButton cusBt2 = new JButton("검색");
		cusBt2.addActionListener(new ActionListener() {
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
					ResultSet rset = stmt.executeQuery("select name, count(*), sum(saleprice)\r\n"
							+ "from customer as c, orders as o\r\n"
							+ "where c.custid = o.custid\r\n"
							+ "group by name\r\n"
							+ "order by count(*) desc");
					
					// DB값 읽어오기
					while(rset.next()) {
						textArea3.append(rset.getString(1)+ " "+ rset.getInt(2)+"권 "+rset.getString(3)+"원\n");
							
					}
					rset.close();
					stmt.close();
					// 닫아주지 않으면 다른사람이 접근을 못함
					conn.close();
					
				}catch(Exception e1) {}
				
			}
		});
		cusBt2.setBounds(710, 316, 62, 18);
		contentPane.add(cusBt2);
		
		
		
		
		
		
		
		
	}
}
