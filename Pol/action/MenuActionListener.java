


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) (e.getSource());

		switch (mi.getText()) {

		case "DB 저장":
			JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			break;
		case "DB 불러오기":
			JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			break;
		case "CSV 파일 불러오기":
			JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			break;
		case "CSV 파일 저장하기":
			JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			break;
		case "원형 그래프":
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
				int pol5 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 6)));
				int pol6 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 7)));
				
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
			
		case "꺽은선 그래프":
			// 지역을 선택하고 기간을 입력하는 팝업창을 띄운다
			
			// 해당 기간 데이터 추출
			
			// 데이터 적용
			
			// 데이터 기반으로 그래프 그리기
			
			break;
		case "막대 그래프":
			// 지역을 선택한다
			
			// 막대그래프
			Frame.bgDialog.setVisible(true);
			break;
		
		case "종료":
			System.exit(0);
			break;
			
		}
		
	}

	
	
}
