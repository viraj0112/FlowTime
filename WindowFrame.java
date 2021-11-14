import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// import javax.swing.JScrollPane;


public class WindowFrame extends JFrame{
	TitleBar title;
	ButtonPanel btnPanel;
	Pomodoro pomodoro;
	List list;
	JButton addTask, done, clear;
	JPanel todoPanel= new JPanel();

	WindowFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("TempoBoy");
		this.setPreferredSize(new Dimension(800,650));

		pomodoro=new Pomodoro();
		title=new TitleBar();
		list=new List();
		btnPanel=new ButtonPanel();
		todoPanel.setPreferredSize(new Dimension(300,500));
		todoPanel.setLayout(new BorderLayout());

		// JScrollPane scrollTasks=new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(title,BorderLayout.NORTH);
		todoPanel.add(list,BorderLayout.WEST);
		todoPanel.add(btnPanel,BorderLayout.SOUTH);
		this.add(todoPanel,BorderLayout.CENTER);
		this.add(pomodoro,BorderLayout.EAST);
		addTask=btnPanel.getAddTask();
		clear= btnPanel.getClear();


		addListeners();
		this.setMinimumSize(new Dimension(800,650));
		this.pack();
		this.setVisible(true);
		// this.add(scrollTasks);
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

		// clear.addMouseListener(new MouseAdapter(){
		// 	public void mousePressed(MouseEvent a){
		// 		list.removeTask();
		// 		repaint();
		// 	}
		// });
	}

	public static void main(String[] args) {
		new WindowFrame();	
	}
}