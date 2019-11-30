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

	private JButton closeBtn = new JButton("�ݱ�");
	
	
	public TextDialog (JFrame jframe, String title) {
		super(jframe, title);
		setLayout(new BorderLayout());
		setSize(Constant.dial_W, Constant.dial_H);
		
		// Ÿ��Ʋ �г�
		JPanel textP = new JPanel();
		
		JLabel titleLabel = new JLabel("���� ���� �ǰ� ����");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
		titleLabel.setForeground(new Color(102, 153, 153));
		titleLabel.setVerticalAlignment(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textP.add(titleLabel);
		
		// ���� �г�
		JPanel contentP = new JPanel(new GridLayout(6, 1));
		
		/*
		JLabel l1 = new JLabel("�̻�ȭ���� : 0-0.03 ����      0.03-0.06 ����      0.06-0.20 ����      0.20- �ſ쳪��");
		JLabel l2 = new JLabel("����   �� : 0-0.03 ����      0.03-0.09 ����      0.09-0.15 ����      0.15- �ſ쳪��");
		JLabel l3 = new JLabel("�̻�ȭź�� : 0-2 ����      2-9 ����      9-15 ����      15- �ſ쳪��");
		JLabel l4 = new JLabel("��Ȳ�갡�� : 0-0.02 ����      0.02-0.05 ����      0.05-0.15 ����      0.15- �ſ쳪��");
		JLabel l5 = new JLabel("�̼�   ���� : 0-30 ����      30-80 ����      80-150 ����      150- �ſ쳪��");
		JLabel l6 = new JLabel("�ʹ̼����� : 0-15 ����      15-35 ����      35-75 ����      75- �ſ쳪��");
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
		
		// ��ư �г�
		JPanel btnP = new JPanel();
		
		btnP.add(closeBtn);
		closeBtn.addActionListener(e -> setVisible(false));
		
		
		add(textP, BorderLayout.NORTH);
		add(contentP, BorderLayout.CENTER);
		add(btnP, BorderLayout.SOUTH);
		
		
	}
	
	
	
	
	
}
