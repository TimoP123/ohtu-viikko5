package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti tai kasvatuskoko väärin");//heitin vaan jotain :D
        }
        this.ljono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == ljono.length) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }

    public void kasvataTaulukkoa() {
        int[] taulukko = new int[alkioidenLkm + kasvatuskoko];
        for (int i = 0; i < alkioidenLkm; i++) {
            taulukko[i] = ljono[i];
        }
        ljono = taulukko;
    }

    public boolean kuuluu(int luku) {
        if (luvunIndeksi(luku) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean kuuluu(int[] jono, int luku) {
        for (int i = 0; i < jono.length; i++) {
            if (luku == jono[i]) {
                return true;
            }
        }
        return false;
    }

    public int luvunIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) {
            return false;
        }
        for (int i = luvunIndeksi(luku); i < alkioidenLkm - 1; i++) {
            ljono[i] = ljono[i + 1];
        }
        alkioidenLkm--;
        return true;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
        public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        }
        return "{" + alkiomerkkijono() + "}";
    }

    public String alkiomerkkijono() {
        String mjono = "";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            mjono += ljono[i] + ", ";
        }
        mjono += ljono[alkioidenLkm - 1];
        return mjono;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko palautus = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            palautus.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            palautus.lisaa(b.toIntArray()[i]);
        }
        return palautus;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko palautus = new IntJoukko();
        for (int i = 0; i < b.mahtavuus(); i++) {
            if (kuuluu(a.toIntArray(), b.toIntArray()[i])) {
                palautus.lisaa(b.toIntArray()[i]);
            }
        }
        return palautus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko palautus = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            palautus.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            palautus.poista(i);
        }
        return palautus;
    }

}
