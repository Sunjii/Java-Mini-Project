import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalDate;

import javax.swing.JPanel;

public class LineGraph extends JPanel {

	//private String item;
	private LocalDate dateS, dateE;
	private String location;
	
	
	
	// 일정 기간 동안 한 물질의 수치를 꺽은선 그래프로 표현
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		
		
		
		// 틀 짜기
		g.setColor(Color.black);
		// x축
		for (int i=0; i < dateLength; i++) {
			g.drawLine(x1, y1, x2, y2);	// x 축에 수직인 선
			g.drawString(date, x, y);
			gap += something;
			
		}
		
		// y축
		for (int i=0; i<10; i++) {
			g.drawLine(x1, y1, x2, y2);
			
			
			
		}
		
		
		// 그래프 그리기
		
		// 각 날짜마다의 y값을 계산
		
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
