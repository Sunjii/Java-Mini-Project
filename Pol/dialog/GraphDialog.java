import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// �׷��� ��ȭ����
public class GraphDialog extends JDialog{

	JButton closeBtn = new JButton("�ݱ�");
	JButton paintBtn = new JButton("�׸���");
	
	CircleGraph circle_graph = new CircleGraph();
	LineGraph line_graph = new LineGraph();
	
	int num1, num2, num3, num4, num5;
	int type; // �׷����� ������ ����. 0 : ����, 1 : ������, 2 : ����
	
	public GraphDialog(JFrame jframe, String title, int type) {
		super(jframe, title);
		this.type = type;
		setLayout(new BorderLayout());
		
		// ��ư �г�
		JPanel btnP = new JPanel();
		btnP.add(paintBtn);
		btnP.add(closeBtn);
		add(btnP, BorderLayout.SOUTH);
		add(circle_graph, BorderLayout.CENTER);
		
		setSize(Constant.dial_W, Constant.dial_H);
		
		// �׸��� ��ư ������
		paintBtn.addActionListener(e -> {
			if(type == 0) {	// �����׷����̸�,
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
				
				circle_graph.setName(area);
				circle_graph.setNumbers(num1, num2, num3, num4, num5);
				circle_graph.repaint();
			} else if(type == 1) {	// ������ �׷����̸�

			} else {	// ���� �׷����̸�
				
			}
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
