package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static IntJoukko a, b, c;
    

    private static String luku() {
        Scanner lukija = new Scanner(System.in);
        String luettu = lukija.nextLine();
        return luettu;
    }

    private static IntJoukko mikaJoukko() {
        String luettu;
        Scanner lukija = new Scanner(System.in);
        luettu = luku();
        while (true) {
            if (luettu.equals("A") || luettu.equals("a")) {
                return A;
            } else if (luettu.equals("B") || luettu.equals("b")) {
                return B;
            } else if (luettu.equals("C") || luettu.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = luku();
            }
        }
    }

    private static void lisaa() {
        int lisLuku;
        IntJoukko joukko;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        lisLuku = lukija.nextInt();
        joukko.lisaa(lisLuku);
        

    }

    private static void yhdiste() {
      
        System.out.print("1. joukko? ");
        a = mikaJoukko();
        System.out.print("2. joukko? ");
        b = mikaJoukko();
        c = IntJoukko.yhdiste(a, b);
        System.out.println("A yhdiste B = " + c.toString());

    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private static void erotus() {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko();
        IntJoukko cJoukko = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + cJoukko.toString());
    }

    private static void poista() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int lisLuku = lukija.nextInt();
        joukko.poista(lisLuku);
    }

    private static void kuuluu() {
        IntJoukko joukko;
        int luku;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        luku = lukija.nextInt();
        
        boolean kuuluuko = joukko.kuuluu(luku);
        if (kuuluuko) {
            System.out.println(luku + " kuuluu joukkoon ");
        } else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }
        
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        
        System.out.println("Tervetuloa joukkolaboratorioon! \nKäytössäsi ovat joukot A, B ja C. \nKomennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q). \nJoukon nimi komentona tarkoittaa pyyntöä tulostaa joukko." );
        Scanner lukija = new Scanner(System.in);
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            }
            komento(luettu);
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
       
    } 
    public static void komento(String luettu) {
        if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else {
                System.out.println("Virheellinen komento! " + luettu + "\nKomennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            
    }
}
