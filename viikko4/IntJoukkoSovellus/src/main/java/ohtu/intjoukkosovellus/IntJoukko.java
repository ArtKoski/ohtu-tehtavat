package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
            KASVATUS = 5;

    private int kasvatuskoko;
    private int[] lukujono;
    private int alkioidenMaara;

    public IntJoukko() {
        alustaTaulukko();
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }

        alustaTaulukko();
        lukujono = new int[kapasiteetti];

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti liian pieni");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko liian pieni");
        }

        alustaTaulukko();
        lukujono = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public void alustaTaulukko() {
        lukujono = new int[KAPASITEETTI];
        this.kasvatuskoko = KASVATUS;
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenMaara = 0;
    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            lukujono[alkioidenMaara] = luku;
            alkioidenMaara++;
            if (alkioidenMaara % lukujono.length == 0) {
                kasvataTaulukonKokoa();
            }
            return true;
        }
        return false;
    }

    public void kasvataTaulukonKokoa() {
        int[] taulukkoOld = new int[lukujono.length];
        kopioiTaulukko(lukujono, taulukkoOld);
        lukujono = new int[alkioidenMaara + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, lukujono);
    }

    public boolean kuuluu(int luku) {

        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int poistetunIndeksi = -1;
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == lukujono[i]) {
                poistetunIndeksi = i;
                lukujono[poistetunIndeksi] = 0;
                break;
            }
        }

        if (poistetunIndeksi != -1) {
            siirraNumeroitaVasemmalleIndeksista(poistetunIndeksi);
            return true;
        }

        return false;
    }

    private void siirraNumeroitaVasemmalleIndeksista(int indeksi) {
        int apu;
        for (int j = indeksi; j < alkioidenMaara - 1; j++) {
            apu = lukujono[j];
            lukujono[j] = lukujono[j + 1];
            lukujono[j + 1] = apu;
        }
        alkioidenMaara--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenMaara;
    }

    @Override
    public String toString() {
        switch (alkioidenMaara) {
            case 0:
                return "{}";
            case 1:
                return "{" + lukujono[0] + "}";
            default:
                String tuotos = "{";
                for (int i = 0; i < alkioidenMaara - 1; i++) {
                    tuotos += lukujono[i];
                    tuotos += ", ";
                }
                tuotos += lukujono[alkioidenMaara - 1];
                tuotos += "}";
                return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenMaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }

        return z;
    }

}
