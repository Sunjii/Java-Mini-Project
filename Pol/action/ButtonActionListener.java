


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) (e.getSource());

		switch (btn.getText()) {

		case "Open":
			//JOptionPane.showMessageDialog(null, "���� DB����� �̱����Դϴ�.", "������ ����", JOptionPane.ERROR_MESSAGE);
			try {
				Frame.csvL.Read();
				//Frame.data.add();
				Frame.insertTable(Frame.csvL.getlocations());
				//System.out.println(Frame.csvL.getlocations());
				//System.out.println(Frame.data.toString());
				System.out.println(Frame.data.get(0)[0]);
				System.out.println(Frame.data.get(0)[1]);
				System.out.println(Frame.data.get(0)[2]);
				
				Frame.makeTable();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Save":
			try {
				Frame.csvW.Write();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//JOptionPane.showMessageDialog(null, "���� DB����� �̱����Դϴ�.", "������ ����", JOptionPane.ERROR_MESSAGE);
			break;
		case "DBLoad":
			try {
				new InputDatabase();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			InputDatabase.loadData(CSVLoad.locations);
			
			break;
		case "DBSave":
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
				double pol5 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 6)));
				double pol6 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 7)));
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
				double pol5 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 6)));
				double pol6 = Double.valueOf((String) (Frame.resTable.getValueAt(row, 7)));
				System.out.println(row + ", " + col);
				System.out.println(area + " " + pol1);
				
				// ������ ���� ��Ű��
				Frame.bgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5, pol6);
				// �����͸� ������� �׷��� �׸���
				Frame.bgDialog.setVisible(true);
				break;
			default:
				JOptionPane.showMessageDialog(null, "���� �׷����� �ϳ��� Į���� �׸� �� �ֽ��ϴ�.");
				break;
			}
			break;
		case "����":
			System.exit(0);
			break;
			
		}
			
		
	}

	private void loadData(ArrayList<Location> locations) {
		// TODO Auto-generated method stub
		
	}

	
	
}
