import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StaticsDialog extends JDialog {

	private JButton closeBtn = new JButton("닫기");
	private JButton paintBtn = new JButton("불러오기");
	
	private PeriodPanel period_panel = new PeriodPanel();
	private LocationPanel location_panel = new LocationPanel();
	
	private LocalDate dateS, dateE;
	//private LocalDate dateS = LocalDate.now();
	//private LocalDate dateE = LocalDate.now();
	private int dateLength;
	private int type;
	
	
	
	
	public StaticsDialog(JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		setSize(Constant.dial_W, Constant.dial_H);
		
		// 타이틀
		JPanel textP = new JPanel();
		
		JLabel titleLabel = new JLabel("통 계 정 보");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
		titleLabel.setForeground(new Color(102, 153, 153));
		titleLabel.setVerticalAlignment(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textP.add(titleLabel);
		// 버튼 패널
		JPanel btnP = new JPanel();
		
		btnP.add(paintBtn);
		btnP.add(closeBtn);
		
		
		switch (type) {
		case 0:	// 특정 기간 통계량 조회
			add(period_panel, BorderLayout.CENTER);
			break;
		case 1:	// 특정 지역 통계량 조회
			add(location_panel, BorderLayout.CENTER);
			break;
			
			
		}
		
		paintBtn.addActionListener(e -> {
			if(type == 0) {	// 모든 지역에서 선택한 기간동안의 통계량을 제공한다.
				LocalDate start = LocalDate.of(2018, 1, 1);
				LocalDate end = LocalDate.of(2018, 12, 31);
				if(Frame.getOpen()) {
					try{
						start = LocalDate.parse(JOptionPane.showInputDialog("시작하는 날짜를 입력하세요. ex) 2018-01-06"));
						end = LocalDate.parse(JOptionPane.showInputDialog("끝나는 날짜를 입력하세요. ex) 2018-01-16"));
						//setDate(start, end);
					} catch(Exception err) {
						JOptionPane.showMessageDialog(null, "잘못된 날짜입니다!", "입력오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "먼저 데이터를 불러와야합니다!");
					//setDate(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 31));
				}
				
				period_panel.setDate(start, end);
				period_panel.repaint();
				
				
			} else {	// 선택된 지역의 통계량을 제공한다.
				
				
				
			}
			
			
			
			
			
			
		});
		
		
		
		
		
		/*
		if(Frame.getOpen()) {
			try{
				LocalDate start = LocalDate.parse(JOptionPane.showInputDialog("시작하는 날짜를 입력하세요. ex) 2018-01-06"));
				LocalDate end = LocalDate.parse(JOptionPane.showInputDialog("끝나는 날짜를 입력하세요. ex) 2018-01-16"));
				//System.out.println(start.toString() + end.toString());
				//Frame.stDialog.setDate(start, end);
				//Frame.stDialog.setType(0);
				setDate(start, end);
			} catch(Exception err) {
				JOptionPane.showMessageDialog(null, "잘못된 날짜입니다!", "입력오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else {
			setDate(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 31));
		}
		*/
	
		// 내용
		
		// 기간 계산
		//Period period = Period.between(dateS, dateE);
		//dateLength = period.getDays();
		//dateLength++; // +1 해야 dateE 까지 나옴
		
		/*
		JPanel contentP = new JPanel();
		
		JPanel stat1 = new JPanel();
		JPanel stat2 = new JPanel();
		String s1, s2;
		
		//System.out.println(dateS.toString() + dateE.toString());
		System.out.println(dateS);	// nullpointer 오류...
		// 간접 참조 방식으로 코드를 다시 짜야할듯...
		
		try {
			s1 = dateS.toString();
			s2 = dateE.toString();	
		} catch (Exception e) {
			s1 = "";
			s2 = "";
		}
		
		

		
		JLabel periodLabel = new JLabel(s1 + " ~ " + s2);
		
		stat1.add(periodLabel);
				
		contentP.add(stat1);
		contentP.add(stat2);
		*/
		
		

		closeBtn.addActionListener(e -> setVisible(false));
		
		
		add(textP, BorderLayout.NORTH);
		//add(contentP, BorderLayout.CENTER);
		add(btnP, BorderLayout.SOUTH);
		
		
	}

	public void setDate(LocalDate start, LocalDate end) {
		this.dateS = start;
		this.dateE = end;
		this.period_panel.setDate(start, end);
	}

	public void setType(int i) {
		this.type = i;
	}
	
}
