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
			break;
		case "Graph 2":
			break;
		
		case "����":
			System.exit(0);
			break;
			
		}
			
		
	}

	
	
}
