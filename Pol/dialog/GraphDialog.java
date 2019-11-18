import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GraphDialog extends JDialog{

	JButton closeBtn = new JButton("�ݱ�");
	JButton paintBtn = new JButton("�׸���");
	
	CircleGraph graph = new CircleGraph();
	
	int num1, num2, num3, num4, num5;
	
	public GraphDialog(JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		
		// ��ư �г�
		JPanel btnP = new JPanel();
		btnP.add(paintBtn);
		btnP.add(closeBtn);
		add(btnP, BorderLayout.SOUTH);
		add(graph, BorderLayout.CENTER);
		
		setSize(Constant.dial_W, Constant.dial_H);
		
		// �׸��� ��ư ������
		paintBtn.addActionListener(e -> {
			if(Frame.resTable.getSelectedRowCount() != 1) {
				JOptionPane.showMessageDialog(null, "���� �׷����� �ϳ��� Į���� �׸� �� �ֽ��ϴ�.");
				return;
			}
			int row = Frame.resTable.getSelectedRow();
			int col = Frame.resTable.getSelectedColumn();
			
			String area = (String) Frame.resTable.getValueAt(row, 0);
			int pol1 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 2)));
			int pol2 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 3)));
			int pol3 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 4)));
			int pol4 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 5)));
			int pol5 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 6)));
			Frame.cgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5);
			
			graph.setName(area);
			graph.setNumbers(num1, num2, num3, num4, num5);
			graph.repaint();
		});
		
		// �ݱ� ��ư ������
		closeBtn.addActionListener(e -> setVisible(false));
		
	}
	
	public void setNumbers(int num1, int num2, int num3, int num4, int num5) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
	}
	
}
