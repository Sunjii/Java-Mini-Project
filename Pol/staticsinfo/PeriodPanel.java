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
	
	private int dateLength; // +1 �ؾ� dateE ���� ����
	
	private ArrayList<String> dateList = new ArrayList<String>();
	private ArrayList<String> maxList = new ArrayList<String>();
	
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
		
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
		}
		
	
		
		
		
		
		
		// dateS ~ dateE ���� �˻�
		// �� ������������ �󵵰� ���� ���� ���� �� ��ġ.
		//findMax(maxList, dateList);
		for (int i=0; i<dateLength; i++) {
			findMax(i, dateList, Constant.pollut[0]);
			
		}
		
		for(int i=0; i<Constant.pollut.length; i++) {
			g.drawString(Constant.pollut[i] + "�� ���� �� �� : " + maxList.get(i), 50, 80 + (i*20));
		}
		
		// �� ������������ ���ġ
		double e[] = {0, 0, 0, 0, 0, 0};

		calE(dateList);
		
		
		for (int i=0; i<Constant.pollut.length; i++) {
			
		}
		
		
		
		
		
		
		
	}

	private String findMax(int i, ArrayList<String> dateList, String item) {
		double max = 0;
		String resultArea = "";
		// dateS �� i �� �̿��Ͽ� ã������ ��¥�� �����.
		LocalDate curD = LocalDate.parse(dateList.get(i));
		
		// location���� curD�� item �󵵸� Ž��.
		Stat resStat = new Stat(0,0,0,0,0,0);
		
		for (int j=1; j<Constant.locations.length; j++) {
			if(Frame.csvL.findLocation(Constant.locations[j], curD) != null) {
				resStat = Frame.csvL.findLocation(Constant.locations[j], curD).getStat();
			} else {
				//return -1; // ������ ����
				continue;
			}
			
			// resStat ���� ���ϴ� item�� �󵵸� Ž��.
			double ppm = -1;
			ppm = resStat.getPpm(item);
			if (max < ppm) {
				max = ppm;
				resultArea = Constant.locations[j];
			}
			
		}
		
		String result = resultArea + "���� " + Double.toString(max);
		
		
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
	
}
