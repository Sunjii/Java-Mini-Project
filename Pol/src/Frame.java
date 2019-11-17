import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Frame extends JFrame {
	
	ImageIcon test = new ImageIcon("image.jpg");

	JPanel top_area = new JPanel(new BorderLayout());	// 상단에 위치하는 툴바&컴포넌트 자리
	JPanel main_area = new JPanel(new BorderLayout());	// 메인
	
	MenuActionListener mal = new MenuActionListener();
	ButtonActionListener bal = new ButtonActionListener();
	
	public Frame() {
		setTitle("POL Project");
		setSize(800, 800);
		setLayout(new BorderLayout());
		menu();
		toolbar();
		mainLayout();
		add(top_area, BorderLayout.NORTH);
		add(main_area, BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	}
	
	// 메뉴바 구성
	void menu() {
		JMenuItem item;
		JMenuBar mb = new JMenuBar();
		// 메뉴 구성
		
		// 1. 파일
		JMenu file = new JMenu("파일");
		// 1. Items
		item = new JMenuItem("DB 저장");
		item.addActionListener(mal);
		file.add(item);
		item = new JMenuItem("DB 불러오기");
		item.addActionListener(mal);
		file.add(item);
		item = new JMenuItem("CSV 파일 불러오기");
		item.addActionListener(mal);
		file.add(item);
		item = new JMenuItem("CSV 파일 저장하기");
		item.addActionListener(mal);
		file.add(item);
		file.addSeparator();
		item = new JMenuItem("종료");
		item.addActionListener(mal);
		file.add(item);
		mb.add(file);
		
		// 2. 그래프
		JMenu graph = new JMenu("그래프");
		// 2. Items
		item = new JMenuItem("지역별 조회");
		item.addActionListener(mal);
		graph.add(item);
		item = new JMenuItem("기간별 조회");
		item.addActionListener(mal);
		graph.add(item);
		
		mb.add(graph);
		
		// 3. 통계
		JMenu statics = new JMenu("통계");
		// 3. Items
		item = new JMenuItem("UC");
		item.addActionListener(mal);
		statics.add(item);

		mb.add(statics);
		
		// 4. 설정
		JMenu option = new JMenu("설정");
		// 4. Items
		
		mb.add(option);
		// 5.
		
		

		setJMenuBar(mb);
		
		
		
	}
	
	
	// 툴바 구성
	void toolbar() {
		JToolBar tb = new JToolBar("Toolbar");
		tb.setBackground(Color.gray);
		JButton item;
		item = new JButton("Open");
		item.addActionListener(bal);
		tb.add(item);
		item = new JButton("Save");
		item.addActionListener(bal);
		tb.add(item);
		tb.addSeparator();
		item = new JButton("Graph 1");
		item.addActionListener(bal);
		tb.add(item);
		item = new JButton("Graph 2");
		item.addActionListener(bal);
		tb.add(item);
		tb.addSeparator();
		item = new JButton("종료");
		item.addActionListener(bal);
		tb.add(item);
	
		
		tb.setFloatable(false);
		
		top_area.add(tb, BorderLayout.NORTH);
	}
	
	
	
	// 메인화면 레이아웃
	void mainLayout() {	
		setLayout(new BorderLayout(10,50));
		
		
		/// p1  ::
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		// 지역 콤보박스
		String [] location = {"전체", "강남", "강북", "용산"};
		JComboBox locations = new JComboBox(location);
		p1.add(locations);
		// 레이블 1
		JLabel inputDate_ex = new JLabel("날짜입력 ");
		p1.add(inputDate_ex);
		// 날짜 입력 텍스트필드
		JTextField inputDate = new JTextField("ex) 20180101", 8);
		// 텍스트필드 클릭시 초기 입력 삭제
		inputDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				inputDate.setText("");
			}
			
		});
		p1.add(inputDate);
		// 확인 버튼
		JButton send = new JButton("확인");
		p1.add(send);
		
		
		/// p2 :: 서울시 지도 그림 들어갈 곳
		JPanel p2 = new JPanel();
		JLabel map = new JLabel("test - 그림 들어갈 곳");
		//map.setBounds(0,50, test.getIconWidth(), test.getIconHeight());
		p2.add(map);
		
		
		
		
		
		/// p3 :: 데이터 출력 할 곳
		JPanel p3 = new JPanel();
		// JTable
		// 데모용 데이터
		String header[] = {"지역", Constant.pollut_0, Constant.pollut_1, Constant.pollut_2};
		String data[][] = {
				{"강남", "10", "20", "30"},
				{"강북", "22", "12", "43"},
				{"용산", "8", "47", "21"}
		};
		// 테이블 생성
		JTable result = new JTable(data, header);
		JScrollPane scroll = new JScrollPane(result);
		p3.add(scroll);	
		
		
		// 메인에 패널들 추가
		top_area.add(p1, BorderLayout.CENTER); 
		
		main_area.add(p2, BorderLayout.NORTH); 
		main_area.add(p3, BorderLayout.SOUTH);
		
		
		
	}
	
	

}
