package EreignisModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dneubauer on 13.11.2015.
 */
public class start {

    public static void main(String[] args) {


        JFrame jf = new JFrame("Farben");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel jp = new JPanel();

        JRadioButton rot = new JRadioButton("Rot");
        rot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.getContentPane().setBackground(Color.RED);

            }
        });

        JRadioButton blau = new JRadioButton("Blau");
        blau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.getContentPane().setBackground(Color.blue);

            }
        });

        JRadioButton gruen = new JRadioButton("Grün");
        gruen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.getContentPane().setBackground(Color.yellow);

            }
        });

        ButtonGroup bg = new ButtonGroup();
        bg.add(rot);
        bg.add(blau);
        bg.add(gruen);

        jp.add(rot);
        jp.add(blau);
        jp.add(gruen);



        jf.add(jp, BorderLayout.NORTH);
        jf.setSize(400,400);
        jf.setVisible(true);



    }
}
