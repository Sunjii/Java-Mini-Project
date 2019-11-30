import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TextDialog extends JDialog{

	private JButton closeBtn = new JButton("닫기");
	
	
	public TextDialog (JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		setSize(Constant.dial_W, Constant.dial_H);
		
		// 권고기준 패널
		JPanel textP = new JPanel();
		
		
		
		
		
		
		// 버튼 패널
		JPanel btnP = new JPanel();
		
		btnP.add(closeBtn);
		closeBtn.addActionListener(e -> setVisible(false));
		
		
		
		
	}
	
	
	
	
	
}
