import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pomodoro extends JPanel implements ActionListener{
	JPanel pomoControl=new JPanel();

	JButton startButton=new JButton("Start");
	JButton resetButton=new JButton("Reset");
	JLabel timeLabel= new JLabel();
	int elapsedTime= 0;
	int sec=0;
	int min=0;
	int hours=0;
	boolean started=false;
	String secString= String.format("%02d",sec);
	String minString= String.format("%02d",min);
	String hourString= String.format("%02d",hours);

	Timer timer= new Timer(1000, new ActionListener(){

		public void actionPerformed(ActionEvent e){

			elapsedTime+=1000;
			hours=elapsedTime/3600000;
			min=(elapsedTime/60000)%60;
			sec=(elapsedTime/1000)%60;

			secString= String.format("%02d",sec);
			minString= String.format("%02d",min);
			hourString= String.format("%02d",hours);
			timeLabel.setText(hourString+":"+minString+":"+secString);

			if(min==25){
				timer.stop();

				JOptionPane.showConfirmDialog((Component) null,"Take a short Break. If the task is over mark it as done and if it isn't then complete it after the break","Take A Break", JOptionPane.PLAIN_MESSAGE);
			}

		}

	});


	Pomodoro(){

		this.setPreferredSize(new Dimension(400,500));
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		this.setBackground(new Color(54,57,63));
		timeLabel.setText(hourString+":"+minString+":"+secString);
		timeLabel.setPreferredSize(new Dimension(200,100));
		timeLabel.setFont(new Font("MONOSPACED",Font.PLAIN,50));
		timeLabel.setForeground(new Color(255,255,255));
		timeLabel.setBackground(new Color(54,57,63));
  		timeLabel.setBorder(BorderFactory.createEmptyBorder());
		timeLabel.setOpaque(true);
  		timeLabel.setHorizontalAlignment(JLabel.CENTER);

		startButton.setPreferredSize(new Dimension(100,50));
		startButton.setFont(new Font("MONOSPACED",Font.PLAIN,20));
		startButton.setFocusable(false);
	  	startButton.setBorder(BorderFactory.createEmptyBorder());
	  	startButton.setForeground(Color.white);
	  	startButton.setBackground(new Color(79,84,92));
		startButton.addActionListener(this);

		resetButton.setPreferredSize(new Dimension(100,50));
		resetButton.setFont(new Font("MONOSPACED",Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBorder(BorderFactory.createEmptyBorder());
		resetButton.setForeground(Color.white);
		resetButton.setBackground(new Color(79,84,92));
		pomoControl.setBackground(new Color(54,57,63));

		this.add(timeLabel,BorderLayout.CENTER);
		pomoControl.add(startButton);
		pomoControl.add(Box.createHorizontalStrut(18));
		pomoControl.add(resetButton);
		this.add(pomoControl,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton){
			if(started==false){
				started=true;
				startButton.setText("Pause");
				start();
			}
			else{
				started=false;
				startButton.setText("Start");
				stop();
			}
		}
		if(e.getSource()==resetButton) {
		   started=false;
		   startButton.setText("Start");
		   reset();
		}
	}

	void start(){
		timer.start();

	}

	void stop(){
		timer.stop();

	}

	void reset(){
		timer.stop();
		elapsedTime=0;
		sec =0;
		min=0;
		hours=0;
		secString = String.format("%02d", sec);
		minString = String.format("%02d", min);
		hourString = String.format("%02d", hours);
		timeLabel.setText(hourString+":"+minString+":"+secString);

	}
}