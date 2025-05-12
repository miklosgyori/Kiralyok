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

    private static final String PATH_TO_DATAFILE = "data/kiralyok.txt";
    /**
     * A file-ból betöltött királyok (Kiraly objektumok) listája.
     */
    private static List<Kiraly> kiralyLista;


    /**
     * A konstuktor hivasaval az adatbetoltes is megtortenik
     */
    public Kiralyok() {
        this.kiralyLista = betolt();
    }

    /**
     * A kiralyok listajanak ellenorzott betoltese a parameterkent megadott UTF-8 filebol.     *
     * @return kiralyLista A beolvasott kiralyokat tartalmazo ArrayList<Kiraly>
     */
    private static List<Kiraly> betolt() {

        List<Kiraly> kiralyLista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_DATAFILE))) {
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

    /**
     * A leghosszabb eletu Kiraly kivalasztasa a kiralyListabol; maximumkereses.
     * Mivel lehetseges, hogy egynel tobb talalat van, listat adunk vissza.
     * @param kiralyLista ArrayList<Kiraly>, a Kiralyok teljes listaja
     * @return legtovabbELtLista ArrayList<Kiraly>, a legtovabb elt Kiralyok listaja
     */
    private static List<Kiraly> legtovabbelt(List<Kiraly> kiralyLista) {

        List<Kiraly> legtovabbELtLista = new ArrayList<>();

        if ( !kiralyLista.isEmpty() ){

            int maxKor = 0;
            for (Kiraly kiraly : kiralyLista) {
                int kor = kiraly.életkor();
                if (kor > maxKor) {
                    legtovabbELtLista.clear();
                    legtovabbELtLista.add(kiraly);
                    maxKor = kor;
                } else if (kor == maxKor) {
                    legtovabbELtLista.add(kiraly);
                }
            }
        } else {
         System.err.println("Nem tudok legtovabb elt kiralyt keresni, mert ures a lista!");
        }
        return legtovabbELtLista;
    }

    public static void main (String[]args) {

        Kiralyok kiralyok = new Kiralyok();

        System.out.println("\n1. feladat:\nA legtovabb elt kiraly(ok) a teljes listabol:");
        for ( Kiraly kiraly : legtovabbelt(kiralyLista) ) {
            System.out.println(kiraly.toString());
        }
    }
}
