import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;


public class List extends JPanel{
	List(){
		GridLayout layout= new GridLayout(10,1);
		layout.setVgap(5);

		this.setLayout(layout);
	}
}