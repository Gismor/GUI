package SchiebePuzzel;

import org.omg.CORBA.INTERNAL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SchiebePuzzel implements ActionListener {

    private static final int XX = 2
            ;
    private static final int YY = 2;
    private JButton[] buttons = new JButton[XX*YY];
    private int lastButton = 0;
    private Icon lastIcon = null;
    private boolean firstClick = true;

    public SchiebePuzzel () {
        JFrame jf = new JFrame("Schiebepuzzel");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(YY, XX));

        try {
            BufferedImage bim = ImageIO.read(new File("snoopy.jpg"));
            int w = bim.getWidth();
            int h = bim.getHeight();

            for (int y = 0; y < YY; y++){
                for (int x = 0; x < XX; x++){
                    buttons[y*XX+x] = new JButton(  /*Hinzufügen von den Kacheln in das Raster*/
                            new ImageIcon(bim.getSubimage(x*(w/XX), y*(h/YY), w/XX, h/YY))); /*um die breite / hoehe des Teilbildes zu berechnen*/
                    int pos = y*XX+x;
                    buttons[pos].setBorder(new LineBorder(Color.BLACK, 2));
                    buttons[pos].setActionCommand("" + (pos)); /*position des Buttons*/
                    buttons[pos].setName("" + (pos)); /*Pos des Icons*/
                    buttons[pos].addActionListener(this);
                    jf.add(buttons[pos]); /*Teilbild wird eingefuegt am gewuenschten rahmen*/
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        jf.pack();
        jf.setVisible(true);
    }

    /**Liefert true, wenn bei allen JButtons  in buttons der Action Command gleich dem Namen ist*/
    private boolean isDone (){
        for (JButton b : buttons)
            if (!b.getName().equals(b.getActionCommand()))
                return false;
        return true;
    }

    /**Liefert true, falls der JButton an pos neben dem JButton an last Button liegt*/
    private boolean inTouch (int pos){
        return ((pos % XX == lastButton % XX) && Math.abs(pos / XX - lastButton / XX) <2) || ((pos / XX == lastButton / XX) && Math.abs(pos % XX - lastButton % XX) <2); /*abs ganzzahlig oder so...*/
    }

    /**tauscht den Namen und das Icon mit dem Zuletzt gedrückten JButton*/
    private void switchButton (int pos){
        if (inTouch(pos)) {
            buttons[lastButton].setIcon(buttons[pos].getIcon());
            buttons[pos].setIcon((null)); /*So wird das "Bildchen" entfernt und der button wird frei*/
            String h = buttons[pos].getName();
            buttons[pos].setName(buttons[lastButton].getName());
            buttons[lastButton].setName(h);
            lastButton = pos;
        }
    }


    public static void main(String[] args) {
        new SchiebePuzzel();
    } /*startet das Spiel*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (firstClick){
            firstClick = false;
            lastIcon = buttons[0].getIcon();
            buttons[0].setIcon(null);
            for (int i = 0; i < 10000; i++) {
                int zufall = (int) (Math.random() * XX * YY); /*um die Bildchen zu verschieben*/
                switchButton(zufall);
            }
            while (lastButton % XX != 0){/*die beiden whiles dienen nur dem Verschieben des Lochs nach links oben, also sodass das ding immer links oben ist*/
                switchButton(lastButton-1);
            }
            while (lastButton /XX != 0){
                switchButton((lastButton - XX));
            }
        }
        else {
            int pos = Integer.parseInt(e.getActionCommand()); /*welcher button wurde gedrueckt?*/
            switchButton(pos);
            if (isDone()){
                buttons[0].setIcon(lastIcon);
                firstClick = true;
            }
        }
    }
}
