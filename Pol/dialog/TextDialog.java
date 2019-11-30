import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import oracle.jdbc.Const;

public class TextDialog extends JDialog{

	private JButton closeBtn = new JButton("닫기");
	
	
	public TextDialog (JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		setSize(Constant.dial_W, Constant.dial_H);
		
		// 타이틀 패널
		JPanel textP = new JPanel();
		
		JLabel titleLabel = new JLabel("오염 물질 권고 기준");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
		titleLabel.setForeground(new Color(102, 153, 153));
		titleLabel.setVerticalAlignment(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textP.add(titleLabel);
		
		// 내용 패널
		JPanel contentP = new JPanel(new GridLayout(6, 1));
		
		/*
		JLabel l1 = new JLabel("이산화질소 : 0-0.03 좋음      0.03-0.06 보통      0.06-0.20 나쁨      0.20- 매우나쁨");
		JLabel l2 = new JLabel("오존   농도 : 0-0.03 좋음      0.03-0.09 보통      0.09-0.15 나쁨      0.15- 매우나쁨");
		JLabel l3 = new JLabel("이산화탄소 : 0-2 좋음      2-9 보통      9-15 나쁨      15- 매우나쁨");
		JLabel l4 = new JLabel("아황산가스 : 0-0.02 좋음      0.02-0.05 보통      0.05-0.15 나쁨      0.15- 매우나쁨");
		JLabel l5 = new JLabel("미세   먼지 : 0-30 좋음      30-80 보통      80-150 나쁨      150- 매우나쁨");
		JLabel l6 = new JLabel("초미세먼지 : 0-15 좋음      15-35 보통      35-75 나쁨      75- 매우나쁨");
		*/
		JLabel l1 = new JLabel(Constant.nppmS);
		JLabel l2 = new JLabel(Constant.oppmS);
		JLabel l3 = new JLabel(Constant.cppmS);
		JLabel l4 = new JLabel(Constant.appmS);
		JLabel l5 = new JLabel(Constant.dustS);
		JLabel l6 = new JLabel(Constant.mdustS);
		
		
		
		
		
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		
		contentP.add(l1); contentP.add(l2); contentP.add(l3); contentP.add(l4); 
		contentP.add(l5); contentP.add(l6);
		
		// 버튼 패널
		JPanel btnP = new JPanel();
		
		btnP.add(closeBtn);
		closeBtn.addActionListener(e -> setVisible(false));
		
		
		add(textP, BorderLayout.NORTH);
		add(contentP, BorderLayout.CENTER);
		add(btnP, BorderLayout.SOUTH);
		
		
	}
	
	
	
	
	
}
