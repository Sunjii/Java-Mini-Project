import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TextDialog extends JDialog{

	private JButton closeBtn = new JButton("�ݱ�");
	
	
	public TextDialog (JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		setSize(Constant.dial_W, Constant.dial_H);
		
		// �ǰ���� �г�
		JPanel textP = new JPanel();
		
		
		
		
		
		
		// ��ư �г�
		JPanel btnP = new JPanel();
		
		btnP.add(closeBtn);
		closeBtn.addActionListener(e -> setVisible(false));
		
		
		
		
	}
	
	
	
	
	
}
