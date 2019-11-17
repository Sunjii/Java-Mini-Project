import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GraphDialog extends JDialog{

	JButton closeBtn = new JButton("닫기");
	
	public GraphDialog(JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new FlowLayout());
		add(new JLabel("TEST"));
		
		setSize(300,300);
		
		closeBtn.addActionListener(e -> setVisible(false)); // 닫기버튼 리스너추가
		
	}
	
}
