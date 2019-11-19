
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class CircleGraph extends JPanel {
	String area;
	double num1, num2, num3, num4, num5, num6;
	
	int count = 0;
	// �׷��� ��ǥ, ������
	static int pos_x = 50;
	static int pos_y = 20;
	static int radius = 200;
	// �� �׷����� �߽���ǥ
	static int c_x = pos_x + radius/2;
	static int c_y = pos_y + radius/2;
	
	double pai = 3.14;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		//���� ���ٸ� �����Ŵ
		if ((num1 < 0) || (num2 < 0) || (num3 < 0) || (num4 <0) || (num5<0) || (num6<0))
			return;
		//��ü ���� ���Ѵ�
		double total = num1 + num2 + num3 + num4 + num5 + num6;
		if (total == 0)
			return;
		// ��ü������ ������ ����. ������ �� - for
		int arc1 = (int) ((int) 360.0 * num1 / total);
		int arc2 = (int) ((int) 360.0 * num2 / total);
		int arc3 = (int) ((int) 360.0 * num3 / total);
		int arc4 = (int) ((int) 360.0 * num4 / total);
		int arc5 = (int) ((int) 360.0 * num5 / total);
		int arc6 = (int) ((int) 360.0 * num6 / total);
		
		int arcs[] = {arc1, arc2, arc3, arc4, arc5, arc6};
		// ȣ �׸���. (���۰�, ����) - ���߿� for��ȭ ��ų��
		g.setColor(Color.YELLOW);
		g.fillArc(pos_x, pos_y, radius, radius, 0, arc1);
		g.setColor(Color.RED);
		g.fillArc(pos_x, pos_y, radius, radius, arc1, arc2);
		g.setColor(Color.BLUE);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2, arc3);
		g.setColor(Color.GREEN);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2 + arc3, arc4);
		g.setColor(Color.ORANGE);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2 + arc3 + arc4, arc5/*360 - (arc1 + arc2 + arc3 + arc4)*/);
		g.setColor(Color.magenta);
		g.fillArc(pos_x, pos_y, radius, radius, arc1 + arc2 + arc3 + arc4 + arc5, 360 - (arc1 + arc2 + arc3 + arc4 + arc5));
		
		drawLabel(num1, c_x, c_y, arcs, arc1, g);
		drawLabel(num2, c_x, c_y, arcs, arc2, g);
		drawLabel(num3, c_x, c_y, arcs, arc3, g);
		drawLabel(num4, c_x, c_y, arcs, arc4, g);
		drawLabel(num5, c_x, c_y, arcs, arc5, g);
		drawLabel(num6, c_x, c_y, arcs, arc6, g);
		count = 0;
		

		// ����
		g.setColor(Color.BLACK);
		g.setFont(new Font("����ü", Font.BOLD, 20));
		g.drawString(area, 300, 50);
		g.setFont(new Font("����ü", Font.PLAIN, 15));
		g.drawString(Constant.pollut[0], 330, 100);
		g.setColor(Color.YELLOW);
		g.fillRect(300, 85, 18, 18);
		g.setColor(Color.BLACK);
		
		// ���߿� for��ȭ ��ų��
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
		
		g.drawString(Constant.pollut[5], 330, 200);
		g.setColor(Color.MAGENTA);
		g.fillRect(300, 185, 18, 18);
		g.setColor(Color.BLACK);
		
	}
	// �߽��� x, y�̰� ���հ��� mid_arc�� ���� ���� �ٿ��ִ� �Լ�
	private void drawLabel(double num, int x, int y, int arcs[], int arc, Graphics g) {
		int result_x, result_y;
		// ���ݱ����� ������ �� + �̹��� �׸� ���� ���հ�
		int sum = 0;
		for(int i = 0; i < count; i++) {
			sum += arcs[i];
		}
		count++;
		int res_arc = (sum + arc/2);
		
		result_x = (int)( c_x + (Math.cos((res_arc) * (pai/180)) * radius/3));
		result_y = (int)( c_y - (Math.sin((res_arc) * (pai/180)) * radius/3));
		g.setColor(Color.BLACK);
		g.setFont(new Font("����", Font.BOLD, 20));
		g.drawString(Double.toString(num), result_x , result_y);
		
	}
	
	public void setNumbers(double num12, double num22, double num32, double num42, int num5, int num6) {
		this.num1 = num12;
		this.num2 = num22;
		this.num3 = num32;
		this.num4 = num42;
		this.num5 = num5;
		this.num6 = num6;
	}
	
	public void setName(String in) {
		this.area = in;
	}

}