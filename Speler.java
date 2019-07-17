package nl.qien.WeekopdrachtYahtzee;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.Scanner;

public class Speler {
    static ArrayList<Speler> Spelers = new ArrayList<Speler>();
    private int spelerNr;
    private String spelerNaam;
    private ArrayList<Dobbelsteen> dobbelsteenLijst;
    private boolean volgendeRonde;
    private ArrayList<StringBuilder> scorelijst;


    public static void registreerSpelers(int numberPeople) {
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < numberPeople; i++) {
            String SpelerNaam;
            System.out.println("Hallo speler " + (i + 1) + ", wat is jouw naam?:");
            SpelerNaam = reader.nextLine();
            Spelers.add(new Speler(i, SpelerNaam, new ArrayList<Dobbelsteen>(), true, new ArrayList<StringBuilder>()));
        }
    }

    public Speler(int spelerNr, String spelerNaam, ArrayList<Dobbelsteen> dobbelsteenLijst, boolean volgendeRonde, ArrayList<StringBuilder> scorelijst) {
        this.spelerNr = spelerNr;
        this.spelerNaam = spelerNaam;
        this.dobbelsteenLijst = dobbelsteenLijst;
        this.volgendeRonde = volgendeRonde;
        this.scorelijst = scorelijst;
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
    public ArrayList<ScoreKaart> setScore(StringBuilder waarde) {
       scorelijst.add(waarde);
        return null;
    }
    public ArrayList<ScoreKaart> getScore() {
        System.out.println("");
        System.out.println("Dit is/zijn je behaalde scores!");
        System.out.println("");
        for (int i = 0; i < scorelijst.size(); i++) {
            int j = i + 1;
            System.out.println("Ronde " + j + ":" +scorelijst.get(i));
        }
        return null;
    }
}


