


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ButtonActionListener implements ActionListener{

	
	DefaultTableModel dtm = new DefaultTableModel();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) (e.getSource());

		switch (btn.getText()) {

		case "Open":
			//JOptionPane.showMessageDialog(null, "���� DB����� �̱����Դϴ�.", "������ ����", JOptionPane.ERROR_MESSAGE);
			try {
				Frame.csvL.Reset();
				Frame.csvL.Read();
				// �ʱ�ȭ
				int rowCount = Frame.model.getRowCount();
				for(int i=0; i<rowCount; i++) {
					Table.deleteTable(0, Frame.model);
				}	
				Frame.model.fireTableDataChanged();
				// ������ �߰�
				Frame.insertTable(Frame.csvL.getlocations(), Frame.model);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "Save":
			try {
				Frame.csvW.Write();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(e1);
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
			//Table.deleteTable(0, Frame.model);
			
			
			
			
			
			// ������ �����ϰ� �Ⱓ�� �Է��ϴ� �˾�â�� ����
			
			// �ش� �Ⱓ ������ ����
			
			// ������ ����
			
			// ������ ������� �׷��� �׸���
			// Frame.lgDialog.setVisible(true);
			break;
		case "Graph 3":
			// ����׷���. ��¥�� ������ �ϳ�����. ��� ���� ��� 
			// ��¥ ����
			String inputDate = JOptionPane.showInputDialog("��¥�� �Է��ϼ���. ex) 2018-01-06");
			// inputDate ��ȿ�� ����
			try{
				LocalDate localDate = LocalDate.parse(inputDate);
				Frame.bgDialog.setDate(localDate);
			} catch(Exception err) {
				JOptionPane.showMessageDialog(null, "�߸��� ��¥�Դϴ�!", "�Է¿���", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// �������� ����(1��)
			String[] values = Constant.pollut;
			Object selected = JOptionPane.showInputDialog(null, "��ȸ�ϰ� ���� ���������� �ϳ� �����ϼ���.", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
			if ( selected != null ){ 
			    Frame.bgDialog.setItem(selected.toString());
			}else{
			    //System.out.println("User cancelled");
			}
			
			
			Frame.bgDialog.setVisible(true);
			
			/*
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
			*/
			break;
		case "Data":
			// ������ ���� â�� ���
			Frame.tbDialog.setVisible(true);
			
			
			
			
			break;
		case "�˻�":
			// ���̺� �ʱ�ȭ �� ������ ���Է�.
			
			
			
			try {
				Frame.csvL.Reset();
				Frame.csvL.Read();
				Frame.insertTable(Frame.csvL.getlocations(), Frame.model);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			String searchDate = Frame.inputDate.getText();
			ArrayList<String[]> search_result = new ArrayList<String[]>();

			for (int i=0; i < Frame.model.getRowCount(); i++) {
				// date�� ��ġ�ϴ� ���� ������ ����Ʈ�� ���� �߰���.
				if(searchDate.equals(Frame.model.getValueAt(i, 1))) {
					String[] in = new String[8];
					for(int j=0; j<8; j++) {
						in[j] = (String) Frame.model.getValueAt(i, j);
					}
					search_result.add(in);
				}
			}
			// ���� ȭ���� ���̺� ���� ����
			if(search_result.size() > 0) {
				int count = Frame.model.getRowCount();
				for(int i=0; i<count; i++) {
					Frame.model.removeRow(0);
				}
				// search_result�� �̿��� ���̺� �����
				for (int i=0; i<search_result.size(); i++) {
					Frame.model.addRow(search_result.get(i));
				}	
			} else {// �˻� ����� ���� ���.
				JOptionPane.showMessageDialog(null, "��ġ�ϴ� �˻� ����� �����ϴ�!");
			}
			
			
			break;
		case "����":
			System.exit(0);
			break;
			
		}
			
		
	}



	
	
}
