import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Box;

public class ButtonPanel extends JPanel{
	JButton addTask;
	JButton clear;


	ButtonPanel(){
		this.setPreferredSize(new Dimension(400,60));

		addTask= new JButton("Add new task");
		addTask.setBounds(100, 100, 100, 100);
		addTask.setBorder(BorderFactory.createEmptyBorder());
		addTask.setFont(new Font("MONOSPACED",Font.PLAIN, 18));
		this.add(addTask);

		this.add(Box.createHorizontalStrut(18));

		clear= new JButton("Clear finished Task");
		clear.setBorder(BorderFactory.createEmptyBorder());
		clear.setFont(new Font("MONOSPACED",Font.PLAIN,18));
		this.add(clear);
	}
}