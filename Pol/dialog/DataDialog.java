import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// �׷��� ��ȭ����
@SuppressWarnings("serial")
public class DataDialog extends JDialog{

	private JButton closeBtn = new JButton("�ݱ�");
	private JButton paintBtn = new JButton("�׸���");
	
	
	private double num1, num2, num3, num4, num5, num6;

	
	public DataDialog(JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		
		// ��ư �г�
		JPanel btnP = new JPanel();
		btnP.add(paintBtn);
		btnP.add(closeBtn);
		add(btnP, BorderLayout.SOUTH);

		setSize(Constant.dial_W, Constant.dial_H + 100);
		
		// �ݱ� ��ư ������
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
