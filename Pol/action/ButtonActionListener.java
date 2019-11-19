


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) (e.getSource());

		switch (btn.getText()) {

		case "Open":
			JOptionPane.showMessageDialog(null, "���� DB����� �̱����Դϴ�.", "������ ����", JOptionPane.ERROR_MESSAGE);
			break;
		case "Save":
			JOptionPane.showMessageDialog(null, "���� DB����� �̱����Դϴ�.", "������ ����", JOptionPane.ERROR_MESSAGE);
			break;
		case "Graph 1":
			// ���̺��� ��� ���õǾ������� �׷������� �Ѵ�.
			switch(Frame.resTable.getSelectedRowCount()) {
			case 0:
				JOptionPane.showMessageDialog(null, "���õ� Į���� �����ϴ�!");
				break;
			case 1:
				// ������ Į������ ������ ��������
				int row = Frame.resTable.getSelectedRow();
				int col = Frame.resTable.getSelectedColumn();
				
				String area = (String) Frame.resTable.getValueAt(row, 0);
				double pol1 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 2)));
				double pol2 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 3)));
				double pol3 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 4)));
				double pol4 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 5)));
				int pol5 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 6)));
				int pol6 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 7)));
				System.out.println(row + ", " + col);
				System.out.println(area + " " + pol1);
				
				// ������ ���� ��Ű��
				Frame.cgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5, pol6);
				// �����͸� ������� �׷��� �׸���
				Frame.cgDialog.setVisible(true);
				break;
			default:
				JOptionPane.showMessageDialog(null, "���� �׷����� �ϳ��� Į���� �׸� �� �ֽ��ϴ�.");
				break;
					
			}			
			
			break;
		case "Graph 2":
			// ������ �����ϰ� �Ⱓ�� �Է��ϴ� �˾�â�� ����
			
			// �ش� �Ⱓ ������ ����
			
			// ������ ����
			
			// ������ ������� �׷��� �׸���
			// Frame.lgDialog.setVisible(true);
			break;
		case "Graph 3":
			// ���� �ϳ��� ��¥ �ϳ��� ����.
			
			// �ش� ������ ����
			
			// ������ ����
			
			// ������ ������� ���� �׷��� �׸���
			Frame.bgDialog.setVisible(true);
			
			break;
		case "����":
			System.exit(0);
			break;
			
		}
			
		
	}

	
	
}
