package nl.qien.WeekopdrachtYahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class Speler {
    static ArrayList<Speler> Spelers = new ArrayList<Speler>();
    private int spelerNr;
    private String spelerNaam;
    private ArrayList<Dobbelsteen> dobbelsteenLijst;
    private boolean volgendeRonde;


    public static void registreerSpelers(int numberPeople) {
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < numberPeople; i++) {
            String SpelerNaam;
            System.out.println("Hallo speler " + (i + 1) + ", wat is jouw naam?:");
            SpelerNaam = reader.nextLine();
            Spelers.add(new Speler(i, SpelerNaam, new ArrayList<Dobbelsteen>(), true));
        }
    }

    public Speler(int spelerNr, String spelerNaam, ArrayList<Dobbelsteen> dobbelsteenLijst, boolean volgendeRonde) {
        this.spelerNr = spelerNr;
        this.spelerNaam = spelerNaam;
        this.dobbelsteenLijst = dobbelsteenLijst;
        this.volgendeRonde = volgendeRonde;
    }

    public static ArrayList<Speler> getSpelers() {
        return Spelers;
    }

    public String getSpelernaam() {
        return spelerNaam;
    }

    public boolean getVolgendeRonde() {
        return volgendeRonde;
    }
    public boolean setVolgendeRonde(boolean volgendeRonde) {
        this.volgendeRonde = volgendeRonde;
        return volgendeRonde;
    }

    public int getSpelerNr() {
        return spelerNr;
    }

    public ArrayList<Dobbelsteen> getDobbelstenen() {
        return dobbelsteenLijst;
    }

    public Dobbelsteen setDobbelsteen(Dobbelsteen dobbelsteen, int spelerNr) {
        dobbelsteenLijst.add(dobbelsteen);
        return null;
    }

    public Dobbelsteen setDobbelsteen(Dobbelsteen dobbelsteen, int spelerNr, int dobbelsteenNr) {
        if (dobbelsteenLijst.get(dobbelsteenNr).dobbelWaarde > 0) {
            dobbelsteenLijst.set(dobbelsteenNr, dobbelsteen);
            return null;
        } else {
            dobbelsteenLijst.add(dobbelsteen);
            return null;
        }
    }
}


