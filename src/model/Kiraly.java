package model;

/**
 * A Kiraly osztály, mint alapvető adattípus definíciója.
 */
public class Kiraly {

    private String nev;
    private int szuletett;
    private int meghalt;
    private String haz;

    public Kiraly(String nev, int szuletett, int meghalt, String haz) {
        this.nev = nev;
        this.szuletett = szuletett;
        this.meghalt = meghalt;
        this.haz = haz;
    }

    public String getNev() {
        return nev;
    }

    public int getSzuletett() {
        return szuletett;
    }

    public int getMeghalt() {
        return meghalt;
    }

    public String getHaz() {
        return haz;
    }

    public int életkor() {
        return (this.meghalt - this.szuletett);
    }

    @Override
    public String toString() {
        return ( nev + ", " + "szuletett: " + szuletett + ", meghalt: " + meghalt + ", elt=" + this.életkor() +
                " evet" + ", a(z) " + haz + " tagja." );
    }
}
