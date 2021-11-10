import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class WindowFrame extends JFrame{
	TitleBar title;
	ButtonPanel btnPanel;
	List list;
	JButton addTask, done, clear;

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

		addTask=btnPanel.getAddTask();
		clear= btnPanel.getClear();

		addListeners();

		this.pack();
		this.setVisible(true);
	}

	public void addListeners(){
		addTask.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				Task task= new Task();
				list.add(task);
				list.updateNumbers();

				task.getDone().addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						task.changeState();
					}
				});
				revalidate();
			}
		});
	}

	public static void main(String[] args) {
		new WindowFrame();	
	}
}