


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
			JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			break;
		case "Save":
			JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
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
				int pol1 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 2)));
				int pol2 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 3)));
				int pol3 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 4)));
				int pol4 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 5)));
				int pol5 = Integer.valueOf((String) (Frame.resTable.getValueAt(row, 6)));

				System.out.println(row + ", " + col);
				System.out.println(area + " " + pol1);
				
				// 데이터 적용 시키기
				Frame.cgDialog.setNumbers(pol1, pol2, pol3, pol4, pol5);
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
		
		case "종료":
			System.exit(0);
			break;
			
		}
			
		
	}

	
	
}
