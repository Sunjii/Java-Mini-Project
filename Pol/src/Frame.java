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
	
	private static boolean isOpen; // �����Ͱ� ���Դ��� Ȯ���ϴ� ����
	
	//static String data[][] = {};
	//static List<Object> data = new ArrayList<Object>();
	static ArrayList<String[]> data = new ArrayList<String[]>();
	static String[][] arr = new String[13000][8];

	JPanel top_area = new JPanel(new BorderLayout());	// ��ܿ� ��ġ�ϴ� ����&������Ʈ �ڸ�
	JPanel main_area = new JPanel(new BorderLayout());	// ����
	
	MenuActionListener mal = new MenuActionListener();
	ButtonActionListener bal = new ButtonActionListener();
	
	
	static JScrollPane jsp;
	static JTable resTable;
	static DefaultTableModel model;
	Vector<String> dataRow;
	
	static GraphDialog cgDialog;	// �����׷��� ��ȭâ
	static GraphDialog lgDialog;	// �����׷��� ��ȭâ
	static GraphDialog bgDialog;	// ����׷���
	static DataDialog tbDialog;		// ������ ����
	static TextDialog txDialog;		// ��Ÿ ���� ��ȭâ
	
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
		
		cgDialog = new GraphDialog(this, "�����׷���", 0);
		lgDialog = new GraphDialog(this, "�������׷���", 1);
		bgDialog = new GraphDialog(this, "����׷���", 2);
		tbDialog = new DataDialog(this, "������");
		txDialog = new TextDialog(this, "�������� �ǰ����");
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	}
	
	// �޴��� ����
	void menu() {
		JMenuItem item;
		JMenuBar mb = new JMenuBar();
		// �޴� ����
		
		// 1. ����
		JMenu file = new JMenu("����");
		// 1. Items
		item = new JMenuItem("DB ����");
		item.addActionListener(mal);
		file.add(item);
		item = new JMenuItem("DB �ҷ�����");
		item.addActionListener(mal);
		file.add(item);
		item = new JMenuItem("CSV ���� �ҷ�����");
		item.addActionListener(mal);
		file.add(item);
		item = new JMenuItem("CSV ���� �����ϱ�");
		item.addActionListener(mal);
		file.add(item);
		file.addSeparator();
		item = new JMenuItem("����");
		item.addActionListener(mal);
		file.add(item);
		mb.add(file);
		
		// 2. �׷���
		JMenu graph = new JMenu("�׷���");
		// 2. Items
		item = new JMenuItem("���� �׷���");
		item.addActionListener(mal);
		graph.add(item);
		item = new JMenuItem("������ �׷���");
		item.addActionListener(mal);
		graph.add(item);
		item = new JMenuItem("���� �׷���");
		item.addActionListener(mal);
		graph.add(item);
		
		mb.add(graph);
		
		// 3. ���
		JMenu statics = new JMenu("���");
		// 3. Items
		item = new JMenuItem("Ư�� �Ⱓ ������ ��跮 ��ȸ");
		item.addActionListener(mal);
		statics.add(item);
		item = new JMenuItem("Ư�� ������ ��跮 ��ȸ");
		item.addActionListener(mal);
		statics.add(item);

		mb.add(statics);
		
		// 4. ������ ���� �޴�
		JMenu data = new JMenu("������");
		// 4. Items
		item = new JMenuItem("������ �߰� �� ����");
		item.addActionListener(mal);
		data.add(item);
		item = new JMenuItem("�������� �ǰ����");
		item.addActionListener(mal);
		data.add(item);
		
		mb.add(data);
		// 5.
		
		

		setJMenuBar(mb);
		
		
		
	}
	
	
	// ���� ����
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
		item = new JButton("����");
		item.addActionListener(bal);
		tb.add(item);
	
		
		tb.setFloatable(false);
		
		top_area.add(tb, BorderLayout.NORTH);
	}
	
	
	
	// ����ȭ�� ���̾ƿ�
	void mainLayout() {	
		setLayout(new BorderLayout(10,50));
		
		
		/// p1  ::
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		// ���� �޺��ڽ�
		JComboBox locations = new JComboBox(Constant.locations);
		p1.add(locations);
		// ���̺� 1
		JLabel inputDate_ex = new JLabel("��¥�Է� ");
		p1.add(inputDate_ex);
		// ��¥ �Է� �ؽ�Ʈ�ʵ�
		//JTextField inputDate = new JTextField("ex) 20180101", 8);
		// �ؽ�Ʈ�ʵ� Ŭ���� �ʱ� �Է� ����
		inputDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				inputDate.setText("");
			}
			
		});
		p1.add(inputDate);
		// Ȯ�� ��ư
		JButton send = new JButton("�˻�");
		send.addActionListener(bal);
		p1.add(send);
		
		
		/// p2 :: ����� ���� �׸� �� ��
		JPanel p2 = new JPanel();
		JLabel map = new JLabel("test - �׸� �� ��");
		//map.setBounds(0,50, test.getIconWidth(), test.getIconHeight());
		p2.add(map);
		
		
		
		
		/// p3 :: ������ ��� �� ��
		JPanel p3 = new JPanel();
		// JTable
		
		/*
		// ����� ������
		String header[] = {"����", "��¥", Constant.pollut[0], Constant.pollut[1], Constant.pollut[2], Constant.pollut[3], Constant.pollut[4], Constant.pollut[5] };
		String data[][] = {
				{"����", "2018-01-01", "0.033", "0.01", "0.6", "0.006", "34", "22"},
				{"����", "2018-01-01", "0.026", "0.018", "0.6", "0.004", "38", "18"},
				{"���", "2018-01-01", "0.036", "0.012", "0.7", "0.004", "22", "13"},
				{"����", "2018-01-02", "0.051", "0.005", "0.7", "0.005", "40", "24"},
				{"����", "2018-01-02", "0.045", "0.008", "0.8", "0.003", "47", "21"},
				{"���", "2018-01-02", "0.029", "0.016", "0.6", "0.007", "34", "17"}
		};
		*/
		
		//String header[] = {"����", "��¥", Constant.pollut[0], Constant.pollut[1], Constant.pollut[2], Constant.pollut[3], Constant.pollut[4], Constant.pollut[5] };
		//resTable = new JTable(data, header);
		//csvL.getlocations();
		
		
		
		// ���̺� ����
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

		
		// ���̺� �� ���� & ���̺� ����
		model = new DefaultTableModel(Constant.header, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		resTable = new JTable(model);
		// ����, �̵�����. ������ ����
		resTable.getTableHeader().setReorderingAllowed(false);
		resTable.getTableHeader().setResizingAllowed(false);
		resTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		// ���̺� ��� Ŭ���� ����
		resTable.setAutoCreateRowSorter(true);
		// �гο� ���̺� �߰�
		jsp = new JScrollPane(resTable);
		jsp.setPreferredSize(new Dimension(600,400));
		p3.add(jsp);
		resTable.updateUI();
		
		
		// ���ο� �гε� �߰�
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
		// �迭 �ʱ�ȭ
		//resetTable(arr);
		
		// input���� String[][] �� �Է�
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
				table[i][j] = ""; // �̰� �ƴ϶� �ƿ� �����ؾߵ�.. �����͸� ����
			}
		}
		
	}

	// data�� �ҷ������� isOpen = true �Ѵ�.
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
