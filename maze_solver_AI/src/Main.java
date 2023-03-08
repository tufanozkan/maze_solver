import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Obstacle obstacle=new Obstacle(11);
        obstacle.generate();
        Problem2GUI pr = new Problem2GUI();
    }
}