import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BarGraph extends JPanel{
	
	int gap;

	double num[] = {0, 0, 0, 0, 0, 0}; // ���������� ��
	double max[] = {0.060, 0.060, 3, 0.050, 200, 130}; // ������������ �ִ밪
	
	int bar_w = 10; // ����׷��� ��
	int bar_h; // ����׷��� ����
	
	int s_x, s_y; // ���� ������ ��ǥ

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W, Constant.dial_H);
		
		// �׷��� Ʋ
		g.setColor(Color.black);
		g.drawRect(40, 40, 420, 280);
		gap = 420 / 6; // ����
		// x��
		for(int i=0; i<6; i++) {
			g.drawLine(40+gap, 40+280, 40+gap, 40);
			g.drawString(Constant.pollut[i], (gap)-20, 40+280+15);
			gap += 420/6;
		}
		// y��
		for(int i=0; i<10; i++) {
			g.drawLine(40, 40+(i*28), 40+420, 40+(i*28));
			g.drawString(Integer.toString(100 - i*10), 40-22, 40+(i*28));
		}
		
		// num1 ~ num6�� ���� �׷��� �׸���
		// bar_h : ��밪. 
		// s_y : 40 ~ 320
		gap = 420/6;
		for (int i=0; i<6; i++) {
			System.out.println(num[i]);
		}
		
		for(int i=0; i<6; i++) {
			s_x = 40 + gap/2;
			bar_h = (int) (num[i] / max[i] * 100);
			s_y = 320 - bar_h;
			gap += 420/3;
			g.setColor(Color.red);
			g.fillRect(s_x, s_y, bar_w, bar_h);		
		}
		
		
		
		
		
	}
	
	public void setNumbers(double num1, double num2, double num3, double num4, double num5, double num6) {
		num[0] = num1;
		num[1] = num2;
		num[2] = num3;
		num[3] = num4;
		num[4] = num5;
		num[5] = num6;
	}
	
	
}
