import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalDate;

import javax.swing.JPanel;

public class BarGraph extends JPanel{
	private double num[] = {0, 0, 0, 0, 0, 0}; // 오염물질의 농도
	private double max[] = {0.060, 0.060, 3, 0.050, 200, 130}; // 오염물질들의 최대값
	
	private static final int bar_w = 10; // 막대그래프 폭
	private int bar_h; // 막대그래프 높이
	
	private static final int graph_pos_x = 40; // 그래프 틀 시작좌표
	private static final int graph_pos_y = 40;
	private static final int graph_w = 420;	// 그래프 폭
	private static final int graph_h = 280;	// 그래프 높이
	
	private int s_x, s_y; // 막대 시작점 좌표
	private int gap;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		
		// 그래프 틀
		g.setColor(Color.black);
		g.drawRect(graph_pos_x, graph_pos_y, graph_w, graph_h);
		gap = graph_w / 6; // 간격
		// x축
		for(int i=0; i<6; i++) {
			g.drawLine(graph_pos_x+gap, graph_pos_y+graph_h, graph_pos_x+gap, graph_pos_y);
			g.drawString(Constant.pollut[i], (gap)-20, graph_pos_y + graph_h + 15);
			gap += 420/6;
		}
		// y축
		for(int i=0; i<10; i++) {
			g.drawLine(graph_pos_x, graph_pos_y+(i*28), graph_pos_x+graph_w, graph_pos_y+(i*28));
			g.drawString(Integer.toString(100 - i*10), graph_pos_x-22, graph_pos_y+(i*28));
		}
		
		// num1 ~ num6의 막대 그래프 그리기
		// bar_h : 상대값. 
		// s_y : 40 ~ 320
		gap = 420/6;
		
		for(int i=0; i<6; i++) {
			s_x = graph_pos_x + gap/2;
			bar_h = (int) (num[i] / max[i] * 100);
			s_y = graph_pos_y + graph_h - bar_h;
			gap += graph_w/3;
			g.setColor(Color.red);
			g.fillRect(s_x, s_y, bar_w, bar_h);		
		}
		
		
		
		
		
	}
	
	public void setNumbers(double num1, double num2, double num3, double num4, double num5, double num6) {
		num[0] = num1;
		num[1] = num2;
		num[2] = num3;
		num[3] = num4;
		num[4] = num5;
		num[5] = num6;
	}

	public void setDate(LocalDate selectedLocalDate) {
		// TODO Auto-generated method stub
		
	}

	public void setItem(String selectedItem) {
		// TODO Auto-generated method stub
		
	}
	
	
}
