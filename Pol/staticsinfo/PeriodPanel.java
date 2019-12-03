import java.awt.Graphics;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;




// 선택한 날의 모든 지역의 오염물질별 통계정보
public class PeriodPanel extends JPanel {
	private LocalDate dateS, dateE;
	private LocalDate bufD;
	private Period period;
	
	private int dateLength; // +1 해야 dateE 까지 나옴
	
	private ArrayList<String> dateList = new ArrayList<String>();
	private ArrayList<String> maxList = new ArrayList<String>();
	private String maxString[] = {"", "", "", "", "", ""};
	private int count = 0;
	private String location;
	
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
		// dateList 생성
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
		}
		
	
		
		
		
		
		
		// dateS ~ dateE 까지 검색
		// 각 오염물질들의 농도가 가장 높은 날과 그 수치
		//findMax(maxList, dateList);
		/*
		double max[] = {0, 0, 0, 0, 0, 0};
		double temp = 0;
		for (int i=0; i<dateLength; i++) {
			// dateList의 시작과 끝까지, 이산화질소를 검색
			//maxList.add( findMax(i, dateList, Constant.pollut[0]) );
			for(int j=0; j<6; j++) {
				temp = findMax(i, dateList, Constant.pollut[j]);
				if(max[j] < temp) {
					max[j] = temp;
				}
			}
			count = 0;
			
			// dateList의 시작과 끝까지, 아황산가스를 검색
			// ...
			
		}
		for (int i=0; i<6; i++) {
			//maxList.add(maxString[i]);
			maxList.add(Double.toString(max[i]));
		}
		*/
		
		
		// dateS ~ dateE 까지 location의 데이터를 탐색.
		//for(int i=0; i<dateLength; i++) {
		//	calculate(this.location, Constant.pollut[0]);
		//}
		
		for (int i=0; i<6; i++) {
			System.out.println( calculate(this.location, Constant.pollut[i]) );
		}
		
		
		/*
		for(int i=0; i<Constant.pollut.length; i++) {
			// index out of bound
			g.drawString(Constant.pollut[i] + "가 가장 높은 곳 : " + maxList.get(i), 50, 80 + (i*20));
		}
		
		// 각 오염물질들의 평균치
		double e[] = {0, 0, 0, 0, 0, 0};

		calE(dateList);
		
		
		for (int i=0; i<Constant.pollut.length; i++) {
			
		}
		*/
		
		
		
		
		
		
	}

	private String calculate(String location, String item) {
		// dateS~dateE의 location의 item
		String maxdate = "";
		double max = 0;
		Stat resS = new Stat(0,0,0,0,0,0);
		for (int i=0; i<dateLength; i++) {
			LocalDate curD = LocalDate.parse(dateList.get(i));
			for (int j=1; j<Constant.locations.length; j++) {
				if(Frame.csvL.findLocation(this.location, curD) != null) {
					resS = Frame.csvL.findLocation(this.location, curD).getStat();
				} else {
					continue;
				}
				
				double ppm = 0;
				ppm = resS.getPpm(item);
				if(max < ppm) {
					maxdate = curD.toString();
					max = ppm;
				}
				
				
			}
			
		}
		
		return (this.location + " " + maxdate + " " + max);
	}

	private String findMax(int i, ArrayList<String> dateList, String item) {
		// dateList의 처음부터 끝까지에서 item의 제일 높은 숫자를 반환한다.
		
		
		double max = 0;
		String resultArea = "";
		// dateS 와 i 를 이용하여 찾으려는 날짜를 만든다.
		LocalDate curD = LocalDate.parse(dateList.get(i));
		
		// location에서 curD의 item 농도를 탐색.
		Stat resStat = new Stat(0,0,0,0,0,0);
		
		for (int j=1; j<Constant.locations.length; j++) {
			// 도시이름과 날짜로 탐색
			if(Frame.csvL.findLocation(this.location, curD) != null) {
				resStat = Frame.csvL.findLocation(this.location, curD).getStat();
			} else {
				//return -1; // 데이터 없음
				continue;
			}
			
			// resStat 에서 원하는 item의 농도를 탐색.
			double ppm = -1;
			ppm = resStat.getPpm(item);
			if (max < ppm) {
				max = ppm;
				//resultArea = Constant.locations[j];
			}
			
		}
		
		String result = dateList.get(i) + " " + this.location + "에서 " + Double.toString(max);
		this.maxString[count]  = result;
		count++;
		
		//return max;
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

	public void reset() {
		this.dateS = null;
		this.dateE = null;
		this.dateList.clear();
		this.maxList.clear();
		
	}

	public void setLocation(String location) {
		this.location = location;
		
	}
	
}
