package Checkboxen;

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

        JCheckBox rot = new JCheckBox("Rot");
        JCheckBox blau = new JCheckBox("Blau");
        JCheckBox gruen = new JCheckBox("Grün");
        JCheckBox cyan = new JCheckBox("Cyan");
        JCheckBox magenta = new JCheckBox("Magenta");
        JCheckBox gelb = new JCheckBox("Gelb");


        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.getContentPane().setBackground(new Color(
                        rot.isSelected() ? 255 : 0,
                        gruen.isSelected() ? 255 : 0,
                        blau.isSelected() ? 255 : 0
                ));
            }
        };

        rot.addActionListener(al);
        gruen.addActionListener(al);
        blau.addActionListener(al);

        jp.add(rot);
        jp.add(gruen);
        jp.add(blau);

        jf.add(jp, BorderLayout.NORTH);
        jf.setSize(400,400);
        jf.setVisible(true);

    }
}
