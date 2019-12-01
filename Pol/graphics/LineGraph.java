import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LineGraph extends JPanel {
	
	private static final int bar_w = 10; // ����׷��� ��
	private int bar_h; // ����׷��� ����
	
	private static final int graph_pos_x = 40; // �׷��� Ʋ ������ǥ
	private static final int graph_pos_y = 40;
	private static final int graph_w = 620;	// �׷��� ��  420
	private static final int graph_h = 480;	// �׷��� ���� 280
	
	private int s_x, s_y; // ���� ������ ��ǥ
	private int gap;
	
	//private String item;
	private LocalDate dateS, dateE;
	private LocalDate bufD;
	private String location;
	private int dateLength; // +1 �ؾ� dateE ���� ����
	
	private ArrayList<String> dateList = new ArrayList<String>();
	
	// ���� �Ⱓ ���� �� ������ ��ġ�� ������ �׷����� ǥ��
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		
		// �Ⱓ ���
		Period period = Period.between(dateS, dateE);
		if (period.getDays() > 15) {
			JOptionPane.showMessageDialog(null, "�ִ� 14�ϱ����� ��ȸ�����մϴ�!");
			return;
		}
		dateLength = period.getDays();
		dateLength++; // +1 �ؾ� dateE ���� ����
		bufD = dateS;
		
		//System.out.println(dateLength);
		//System.out.println(dateS + " ~ " + dateE);
		//System.out.println(bufD);
		// dateList�� �Է�
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
			//bufD.plusDays(1); // bufD �� ��ü�� ��ȯ��Ű�°� �ƴ�...
		}
		
		//for(int i=0; i<dateLength; i++) {
		//	System.out.println(dateList.get(i));
		//}
		
		// Ʋ ¥��
		g.setColor(Color.black);
		// x��
		gap = (graph_w) / dateLength;
		
		for (int i=0; i < dateLength; i++) {
			g.drawLine(graph_pos_x+gap, graph_pos_y+graph_h, graph_pos_x+gap, graph_pos_y);	// x �࿡ ������ ��
			String d = dateList.get(i).split("-")[1] + "-" + dateList.get(i).split("-")[2];
			g.drawString(d, gap, graph_pos_y + graph_h + 15);
			gap += graph_w / dateLength;	
		}
		
		// y��
		for (int i=0; i<10; i++) {
			//g.drawLine(x1, y1, x2, y2);
			
			
			
		}
		
		
		// �׷��� �׸���
		
		// �� ��¥������ y���� ���
		
		// drawPolyline(int[] x, int[] y, numberofLine);
		
		
		
		
		
		
		
	}



	public void setDate(LocalDate start, LocalDate end) {
		this.dateS = start;
		this.dateE = end;
		
	}

	public void setLocation(String string) {
		this.location = string;
	}



	public void init() {
		dateList.clear();
		
	}
	
	
	
}
