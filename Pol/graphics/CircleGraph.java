
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class CircleGraph extends JPanel {
	private String area;

	private double num[] = {0, 0, 0, 0, 0, 0}; // ���������� ��
	private double relative_num[] = {0, 0, 0, 0, 0, 0};
	private double max[] = {0.060, 0.060, 3, 0.050, 200, 130}; // ������������ �ִ밪
	
	private int count = 0;
	// �׷��� ��ǥ, ������
	private static int pos_x = 50;
	private static int pos_y = 20;
	private static int radius = 200;
	// �� �׷����� �߽���ǥ
	private static int c_x = pos_x + radius/2;
	private static int c_y = pos_y + radius/2;
	
	private double pai = 3.14;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		//���� ���ٸ� �����Ŵ
		if ((num[0] < 0) || (num[1] < 0) || (num[2] < 0) || (num[3] <0) || (num[4]<0) || (num[5]<0))
			return;	
		// num ���� ��밪ȭ ��Ų��.
		for (int i=0; i<6; i++) {
			relative_num[i] = num[i] / max[i] * 100;
		}	
		//��ü ���� ���Ѵ�
		double total = 0;
		for (int i=0; i<6; i++) {
			total += relative_num[i];
		}
		if (total == 0)
			return;
		// ��ü������ ������ ����. ������ ��
		int arc[] = {0, 0, 0, 0, 0, 0};
		for(int i=0; i<6; i++) {
			arc[i] = (int) ((int) 360.0 * relative_num[i] / total);
		}
		// ȣ �׸���. (���۰�, ����) - ���߿� for��ȭ ��ų��
		g.setColor(Color.YELLOW);
		g.fillArc(pos_x, pos_y, radius, radius, 0, arc[0]);
		g.setColor(Color.RED);
		g.fillArc(pos_x, pos_y, radius, radius, arc[0], arc[1]);
		g.setColor(Color.BLUE);
		g.fillArc(pos_x, pos_y, radius, radius, arc[0] + arc[1], arc[2]);
		g.setColor(Color.GREEN);
		g.fillArc(pos_x, pos_y, radius, radius, arc[0] + arc[1] + arc[2], arc[3]);
		g.setColor(Color.ORANGE);
		g.fillArc(pos_x, pos_y, radius, radius, arc[0] + arc[1] + arc[2] + arc[3], arc[4]/*360 - (arc1 + arc2 + arc3 + arc4)*/);
		g.setColor(Color.magenta);
		g.fillArc(pos_x, pos_y, radius, radius, arc[0] + arc[1] + arc[2] + arc[3] + arc[4], 360 - (arc[0] + arc[1] + arc[2] + arc[3] + arc[4]));
		
		for(int i=0; i<6; i++) {
			drawLabel(num[i], c_x, c_y, arc, arc[i], g);
		}
		count = 0;

		// ����
		g.setColor(Color.BLACK);
		g.setFont(new Font("���� ���", Font.BOLD, 20));
		g.drawString(area, 300, 50);
		g.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		// ���߿� for��ȭ ��ų��
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
		g.setFont(new Font("���� ���", Font.PLAIN, 20));
		g.drawString(Double.toString(num), result_x , result_y);
		
	}
	
	public void setNumbers(double num1, double num2, double num3, double num4, double num5, double num6) {
		num[0] = num1;
		num[1] = num2;
		num[2] = num3;
		num[3] = num4;
		num[4] = num5;
		num[5] = num6;
	}
	
	public void setName(String in) {
		this.area = in;
	}

}