import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Map extends JPanel {
	
	// 1구역의 x, y 좌표들
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
	
	private String item = "미세먼지";			// 오염물질
	private LocalDate date = LocalDate.parse("2018-01-01");	// 날짜
					

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
		
		//System.out.println(date.toString() + " 날짜, 아이템 " + item);
		//makeFill(g);
		
		
		
	
		
		
		
	}

	private void makeFill(Graphics g) {
		// 구역의 평균으로 폴리곤에 색을 칠한다.
		
		// s1 의 평균을 구한다.
		int[] power = {0, 0, 0, 0, 0, 0}; // 그라데이션의 세기 (0~255)
		//power = getColor(1, item);
		
		for (int i=0; i<6; i++) {
			// i sector의 그라데이션 세기를 구한다.
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
		// 현재 섹터는 s 번 섹터.
		// 현재 날짜는 date, 찾으려는 물질은 item
		// date의 item 농도를 가져온다.		
		/*
		for(int i=0; i<Constant.locations.length; i++) {
			Stat resStat = new Stat(0,0,0,0,0,0);
			if(Frame.csvL.findLocation(Constant.locations[i], date) != null) {
				resStat = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
				
				double ppm = 0;
				ppm = resStat.getPpm(item);	// item의 농도를 가져옴
				if(ppm == -1) {
					// 값이 없는 경우임.
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
				ppm = resStat.getPpm(item);	// item의 농도를 가져옴
				if(ppm == -1) {
					// 값이 없는 경우임.
					ppm = 0;
				} else {
					count++;
				}
				sum += ppm;
			}
		}
		// 전체 지역에서 item의 평균을 구함.
		double avg = 0;
		avg = sum/count;
		
		
		System.out.println(sum + " = sum, " + avg);
		int result = 0; // 100 ~ 255
		// 각 오염물질의 권고기준을 찾아낸다.
		switch (item) {
		case "이산화질소":
			result = (int) ((avg/0.2) * 100) ;
			break;
		case "오존농도":
			result = (int) ((avg/0.15) * 100) ;		
			break;
		case "이산화탄소":
			result = (int) ((avg/15) * 100) ;		
			break;
		case "아황산가스":
			result = (int) ((avg/0.15) * 100) ;			
			break;
		case "미세먼지":
			result = (int) ((avg/150) * 100) ;			
			break;			
		case "초미세먼지":
			result = (int) ((avg/75) * 100) ;
			break;
		}
		
		
		
		return 255-result;
	}

	public void setDate(String searchDate) {
		try {
			this.date = LocalDate.parse(searchDate);	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못된 날짜를 입력했습니다.");
		}
	}

	public void setItem(String string) {
		this.item = string;
		
	}
	
	
	

}
