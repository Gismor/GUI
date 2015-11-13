package ereignismodell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dneubauer on 10.11.2015.
 */
public class start {

    public static void main(String[] args) {



        JFrame jf = new JFrame("ROT");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jb = new JButton("ROT");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    jf.getContentPane().setBackground(Color.RED);

                }
            });


            jf.add(jb ,BorderLayout.NORTH);
            jf.setSize(400,400);
            jf.setVisible(true);


        }

    }


