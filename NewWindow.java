import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class NewWindow{
    int a;

    NewWindow(){
        String temp = JOptionPane.showInputDialog(null, "Time: ");
        System.out.println(temp);
        a = Integer.parseInt(temp);
        
        // temp = JOptionPane.showInputDialog(parentComponent, message)
        JOptionPane.showMessageDialog(null, "Time setted: "+a);
    }
}
