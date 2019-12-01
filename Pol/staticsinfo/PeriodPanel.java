import java.awt.Graphics;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PeriodPanel extends JPanel {
	private LocalDate dateS, dateE;
	private LocalDate bufD;
	private Period period;
	
	private int dateLength; // +1 해야 dateE 까지 나옴
	
	private ArrayList<String> dateList = new ArrayList<String>();
	private ArrayList<String> maxList = new ArrayList<String>();
	
	public void paint(Graphics g) {
	
		// period를 계산한다.
		period = Period.between(dateS, dateE);
		if(period.getDays() > 365) {
			JOptionPane.showMessageDialog(null, "날짜 범위 오류!");
			return;
		}
		dateLength = period.getDays();
		dateLength++; // +1 해야 dateE 까지 나옴
		bufD = dateS;

		g.drawString(dateS.toString() + " ~ " + dateE.toString(), 50, 50);
		
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
		}
		
	
		
		
		
		
		
		// dateS ~ dateE 까지 검색
		// 각 오염물질들의 농도가 가장 높은 날과 그 위치.
		//findMax(maxList, dateList);
		for (int i=0; i<dateLength; i++) {
			findMax(i, dateList, Constant.pollut[0]);
			
		}
		
		for(int i=0; i<Constant.pollut.length; i++) {
			g.drawString(Constant.pollut[i] + "가 가장 높 곳 : " + maxList.get(i), 50, 80 + (i*20));
		}
		
		// 각 오염물질들의 평균치
		double e[] = {0, 0, 0, 0, 0, 0};

		calE(dateList);
		
		
		for (int i=0; i<Constant.pollut.length; i++) {
			
		}
		
		
		
		
		
		
		
	}

	private String findMax(int i, ArrayList<String> dateList, String item) {
		double max = 0;
		String resultArea = "";
		// dateS 와 i 를 이용하여 찾으려는 날짜를 만든다.
		LocalDate curD = LocalDate.parse(dateList.get(i));
		
		// location에서 curD의 item 농도를 탐색.
		Stat resStat = new Stat(0,0,0,0,0,0);
		
		for (int j=1; j<Constant.locations.length; j++) {
			if(Frame.csvL.findLocation(Constant.locations[j], curD) != null) {
				resStat = Frame.csvL.findLocation(Constant.locations[j], curD).getStat();
			} else {
				//return -1; // 데이터 없음
				continue;
			}
			
			// resStat 에서 원하는 item의 농도를 탐색.
			double ppm = -1;
			ppm = resStat.getPpm(item);
			if (max < ppm) {
				max = ppm;
				resultArea = Constant.locations[j];
			}
			
		}
		
		String result = resultArea + "에서 " + Double.toString(max);
		
		
		return result;
		
	}


	private void findMax(ArrayList<String> maxList, ArrayList<String> dateList) {
		//maxList[0] = 이산화질소의 최대값;
		
		
		
	}



	private void calE(ArrayList<String> dateList) {
		// dl동안 각 오염물질들 마다 평균치를 계산한다.
		
		//LocalDate curD = LocalDate.parse(dateList.get(i));
		double buf = 0;
		
		for (int i=0; i<dateLength; i++) {
			//buf += 
		}
		
	}



	public void setDate(LocalDate start, LocalDate end) {
		this.dateS = start;
		this.dateE = end;
	}
	
}
