import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// 그래프 대화상자
@SuppressWarnings("serial")
public class DataDialog extends JDialog{

	private JButton addBtn = new JButton("추가");
	private JButton updateBtn = new JButton("수정");
	private JButton closeBtn = new JButton("닫기");
	
	
	private static JTextField fname;
	private static JTextField fdate;
	private static JTextField fnppm;
	private static JTextField foppm;
	private static JTextField fcppm;
	private static JTextField fappm;
	private static JTextField fdust;
	private static JTextField fmdust;
	private JPanel pna = new JPanel();
	private JPanel pda = new JPanel();
	private JPanel pnp = new JPanel();
	private JPanel pop = new JPanel();
	private JPanel pcp = new JPanel();
	private JPanel pap = new JPanel();
	private JPanel pdu = new JPanel();
	private JPanel pmd = new JPanel();
	
	private JPanel left = new JPanel(new GridLayout(8,1));
	private JPanel right = new JPanel();
	
	private JLabel label;
	
	private JScrollPane jsp;
	private JTable resTable;
	private static DefaultTableModel model;
	
	public DataDialog(JFrame jframe, String title) {
		super(jframe, title);
		setSize(Constant.dial_W + 400, Constant.dial_H + 200);
		setLayout(new BorderLayout());
		
		fname = new JTextField(10);
		label = new JLabel("지      역 : ");
		pna.add(label);
		pna.add(fname);
		fdate = new JTextField(10);
		label = new JLabel("날      짜 : ");
		pda.add(label);
		pda.add(fdate);
		fnppm = new JTextField(10);
		label = new JLabel("이산화질소 : ");
		pnp.add(label);
		pnp.add(fnppm);
		foppm = new JTextField(10);
		label = new JLabel("오존  농도 : ");
		pop.add(label);
		pop.add(foppm);
		fcppm = new JTextField(10);
		label = new JLabel("이산화탄소 : ");
		pcp.add(label);
		pcp.add(fcppm);
		fappm = new JTextField(10);
		label = new JLabel("아황산가스 : ");
		pap.add(label);
		pap.add(fappm);
		fdust = new JTextField(10);
		label = new JLabel("미세먼지 : ");
		pdu.add(label);
		pdu.add(fdust);
		fmdust = new JTextField(10);
		label = new JLabel("초미세먼지 : ");
		pmd.add(label);
		pmd.add(fmdust);
		
		left.add(pna); left.add(pda); left.add(pnp); left.add(pop); left.add(pcp);
		left.add(pap); left.add(pdu); left.add(pmd);
		
		add(left, BorderLayout.WEST);
		
		
		// 버튼 및 입력 패널
		JPanel btnP = new JPanel();
		btnP.add(addBtn);
		btnP.add(updateBtn);
		btnP.add(closeBtn);
		add(btnP, BorderLayout.SOUTH);

		// 액션 리스너 - 람다식
		closeBtn.addActionListener(e -> setVisible(false));
		addBtn.addActionListener(e -> add());
		updateBtn.addActionListener(e -> update());
		
		
		// 테이블 모델 생성 & 테이블 생성
		model = new DefaultTableModel(Constant.header, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		this.model = Frame.model; // 현재화면의 테이블을 가져옵니다.
		resTable = new JTable(model);
		// 수정, 이동방지. 사이즈 조정
		resTable.getTableHeader().setReorderingAllowed(false);
		resTable.getTableHeader().setResizingAllowed(false);
		resTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		// 패널에 테이블 추가
		jsp = new JScrollPane(resTable);
		jsp.setPreferredSize(new Dimension(600,400));
		
		right.add(jsp);
		
		add(right, BorderLayout.EAST);
		
		
		
		
	}
	
	public static void add() {
		String name = fname.getText();
		String date = fdate.getText();
		String nppm = fnppm.getText();
		String oppm = foppm.getText();
		String cppm = fcppm.getText();
		String appm = fappm.getText();
		String dust = fdust.getText();
		String mdust = fmdust.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "지역명을 입력해야 합니다!");
			return;
		}
		if(date.equals("")) {
			JOptionPane.showMessageDialog(null, "날짜를 입력해야 합니다!");
			return;
		}
		if(nppm.equals("") || oppm.equals("") || cppm.equals("") ||
				appm.equals("") || dust.equals("") || mdust.equals("")) {
			JOptionPane.showMessageDialog(null, "수치를 모두 입력해야 합니다!");
			return;
		}

		String[] one = {name, date, nppm, oppm, cppm, appm, dust, mdust};
		model.addRow(one);
		
	}

	public static void update() {
		String name = fname.getText();
		String date = fdate.getText();
		String nppm = fnppm.getText();
		String oppm = foppm.getText();
		String cppm = fcppm.getText();
		String appm = fappm.getText();
		String dust = fdust.getText();
		String mdust = fmdust.getText();
		
		// name과 date가 일치하는 행을 찾기.
		int target;
		for (int i=0; i<model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 0)) && 
					date.equals(model.getValueAt(i, 1))) {
				target = i;
				// 데이터 수정 실행
				model.setValueAt(name, target, 0);
				model.setValueAt(date, target, 1);
				model.setValueAt(nppm, target, 2);
				model.setValueAt(oppm, target, 3);
				model.setValueAt(cppm, target, 4);
				model.setValueAt(appm, target, 5);
				model.setValueAt(dust, target, 6);
				model.setValueAt(mdust, target, 7);
				break;
			}
		}	
	}

	
}
