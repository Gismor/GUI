package Sodoku;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dneubauer on 24.11.2015.
 */
public class Sodoku {




    public Sodoku (){
        JFrame jf = new JFrame("Sodoku");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());

        JPanel jpNorth = new JPanel();
        jf.add(jpNorth, BorderLayout.NORTH);

        JPanel jpSouth = new JPanel();
        jf.add(jpSouth, BorderLayout.SOUTH);

        JPanel jpCenter = new JPanel();
        jf.add(jpCenter,BorderLayout.CENTER);


        jpNorth.setLayout(new BorderLayout());
        JLabel Zeit = new JLabel("Zeit 03:13");
        jpNorth.add(Zeit, BorderLayout.WEST);

        JButton neu = new JButton("Neu");
        jpNorth.add(neu, BorderLayout.EAST);



        jpCenter.setLayout(new GridLayout(3,3));




        jpSouth.setLayout(new GridLayout(2, 6));

        JButton eins = new JButton("1");
        JButton zwei = new JButton("2");
        JButton drei = new JButton("3");
        JButton vier = new JButton("4");
        JButton fuenf = new JButton("5");
        JButton sechs = new JButton("6");
        JButton sieben = new JButton("7");
        JButton acht = new JButton("8");
        JButton neun = new JButton("9");

        JPanel Buttons = new JPanel();
        JButton radierer = new JButton(new ImageIcon("Radiergummi.png"));
        JButton reset = new JButton("Reset");






        Buttons.add(radierer,BorderLayout.WEST);
        Buttons.add(reset,BorderLayout.CENTER);


        jpSouth.add(eins);
        jpSouth.add(zwei);
        jpSouth.add(drei);
        jpSouth.add(vier);
        jpSouth.add(fuenf);
        jpSouth.add(sechs);
        jpSouth.add(sieben);
        jpSouth.add(acht);
        jpSouth.add(neun);
        jpSouth.add(Buttons);
















        jf.setVisible(true);
    }






    public static void main(String[] args) {
        new Sodoku();
    }
}
