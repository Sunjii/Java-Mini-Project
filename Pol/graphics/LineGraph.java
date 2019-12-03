import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	private static final int graph_w = 620;	// 그래프 폭  420 620
	private static final int graph_h = 480;	// 그래프 높이 280 480

	
	
	private int s_x, s_y; // 막대 시작점 좌표
	private int gap;

	private LocalDate dateS, dateE;
	private LocalDate bufD;
	private String location;
	private String item;
	private int type;
	private int dateLength; // +1 해야 dateE 까지 나옴
	
	private ArrayList<String> dateList = new ArrayList<String>();
	
	//private int xArr[];
	//private int yArr[];
	
	// 일정 기간 동안 한 물질의 수치를 꺽은선 그래프로 표현
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W+600, Constant.dial_H+300);
		
		setType(item);
		
		// 기간 계산
		Period period = Period.between(dateS, dateE);
		if (period.getDays() > 15) {
			JOptionPane.showMessageDialog(null, "최대 14일까지만 조회가능합니다!");
			return;
		}
		dateLength = period.getDays();
		dateLength++; // +1 해야 dateE 까지 나옴
		bufD = dateS;
		
		// dateList에 입력
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
			//bufD.plusDays(1); // bufD 값 자체를 변환시키는건 아님...
		}
		
		// 틀 짜기
		g.setColor(Color.black);
		// x축
		gap = graph_w / dateLength;
		g.drawLine(graph_pos_x, graph_pos_y+graph_h, graph_pos_x, graph_pos_y);
		for (int i=0; i < dateLength; i++) {
			g.drawLine(graph_pos_x+gap, graph_pos_y+graph_h, graph_pos_x+gap, graph_pos_y);	// x 축에 수직인 선
			String d = dateList.get(i).split("-")[1] + "-" + dateList.get(i).split("-")[2];
			g.drawString(d, gap, graph_pos_y + graph_h + 15);
			gap += graph_w / dateLength;	
		}
		
		// y축
		for (int i=0; i<10; i++) {
			//g.drawLine(x1, y1, x2, y2);
			double dou = Constant.pollut_max[type] - i *(Constant.pollut_max[type]/10);
			String str = String.format("%.3f", dou);
			g.drawString(str, graph_pos_x-22, graph_pos_y+(i*48));
			
		}
		
		
		// 그래프 그리기
		
		// 각 날짜마다의 y값을 계산
		gap = graph_w / dateLength;
		gap -= 20;
		int [] xArr = new int [dateLength];
		int [] yArr = new int [dateLength];
		
		// 선의 꼭짓점을 배열에 넣는다.
		for (int i=0; i<dateLength; i++) {
			xArr[i] = graph_pos_x+gap;
			//yArr[i] = 150 + (i*10);
			int buf = getPoint(i, dateList, item);
			if (buf < 0) {
				buf = 0;
			}
			buf = graph_pos_y + graph_h - buf;
			yArr[i] = buf;
			gap += graph_w / dateLength;
		}
		
		// 선을 그린다.
		g.setColor(Color.red);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5)); // 선 굵기 설정
		g.drawPolyline(xArr, yArr, dateLength);
		
	}


	// i번째 날의 item 농도를 계산하여 반환.
	private int getPoint(int i, ArrayList<String> dateList, String item) {
		
		// dateS 와 i 를 이용하여 찾으려는 날짜를 만든다.
		LocalDate curD = LocalDate.parse(dateList.get(i));
		
		// location에서 curD의 item 농도를 탐색.
		Stat resStat = new Stat(0,0,0,0,0,0);
		if(Frame.csvL.findLocation(this.location, curD) != null) {
			resStat = Frame.csvL.findLocation(this.location, curD).getStat();
		} else {
			return -1; // 데이터 없음
		}
		
		// resStat 에서 원하는 item의 농도를 탐색.
		double ppm = -1;
		ppm = resStat.getPpm(item);
		if (ppm == -1) {
			return -1; // 데이터 없음
		}
		
		// 10칸이 max, 1칸 당 48px
		// 찾아낸 ppm을 상대값화 시킨다. 각 오염물질의 값 범위는 max를 참조한다.
		for (int k=0; k<Constant.pollut.length; k++) {
			if(item.equals(Constant.pollut[k])) {
				//double result = (ppm / Constant.pollut_max[k] * 100); // ex) 21  == 21%.. 즉 2.1칸		
				//return (int)(result / 10 * 48);
				double result = (ppm / Constant.pollut_max[k] * 100);
				//System.out.println(i + "날 " + location + "의 " + item + " " + ppm);
				return (int)(result / 10 * 48);
				
			}
		}
		return -1;
	}



	public void init() {
		dateList.clear();
		
	}

	public void setDate(LocalDate start, LocalDate end) {
		this.dateS = start;
		this.dateE = end;
	}

	public void setLocation(String string) {
		this.location = string;
	}

	private void setType(String item) {
		switch (item) {
		case "이산화질소":
			this.type = 0;
			break;
		case "오존농도":
			this.type = 1;
			break;
		case "이산화탄소":
			this.type = 2;
			break;
		case "아황산가스":
			this.type = 3;
			break;
		case "미세먼지":
			this.type = 4;
			break;
		case "초미세먼지":
			this.type = 5;
			break;
		}
		
	}



	public void setItem(String selectedItem) {
		this.item = selectedItem;
		
	}
	
	
	
}
