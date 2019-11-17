import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphDialog extends JDialog{

	JButton closeBtn = new JButton("�ݱ�");
	JButton paintBtn = new JButton("�׸���");
	
	CircleGraph graph = new CircleGraph();
	
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
			graph.setNumbers(10, 20, 30);
			graph.repaint();
		});
		
		// �ݱ� ��ư ������
		closeBtn.addActionListener(e -> setVisible(false));
		
	}
	
}