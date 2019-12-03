import java.awt.Graphics;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;




// ������ ���� ��� ������ ���������� �������
public class PeriodPanel extends JPanel {
	private LocalDate dateS, dateE;
	private LocalDate bufD;
	private Period period;
	
	private int dateLength; // +1 �ؾ� dateE ���� ����
	
	private ArrayList<String> dateList = new ArrayList<String>();
	private ArrayList<String> maxList = new ArrayList<String>();
	private String maxString[] = {"", "", "", "", "", ""};
	private int count = 0;
	private String location;
	
	public void paint(Graphics g) {
	
		// period�� ����Ѵ�.
		period = Period.between(dateS, dateE);
		if(period.getDays() > 365) {
			JOptionPane.showMessageDialog(null, "��¥ ���� ����!");
			return;
		}
		dateLength = period.getDays();
		dateLength++; // +1 �ؾ� dateE ���� ����
		bufD = dateS;

		g.drawString(dateS.toString() + " ~ " + dateE.toString(), 50, 50);
		// dateList ����
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
		}
		
	
		
		
		
		
		
		// dateS ~ dateE ���� �˻�
		// �� ������������ �󵵰� ���� ���� ���� �� ��ġ
		//findMax(maxList, dateList);
		/*
		double max[] = {0, 0, 0, 0, 0, 0};
		double temp = 0;
		for (int i=0; i<dateLength; i++) {
			// dateList�� ���۰� ������, �̻�ȭ���Ҹ� �˻�
			//maxList.add( findMax(i, dateList, Constant.pollut[0]) );
			for(int j=0; j<6; j++) {
				temp = findMax(i, dateList, Constant.pollut[j]);
				if(max[j] < temp) {
					max[j] = temp;
				}
			}
			count = 0;
			
			// dateList�� ���۰� ������, ��Ȳ�갡���� �˻�
			// ...
			
		}
		for (int i=0; i<6; i++) {
			//maxList.add(maxString[i]);
			maxList.add(Double.toString(max[i]));
		}
		*/
		
		
		// dateS ~ dateE ���� location�� �����͸� Ž��.
		//for(int i=0; i<dateLength; i++) {
		//	calculate(this.location, Constant.pollut[0]);
		//}
		
		for (int i=0; i<6; i++) {
			System.out.println( calculate(this.location, Constant.pollut[i]) );
		}
		
		
		/*
		for(int i=0; i<Constant.pollut.length; i++) {
			// index out of bound
			g.drawString(Constant.pollut[i] + "�� ���� ���� �� : " + maxList.get(i), 50, 80 + (i*20));
		}
		
		// �� ������������ ���ġ
		double e[] = {0, 0, 0, 0, 0, 0};

		calE(dateList);
		
		
		for (int i=0; i<Constant.pollut.length; i++) {
			
		}
		*/
		
		
		
		
		
		
	}

	private String calculate(String location, String item) {
		// dateS~dateE�� location�� item
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
		// dateList�� ó������ ���������� item�� ���� ���� ���ڸ� ��ȯ�Ѵ�.
		
		
		double max = 0;
		String resultArea = "";
		// dateS �� i �� �̿��Ͽ� ã������ ��¥�� �����.
		LocalDate curD = LocalDate.parse(dateList.get(i));
		
		// location���� curD�� item �󵵸� Ž��.
		Stat resStat = new Stat(0,0,0,0,0,0);
		
		for (int j=1; j<Constant.locations.length; j++) {
			// �����̸��� ��¥�� Ž��
			if(Frame.csvL.findLocation(this.location, curD) != null) {
				resStat = Frame.csvL.findLocation(this.location, curD).getStat();
			} else {
				//return -1; // ������ ����
				continue;
			}
			
			// resStat ���� ���ϴ� item�� �󵵸� Ž��.
			double ppm = -1;
			ppm = resStat.getPpm(item);
			if (max < ppm) {
				max = ppm;
				//resultArea = Constant.locations[j];
			}
			
		}
		
		String result = dateList.get(i) + " " + this.location + "���� " + Double.toString(max);
		this.maxString[count]  = result;
		count++;
		
		//return max;
		return result;
		
	}


	private void findMax(ArrayList<String> maxList, ArrayList<String> dateList) {
		//maxList[0] = �̻�ȭ������ �ִ밪;
		
		
		
	}



	private void calE(ArrayList<String> dateList) {
		// dl���� �� ���������� ���� ���ġ�� ����Ѵ�.
		
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
