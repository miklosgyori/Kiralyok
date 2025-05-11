package test;

import model.Kiraly;

/**
 * A Kiraly osztály tesztelésére.
 */
public class testKiraly {

    public static void main(String[] args){
        Kiraly tesztkiraly = new Kiraly("Teszt Kiraly", 1900, 2025, "Kiralyi Haz");
        System.out.println(tesztkiraly.toString());
        System.out.println(tesztkiraly.getNev());
        System.out.println(tesztkiraly.getSzuletett());
        System.out.println(tesztkiraly.getMeghalt());
        System.out.println(tesztkiraly.getHaz());
    }
}
