import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;


public class TitleBar extends JPanel{

	TitleBar(){
		this.setPreferredSize(new Dimension(500,80));
		JLabel titleText= new JLabel("StudentApp");
		titleText.setPreferredSize(new Dimension(300,75));
		titleText.setFont(new Font("MONOSPACED",Font.BOLD, 20));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		this.add(titleText);
	}
	
}