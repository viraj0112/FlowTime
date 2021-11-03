import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class WindowFrame extends JFrame{
	TitleBar title;
	ButtonPanel btnPanel;
	List list;

	WindowFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("StudentApp");
		this.setPreferredSize(new Dimension(500,700));

		title=new TitleBar();
		list=new List();
		btnPanel=new ButtonPanel();
		this.add(title,BorderLayout.NORTH);
		this.add(btnPanel,BorderLayout.SOUTH);
		this.add(list,BorderLayout.CENTER);
		// this.add(Task,)
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new WindowFrame();	
	}
}