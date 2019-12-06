


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) (e.getSource());

		switch (mi.getText()) {

		case "DB ����":
			
			
			break;
		case "DB �ҷ�����":
			try {
				new InputDatabase();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			InputDatabase.loadData(CSVLoad.locations);
			
			
			break;
		case "CSV ���� �ҷ�����":
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
			Frame.setOpen(true);
			break;
		case "CSV ���� �����ϱ�":
			try {
				Frame.csvW.Write();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(e1);
			}
			break;
		case "���� �׷���":
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
		case "������ �׷���":
			Frame.lgDialog.init();
			// ���� �׷���. ���۳�¥, ����¥, ������ �����ϰ� �׷��� â ���
			if (Frame.getOpen() != true) {
				JOptionPane.showMessageDialog(null, "���� �����͸� �ҷ��;��մϴ�!");
				return;
			}
			// ������ �����ϰ� �Ⱓ�� �Է��ϴ� �˾�â�� ����
			try{
				LocalDate start = LocalDate.parse(JOptionPane.showInputDialog("�����ϴ� ��¥�� �Է��ϼ���. ex) 2018-01-06"));
				LocalDate end = LocalDate.parse(JOptionPane.showInputDialog("������ ��¥�� �Է��ϼ���. ex) 2018-01-16"));
				Frame.lgDialog.setDate(start, end);
			} catch(Exception err) {
				JOptionPane.showMessageDialog(null, "�߸��� ��¥�Դϴ�!", "�Է¿���", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// ���� ����
			String[] locations = Constant.locations;
			Object selectedLocation = JOptionPane.showInputDialog(null, "��ȸ�ϰ� ���� ������ �ϳ� �����ϼ���.\n��ü�� �������Դϴ�.", "Selection", JOptionPane.DEFAULT_OPTION, null, locations, "1");
			if ( selectedLocation != null ){ 
			    Frame.lgDialog.setLocation(selectedLocation.toString());
			}else{
			    //System.out.println("User cancelled");
			}
			// �������� ����(1��)
			String[] values1 = Constant.pollut;
			Object selected1 = JOptionPane.showInputDialog(null, "��ȸ�ϰ� ���� ���������� �ϳ� �����ϼ���.", "Selection", JOptionPane.DEFAULT_OPTION, null, values1, "0");
			if ( selected1 != null ){ 
				Frame.lgDialog.setItem(selected1.toString());			    
			}else{
			    JOptionPane.showMessageDialog(null, "item selection Error !!!", "Unknowun Error", JOptionPane.ERROR_MESSAGE);
			}
			
			Frame.lgDialog.setVisible(true);
			break;
		case "���� �׷���":
			// ����׷���. ��¥�� ������ �ϳ�����. ��� ���� ��� 
			if (Frame.getOpen() != true) {
				JOptionPane.showMessageDialog(null, "���� �����͸� �ҷ��;��մϴ�!");
				return;
			}
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
			break;
		case "Ư�� �Ⱓ ������ ��跮 ��ȸ":
			
			
			break;
		case "Ư�� ������ ��跮 ��ȸ":
			// �� �������� Ư�� �Ⱓ������ ��跮�� ����
						// �ʱ�ȭ
						Frame.stDialog.init();
						
						
						// �Ⱓ �Է�
						// �� �Ⱓ���� A ������ ���� ���� ��, ���� ��.  B ������ ���� ������ ������. ...
						
						// ���� �Է�â
						if (Frame.getOpen() != true) {
							JOptionPane.showMessageDialog(null, "���� �����͸� �ҷ��;��մϴ�!");
							return;
						}
						// �Ⱓ�� �Է��ϴ� �˾�â�� ����
						
						try{
							LocalDate start = LocalDate.parse(JOptionPane.showInputDialog("�����ϴ� ��¥�� �Է��ϼ���. ex) 2018-01-06"));
							LocalDate end = LocalDate.parse(JOptionPane.showInputDialog("������ ��¥�� �Է��ϼ���. ex) 2018-01-16"));
							//System.out.println(start.toString() + end.toString());
							Frame.stDialog.setDate(start, end);
							//Frame.stDialog.setType(0);
						} catch(Exception err) {
							JOptionPane.showMessageDialog(null, "�߸��� ��¥�Դϴ�!", "�Է¿���", JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						// ���� ����â�� ����.
						String[] ls = Constant.locations;
						Object selectedL = JOptionPane.showInputDialog(null, "��ȸ�ϰ� ���� ������ �ϳ� �����ϼ���.\n��ü�� �������Դϴ�.", "Selection", JOptionPane.DEFAULT_OPTION, null, ls, "1");
						if ( selectedL != null ){ 
						    Frame.stDialog.setLocation(selectedL.toString());
						}else{
						    //System.out.println("User cancelled");
						}
						
						
						//Frame.stDialog.repaint();
						//Frame.stDialog.revalidate();
						Frame.stDialog.setType(0);
						Frame.stDialog.setVisible(true);
			
			break;
		case "������ �߰� �� ����":
			Frame.tbDialog.setVisible(true);
			
			break;
		case "�������� �ǰ����":
			Frame.txDialog.setVisible(true);
			
			break;
		
		case "����":
			System.exit(0);
			break;
			
		}
		
	}

	
	
}
