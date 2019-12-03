import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LineGraph extends JPanel {
	
	private static final int bar_w = 10; // ����׷��� ��
	private int bar_h; // ����׷��� ����
	
	private static final int graph_pos_x = 40; // �׷��� Ʋ ������ǥ
	private static final int graph_pos_y = 40;
	private static final int graph_w = 620;	// �׷��� ��  420 620
	private static final int graph_h = 480;	// �׷��� ���� 280 480

	
	
	private int s_x, s_y; // ���� ������ ��ǥ
	private int gap;

	private LocalDate dateS, dateE;
	private LocalDate bufD;
	private String location;
	private String item;
	private int type;
	private int dateLength; // +1 �ؾ� dateE ���� ����
	
	private ArrayList<String> dateList = new ArrayList<String>();
	
	//private int xArr[];
	//private int yArr[];
	
	// ���� �Ⱓ ���� �� ������ ��ġ�� ������ �׷����� ǥ��
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Constant.dial_W+600, Constant.dial_H+300);
		
		setType(item);
		
		// �Ⱓ ���
		Period period = Period.between(dateS, dateE);
		if (period.getDays() > 15) {
			JOptionPane.showMessageDialog(null, "�ִ� 14�ϱ����� ��ȸ�����մϴ�!");
			return;
		}
		dateLength = period.getDays();
		dateLength++; // +1 �ؾ� dateE ���� ����
		bufD = dateS;
		
		// dateList�� �Է�
		for (int i=0; i< dateLength; i++) {
			dateList.add(bufD.plusDays(i).toString());
			//bufD.plusDays(1); // bufD �� ��ü�� ��ȯ��Ű�°� �ƴ�...
		}
		
		// Ʋ ¥��
		g.setColor(Color.black);
		// x��
		gap = graph_w / dateLength;
		g.drawLine(graph_pos_x, graph_pos_y+graph_h, graph_pos_x, graph_pos_y);
		for (int i=0; i < dateLength; i++) {
			g.drawLine(graph_pos_x+gap, graph_pos_y+graph_h, graph_pos_x+gap, graph_pos_y);	// x �࿡ ������ ��
			String d = dateList.get(i).split("-")[1] + "-" + dateList.get(i).split("-")[2];
			g.drawString(d, gap, graph_pos_y + graph_h + 15);
			gap += graph_w / dateLength;	
		}
		
		// y��
		for (int i=0; i<10; i++) {
			//g.drawLine(x1, y1, x2, y2);
			double dou = Constant.pollut_max[type] - i *(Constant.pollut_max[type]/10);
			String str = String.format("%.3f", dou);
			g.drawString(str, graph_pos_x-22, graph_pos_y+(i*48));
			
		}
		
		
		// �׷��� �׸���
		
		// �� ��¥������ y���� ���
		gap = graph_w / dateLength;
		gap -= 20;
		int [] xArr = new int [dateLength];
		int [] yArr = new int [dateLength];
		
		// ���� �������� �迭�� �ִ´�.
		for (int i=0; i<dateLength; i++) {
			xArr[i] = graph_pos_x+gap;
			//yArr[i] = 150 + (i*10);
			int buf = getPoint(i, dateList, item);
			if (buf < 0) {
				buf = 0;
			}
			buf = graph_pos_y + graph_h - buf;
			yArr[i] = buf;
			gap += graph_w / dateLength;
		}
		
		// ���� �׸���.
		g.setColor(Color.red);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5)); // �� ���� ����
		g.drawPolyline(xArr, yArr, dateLength);
		
	}


	// i��° ���� item �󵵸� ����Ͽ� ��ȯ.
	private int getPoint(int i, ArrayList<String> dateList, String item) {
		
		// dateS �� i �� �̿��Ͽ� ã������ ��¥�� �����.
		LocalDate curD = LocalDate.parse(dateList.get(i));
		
		// location���� curD�� item �󵵸� Ž��.
		Stat resStat = new Stat(0,0,0,0,0,0);
		if(Frame.csvL.findLocation(this.location, curD) != null) {
			resStat = Frame.csvL.findLocation(this.location, curD).getStat();
		} else {
			return -1; // ������ ����
		}
		
		// resStat ���� ���ϴ� item�� �󵵸� Ž��.
		double ppm = -1;
		ppm = resStat.getPpm(item);
		if (ppm == -1) {
			return -1; // ������ ����
		}
		
		// 10ĭ�� max, 1ĭ �� 48px
		// ã�Ƴ� ppm�� ��밪ȭ ��Ų��. �� ���������� �� ������ max�� �����Ѵ�.
		for (int k=0; k<Constant.pollut.length; k++) {
			if(item.equals(Constant.pollut[k])) {
				//double result = (ppm / Constant.pollut_max[k] * 100); // ex) 21  == 21%.. �� 2.1ĭ		
				//return (int)(result / 10 * 48);
				double result = (ppm / Constant.pollut_max[k] * 100);
				//System.out.println(i + "�� " + location + "�� " + item + " " + ppm);
				return (int)(result / 10 * 48);
				
			}
		}
		return -1;
	}



	public void init() {
		dateList.clear();
		
	}

	public void setDate(LocalDate start, LocalDate end) {
		this.dateS = start;
		this.dateE = end;
	}

	public void setLocation(String string) {
		this.location = string;
	}

	private void setType(String item) {
		switch (item) {
		case "�̻�ȭ����":
			this.type = 0;
			break;
		case "������":
			this.type = 1;
			break;
		case "�̻�ȭź��":
			this.type = 2;
			break;
		case "��Ȳ�갡��":
			this.type = 3;
			break;
		case "�̼�����":
			this.type = 4;
			break;
		case "�ʹ̼�����":
			this.type = 5;
			break;
		}
		
	}



	public void setItem(String selectedItem) {
		this.item = selectedItem;
		
	}
	
	
	
}
