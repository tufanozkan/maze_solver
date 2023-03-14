import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class Problem2GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private Problem2PANEL mazePane;
    private JMenuBar menuBar;
    private JMenu game;
    private JMenu computer;

    private JMenu change;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Problem2GUI frame = new Problem2GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Problem2GUI() {
        setSize(625, 675);
        setResizable(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Maze Game");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Menu Bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menu
        game = new JMenu("Game");
        computer = new JMenu("Computer");
        change=new JMenu("Change");


        menuBar.add(game);
        menuBar.add(computer);
        menuBar.add(change);

        JMenuItem newGame = new JMenuItem(new AbstractAction("New Game") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                mazePane.refresh(mazePane.getCellsMaze());
                repaint();
            }
        });

        JMenuItem algorithm = new JMenuItem(new AbstractAction("Algorithm") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                mazePane.algorithm((Graphics2D) mazePane.getGraphics());
            }
        });

        JMenuItem size=new JMenuItem(new AbstractAction("Size") {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = JOptionPane.showInputDialog(mazePane, "Enter size:");
                int i=Integer.parseInt(result);
                mazePane.refresh(i);
                mazePane.refresh(mazePane.getCellsMaze());
                repaint();
            }

        });

        game.add(newGame);
        computer.add(algorithm);
        change.add(size);

        mazePane = new Problem2PANEL(23);
        contentPane.add(mazePane, BorderLayout.CENTER);
    }
}