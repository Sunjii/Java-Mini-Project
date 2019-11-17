
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class CircleGraph extends JPanel {
	int num1;  
	int num2;  
	int num3; 
	
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
		//���� �Էµ����ʾ����� return
		if ((num1 < 0) || (num2 < 0) || (num3 < 0) )
			return;
		//��ü ���� ���Ѵ�
		int total = num1 + num2 + num3;
		if (total == 0)
			return;
		// ��ü������ ������ ����.
		//arc4 = ��ü - (arc1+arc2+arc3)�� ����
		// arc ������ ��
		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		int arc3 = (int) 360.0 * num3 / total;
		
		int arcs[] = {arc1, arc2, arc3};
		// ȣ �׸���. (���۰�, ����)
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
		// ����
		g.setColor(Color.BLACK);
		g.setFont(new Font("����ü", Font.PLAIN, 12));
		g.drawString(Constant.pollut_0 + " : ���", 300, 150);
		g.drawString(Constant.pollut_1 + " : ����", 300, 170);
		g.drawString(Constant.pollut_2 + " : �Ķ�", 300, 190);
		
	}
	// �߽��� x, y�̰� ���հ��� mid_arc�� ���� ���� �ٿ��ִ� �Լ�
	private void drawLabel(int num, int x, int y, int arcs[], int arc, Graphics g) {
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
		//System.out.println(result_x + ", " + result_y + " " + res_arc);
		g.setColor(Color.BLACK);
		g.setFont(new Font("����", Font.BOLD, 20));
		g.drawString(Integer.toString(num), result_x , result_y);
		
	}
	
	
	//���ڰ� �Է¹޴� �޼ҵ�
	public void setNumbers(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

}