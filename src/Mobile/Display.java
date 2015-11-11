package Mobile;

import java.awt.*;
import java.util.List;
import javax.swing.*;


public class Display {

    List<Auto> liste = Mobile.getAutos();
    JList<Auto> list;

    public Display(List<Auto> liste) {


        Auto[] array = new Auto[liste.size()];

        for (int i = 0; i < array.length ; i++)
            array[i]=liste.get(i);



        JFrame frame = new JFrame("mobile.de");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JList<Auto> list = new JList<Auto>(array);
        JScrollPane scrollbar = new JScrollPane(list);


        frame.add(scrollbar);
        frame.setSize(400, 400);
        frame.setLocation(400, 400);
        frame.setVisible(true);


    }




}
