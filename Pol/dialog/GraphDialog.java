import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 그래프 대화상자
public class GraphDialog extends JDialog{

	JButton closeBtn = new JButton("닫기");
	JButton paintBtn = new JButton("그리기");
	
	CircleGraph circle_graph = new CircleGraph();
	LineGraph line_graph = new LineGraph();
	BarGraph bar_graph = new BarGraph();
	
	double num1, num2, num3, num4, num5, num6;
	int type; // 그래프의 종류를 결정. 0 : 원형, 1 : 꺽은선, 2 : 막대
	
	public GraphDialog(JFrame jframe, String title, int type) {
		super(jframe, title);
		this.type = type;
		setLayout(new BorderLayout());
		
		// 버튼 패널
		JPanel btnP = new JPanel();
		btnP.add(paintBtn);
		btnP.add(closeBtn);
		add(btnP, BorderLayout.SOUTH);
		switch (type) {	// 그래프 종류 설정
		case 0:
			add(circle_graph, BorderLayout.CENTER);
			break;
		case 1:
			add(line_graph, BorderLayout.CENTER);
			break;
		case 2:
			add(bar_graph, BorderLayout.CENTER);
			break;
		}

		setSize(Constant.dial_W, Constant.dial_H + 100);

		// 그리기 버튼 리스너
		paintBtn.addActionListener(e -> {
			if(type == 0) {	// 원형그래프이면,
				if(Frame.resTable.getSelectedRowCount() != 1) {
					JOptionPane.showMessageDialog(null, "원형 그래프는 하나의 칼럼만 그릴 수 있습니다.");
					return;
				}
			
				
				int row = Frame.resTable.getSelectedRow();
				int col = Frame.resTable.getSelectedColumn();
				
				String area = (String) Frame.resTable.getValueAt(row, 0);
				double pol1 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 2)));
				double pol2 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 3)));
				double pol3 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 4)));
				double pol4 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 5)));
				double pol5 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 6)));
				double pol6 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 7)));
				Frame.cgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5, pol6);
				
				circle_graph.setName(area);
				circle_graph.setNumbers(num1, num2, num3, num4, num5, num6);
				circle_graph.repaint();
			} else if(type == 1) {	// 꺽은선 그래프이면

			} else {	// 막대 그래프이면
				System.out.println("막대");
				if(Frame.resTable.getSelectedRowCount() != 1) {
					JOptionPane.showMessageDialog(null, "원형 그래프는 하나의 칼럼만 그릴 수 있습니다.");
					return;
				}
			
				
				int row = Frame.resTable.getSelectedRow();
				int col = Frame.resTable.getSelectedColumn();
				
				String area = (String) Frame.resTable.getValueAt(row, 0);
				double pol1 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 2)));
				double pol2 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 3)));
				double pol3 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 4)));
				double pol4 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 5)));
				double pol5 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 6)));
				double pol6 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 7)));
				Frame.bgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5, pol6);
				
				bar_graph.setName(area);
				bar_graph.setNumbers(num1, num2, num3, num4, num5, num6);
				bar_graph.repaint();
				
			}
		});
		
		// 닫기 버튼 리스너
		closeBtn.addActionListener(e -> setVisible(false));
		
	}
	
	public void setNumbers(double pol1, double pol2, double pol3, double pol4, double pol5, double pol6) {
		this.num1 = pol1;
		this.num2 = pol2;
		this.num3 = pol3;
		this.num4 = pol4;
		this.num5 = pol5;
		this.num6 = pol6;
	}
	
}
