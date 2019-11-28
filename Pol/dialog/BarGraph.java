import java.awt.Color;
import java.awt.Graphics;
import java.lang.management.GarbageCollectorMXBean;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import oracle.jdbc.Const;

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
		//g.drawRect(graph_pos_x, graph_pos_y, graph_w + plus, graph_h);
		
		

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
		
		//System.out.println("지역의 수" + Constant.locations.length);
		
		// num1 ~ num6의 막대 그래프 그리기
		// bar_h : 상대값. 
		// s_y : 40 ~ 320
		//gap = 420/6;
		
		gap = (graph_w+plus) / (Constant.locations.length -1);
		for (int i=0; i < Constant.locations.length - 1; i++) {
			s_x = graph_pos_x + gap/2;
			
			gap += ( (graph_w + plus)/(Constant.locations.length -1) ) * 2  ;
			//bar_h = 10;
			// 지역 i의 date날의 item의 농도를 가져온다
			//try {
				bar_h = getBar(i, date, item);
			//} catch(Exception e) {
			//	JOptionPane.showMessageDialog(null, "잘못 된 날짜같습니다!");
			//	return;
			//}
			
			
			g.setColor(Color.red);
			g.fillRect(s_x, s_y, bar_w, bar_h);
			System.out.println("좌표 : " + s_x + " " + s_y+ " " +bar_w + " " + bar_h);
		}
		
		/*
		for(int i=0; i<6; i++) {
			s_x = graph_pos_x + gap/2;
			bar_h = (int) (num[i] / max[i] * 100);
			s_y = graph_pos_y + graph_h - bar_h;
			gap += graph_w/3;
			g.setColor(Color.red);
			g.fillRect(s_x, s_y, bar_w, bar_h);		
		}
		*/
		
		
		
		/*
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
		*/
		
		
		
		
	}
	
	private int getBar(int i, LocalDate date, String item) {
		// i번째 도시 (1부터 시작) 의 date날의 item에 해당하는 오염물질의 농도를 가져오는 함수
		i++;
		// i 와 date 기준으로 탐색
		//Stat resStat = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
		Stat resStat = new Stat(0,0,0,0,0,0);
		resStat = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
		// getStat  --> nullpointer 에러
		
		//Location loc = Frame.csvL.findLocation(Constant.locations[i], date);
		//System.out.println(loc);
		
		//System.out.println(item); // null 로 출력됨...
		
		
		// item의 농도를 탐색. 없으면 0 반환
		double ppm = resStat.getPpm(item);
		System.out.println(item + "의 " + ppm);
		// 찾아낸 ppm을 상대값화 시킨다?
		for (int k=0; k<Constant.pollut.length; k++) {
			if(item.equals(Constant.pollut[i])) {
				return (int)(ppm / max[k] * 100);
			}
		}
		return 0;
		
		//return (int)(ppm / max[k] * 100);
		
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
		this.date = selectedLocalDate;
	}

	public void setItem(String selectedItem) {
		// TODO Auto-generated method stub
		this.item = selectedItem;
	}
	
	
}
