import java.awt.Color;
import java.awt.Graphics;
import java.lang.management.GarbageCollectorMXBean;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import oracle.jdbc.Const;

public class BarGraph extends JPanel{
	//private double num[] = {0, 0, 0, 0, 0, 0}; // 오염물질의 농도
	//private double max[] = {0.060, 0.060, 3, 0.050, 200, 130}; // 오염물질들의 최대값
	
	private static final int bar_w = 10; // 막대그래프 폭
	private int bar_h; // 막대그래프 높이
	
	private static final int graph_pos_x = 40; // 그래프 틀 시작좌표
	private static final int graph_pos_y = 40;
	private static final int graph_w = 420;	// 그래프 폭
	private static final int graph_h = 280;	// 그래프 높이
	
	private int s_x, s_y; // 막대 시작점 좌표
	private int gap;
	
	private LocalDate date; // 그릴 날짜
	private String item; // 그릴 오염물질
	
	
	int plus = 1600;  // 막대그래프에서 추가로 늘어나는 폭

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W + plus, Constant.dial_H);
		
		gap = (graph_w+plus) / (Constant.locations.length -1); // 간격. 46개지역
		// 그래프 틀
		g.setColor(Color.black);
		// x축
		for(int i=1; i < Constant.locations.length; i++) {
			g.drawLine(graph_pos_x+gap, graph_pos_y+graph_h, graph_pos_x+gap, graph_pos_y);
			g.drawString(Constant.locations[i], (gap), graph_pos_y + graph_h + 15);
			//gap += 420/6;
			gap += (graph_w + plus) / (Constant.locations.length -1);
		}
		// y축
		for(int i=0; i<10; i++) {
			g.drawLine(graph_pos_x, graph_pos_y+(i*28), graph_pos_x+graph_w+plus, graph_pos_y+(i*28));
			g.drawString(Integer.toString(100 - i*10), graph_pos_x-22, graph_pos_y+(i*28));
		}
		

		gap = (graph_w+plus) / (Constant.locations.length -1);
		// 각 도시의 date 의 item 농도를 그린다.
		for (int i=1; i < Constant.locations.length - 1; i++) {
			// 막대의 x좌표와 gap을 다시 설정합니다.
			s_x = graph_pos_x + gap/2;
			gap += ( (graph_w + plus)/(Constant.locations.length -1) ) * 2  ;
			// 지역 i의 date날의 item의 농도를 가져옵니다.
			//System.out.println(Constant.locations[i] + " 도시의 " + date + " 의 " + item + " 은...");
			// 막대의 높이를 계산합니다. 데이터가 없는 경우에는 -1이 반환됩니다.
			bar_h = getBar(i, date, item);
			if (bar_h < 0) {
				bar_h = 0;
			}
			// 막대의 높이를 이용하여 막대의 y좌표를 계산합니다.
			s_y = graph_pos_y + graph_h - bar_h;
			
			g.setColor(Color.red);
			g.fillRect(s_x, s_y, bar_w, bar_h);
		}

	}
	
	private int getBar(int i, LocalDate date, String item) {
		// i번째 도시 (1부터 시작) 의 date날의 item에 해당하는 오염물질의 농도를 가져오는 함수

		// i 와 date 기준으로 탐색
		Stat resStat = new Stat(0,0,0,0,0,0);
		// findLocation후에 null이면 getStat을 진행하지 않도록 바꾼다.
		if(Frame.csvL.findLocation(Constant.locations[i], date) != null) {
			resStat = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
		} else {
			// 해당 날짜와 지역의 데이터가 없는 경우에는 return -1
			return -1;
		}

		// item의 농도를 탐색. 없으면 -1 반환
		double ppm = -1;
		ppm = resStat.getPpm(item);
		if(ppm == -1) {
			return -1; // 값 없음
		}
		
		// 찾아낸 ppm을 상대값화 시킨다. 각 오염물질의 값 범위는 max를 참조한다.
		for (int k=0; k<Constant.pollut.length; k++) {
			if(item.equals(Constant.pollut[k])) {
				return (int)(ppm / Constant.pollut_max[k] * 100);
			}
		}
		
		return -1;
		
	}

	/*
	public void setNumbers(double num1, double num2, double num3, double num4, double num5, double num6) {
		num[0] = num1;
		num[1] = num2;
		num[2] = num3;
		num[3] = num4;
		num[4] = num5;
		num[5] = num6;
	}
	*/

	public void setDate(LocalDate selectedLocalDate) {
		this.date = selectedLocalDate;
	}

	public void setItem(String selectedItem) {
		this.item = selectedItem;
	}
	
	
}
