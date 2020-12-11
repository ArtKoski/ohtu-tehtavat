
package ohtu.kivipaperisakset;

public class KiviPaperiSaksetTehdas {

    public KiviPaperiSakset Tekoaly() {
        return new KPSTekoaly();
    }

    public KiviPaperiSakset Ihminen() {
        return new KPSPelaajaVsPelaaja();
    }

    public KiviPaperiSakset TekoalyParannettu() {
        return new KPSParempiTekoaly();
    }
}
