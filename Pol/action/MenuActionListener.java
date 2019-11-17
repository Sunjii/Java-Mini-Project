
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
		case "지역별 조회":
			Frame.gDialog.setVisible(true);
			break;
		case "기간별 조회":
			break;
		
		case "종료":
			System.exit(0);
			break;
			
		}
		
	}

	
	
}
