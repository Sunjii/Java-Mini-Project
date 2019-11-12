import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Frame extends JFrame implements ActionListener{
	
	ImageIcon test = new ImageIcon("image.jpg");
	
	//Container contentPane;
	
	
	public Frame() {
		setTitle("POL Project");
		setSize(800, 800);
		setLayout(new BorderLayout());
		menu();
		
		//contentPane = getContentPane();
		//toolbar();
		mainLayout();
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
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("DB 불러오기");
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("CSV 파일 불러오기");
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("CSV 파일 저장하기");
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem("종료");
		item.addActionListener(this);
		file.add(item);
		mb.add(file);
		// 2. 그래프
		JMenu graph = new JMenu("그래프");
		// 2. Items
		
		mb.add(graph);
		// 3. 통계
		JMenu statics = new JMenu("통계");
		// 3. Items
		
		mb.add(statics);
		// 4. 설정
		JMenu option = new JMenu("옵션");
		// 4. Items
		
		mb.add(option);
		// 5.
		
		
		
		/*
		JMenu subj = new JMenu("과목");
		JMenu ratio = new JMenu("비율");
		JMenu stu_manage = new JMenu("학생관리");
		JMenu score_manage = new JMenu("성적관리");
		JMenu statics = new JMenu("통계");
		JMenu graph = new JMenu("그래프");
		*/
		

		setJMenuBar(mb);
		
		
		
	}
	
	
	// 툴바 구성
	void toolbar() {
		JToolBar tb = new JToolBar("툴바", JToolBar.HORIZONTAL);

		tb.setBackground(Color.red);
		
		tb.add(new JButton(new ImageIcon("new.jpg")));
		tb.setFloatable(false);
		
		add(tb);
		//contentPane.add(tb,BorderLayout.NORTH);
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
		JLabel map = new JLabel(test);
		map.setBounds(0,50, test.getIconWidth(), test.getIconHeight());
		p2.add(map);
		
		
		
		
		
		/// p3 :: 데이터 출력 할 곳
		JPanel p3 = new JPanel();
		// 텍스트 에어리어
		JTextArea result = new JTextArea(5, 20);
		p3.add(result);
		
		
		
		
		// 메인에 패널들 추가
		add(p1, BorderLayout.NORTH); add(p2, BorderLayout.CENTER); add(p3, BorderLayout.SOUTH);
		
		
		
	}
	
	


	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem) (e.getSource());

		switch (mi.getText()) {

		case "DB 저장":
			break;
		case "DB 불러오기":
			break;
		case "CSV 파일 불러오기":
			break;
		case "CSV 파일 저장하기":
			break;
		
		case "종료":
			System.exit(0);
			break;
			
		}
		
	}
	
	
	

}
