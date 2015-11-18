package Mobile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class Display implements ActionListener {


    private List<Auto> autos = Mobile.getAutos();
    private JList<Auto> garage = new JList<>();

    public Display() {

        garage.setListData(autos.toArray(new Auto[autos.size()]));
        JFrame frame = new JFrame("Mobile");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(garage);

        JMenuBar menuBar = new JMenuBar();

        JMenu sortieren = new JMenu("Sortieren");

        menuBar.add(sortieren);
        JMenuItem preisauf = new JMenuItem("Preis aufwärts");
        preisauf.addActionListener(this);
        preisauf.setActionCommand("Preisauf");
        sortieren.add(preisauf);

        JMenuItem preisab = new JMenuItem("Preis abwärts");
        preisab.addActionListener(this);
        preisab.setActionCommand("Preisab");
        sortieren.add(preisab);

        JMenu sortierenEZ = new JMenu("Sortieren nach EZ");
        sortieren.add(sortierenEZ);


        JMenuItem ezauf = new JMenuItem("EZ aufwärts");
        ezauf.addActionListener(this);
        ezauf.setActionCommand("EzAuf");
        sortierenEZ.add(ezauf);

        JMenuItem ezab = new JMenuItem("EZ abwärts");
        ezab.addActionListener(this);
        ezab.setActionCommand("EzAb");
        sortierenEZ.add(ezab);


        JPanel panelWest = new JPanel();
        panelWest.setLayout(new GridLayout(6, 1));


        JButton ezAuf = new JButton("EzAuf");
        ezAuf.addActionListener(this);
        ezAuf.setActionCommand("EzAuf");
        panelWest.add(ezAuf);
        JButton ezAb = new JButton("EzAb");
        ezAb.addActionListener(this);
        ezAb.setActionCommand("EzAb");
        panelWest.add(ezAb);


        frame.add(panelWest, BorderLayout.WEST);
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane);
        frame.setSize(800, 800);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Preisauf":
                autos.sort(Auto.SORT_PREIS);
                garage.setListData(autos.toArray(new Auto[autos.size()]));
                break;
            case "Preisab":
                autos.sort(Auto.SORT_PREIS_RE);
                garage.setListData(autos.toArray(new Auto[autos.size()]));
                break;
            case "EzAuf":
                autos.sort(Auto.SORT_EZ);
                garage.setListData(autos.toArray(new Auto[autos.size()]));
                break;
            case "EzAb":
                autos.sort(Auto.SORT_EZ_RE);
                garage.setListData(autos.toArray(new Auto[autos.size()]));
                break;


        }


    }
}
