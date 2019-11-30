import java.awt.BorderLayout;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 그래프 대화상자
@SuppressWarnings("serial")
public class GraphDialog extends JDialog{

	private JButton closeBtn = new JButton("닫기");
	private JButton paintBtn = new JButton("그리기");
	
	private CircleGraph circle_graph = new CircleGraph();
	private LineGraph line_graph = new LineGraph();
	private BarGraph bar_graph = new BarGraph();
	
	private double num1, num2, num3, num4, num5, num6; // 오염물질들의 농도
	private int type; // 그래프의 종류를 결정. 0 : 원형, 1 : 꺽은선, 2 : 막대
	
	private LocalDate selectedLocalDate; // 선택된 특정한 한 날짜
	private String selectedItem; // 선택된 특정 오염물질
	
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
		
		// 대화창 사이즈 조절
		setSize(Constant.dial_W, Constant.dial_H);
		if (type == 2) {	// 막대그래프시
			setSize(Constant.dial_W + 1427, Constant.dial_H + 300);
		}
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
				
				// 기간 입력 & 지역 선택
				
				
				
				// 그리기 - 모든 오염물질
				

			} else {	// 막대 그래프이면
				// 날짜 선택
				String inputDate = JOptionPane.showInputDialog("날짜를 입력하세요. ex) 2018-01-06");
				// inputDate 유효성 검증
				try{
					LocalDate localDate = LocalDate.parse(inputDate);
					setDate(localDate);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(null, "잘못된 날짜입니다!", "입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 오염물질 선택(1개)
				String[] values = Constant.pollut;
				Object selected = JOptionPane.showInputDialog(null, "조회하고 싶은 오염물질을 하나 선택하세요.", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
				if ( selected != null ){ 
					setItem(selected.toString());			    
				}else{
				    JOptionPane.showMessageDialog(null, "item selection Error !!!", "Unknowun Error", JOptionPane.ERROR_MESSAGE);
				}
				
				// 그 날의 모든 지역의 오염물질을 막대그래프로 그린다.
				bar_graph.setDate(this.selectedLocalDate);
				bar_graph.setItem(this.selectedItem);
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

	public void setDate(LocalDate lo) {
		this.selectedLocalDate = lo;
		bar_graph.setDate(this.selectedLocalDate);
	}

	public void setItem(String item) {
		this.selectedItem = item;
		bar_graph.setItem(this.selectedItem);
	}
	
}
