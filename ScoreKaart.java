package nl.qien.WeekopdrachtYahtzee;

import java.util.ArrayList;

public class ScoreKaart {
    int scorePositie;
    int punten;
    void ScoreKaart(int scorePositie) {

    }
     static ArrayList<ScoreKaart> setScore(StringBuilder dobbelSteenWaarde, int spelerNr) {
        ArrayList<Speler> spelers = Speler.getSpelers();
        ArrayList scorekaart = spelers.get(spelerNr).setScore(dobbelSteenWaarde);
        return scorekaart;
    }
}
