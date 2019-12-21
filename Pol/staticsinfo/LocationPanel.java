import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalDate;

import javax.swing.JPanel;




// ������ ���� ������� ��ȸ.
public class LocationPanel extends JPanel {

	private LocalDate date;


	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.black);
		g.drawString(date.toString(), 50, 50);
		// �� �� p0�� ���� ���� ���� & ���� ����
		// �� �� p1�� ���� ���� ���� & ���� ����
		// ...
		
		for(int i=0; i<Constant.pollut.length; i++) {
			g.drawString(Constant.pollut[i] + "�� ���� ���� ���� : " + getMaxLocation(this.date, Constant.pollut[i]), 50, 80 + (i*40));
			g.drawString(Constant.pollut[i] + "�� ���� ���� ���� : " + getMinLocation(this.date, Constant.pollut[i]), 50, 100 + (i*40));
			
		}
		
		
		// �׳� p0�� ���, p1�� ���, p2�� ��� ...
		
		
		
	}


	// date�� item�� ���� ���� ���� ã�� �޼ҵ�
	private String getMinLocation(LocalDate date, String item) {
		String result = "";
		double min = 0;
		double ppm = 3000;
		Stat resS = new Stat(0,0,0,0,0,0);
		for (int i=1; i<Constant.locations.length; i++) {
			if(Frame.csvL.findLocation(Constant.locations[i], date) != null) {
				resS = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
				ppm = resS.getPpm(item);
				if(ppm == -1) {
					// null ���� ����̹Ƿ� ��ŵ.
					continue;
				} else if(min > ppm) {
					min = ppm;
					result = Constant.locations[i] + "���� " + min;
				}
			} else {
				continue;
			}
		}
		
		
		return result;
	}


	// date�� item�� ���� ���� ������ ã�� �޼ҵ�
	private String getMaxLocation(LocalDate date, String item) {
		String result = "";
		double max = 0;
		double ppm = -1;
		Stat resS = new Stat(0,0,0,0,0,0);
		for (int i=1; i<Constant.locations.length; i++) {
			if(Frame.csvL.findLocation(Constant.locations[i], date) != null) {
				resS = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
				ppm = resS.getPpm(item);
				if(ppm == -1) {
					continue;
				} else if(max < ppm) {
					max = ppm;
					result = Constant.locations[i] + "���� " + max;
				}
				
			} else {
				continue;
			}
		}
		
		
		
		return result;
	}



	public void reset() {
		this.date = LocalDate.parse("2018-01-02");
	}


	public void setDate(LocalDate targetDate) {
		this.date = targetDate;
	}

	
	
}
