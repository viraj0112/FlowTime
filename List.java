import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class List extends JPanel{
	List(){
		GridLayout layout= new GridLayout(10,1);
		layout.setVgap(5);
		this.setLayout(layout);
	}

	public void updateNumbers(){
		Component[] listItems= this.getComponents();

		for(int i=0;i<listItems.length;i++){
			if(listItems[i] instanceof Task){
				((Task)listItems[i]).changeIndex(i+1);
			}
		}
	}

	public void removeTask(){
		Component[] listItems= this.getComponents();

		for(int i=0;i<listItems.length;i++){
			if(listItems[i] instanceof Task){
					if(((Task)listItems[i]).getStatus()==true){
					this.remove((Task)listItems[i]);
				};
			}
		}

	}
}