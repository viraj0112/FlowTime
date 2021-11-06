import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Dimension;

public class Task extends JPanel{
	JLabel srno;
	JTextField taskName;
	JButton done,complete;
	Boolean status;

	Task(){
		this.setPreferredSize(new Dimension(40,20));
		this.setLayout(new BorderLayout());

		status=false;

		srno= new JLabel();
		srno.setPreferredSize(new Dimension(20,20));
		srno.setHorizontalAlignment(JLabel.CENTER);
		this.add(srno,BorderLayout.WEST);

		taskName= new JTextField("Enter your task");
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setBackground(Color.gray);

		this.add(taskName,BorderLayout.CENTER);

		done= new JButton("done");
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());

		this.add(done,BorderLayout.EAST);
	}
}