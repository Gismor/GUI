package JListModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dneubauer on 01.12.2015.
 */
public class start {


    private int zahl = 1;


    public start() {

        MyModel lm = new MyModel();
        JList<Integer> jl = new JList<>(lm);
        JButton b = new JButton("ADD");
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                lm.add(zahl++);
            }
        });


        JFrame jf = new JFrame("List Test");
        jf.setLayout(new BorderLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JScrollPane scrollen = new JScrollPane(jl);

        jf.add(b, BorderLayout.SOUTH);
        jf.add(scrollen, BorderLayout.NORTH);
        jf.setSize(300, 300);
        jf.setLocation(400, 500);
        jf.setVisible(true);

    }





    public static void main(String[] args) {

        new start();
    }







    private class MyModel implements ListModel<Integer> {




        List<Integer> liste = new ArrayList<>();
        List<ListDataListener> ldls = new ArrayList<>();

        public int getSize() {
            return liste.size();
        }


        public Integer getElementAt(int index) {
            return liste.get(index);
        }


        public void addListDataListener(ListDataListener l) {
            ldls.add(l);
        }


        public void removeListDataListener(ListDataListener l) {
            ldls.remove(l);

        }

        public void add(Integer zahl){
            liste.add(zahl);
            for (ListDataListener l : ldls)
                l.contentsChanged( new ListDataEvent(
                        this,
                        ListDataEvent.CONTENTS_CHANGED,
                        0,
                        liste.size()-1));

        }
    }

}
