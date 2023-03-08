import javax.swing.*;
public class MainGUI {
    public static void main(String args[]){
        JFrame frame = new JFrame("Maze Problem Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("PROBLEM ONE");
        JButton button2 = new JButton("PROBLEM TWO");
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button2);
        frame.getContentPane().add(panel); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
}
