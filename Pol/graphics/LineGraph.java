import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalDate;

import javax.swing.JPanel;

public class LineGraph extends JPanel {

	//private String item;
	private LocalDate dateS, dateE;
	private String location;
	
	
	
	// ���� �Ⱓ ���� �� ������ ��ġ�� ������ �׷����� ǥ��
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		
		
		
		// Ʋ ¥��
		g.setColor(Color.black);
		// x��
		for (int i=0; i < dateLength; i++) {
			g.drawLine(x1, y1, x2, y2);	// x �࿡ ������ ��
			g.drawString(date, x, y);
			gap += something;
			
		}
		
		// y��
		for (int i=0; i<10; i++) {
			g.drawLine(x1, y1, x2, y2);
			
			
			
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
	
	
	
}
