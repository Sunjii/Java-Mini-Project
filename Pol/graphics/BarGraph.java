import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BarGraph extends JPanel{
	
	int gap;
	double num1, num2, num3, num4;
	int num5, num6; // �� ������������ ��
	
	double max[] = {0.150, 0.300, 3, 0.150, 200, 130};
	
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
		
		// num1 ~ num5�� ���� �׷��� �׸���
		// bar_h : ��밪. 
		// s_y : 40 ~ 320
		gap = 420/6;
		for(int i=0; i<6; i++) {
			s_x = 40 + gap/2;
			//s_y = 320;	// ������ �ְ���
			
			
			
			
			
			bar_h = 280 + 40 - s_y;	// ���� ����
			gap += 420/3;
			g.setColor(Color.red);
			g.fillRect(s_x, s_y, bar_w, bar_h);
			
			
		}
		
		
		
		
		
	}
	
	public void setNumbers(double num1, double num2, double num3, double num4, int num5, int num6) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
	}
	
	
}
