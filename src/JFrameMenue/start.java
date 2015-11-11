package JFrameMenue;


import javax.swing.*;
import java.awt.*;

public class start {



    JFrame rechner;
    Container container;
    JMenuBar menueLeiste;
    JTextArea textarea;

    JMenu ansicht;
    JMenu bearbeiten;
    JMenu fragzeichen;

    JMenuItem standard;
    JMenuItem wissenschaftlich;
    JMenuItem programmierer;
    JMenuItem statistik;
    JMenuItem verlauf;
    JMenuItem zifferngruppierung;
    JMenuItem basismodus;
    JMenuItem einheitenumrechnung;
    JMenuItem datenumrechnung;
    JMenuItem arbeitsblaetter;

    JMenuItem kopieren;
    JMenuItem einfuegen;


    JMenuItem hilfe;
    JMenuItem info;


    public start() {
        rechner = new JFrame("Rechner");
        container = rechner.getContentPane();
        menueLeiste = new JMenuBar();

        ansicht = new JMenu("Ansicht");
        bearbeiten = new JMenu("Bearbeiten");
        fragzeichen = new JMenu("?");

        standard = new JMenuItem("Standard");
        wissenschaftlich = new JMenuItem("Wissenschaftlich");
        programmierer = new JMenuItem("Programmierer");
        statistik = new JMenuItem("Statistik");
        verlauf = new JMenuItem("Verlauf");
        zifferngruppierung = new JMenuItem("Zifferngruppierung");
        basismodus = new JMenuItem("Basismodus");
        einheitenumrechnung = new JMenuItem("Einheitenumrechnung");
        datenumrechnung = new JMenuItem("Datenumrechnung");
        arbeitsblaetter = new JMenuItem("Arbeitsblätter");

        kopieren = new JMenuItem("Kopieren");
        einfuegen = new JMenuItem("Einfügen");

        hilfe = new JMenuItem("Hilfe");
        info = new JMenuItem("Info");


        menueLeiste.add(ansicht);
        menueLeiste.add(bearbeiten);
        menueLeiste.add(fragzeichen);

        ansicht.add(standard);
        ansicht.add(wissenschaftlich);
        ansicht.add(programmierer);
        ansicht.add(statistik);
        ansicht.add(new JPopupMenu.Separator());
        ansicht.add(verlauf);
        ansicht.add(zifferngruppierung);
        ansicht.add(new JPopupMenu.Separator());
        ansicht.add(basismodus);
        ansicht.add(einheitenumrechnung);
        ansicht.add(datenumrechnung);
        ansicht.add(arbeitsblaetter);

        bearbeiten.add(kopieren);
        bearbeiten.add(einfuegen);
        bearbeiten.add(new JPopupMenu.Separator());
        bearbeiten.add(verlauf);

        fragzeichen.add(hilfe);
        fragzeichen.add(new JPopupMenu.Separator());
        fragzeichen.add(info);





        textarea = new JTextArea();

        rechner.add(menueLeiste, BorderLayout.NORTH);
        rechner.add(new JScrollPane(textarea), BorderLayout.CENTER);

        rechner.setSize(400, 300);
        rechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rechner.setVisible(true);

    }

    public static void main(String[] args) {
        new start();
    }
}

