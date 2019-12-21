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

	private JButton closeBtn = new JButton("�ݱ�");
	private JButton paintBtn = new JButton("�ҷ�����");
	
	//private PeriodPanel period_panel = new PeriodPanel();
	//private LocationPanel location_panel = new LocationPanel();
	
	private PeriodPanel period_panel;
	private LocationPanel location_panel;
	
	//private LocalDate dateS, dateE;
	//private LocalDate dateS = LocalDate.now();
	//private LocalDate dateE = LocalDate.now();

	private LocalDate dateS = LocalDate.parse("2018-01-01");
	private LocalDate dateE = LocalDate.parse("2018-12-31");
	private int dateLength;
<<<<<<< HEAD
	public int type;
=======
	//private int type;
>>>>>>> 4c5c752ce817d950c1d7000b3204838f79422ca2
	private String location;
	
	
	
	
	public StaticsDialog(JFrame jframe, String title, int type) {
		super(jframe, title);
		setLayout(new BorderLayout());
		setSize(Constant.dial_W, Constant.dial_H);
		System.out.println("DEBUG START");
		
		// Ÿ��Ʋ
		JPanel textP = new JPanel();
		
		JLabel titleLabel = new JLabel("�� �� �� ��");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
		titleLabel.setForeground(new Color(102, 153, 153));
		titleLabel.setVerticalAlignment(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textP.add(titleLabel);
		// ��ư �г�
		JPanel btnP = new JPanel();
		
		btnP.add(paintBtn);
		btnP.add(closeBtn);
		
		
		switch (type) {
		case 0:	// Ư�� �Ⱓ ��跮 ��ȸ
			period_panel = new PeriodPanel();
			period_panel.reset();
			add(period_panel, BorderLayout.CENTER);
			break;
		case 1:	// Ư�� ���� ��跮 ��ȸ
<<<<<<< HEAD
			location_panel = new LocationPanel();
			location_panel.reset();
=======
			setSize(Constant.dial_W, Constant.dial_H + 150);
>>>>>>> 4c5c752ce817d950c1d7000b3204838f79422ca2
			add(location_panel, BorderLayout.CENTER);
			break;
		}
		System.out.println("TTT");
		
		paintBtn.addActionListener(e -> {
			if(type == 0) {	// ������ �������� ������ �Ⱓ������ ��跮�� �����Ѵ�.
				period_panel.reset();
				
				LocalDate start = LocalDate.of(2018, 1, 1);
				LocalDate end = LocalDate.of(2018, 12, 31);
				if(Frame.getOpen()) {
					try{
						start = LocalDate.parse(JOptionPane.showInputDialog("�����ϴ� ��¥�� �Է��ϼ���. ex) 2018-01-06"));
						end = LocalDate.parse(JOptionPane.showInputDialog("������ ��¥�� �Է��ϼ���. ex) 2018-01-16"));
						setDate(start, end);
					} catch(Exception err) {
						JOptionPane.showMessageDialog(null, "�߸��� ��¥�Դϴ�!", "�Է¿���", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String[] ls = Constant.locations;
					Object selectedL = JOptionPane.showInputDialog(null, "��ȸ�ϰ� ���� ������ �ϳ� �����ϼ���.\n��ü�� �������Դϴ�.", "Selection", JOptionPane.DEFAULT_OPTION, null, ls, "1");
					if ( selectedL != null ){ 
					    setLocation(selectedL.toString());
					}else{
					    //System.out.println("User cancelled");
					}
					
					
				} else {
					JOptionPane.showMessageDialog(null, "���� �����͸� �ҷ��;��մϴ�!");
					//setDate(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 31));
				}
				
				period_panel.setDate(start, end);
				period_panel.repaint();
				
				
			} else {	// ���õ� ���� ��跮�� �����Ѵ�.
				location_panel.reset();
				if(Frame.getOpen()) {
					LocalDate targetDate;
					try {
						targetDate = LocalDate.parse(JOptionPane.showInputDialog("��¥�� �Է����ּ���. ex) 2018-01-06"));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "�߸��� ��¥�Դϴ�!", "�Է¿���", JOptionPane.ERROR_MESSAGE);
						return;
					}
					setDate(targetDate);
					location_panel.setDate(targetDate);	
				} else {
					JOptionPane.showMessageDialog(null, "���� �����͸� �ҷ��;��մϴ�!");
				}
				
				location_panel.repaint();
			}
			
			
			
			
			
			
		});
		
		
		
		
		
		/*
		if(Frame.getOpen()) {
			try{
				LocalDate start = LocalDate.parse(JOptionPane.showInputDialog("�����ϴ� ��¥�� �Է��ϼ���. ex) 2018-01-06"));
				LocalDate end = LocalDate.parse(JOptionPane.showInputDialog("������ ��¥�� �Է��ϼ���. ex) 2018-01-16"));
				//System.out.println(start.toString() + end.toString());
				//Frame.stDialog.setDate(start, end);
				//Frame.stDialog.setType(0);
				setDate(start, end);
			} catch(Exception err) {
				JOptionPane.showMessageDialog(null, "�߸��� ��¥�Դϴ�!", "�Է¿���", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else {
			setDate(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 12, 31));
		}
		*/
	
		// ����
		
		// �Ⱓ ���
		//Period period = Period.between(dateS, dateE);
		//dateLength = period.getDays();
		//dateLength++; // +1 �ؾ� dateE ���� ����
		
		/*
		JPanel contentP = new JPanel();
		
		JPanel stat1 = new JPanel();
		JPanel stat2 = new JPanel();
		String s1, s2;
		
		//System.out.println(dateS.toString() + dateE.toString());
		System.out.println(dateS);	// nullpointer ����...
		// ���� ���� ������� �ڵ带 �ٽ� ¥���ҵ�...
		
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
	
	public void setDate(LocalDate date) {
		this.location_panel.setDate(date);
		//System.out.println("PPPP");
		//this.dateS = date;
		//this.dateE = date;
		//this.period_panel.setDate(dateS, dateE);
	}

	public void init() {
		this.dateS = null;
		this.dateE = null;
		this.period_panel.reset();
		this.location_panel.reset();
		
	}
	
	public void setDate(LocalDate targetDate) {
		this.dateS = targetDate;
		this.dateE = targetDate;
		this.location_panel.setDate(targetDate);
		this.period_panel.setDate(targetDate, targetDate);
	}

	public void setLocation(String string) {
		this.location = string;
		this.period_panel.setLocation(this.location);
		
	}


	
}
