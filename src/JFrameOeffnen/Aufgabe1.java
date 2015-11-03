package JFrameOeffnen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dneubauer on 03.11.2015.
 */
public class Aufgabe1 extends JFrame {

    public Aufgabe1() {
        super("Aufgabe 1");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel ersterText = new JLabel("Hallo Welt",JLabel.CENTER);
        add(ersterText);
        ersterText.setForeground(Color.RED);
        ersterText.setBackground(Color.GREEN);
        ersterText.setOpaque(true);
        ersterText.setFont(ersterText.getFont().deriveFont(40.0f));
        setLocation(400, 600);
        setSize(400,400);
        setVisible(true);

    }
}
