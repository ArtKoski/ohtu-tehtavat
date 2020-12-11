package ohtu.kivipaperisakset;


public class KPSTekoaly extends KiviPaperiSakset {

    private final Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto() {
        String tekoalynSiirto = tekoaly.annaSiirto();
        System.out.print("Toisen pelaajan siirto (tekoaly): " + tekoalynSiirto);
        return tekoalynSiirto;
    }

    @Override
    protected void asetaSiirto(String toisenPelaajanSiirto) {
        tekoaly.asetaSiirto(toisenPelaajanSiirto);
    }

}
