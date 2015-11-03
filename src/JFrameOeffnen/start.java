package JFrameOeffnen;

import javax.swing.*;

/**
 * Created by dneubauer on 03.11.2015.
 */
public class start {

    public static void main(String[] args) {


        JFrame test = new JFrame("Variante 1");
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.setLocation(300, 200);
        test.setSize(300, 300);
        test.setVisible(true);

        new MeinFenster();
        new Aufgabe1();
    }


}


