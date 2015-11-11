package Mobile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Mobile {

    public static List getAutos () {
        LinkedList<String> dateien = findeDateien();
        List<String> con = new LinkedList<>();
        for (String s : dateien) {
            try (BufferedReader br = new BufferedReader(new FileReader(s))) {
                String line = "";
                while ((line = br.readLine()) != null)
                    con.add(line);
            } catch (IOException e) {
                System.out.println("Fäler beihm Lehsen . . .");
            }
        }

        List<Auto> autos = new ArrayList<>();

        for (int index = 0; index < con.size(); index++) {
            if (con.get(index).matches("\\w{2,3}\\s-\\s\\d{5}\\s\\w+.*")) {
                List<String> daten = new LinkedList<>();
                index--;
                while (!con.get(index).startsWith("Finanzierung, Versicherung") &&
                        !con.get(index).startsWith("FinanzierungVersicherungParken")) {
                    daten.add(con.get(index));
                    index++;
                }
                Auto tmp = Auto.baueAuto(daten);
                if (tmp != null)
                    autos.add(tmp);
            }
        }
        return autos;
    }

    public static LinkedList<String> findeDateien() {
        String pfadName = "Y://3_XI//XI_6//302_SOP_OOP//Autos//";
        String dateiName = ".txt";
        LinkedList<String> datei = new LinkedList<>();
        File file;
        for (int i = 1; i < 255; i++) {
            dateiName = "Autos_" + i + ".txt";
            file = new File(pfadName + dateiName);
            if (file.exists())
                datei.add(pfadName + dateiName);
        }
        System.out.println("Es wurden " + datei.size() + " Dateien gefunden!");
        return datei;
    }

}
