
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class CircleGraph extends JPanel {
	int num1;  
	int num2;  
	int num3; 
	
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
		//값이 입력되지않았으면 return
		if ((num1 < 0) || (num2 < 0) || (num3 < 0) )
			return;
		//전체 합을 구한다
		int total = num1 + num2 + num3;
		if (total == 0)
			return;
		// 전체에서의 비중을 구함.
		//arc4 = 전체 - (arc1+arc2+arc3)로 구함
		// arc 단위는 도
		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		int arc3 = (int) 360.0 * num3 / total;
		
		int arcs[] = {arc1, arc2, arc3};
		// 호 그리기. (시작각, 끝각)
		g.setColor(Color.YELLOW);
		g.fillArc(pos_x, pos_y, radius, radius, 0, arc1);
		g.setColor(Color.RED);
		g.fillArc(pos_x, pos_y, radius, radius, arc1, arc2);
		g.setColor(Color.BLUE);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2, arc3);
		

		
		/*
		int x, y;
		x = (int)( c_x + (Math.cos((arc1/2) * (pai/180)) * radius/2));
		y = (int)( c_y - (Math.sin((arc1/2) * (pai/180)) * radius/2));
		System.out.println(x + ", " + y + " " + arc1);
		g.drawString(Integer.toString(num1), x , y);
		//g.drawString("H", c_x, c_y);
		*/
		
		drawLabel(num1, c_x, c_y, arcs, arc1, g);
		drawLabel(num2, c_x, c_y, arcs, arc2, g);
		drawLabel(num3, c_x, c_y, arcs, arc3, g);
		count = 0;
		
		//System.out.printf("%d %d %d", arc1, arc2, arc3);
		// 범례
		g.setColor(Color.BLACK);
		g.setFont(new Font("굴림체", Font.PLAIN, 12));
		g.drawString(Constant.pollut_0 + " : 노랑", 300, 150);
		g.drawString(Constant.pollut_1 + " : 빨강", 300, 170);
		g.drawString(Constant.pollut_2 + " : 파랑", 300, 190);
		
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
		//System.out.println(result_x + ", " + result_y + " " + res_arc);
		g.setColor(Color.BLACK);
		g.setFont(new Font("굵게", Font.BOLD, 20));
		g.drawString(Integer.toString(num), result_x , result_y);
		
	}
	
	
	//숫자값 입력받는 메소드
	public void setNumbers(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

}