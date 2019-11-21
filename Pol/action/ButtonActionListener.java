


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
			//JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
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
			//JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
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
			// 테이블에서 어딘가 선택되었을때만 그려지도록 한다.
			switch(Frame.resTable.getSelectedRowCount()) {
			case 0:
				JOptionPane.showMessageDialog(null, "선택된 칼럼이 없습니다!");
				break;
			case 1:
				// 선택한 칼럼에서 데이터 가져오기
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
				
				// 데이터 적용 시키기
				Frame.cgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5, pol6);
				// 데이터를 기반으로 그래프 그리기
				Frame.cgDialog.setVisible(true);
				break;
			default:
				JOptionPane.showMessageDialog(null, "원형 그래프는 하나의 칼럼만 그릴 수 있습니다.");
				break;
					
			}			
			
			break;
		case "Graph 2":
			// 지역을 선택하고 기간을 입력하는 팝업창을 띄운다
			
			// 해당 기간 데이터 추출
			
			// 데이터 적용
			
			// 데이터 기반으로 그래프 그리기
			// Frame.lgDialog.setVisible(true);
			break;
		case "Graph 3":
			// 지역 하나와 날짜 하나를 고른다.
			switch(Frame.resTable.getSelectedRowCount()) {
			case 0:
				JOptionPane.showMessageDialog(null, "선택된 칼럼이 없습니다!");
				break;
			case 1:
				// 선택한 칼럼에서 데이터 가져오기
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
				
				// 데이터 적용 시키기
				Frame.bgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5, pol6);
				// 데이터를 기반으로 그래프 그리기
				Frame.bgDialog.setVisible(true);
				break;
			default:
				JOptionPane.showMessageDialog(null, "막대 그래프는 하나의 칼럼만 그릴 수 있습니다.");
				break;
			}
			break;
		case "종료":
			System.exit(0);
			break;
			
		}
			
		
	}

	private void loadData(ArrayList<Location> locations) {
		// TODO Auto-generated method stub
		
	}

	
	
}
