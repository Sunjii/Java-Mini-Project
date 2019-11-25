


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
			//JOptionPane.showMessageDialog(null, "아직 DB기능은 미구현입니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			try {
				Frame.csvL.Reset();
				Frame.csvL.Read();
				// 초기화
				int rowCount = Frame.model.getRowCount();
				for(int i=0; i<rowCount; i++) {
					Table.deleteTable(0, Frame.model);
				}	
				Frame.model.fireTableDataChanged();
				// 데이터 추가
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
			//Table.deleteTable(0, Frame.model);
			
			
			
			
			
			// 지역을 선택하고 기간을 입력하는 팝업창을 띄운다
			
			// 해당 기간 데이터 추출
			
			// 데이터 적용
			
			// 데이터 기반으로 그래프 그리기
			// Frame.lgDialog.setVisible(true);
			break;
		case "Graph 3":
			// 막대그래프. 날짜와 물질을 하나선택. 모든 지역 출력 
			// 날짜 선택
			String inputDate = JOptionPane.showInputDialog("날짜를 입력하세요. ex) 2018-01-06");
			// inputDate 유효성 검증
			try{
				LocalDate localDate = LocalDate.parse(inputDate);
				Frame.bgDialog.setDate(localDate);
			} catch(Exception err) {
				JOptionPane.showMessageDialog(null, "잘못된 날짜입니다!", "입력오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// 오염물질 선택(1개)
			String[] values = Constant.pollut;
			Object selected = JOptionPane.showInputDialog(null, "조회하고 싶은 오염물질을 하나 선택하세요.", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
			if ( selected != null ){ 
			    Frame.bgDialog.setItem(selected.toString());
			}else{
			    //System.out.println("User cancelled");
			}
			
			
			Frame.bgDialog.setVisible(true);
			
			/*
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
			*/
			break;
		case "Data":
			// 데이터 수정 창을 출력
			Frame.tbDialog.setVisible(true);
			
			
			
			
			break;
		case "검색":
			// 테이블 초기화 및 데이터 재입력.
			
			
			
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
				// date와 일치하는 행을 가지고 리스트로 만들어서 추가함.
				if(searchDate.equals(Frame.model.getValueAt(i, 1))) {
					String[] in = new String[8];
					for(int j=0; j<8; j++) {
						in[j] = (String) Frame.model.getValueAt(i, j);
					}
					search_result.add(in);
				}
			}
			// 현재 화면의 테이블 전부 삭제
			if(search_result.size() > 0) {
				int count = Frame.model.getRowCount();
				for(int i=0; i<count; i++) {
					Frame.model.removeRow(0);
				}
				// search_result를 이용해 테이블 재생성
				for (int i=0; i<search_result.size(); i++) {
					Frame.model.addRow(search_result.get(i));
				}	
			} else {// 검색 결과가 없는 경우.
				JOptionPane.showMessageDialog(null, "일치하는 검색 결과가 없습니다!");
			}
			
			
			break;
		case "종료":
			System.exit(0);
			break;
			
		}
			
		
	}



	
	
}
