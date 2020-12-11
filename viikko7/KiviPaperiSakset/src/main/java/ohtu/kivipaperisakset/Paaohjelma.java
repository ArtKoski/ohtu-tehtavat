package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        KiviPaperiSaksetTehdas tehdas = new KiviPaperiSaksetTehdas();
        KiviPaperiSakset peli;

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                peli = tehdas.Ihminen();
            } else if (vastaus.endsWith("b")) {
                peli = tehdas.Tekoaly();
            } else if (vastaus.endsWith("c")) {
                peli = tehdas.TekoalyParannettu();
            } else {
                break;
            }
            
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();
        }
    }
}
