import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

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
import javax.swing.table.DefaultTableModel;

public class Frame extends JFrame {
	
	ImageIcon test = new ImageIcon("image.jpg");
	
	static CSVLoad csvL = new CSVLoad();
	static CSVWrite csvW = new CSVWrite();
	
	private static boolean isOpen; // 데이터가 들어왔는지 확인하는 변수
	
	//static String data[][] = {};
	//static List<Object> data = new ArrayList<Object>();
	static ArrayList<String[]> data = new ArrayList<String[]>();
	static String[][] arr = new String[13000][8];

	JPanel top_area = new JPanel(new BorderLayout());	// 상단에 위치하는 툴바&컴포넌트 자리
	JPanel main_area = new JPanel(new BorderLayout());	// 메인
	
	MenuActionListener mal = new MenuActionListener();
	ButtonActionListener bal = new ButtonActionListener();
	
	
	static JScrollPane jsp;
	static JTable resTable;
	static DefaultTableModel model;
	Vector<String> dataRow;
	
	static GraphDialog cgDialog;	// 원형그래프 대화창
	static GraphDialog lgDialog;	// 선형그래프 대화창
	static GraphDialog bgDialog;	// 막대그래프
	static DataDialog tbDialog;		// 데이터 수정
	static TextDialog txDialog;		// 기타 정보 대화창
	
	static JTextField inputDate = new JTextField("ex) 2018-01-01", 8);

	
	
	public Frame() {
		setTitle("POL Project");
		setSize(1000, 1000);
		setLayout(new BorderLayout());
		menu();
		toolbar();
		mainLayout();
		add(top_area, BorderLayout.NORTH);
		add(main_area, BorderLayout.CENTER);
		
		cgDialog = new GraphDialog(this, "원형그래프", 0);
		lgDialog = new GraphDialog(this, "꺽은선그래프", 1);
		bgDialog = new GraphDialog(this, "막대그래프", 2);
		tbDialog = new DataDialog(this, "데이터");
		txDialog = new TextDialog(this, "오염물질 권고기준");
		
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
		item = new JMenuItem("원형 그래프");
		item.addActionListener(mal);
		graph.add(item);
		item = new JMenuItem("꺽은선 그래프");
		item.addActionListener(mal);
		graph.add(item);
		item = new JMenuItem("막대 그래프");
		item.addActionListener(mal);
		graph.add(item);
		
		mb.add(graph);
		
		// 3. 통계
		JMenu statics = new JMenu("통계");
		// 3. Items
		item = new JMenuItem("특정 기간 동안의 통계량 조회");
		item.addActionListener(mal);
		statics.add(item);
		item = new JMenuItem("특정 지역의 통계량 조회");
		item.addActionListener(mal);
		statics.add(item);

		mb.add(statics);
		
		// 4. 데이터 관련 메뉴
		JMenu data = new JMenu("데이터");
		// 4. Items
		item = new JMenuItem("데이터 추가 및 수정");
		item.addActionListener(mal);
		data.add(item);
		item = new JMenuItem("오염물질 권고기준");
		item.addActionListener(mal);
		data.add(item);
		
		mb.add(data);
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
		item = new JButton("DBLoad");
		item.addActionListener(bal);
		tb.add(item);
		item = new JButton("DBSave");
		item.addActionListener(bal);
		tb.add(item);
		tb.addSeparator();
		item = new JButton("Graph 1");
		item.addActionListener(bal);
		tb.add(item);
		item = new JButton("Graph 2");
		item.addActionListener(bal);
		tb.add(item);
		item = new JButton("Graph 3");
		item.addActionListener(bal);
		tb.add(item);
		tb.addSeparator();
		item = new JButton("Data");
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
		JComboBox locations = new JComboBox(Constant.locations);
		p1.add(locations);
		// 레이블 1
		JLabel inputDate_ex = new JLabel("날짜입력 ");
		p1.add(inputDate_ex);
		// 날짜 입력 텍스트필드
		//JTextField inputDate = new JTextField("ex) 20180101", 8);
		// 텍스트필드 클릭시 초기 입력 삭제
		inputDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				inputDate.setText("");
			}
			
		});
		p1.add(inputDate);
		// 확인 버튼
		JButton send = new JButton("검색");
		send.addActionListener(bal);
		p1.add(send);
		
		
		/// p2 :: 서울시 지도 그림 들어갈 곳
		JPanel p2 = new JPanel();
		JLabel map = new JLabel("test - 그림 들어갈 곳");
		//map.setBounds(0,50, test.getIconWidth(), test.getIconHeight());
		p2.add(map);
		
		
		
		
		/// p3 :: 데이터 출력 할 곳
		JPanel p3 = new JPanel();
		// JTable
		
		/*
		// 데모용 데이터
		String header[] = {"지역", "날짜", Constant.pollut[0], Constant.pollut[1], Constant.pollut[2], Constant.pollut[3], Constant.pollut[4], Constant.pollut[5] };
		String data[][] = {
				{"강남", "2018-01-01", "0.033", "0.01", "0.6", "0.006", "34", "22"},
				{"강북", "2018-01-01", "0.026", "0.018", "0.6", "0.004", "38", "18"},
				{"용산", "2018-01-01", "0.036", "0.012", "0.7", "0.004", "22", "13"},
				{"강남", "2018-01-02", "0.051", "0.005", "0.7", "0.005", "40", "24"},
				{"강북", "2018-01-02", "0.045", "0.008", "0.8", "0.003", "47", "21"},
				{"용산", "2018-01-02", "0.029", "0.016", "0.6", "0.007", "34", "17"}
		};
		*/
		
		//String header[] = {"지역", "날짜", Constant.pollut[0], Constant.pollut[1], Constant.pollut[2], Constant.pollut[3], Constant.pollut[4], Constant.pollut[5] };
		//resTable = new JTable(data, header);
		//csvL.getlocations();
		
		
		
		// 테이블 생성
		//resTable = new JTable(data, header);
		//String[] arr = data.toArray(new String[data.size()]);
		/*
		String[][] arr = new String[101][9];
		for(int i=0; i< 100; i++) {
			for(int j=0; j<8; j++) {
				arr[i][j] = (String) data.get(j);
			}
		}
		*/
		
		
		

		//resTable = new JTable(arr, Constant.header);
		//redrawTable(arr);
		//JScrollPane scroll = new JScrollPane(resTable);
		//p3.add(scroll);	

		
		// 테이블 모델 생성 & 테이블 생성
		model = new DefaultTableModel(Constant.header, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		resTable = new JTable(model);
		// 수정, 이동방지. 사이즈 조정
		resTable.getTableHeader().setReorderingAllowed(false);
		resTable.getTableHeader().setResizingAllowed(false);
		resTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		// 테이블 헤더 클릭시 정렬
		resTable.setAutoCreateRowSorter(true);
		// 패널에 테이블 추가
		jsp = new JScrollPane(resTable);
		jsp.setPreferredSize(new Dimension(600,400));
		p3.add(jsp);
		resTable.updateUI();
		
		
		// 메인에 패널들 추가
		top_area.add(p1, BorderLayout.CENTER); 
		
		main_area.add(p2, BorderLayout.NORTH); 
		main_area.add(p3, BorderLayout.SOUTH);
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void insertTable(ArrayList<Location> arrayList, DefaultTableModel mod) {
		for(int i=0; i<arrayList.size(); i++) {
			Location location = arrayList.get(i);
			String name = location.getName();
			LocalDate date = location.getDate();
			Stat stat = location.getStat();
			
			String[] one = {name, date.toString(), Double.toString(stat.nppm),
					Double.toString(stat.oppm), Double.toString(stat.cppm), Double.toString(stat.appm),
					Double.toString(stat.dust), Double.toString(stat.mdust)
			};
			
			/*
			data.add(name);
			data.add(date.toString());
			data.add(Double.toString(stat.nppm));
			data.add(Double.toString(stat.oppm));
			data.add(Double.toString(stat.cppm));
			data.add(Double.toString(stat.appm));
			data.add(Double.toString(stat.dust));
			data.add(Double.toString(stat.mdust));
			*/
			//System.out.println(name + " " + date.toString() + " " + Double.toString(stat.dust));
			//data.add(one);
			//model.addRow(one);
			mod.addRow(one);
			
		}
	}
	
	
	
	
	public static void makeTable(ArrayList<String[]> input) {
		//String[][] array = new String[13000][8];
		// 배열 초기화
		//resetTable(arr);
		
		// input으로 String[][] 에 입력
		for(int i=0; i</*data*/input.size(); i++) {
			for(int j=0; j<8; j++) {
				arr[i][j]/*array[i][j]*/ = /*data*/input.get(i)[j];
			}
		}
		//return array;
	}
	
	
	public static void redrawTable(String[][] ar) {
		resTable = new JTable(ar, Constant.header);
	}
	
	public static void resetTable(String[][] table) {
		for(int i=0; i<13000; i++) {
			for(int j=0; j<8; j++) {
				table[i][j] = ""; // 이게 아니라 아예 삭제해야됨.. 포인터를 감소
			}
		}
		
	}

	// data를 불러왔으면 isOpen = true 한다.
	public static void setOpen(boolean tf) {
		if (tf){
			isOpen = true;
		} else {
			isOpen = false;
		}
	}
	
	public static boolean getOpen() {
		return isOpen;
	}
	
	

}
