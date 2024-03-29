package nl.qien.WeekopdrachtYahtzee;

import java.util.ArrayList;

public class Dobbelsteen {
    ArrayList<Dobbelsteen> dobbelsteenLijst = new ArrayList<>();
    static ArrayList<Speler> spelers = Speler.getSpelers();
    int dobbelsteenNr;
    int dobbelWaarde;
    String dobbelWaardeString;
    boolean vasthouden;

    private Dobbelsteen(int dobbelsteenNr, int dobbelWaarde, String dobbelWaardeString, boolean vasthouden) {
        this.dobbelsteenNr = dobbelsteenNr;
        this.dobbelWaarde = dobbelWaarde;
        this.dobbelWaardeString = dobbelWaardeString;
        this.vasthouden = vasthouden;
    }

    static Dobbelsteen gooiDobbelsteen(int spelerNr) {
        Dobbelsteen dobbel = null;
        ArrayList<Dobbelsteen> getdobbelsteen = spelers.get(spelerNr).getDobbelstenen();
        for (int i = 0; i < 5; i++) {
                int dobbelSteen = (int) (Math.random() * 6 + 1);
                dobbel = new Dobbelsteen(i, dobbelSteen, Integer.toString(dobbelSteen), false);
                spelers.get(spelerNr).setDobbelsteen(dobbel, spelerNr);

        }
        return dobbel;
    }
    static Dobbelsteen gooiDobbelsteenNogEenKeer(int spelerNr) {
        Dobbelsteen dobbel = null;
        ArrayList<Dobbelsteen> getdobbelsteen = spelers.get(spelerNr).getDobbelstenen();
        for (int i = 0; i < 5; i++) {
             if(!getdobbelsteen.get(spelerNr).getVasthouden(i, spelerNr)) {
                int dobbelSteen = (int) (Math.random() * 6 + 1);

                dobbel = new Dobbelsteen(i, dobbelSteen, Integer.toString(dobbelSteen), false);
                spelers.get(spelerNr).setDobbelsteen(dobbel, spelerNr, i);
            }
        }
        return dobbel;
    }

    public ArrayList<Dobbelsteen> maakDobbelLijst(int dobbelsteenNr, int dobbelWaarde, String dobbelWaardeString, boolean vasthouden) {
        this.dobbelsteenNr = dobbelsteenNr;
        this.dobbelWaarde = dobbelWaarde;
        this.dobbelWaardeString = dobbelWaardeString;
        this.vasthouden = vasthouden;
        Dobbelsteen dobbelsteen = new Dobbelsteen(this.dobbelsteenNr, this.dobbelWaarde, this.dobbelWaardeString, this.vasthouden);
        dobbelsteenLijst.add(dobbelsteen);
        return dobbelsteenLijst;
    }
    boolean getVasthouden() {
        return vasthouden;
    }
    private boolean getVasthouden(int dobbelsteenNr, int spelerNr) {
        ArrayList<Dobbelsteen> getdobbelsteen = spelers.get(spelerNr).getDobbelstenen();
        boolean bool = getdobbelsteen.get(dobbelsteenNr).vasthouden;
        return bool;
    }

    private void setVast() {
        if (vasthouden) {
            vasthouden = false;
        } else {
            vasthouden = true;
        }
    }

     static void setVasthouden(String vasthouden, int spelerNr) {
        int length = vasthouden.length();
        for (int i = 0; i < length; i++) {
            int positie = Character.getNumericValue(vasthouden.charAt(i)) - 1;
            ArrayList<Dobbelsteen> getdobbelsteen = spelers.get(spelerNr).getDobbelstenen();
            getdobbelsteen.get(positie).setVast();
        }
    }

    String getDobbelsteenString() {
        return dobbelWaardeString;
    }
}