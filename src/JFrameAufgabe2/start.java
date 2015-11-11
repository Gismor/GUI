package JFrameAufgabe2;

import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dneubauer on 06.11.2015.
 */
public class start {

    public static void main(String[] args) {

        JFrame test1 = new JFrame("daserste");
        test1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel Text1 = new JLabel("Hallo1", JLabel.CENTER);
        test1.add(Text1);
        test1.setLocation(300, 200);
        test1.setSize(300, 300);
        test1.setVisible(true);

        JFrame test2 = new JFrame("daszweite");
        test2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel Text2 = new JLabel("Hallo2", JLabel.CENTER);
        test2.add(Text2);
        test2.setLocation(800, 200);
        test2.setSize(300, 300);
        test2.setVisible(true);


        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        f.setLayout(new BorderLayout());

        f.add(newJLabel("North", Color.PINK), BorderLayout.NORTH);
        f.add(newJLabel("East", Color.BLUE),BorderLayout.EAST);
        f.add(newJLabel("South", Color.GREEN),BorderLayout.SOUTH);

        f.add(newJLabel("Center", Color.RED),BorderLayout.CENTER);
        f.add(newJLabel("West", Color.YELLOW),BorderLayout.WEST);


        f.setSize(400, 150);
        f.setVisible(true);



    }

    private static JLabel newJLabel(String text, Color c) {
        JLabel ret = new JLabel(text, JLabel.CENTER);
        ret.setBackground(c);
        ret.setOpaque(true);

        return ret;
    }




}
