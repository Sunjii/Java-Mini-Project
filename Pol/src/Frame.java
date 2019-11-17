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

	JPanel top_area = new JPanel(new BorderLayout());	// ��ܿ� ��ġ�ϴ� ����&������Ʈ �ڸ�
	JPanel main_area = new JPanel(new BorderLayout());	// ����
	
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
		item = new JMenuItem("������ ��ȸ");
		item.addActionListener(mal);
		graph.add(item);
		item = new JMenuItem("�Ⱓ�� ��ȸ");
		item.addActionListener(mal);
		graph.add(item);
		
		mb.add(graph);
		
		// 3. ���
		JMenu statics = new JMenu("���");
		// 3. Items
		item = new JMenuItem("UC");
		item.addActionListener(mal);
		statics.add(item);

		mb.add(statics);
		
		// 4. ����
		JMenu option = new JMenu("����");
		// 4. Items
		
		mb.add(option);
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
		item = new JButton("Graph 1");
		item.addActionListener(bal);
		tb.add(item);
		item = new JButton("Graph 2");
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
		String [] location = {"��ü", "����", "����", "���"};
		JComboBox locations = new JComboBox(location);
		p1.add(locations);
		// ���̺� 1
		JLabel inputDate_ex = new JLabel("��¥�Է� ");
		p1.add(inputDate_ex);
		// ��¥ �Է� �ؽ�Ʈ�ʵ�
		JTextField inputDate = new JTextField("ex) 20180101", 8);
		// �ؽ�Ʈ�ʵ� Ŭ���� �ʱ� �Է� ����
		inputDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				inputDate.setText("");
			}
			
		});
		p1.add(inputDate);
		// Ȯ�� ��ư
		JButton send = new JButton("Ȯ��");
		p1.add(send);
		
		
		/// p2 :: ����� ���� �׸� �� ��
		JPanel p2 = new JPanel();
		JLabel map = new JLabel("test - �׸� �� ��");
		//map.setBounds(0,50, test.getIconWidth(), test.getIconHeight());
		p2.add(map);
		
		
		
		
		
		/// p3 :: ������ ��� �� ��
		JPanel p3 = new JPanel();
		// JTable
		// ����� ������
		String header[] = {"����", Constant.pollut_0, Constant.pollut_1, Constant.pollut_2};
		String data[][] = {
				{"����", "10", "20", "30"},
				{"����", "22", "12", "43"},
				{"���", "8", "47", "21"}
		};
		// ���̺� ����
		JTable result = new JTable(data, header);
		JScrollPane scroll = new JScrollPane(result);
		p3.add(scroll);	
		
		
		// ���ο� �гε� �߰�
		top_area.add(p1, BorderLayout.CENTER); 
		
		main_area.add(p2, BorderLayout.NORTH); 
		main_area.add(p3, BorderLayout.SOUTH);
		
		
		
	}
	
	

}
