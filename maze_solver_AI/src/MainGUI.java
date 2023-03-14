import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    public static void main(String args[]){
        JFrame frame = new JFrame("Maze Problem Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("PROBLEM ONE");
        button.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Do Something Clicked");
            }
        });
        JButton button2 = new JButton("PROBLEM TWO");
        button2.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                Problem2GUI problem2GUI=new Problem2GUI();
                problem2GUI.setVisible(true);
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button2);
        frame.getContentPane().add(panel); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
}
