import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


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
		// this.setUndecorated(true);
		this.setBackground(new Color(54,57,63));

		pomodoro=new Pomodoro();
		title=new TitleBar();
		list=new List();
		btnPanel=new ButtonPanel();
		todoPanel.setLayout(new BorderLayout());
		todoPanel.setSize(700, 400);
		todoPanel.setBackground(new Color(54,57,63));
		list.setBackground(new Color(54,57,63));
		title.setBackground(new Color(115,135,180));
		btnPanel.setBackground(new Color(54,57,63));
		JScrollPane scrollTasks=new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTasks.setComponentZOrder(scrollTasks.getVerticalScrollBar(), 0);
		scrollTasks.setBackground(new Color(54,57,63));
		scrollTasks.setBorder(BorderFactory.createEmptyBorder());
		
		this.add(title,BorderLayout.NORTH);
		todoPanel.add(scrollTasks,BorderLayout.CENTER);
		todoPanel.add(btnPanel,BorderLayout.SOUTH);
		this.add(todoPanel,BorderLayout.WEST);
		this.add(pomodoro,BorderLayout.EAST);
		addTask=btnPanel.getAddTask();
		clear= btnPanel.getClear();


		addListeners();
		this.setMinimumSize(new Dimension(800,650));
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

		clear.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent a){
				list.removeTask();
				list.updateNumbers();
				repaint();
			}
		});
		revalidate();
	}

	public static void main(String[] args) {
		new WindowFrame();	
	}
}