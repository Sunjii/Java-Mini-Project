import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphDialog extends JDialog{

	JButton closeBtn = new JButton("닫기");
	JButton paintBtn = new JButton("그리기");
	
	CircleGraph graph = new CircleGraph();
	
	int num1, num2, num3;
	
	public GraphDialog(JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		
		// 버튼 패널
		JPanel btnP = new JPanel();
		btnP.add(paintBtn);
		btnP.add(closeBtn);
		add(btnP, BorderLayout.SOUTH);
		add(graph, BorderLayout.CENTER);
		
		setSize(Constant.dial_W, Constant.dial_H);
		
		// 그리기 버튼 리스너
		paintBtn.addActionListener(e -> {
			//graph.setNumbers(10, 20, 30);
			
			graph.setNumbers(num1, num2, num3);
			graph.repaint();
		});
		
		// 닫기 버튼 리스너
		closeBtn.addActionListener(e -> setVisible(false));
		
	}
	
	public void setNumbers(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	
}
