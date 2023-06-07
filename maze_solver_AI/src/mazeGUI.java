import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import static java.awt.BorderLayout.CENTER;

public class mazeGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private mazePanel mazePane;
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
                    mazeGUI frame = new mazeGUI();
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
    public mazeGUI() {
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
                mazePane.app.count=0;
            }
        });

        JMenuItem algorithm = new JMenuItem(new AbstractAction("Algorithm") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                mazePane.algorithm((Graphics2D) mazePane.getGraphics());
                mazePane.cevir();
                JOptionPane.showMessageDialog(null,"Passing Time: " + mazePane.rslt + " Second");
                JOptionPane.showMessageDialog(null,"Step Count: " + mazePane.app.count);
                mazePane.app.count=0;
            }

        });

        JMenuItem autoMove = new JMenuItem(new AbstractAction("Auto Move") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                mazePane.autoMove((Graphics2D) mazePane.getGraphics());
                mazePane.cevir();
                JOptionPane.showMessageDialog(null,"Passing Time: " + mazePane.rslt + " Second");
                JOptionPane.showMessageDialog(null,"Step Count: " + mazePane.app.count2);
                mazePane.app.count2=0;
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
                mazePane.app.count=0;
            }
        });

        game.add(newGame);
        computer.add(autoMove);
        computer.add(algorithm);
        change.add(size);

        mazePane = new mazePanel(23);
        contentPane.add(mazePane, CENTER);
    }
}