import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleBar extends JPanel{
	JButton settingButton = new JButton("Setting");
	
	TitleBar(){
		this.setPreferredSize(new Dimension(500,80));
		JLabel titleText= new JLabel("FLOWTIME APP");
		titleText.setPreferredSize(new Dimension(300,75));
		titleText.setFont(new Font("Manjari",Font.BOLD, 30));
		titleText.setForeground(Color.white);
		titleText.setHorizontalAlignment(JLabel.CENTER);

		this.add(titleText);
		
		settingButton.setBounds(100, 160, 200, 40);
		settingButton.setFocusable(false);
		settingButton.addActionListener(this);
	}
	
	@Override
		public void actionPerformed(ActionEvent e){
			if (e.getSource()== settingButton) {
				
				NewWindow newwindow = new NewWindow();
			} 
		}
}
