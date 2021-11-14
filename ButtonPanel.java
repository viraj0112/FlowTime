import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel{
	JButton addTask;
	JButton clear;


	ButtonPanel(){
		this.setPreferredSize(new Dimension(400,60));

		addTask= new JButton("Add new task");
		addTask.setPreferredSize(new Dimension(150,50));
		addTask.setBorder(BorderFactory.createEmptyBorder());
		addTask.setFont(new Font("MONOSPACED",Font.BOLD, 13));
		addTask.setFocusable(false);
		this.add(addTask);

		this.add(Box.createHorizontalStrut(18));

		clear= new JButton("Clear finished Task");
		clear.setPreferredSize(new Dimension(170,50));
		clear.setBorder(BorderFactory.createEmptyBorder());
		clear.setFont(new Font("MONOSPACED",Font.BOLD,13));
		clear.setFocusable(false);
		this.add(clear);
	}

	public JButton getAddTask(){
		return addTask;
	}

	public JButton getClear(){
		return clear;
	}
}