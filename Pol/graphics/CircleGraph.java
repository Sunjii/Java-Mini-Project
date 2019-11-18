
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class CircleGraph extends JPanel {
	String area;
	int num1, num2, num3, num4, num5;
	
	int count = 0;
	// 그래프 좌표, 반지름
	static int pos_x = 50;
	static int pos_y = 20;
	static int radius = 200;
	// 원 그래프의 중심좌표
	static int c_x = pos_x + radius/2;
	static int c_y = pos_y + radius/2;
	
	double pai = 3.14;

	public void paint(Graphics g) {
		
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		//값이 없다면 종료시킴
		if ((num1 < 0) || (num2 < 0) || (num3 < 0) || (num4 <0) || (num5<0))
			return;
		//전체 합을 구한다
		int total = num1 + num2 + num3 + num4 + num5;
		if (total == 0)
			return;
		// 전체에서의 비중을 구함. 단위는 도
		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		int arc3 = (int) 360.0 * num3 / total;
		int arc4 = (int) 360.0 * num4 / total;
		int arc5 = (int) 360.0 * num5 / total;
		
		int arcs[] = {arc1, arc2, arc3, arc4, arc5};
		// 호 그리기. (시작각, 끝각)
		g.setColor(Color.YELLOW);
		g.fillArc(pos_x, pos_y, radius, radius, 0, arc1);
		g.setColor(Color.RED);
		g.fillArc(pos_x, pos_y, radius, radius, arc1, arc2);
		g.setColor(Color.BLUE);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2, arc3);
		g.setColor(Color.GREEN);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2 + arc3, arc4);
		g.setColor(Color.ORANGE);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2 + arc3 + arc4, 360 - (arc1 + arc2 + arc3 + arc4));
		
		drawLabel(num1, c_x, c_y, arcs, arc1, g);
		drawLabel(num2, c_x, c_y, arcs, arc2, g);
		drawLabel(num3, c_x, c_y, arcs, arc3, g);
		drawLabel(num4, c_x, c_y, arcs, arc4, g);
		drawLabel(num5, c_x, c_y, arcs, arc5, g);
		count = 0;
		

		// 범례
		g.setColor(Color.BLACK);
		g.setFont(new Font("굴림체", Font.BOLD, 20));
		g.drawString(area, 300, 50);
		g.setFont(new Font("굴림체", Font.PLAIN, 15));
		g.drawString(Constant.pollut[0], 330, 100);
		g.setColor(Color.YELLOW);
		g.fillRect(300, 85, 18, 18);
		g.setColor(Color.BLACK);
		
		g.drawString(Constant.pollut[1], 330, 120);
		g.setColor(Color.RED);
		g.fillRect(300, 105, 18, 18);
		g.setColor(Color.BLACK);
		
		g.drawString(Constant.pollut[2], 330, 140);
		g.setColor(Color.BLUE);
		g.fillRect(300, 125, 18, 18);
		g.setColor(Color.BLACK);
		
		g.drawString(Constant.pollut[3], 330, 160);
		g.setColor(Color.GREEN);
		g.fillRect(300, 145, 18, 18);
		g.setColor(Color.BLACK);
		
		g.drawString(Constant.pollut[4], 330, 180);
		g.setColor(Color.ORANGE);
		g.fillRect(300, 165, 18, 18);
		g.setColor(Color.BLACK);
		
	}
	// 중심이 x, y이고 사잇각이 mid_arc인 원에 라벨을 붙여주는 함수
	private void drawLabel(int num, int x, int y, int arcs[], int arc, Graphics g) {
		int result_x, result_y;
		// 지금까지의 각들의 합 + 이번에 그릴 원의 사잇각
		int sum = 0;
		for(int i = 0; i < count; i++) {
			sum += arcs[i];
		}
		count++;
		int res_arc = (sum + arc/2);
		
		result_x = (int)( c_x + (Math.cos((res_arc) * (pai/180)) * radius/3));
		result_y = (int)( c_y - (Math.sin((res_arc) * (pai/180)) * radius/3));
		g.setColor(Color.BLACK);
		g.setFont(new Font("굵게", Font.BOLD, 20));
		g.drawString(Integer.toString(num), result_x , result_y);
		
	}
	
	public void setNumbers(int num1, int num2, int num3, int num4, int num5) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
	}
	
	public void setName(String in) {
		this.area = in;
	}

}