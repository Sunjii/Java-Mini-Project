


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
				int pol1 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 2)));
				int pol2 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 3)));
				int pol3 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 4)));
				int pol4 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 5)));
				int pol5 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 6)));

				System.out.println(row + ", " + col);
				System.out.println(area + " " + pol1);
				
				// ������ ���� ��Ű��
				Frame.cgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5);
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
		
		case "����":
			System.exit(0);
			break;
			
		}
			
		
	}

	
	
}
