package SchiebePuzzel;

import javafx.scene.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dneubauer on 17.11.2015.
 */
public class SchiebePuzzel implements ActionListener {

    private static final int XX = 4;
    private static final int YY = 3;
    private JButton[] buttons = new JButton[XX * YY];
    private int lastButton = 0;
    private Icon lastIcon = null;
    private boolean firstClick = true;


    public SchiebePuzzel() {
        JFrame jf = new JFrame("SchiebePuzzel");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(YY, XX));
        try {
            BufferedImage bi = ImageIO.read(new File("snoopy.jpg"));
            int w = bi.getWidth();
            int h = bi.getHeight();
            for (int y = 0; y < YY; y++)
                for (int x = 0; x < XX; x++) {
                    buttons[y * XX + x] = new JButton(
                            new ImageIcon(
                                    bi.getSubimage(x * (w / XX), y * (h / YY), w / XX, h / YY)));

                    buttons[y * XX + x].setBorder(new LineBorder(Color.black, 2));
                    buttons[y * XX + x].setActionCommand("" + (y * XX + x));
                    buttons[y * XX + x].setName("" + (y * XX + x));
                    buttons[y * XX + x].addActionListener(this);
                    jf.add(buttons[y * XX + x]);
                }


        } catch (IOException e) {
            e.printStackTrace();
        }
        jf.pack();
        jf.setVisible(true);
    }


    public static void main(String[] args) {


        new SchiebePuzzel();

    }

    private boolean isDone() {
        for (JButton b : buttons)
            if (!b.getName().equals(b.getActionCommand()))
                return false;
        return true;
    }

    private boolean inTouch(int pos) {
        return
                ((pos % XX == lastButton % XX) &&
                        Math.abs(pos / XX - lastButton / XX) < 2) ||
                        ((pos / XX == lastButton / XX) &&
                                Math.abs(pos % XX - lastButton % XX) < 2);
    }

    private void switchButton(int pos) {
        if (inTouch(pos)) {
            buttons[lastButton].setIcon(buttons[pos].getIcon());
            buttons[pos].setIcon(null);
            String h = buttons[pos].getName();
            buttons[pos].setName(buttons[lastButton].getName());
            buttons[lastButton].setName(h);
            lastButton = pos;
        }
    }


    public void actionPerformed(ActionEvent e) {

        if(firstClick){
            firstClick=false;
            buttons[0].setIcon(null);
        }
        int pos = Integer.parseInt (e.getActionCommand());
        switchButton(pos);
    }
}
