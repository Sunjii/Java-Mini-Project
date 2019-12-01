import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LineGraph extends JPanel {
	
	private static final int bar_w = 10; // 막대그래프 폭
	private int bar_h; // 막대그래프 높이
	
	private static final int graph_pos_x = 40; // 그래프 틀 시작좌표
	private static final int graph_pos_y = 40;
	private static final int graph_w = 620;	// 그래프 폭  420
	private static final int graph_h = 480;	// 그래프 높이 280
	
	private int s_x, s_y; // 막대 시작점 좌표
	private int gap;
	
	//private String item;
	private LocalDate dateS, dateE;
	private LocalDate bufD;
	private String location;
	private int dateLength; // +1 해야 dateE 까지 나옴
	
	private ArrayList<String> dateList = new ArrayList<String>();
	
	// 일정 기간 동안 한 물질의 수치를 꺽은선 그래프로 표현
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		
		// 기간 계산
		Period period = Period.between(dateS, dateE);
		if (period.getDays() > 15) {
			JOptionPane.showMessageDialog(null, "최대 14일까지만 조회가능합니다!");
			return;
		}
		dateLength = period.getDays();
		dateLength++; // +1 해야 dateE 까지 나옴
		bufD = dateS;
		
		//System.out.println(dateLength);
		//System.out.println(dateS + " ~ " + dateE);
		//System.out.println(bufD);
		// dateList에 입력
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
			//bufD.plusDays(1); // bufD 값 자체를 변환시키는건 아님...
		}
		
		//for(int i=0; i<dateLength; i++) {
		//	System.out.println(dateList.get(i));
		//}
		
		// 틀 짜기
		g.setColor(Color.black);
		// x축
		gap = (graph_w) / dateLength;
		
		for (int i=0; i < dateLength; i++) {
			g.drawLine(graph_pos_x+gap, graph_pos_y+graph_h, graph_pos_x+gap, graph_pos_y);	// x 축에 수직인 선
			String d = dateList.get(i).split("-")[1] + "-" + dateList.get(i).split("-")[2];
			g.drawString(d, gap, graph_pos_y + graph_h + 15);
			gap += graph_w / dateLength;	
		}
		
		// y축
		for (int i=0; i<10; i++) {
			//g.drawLine(x1, y1, x2, y2);
			
			
			
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



	public void init() {
		dateList.clear();
		
	}
	
	
	
}
