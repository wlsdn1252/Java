package OPENAPI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.awt.event.ActionEvent;

public class ApiSearch extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchText;
	
	String searchResult;
	
	// 공공데이터포텔에서 받은 url
	String userKey = "WdHqKDSztfeQkJWxjDg4qpZIM12DheaRb7oWrADah9QFzThtDXcRNsmmSmNQAdBob0DaWApIjJNFr0pNKYzlQg%3D%3D";
	String baseAddress = "https://api.odcloud.kr/api/15005906/v1/uddi:579e7f02-3a0a-4380-b9d5-ededf83b8238_201912121451?page=1&perPage=10&serviceKey=";
			
	String result = ""; // 결과물이 담길

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApiSearch frame = new ApiSearch();
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
	public ApiSearch() {
		
		
		setTitle("부산시 북구 착한업소 현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchText = new JTextField();
		searchText.setBounds(139, 42, 252, 33);
		contentPane.add(searchText);
		searchText.setColumns(10);
		
		JTextArea responseText = new JTextArea();
		responseText.setBounds(33, 106, 510, 347);
		contentPane.add(responseText);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResult = searchText.getText();
				try {
					URL url = new URL(baseAddress+userKey);
					
					BufferedReader bf; // 인테넷에서 스트림으로 들어오는 값들을 보관
					bf = new BufferedReader(  // 인터넷에서 날라오는 json파일을 한글로 변환.
							new InputStreamReader(url.openStream(), "UTF-8"));
					
					// 파일 끝까지 result에 넣는다.
					result = bf.readLine();
					System.out.println(result);
					
					JSONParser jp = new JSONParser();	// 전체 api를 들고온다.
					
					JSONObject jo = (JSONObject) jp.parse(result);	// 전체 api의 키와 벨류를 구분
					
					// (JSONArray)으로 형변환 시킨 data의 밸류를 담는다.
					JSONArray dataArray = (JSONArray) jo.get("data");		// 밸류안에 들어있는 배열을 구분
					
					// 배열안에있는 키와 벨류를 뽑기위한 오브젝
					JSONObject dataObject;
					
					
					// 데이터 어레이의 데이터가 남아있으면
					if(dataArray.size() > 0) {
						
						String[] a = new String[dataArray.size()];
						
						for(int i=0; i<dataArray.size(); i++) {	// dataArray의 사이즈만큼 돈다.
							dataObject = (JSONObject) dataArray.get(i); //(JSONObject)형으로 데이터어레이의 각각의 배열을 들고온다.
							
							responseText.append((String) dataObject.get("상호")+"\n");
							a[i] = (String) dataObject.get("상호");		
						}
						
						responseText.setText("");
						
						for(int i=0; i<a.length; i++) {
							if(a[i].contains(searchResult)) {
								responseText.append("");
								responseText.append(a[i] + "\n");
							}
							
					}
						
					}
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(417, 47, 97, 23);
		contentPane.add(button);
				
	}
}
