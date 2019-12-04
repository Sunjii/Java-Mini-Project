import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Map extends JPanel {
	
	// 1������ x, y ��ǥ��
	/*
	private int[] s1_xp = {65, 105, 95, 160, 195, 244, 240, 195};
	private int[] s1_yp = {148, 120, 78, 60, 153, 177, 232, 264};
	private int s1_num = 8;
	
	private int[] s2_xp = {175, 195, 244, 387, 378, 360, 352, 315, 249, 210, 202    };
	private int[] s2_yp = {92, 153, 177, 130, 99, 99, 49, 45, 25, 41, 78    };
	private int s2_num = 11;
	
	private int[] s3_xp = {244, 240, 270, 342, 432, 408, 439, 387  };
	private int[] s3_yp = {177, 232, 227, 253, 213, 194, 131, 130 };
	private int s3_num = 8;
	
	
	private int[] s4_xp = {342, 344, 409, 425, 520, 492, 540, 560, 556, 522, 443 };
	private int[] s4_yp = {280, 322, 345, 366, 322, 282, 227, 224, 175, 167, 238  };
	private int s4_num = 11;
	
	private int[] s5_xp = {342, 344, 409, 425, 357, 330, 300, 247, 252, 232, 168, 109, 157, 195, 219, 266  };
	private int[] s5_yp = {280, 322, 345, 366, 401, 385, 426, 403, 376, 372, 418, 332, 265, 287, 288, 252 };
	private int s5_num = 16;
	
	private int[] s6_xp = {157, 109, 154, 117, 56, 19,  10,  32,  11,  54 };
	private int[] s6_yp = {265, 332, 403, 431, 335, 355, 332, 243, 212, 167 };
	private int s6_num = 10;
*/
	
	private String item = "�̼�����";			// ��������
	private LocalDate date = LocalDate.parse("2018-01-01");	// ��¥
					

	public void paint(Graphics g) {
		//setSize(250, 250);
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		//g.drawRect(20, 10, 100, 200);
		makeFill(g);
		
		g.setColor(Color.black);
		g.drawPolygon(Constant.s1_xp, Constant.s1_yp, Constant.s1_num);
		g.drawPolygon(Constant.s2_xp, Constant.s2_yp, Constant.s2_num);
		g.drawPolygon(Constant.s3_xp, Constant.s3_yp, Constant.s3_num);
		g.drawPolygon(Constant.s4_xp, Constant.s4_yp, Constant.s4_num);
		g.drawPolygon(Constant.s5_xp, Constant.s5_yp, Constant.s5_num);
		g.drawPolygon(Constant.s6_xp, Constant.s6_yp, Constant.s6_num);
		
		//System.out.println(date.toString() + " ��¥, ������ " + item);
		//makeFill(g);
		
		
		
	
		
		
		
	}

	private void makeFill(Graphics g) {
		// ������ ������� �����￡ ���� ĥ�Ѵ�.
		
		// s1 �� ����� ���Ѵ�.
		int[] power = {0, 0, 0, 0, 0, 0}; // �׶��̼��� ���� (0~255)
		//power = getColor(1, item);
		
		for (int i=0; i<6; i++) {
			// i sector�� �׶��̼� ���⸦ ���Ѵ�.
			power[i] = getColor(i, item);
			System.out.println(power[i]);
		}
		
		
		
		
		g.setColor(new Color(200, power[0], 10));
		g.fillPolygon(Constant.s1_xp, Constant.s1_yp, Constant.s1_num);
		
		g.setColor(new Color(200, power[1], 10));
		g.fillPolygon(Constant.s2_xp, Constant.s2_yp, Constant.s2_num);
		
		g.setColor(new Color(200, power[2], 10));
		g.fillPolygon(Constant.s3_xp, Constant.s3_yp, Constant.s3_num);
		
		g.setColor(new Color(200, power[3], 10));
		g.fillPolygon(Constant.s4_xp, Constant.s4_yp, Constant.s4_num);
		
		g.setColor(new Color(200, power[4], 10));
		g.fillPolygon(Constant.s5_xp, Constant.s5_yp, Constant.s5_num);
		
		g.setColor(new Color(200, power[5], 10));
		g.fillPolygon(Constant.s6_xp, Constant.s6_yp, Constant.s6_num);
		
		
		
		
		
	}

	private int getColor(int s, String item) {
		double sum = 0;
		double count = 0;
		// ���� ���ʹ� s �� ����.
		// ���� ��¥�� date, ã������ ������ item
		// date�� item �󵵸� �����´�.		
		/*
		for(int i=0; i<Constant.locations.length; i++) {
			Stat resStat = new Stat(0,0,0,0,0,0);
			if(Frame.csvL.findLocation(Constant.locations[i], date) != null) {
				resStat = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
				
				double ppm = 0;
				ppm = resStat.getPpm(item);	// item�� �󵵸� ������
				if(ppm == -1) {
					// ���� ���� �����.
					ppm = 0;
				} else {
					count++;
				}
				sum += ppm;
			}
		}
		*/
		for(int i=0; i < Constant.sectorList.get(s).length; i++) {
			Stat resStat = new Stat(0,0,0,0,0,0);
			if(Frame.csvL.findLocation(Constant.sectorList.get(s)[i], date) != null) {
				resStat = Frame.csvL.findLocation(Constant.sectorList.get(s)[i], date).getStat();
				
				double ppm = 0;
				ppm = resStat.getPpm(item);	// item�� �󵵸� ������
				if(ppm == -1) {
					// ���� ���� �����.
					ppm = 0;
				} else {
					count++;
				}
				sum += ppm;
			}
		}
		// ��ü �������� item�� ����� ����.
		double avg = 0;
		avg = sum/count;
		
		
		System.out.println(sum + " = sum, " + avg);
		int result = 0; // 100 ~ 255
		// �� ���������� �ǰ������ ã�Ƴ���.
		switch (item) {
		case "�̻�ȭ����":
			result = (int) ((avg/0.2) * 100) ;
			break;
		case "������":
			result = (int) ((avg/0.15) * 100) ;		
			break;
		case "�̻�ȭź��":
			result = (int) ((avg/15) * 100) ;		
			break;
		case "��Ȳ�갡��":
			result = (int) ((avg/0.15) * 100) ;			
			break;
		case "�̼�����":
			result = (int) ((avg/150) * 100) ;			
			break;			
		case "�ʹ̼�����":
			result = (int) ((avg/75) * 100) ;
			break;
		}
		
		
		
		return 255-result;
	}

	public void setDate(String searchDate) {
		try {
			this.date = LocalDate.parse(searchDate);	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�߸��� ��¥�� �Է��߽��ϴ�.");
		}
	}

	public void setItem(String string) {
		this.item = string;
		
	}
	
	
	

}
