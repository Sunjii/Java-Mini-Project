import java.awt.Color;
import java.awt.Graphics;
import java.lang.management.GarbageCollectorMXBean;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import oracle.jdbc.Const;

public class BarGraph extends JPanel{
	//private double num[] = {0, 0, 0, 0, 0, 0}; // ���������� ��
	//private double max[] = {0.060, 0.060, 3, 0.050, 200, 130}; // ������������ �ִ밪
	
	private static final int bar_w = 10; // ����׷��� ��
	private int bar_h; // ����׷��� ����
	
	private static final int graph_pos_x = 40; // �׷��� Ʋ ������ǥ
	private static final int graph_pos_y = 40;
	private static final int graph_w = 420;	// �׷��� ��
	private static final int graph_h = 280;	// �׷��� ����
	
	private int s_x, s_y; // ���� ������ ��ǥ
	private int gap;
	
	private LocalDate date; // �׸� ��¥
	private String item; // �׸� ��������
	
	
	int plus = 1600;  // ����׷������� �߰��� �þ�� ��

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W + plus, Constant.dial_H);
		
		gap = (graph_w+plus) / (Constant.locations.length -1); // ����. 46������
		// �׷��� Ʋ
		g.setColor(Color.black);
		// x��
		for(int i=1; i < Constant.locations.length; i++) {
			g.drawLine(graph_pos_x+gap, graph_pos_y+graph_h, graph_pos_x+gap, graph_pos_y);
			g.drawString(Constant.locations[i], (gap), graph_pos_y + graph_h + 15);
			//gap += 420/6;
			gap += (graph_w + plus) / (Constant.locations.length -1);
		}
		// y��
		for(int i=0; i<10; i++) {
			g.drawLine(graph_pos_x, graph_pos_y+(i*28), graph_pos_x+graph_w+plus, graph_pos_y+(i*28));
			g.drawString(Integer.toString(100 - i*10), graph_pos_x-22, graph_pos_y+(i*28));
		}
		

		gap = (graph_w+plus) / (Constant.locations.length -1);
		// �� ������ date �� item �󵵸� �׸���.
		for (int i=1; i < Constant.locations.length - 1; i++) {
			// ������ x��ǥ�� gap�� �ٽ� �����մϴ�.
			s_x = graph_pos_x + gap/2;
			gap += ( (graph_w + plus)/(Constant.locations.length -1) ) * 2  ;
			// ���� i�� date���� item�� �󵵸� �����ɴϴ�.
			//System.out.println(Constant.locations[i] + " ������ " + date + " �� " + item + " ��...");
			// ������ ���̸� ����մϴ�. �����Ͱ� ���� ��쿡�� -1�� ��ȯ�˴ϴ�.
			bar_h = getBar(i, date, item);
			if (bar_h < 0) {
				bar_h = 0;
			}
			// ������ ���̸� �̿��Ͽ� ������ y��ǥ�� ����մϴ�.
			s_y = graph_pos_y + graph_h - bar_h;
			
			g.setColor(Color.red);
			g.fillRect(s_x, s_y, bar_w, bar_h);
		}

	}
	
	private int getBar(int i, LocalDate date, String item) {
		// i��° ���� (1���� ����) �� date���� item�� �ش��ϴ� ���������� �󵵸� �������� �Լ�

		// i �� date �������� Ž��
		Stat resStat = new Stat(0,0,0,0,0,0);
		// findLocation�Ŀ� null�̸� getStat�� �������� �ʵ��� �ٲ۴�.
		if(Frame.csvL.findLocation(Constant.locations[i], date) != null) {
			resStat = Frame.csvL.findLocation(Constant.locations[i], date).getStat();
		} else {
			// �ش� ��¥�� ������ �����Ͱ� ���� ��쿡�� return -1
			return -1;
		}

		// item�� �󵵸� Ž��. ������ -1 ��ȯ
		double ppm = -1;
		ppm = resStat.getPpm(item);
		if(ppm == -1) {
			return -1; // �� ����
		}
		
		// ã�Ƴ� ppm�� ��밪ȭ ��Ų��. �� ���������� �� ������ max�� �����Ѵ�.
		for (int k=0; k<Constant.pollut.length; k++) {
			if(item.equals(Constant.pollut[k])) {
				return (int)(ppm / Constant.pollut_max[k] * 100);
			}
		}
		
		return -1;
		
	}

	/*
	public void setNumbers(double num1, double num2, double num3, double num4, double num5, double num6) {
		num[0] = num1;
		num[1] = num2;
		num[2] = num3;
		num[3] = num4;
		num[4] = num5;
		num[5] = num6;
	}
	*/

	public void setDate(LocalDate selectedLocalDate) {
		this.date = selectedLocalDate;
	}

	public void setItem(String selectedItem) {
		this.item = selectedItem;
	}
	
	
}
