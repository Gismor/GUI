package Mobile;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dneubauer on 11.11.2015.
 */
public class Main {

    public static void main(String[] args) {

        List<Auto> liste = Mobile.getAutos();
        Scanner s = new Scanner(System.in);
        Display display = new Display(liste);


        System.out.println("Was möchten Sie tun");
        System.out.println("1 nach Preis aufwärts");
        System.out.println("2 nach Preis abwärts");
        System.out.println("3 EZ alt nach Jung");
        System.out.println("4 EZ jung nach alt");
        System.out.println("5 km aufwärts");
        System.out.println("6 km rückwärts");
        System.out.println("7 Ende");

        switch(s.next()){

            case "1":
                liste.sort(Auto.SORT_PREIS);
                break;
            case "2":
                liste.sort(Auto.SORT_PREIS_RE);
                break;
            case "3":
                liste.sort(Auto.SORT_EZ);
                break;
            case "4":
                liste.sort(Auto.SORT_EZ_RE);
                break;
            case "5":
                liste.sort(Auto.SORT_KMSTAND);
                break;
            case "6":
                liste.sort(Auto.SORT_KMSTAND_RE);
                break;
            case "7":
                break;
        }
        display = new Display(liste);



    }
}
