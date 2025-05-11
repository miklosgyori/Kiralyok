import model.Kiraly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Az applikáció logikáját definiáló osztály.
 */
public class Kiralyok {

    /**
     * A file-ból betöltött királyok (Kiraly objektumok) listája.
     */
    private static List<Kiraly> kiralyLista;

    /**
     * A konstuktor hivasaval az adatbetoltes is megtortenik
     */
    public Kiralyok() {
        this.kiralyLista = betolt("data/kiralyok.txt");
    }

    /**
     * A kiralyok listajanak ellenorzott betoltese a parameterkent megadott UTF-8 filebol.
     * @param fajlPathNev A bemeneti adatfile elerese a projektmappahoz viszonyitva
     * @return kiralyLista A beolvasott kiralyokat tartalmazo ArrayList<Kiraly>
     */
    private static List<Kiraly> betolt(String fajlPathNev) {

        List<Kiraly> kiralyLista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fajlPathNev))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        String nev = parts[0].trim();
                        int szuletett = Integer.parseInt(parts[1].trim());
                        int meghalt = Integer.parseInt(parts[2].trim());
                        String haz = parts[3].trim();
                        Kiraly kiraly = new Kiraly(nev, szuletett, meghalt, haz);
                        kiralyLista.add(kiraly);

                        System.out.println("Beolvasva a fajlbol: " + kiralyLista.size() + ". " + kiraly.toString());

                    } catch (NumberFormatException e) {
                        System.err.println("Hibas szamformatum a fajlban: " + line + "; sor szama: " + (kiralyLista.size()+1) );
                    }
                } else {
                    System.err.println("Hibas vagy hianyos adatsor a fajlban: " + line + "; sor szama: " + (kiralyLista.size()+1) );
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba a fajl beolvasasakor: " + e.getMessage());
        }
        return kiralyLista;
    }

    public static void main (String[]args) {

        Kiralyok kiralyok = new Kiralyok();

    }
}
