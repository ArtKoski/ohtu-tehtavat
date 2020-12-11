package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    private static final Scanner scanner = new Scanner(System.in);
    private final TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String toisenSiirto() {
        String tekoalynSiirto = tekoaly.annaSiirto();
        System.out.print("Toisen pelaajan siirto (parannettu tekoaly): " + tekoalynSiirto);
        return tekoalynSiirto;
    }

    @Override
    protected void asetaSiirto(String toisenPelaajanSiirto) {
        tekoaly.asetaSiirto(toisenPelaajanSiirto);
    }

}
