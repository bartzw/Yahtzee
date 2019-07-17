package nl.qien.WeekopdrachtYahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //ScoreKaart.laatScoreKaartZien();
        System.out.print("\n" + "Welkom bij Yahtzee!");
        System.out.print(" Hoeveel personen willen meedoen? : ");
        int numberPeople = Integer.parseInt(reader.nextLine());
        Speler.registreerSpelers(numberPeople);
        YahtzeeSpelen spel = new YahtzeeSpelen();
        spel.YahtzeeSpelen();
    }
}

class YahtzeeSpelen {
    ArrayList<Speler> spelers = Speler.getSpelers();
    Scanner reader1 = new Scanner(System.in);

    void YahtzeeSpelen() {
        //ArrayList<Dobbelsteen> dobbelsteen = spelers.get(0).getDobbelstenen();
        spelers.forEach(Speler -> {
            Dobbelsteen.gooiDobbelsteen(Speler.getSpelerNr());
            output(Speler.getSpelerNr());
            int worp = 0;
            while (Speler.getVolgendeRonde()) {
                if (worp < 2) {
                    System.out.println("Welke posities wilt u vasthouden? 0 voor geen anders bv 124");
                    String vasthoudenInput = reader1.nextLine();
                    if (vasthoudenInput.equals("x")) {
                        Dobbelsteen.gooiDobbelsteenNogEenKeer(Speler.getSpelerNr());
                        // scoreboard
                    } else if (vasthoudenInput.equals("0")) {
                        System.out.println("");
                        System.out.println(Speler.getSpelernaam() + ", volgende worp!");
                        Dobbelsteen.gooiDobbelsteenNogEenKeer(Speler.getSpelerNr());
                        worp++;
                        output(Speler.getSpelerNr());

                    } else {
                        System.out.println("");
                        System.out.println(Speler.getSpelernaam() + ", de volgende stenen houd je nu vast!");
                        Dobbelsteen.setVasthouden(vasthoudenInput, Speler.getSpelerNr());
                        output(Speler.getSpelerNr());
                    }
                } else {
                    System.out.println("");
                    System.out.println("Je hebt 3 keer gegooid, dit is je resultaat:");
                    ScoreKaart.setScore(output(Speler.getSpelerNr()), Speler.getSpelerNr());
                    Speler.getScore();
                    System.out.println("Wil je nog een ronde spelen typ: r, of als je wilt stoppen typ: q :");
                    String vasthoudenInput1 = reader1.nextLine();
                    if (vasthoudenInput1.equals("r")) {
                        int j = Speler.getDobbelstenen().size();
                        for (int i = 0; i < j; i++) {
                            Speler.getDobbelstenen().remove(0);
                        }
                        YahtzeeSpelen();
                    } else if (vasthoudenInput1.equals("q")) {
                        Speler.setVolgendeRonde(false);
                        System.out.println(Speler.getSpelernaam() + " ,je bent nu gestopt met het spel.");
                    }
                }
            }
        });

    }

    private StringBuilder output(int spelerNr) {
        ArrayList<Dobbelsteen> dobbelsteen = spelers.get(spelerNr).getDobbelstenen();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < spelers.get(spelerNr).getDobbelstenen().size(); i++) {
            String dobbelsteenString = spelers.get(spelerNr).getDobbelstenen().get(i).getDobbelsteenString();
            boolean vasthoudenString = spelers.get(spelerNr).getDobbelstenen().get(i).getVasthouden();
            str1.append(dobbelsteenString + " ");
            if (vasthoudenString) {
                str2.append("X ");
            } else {
                str2.append("O ");
            }
        }
        System.out.println();
        System.out.println("1 2 3 4 5 Positie dobbelsteen");
        System.out.println(str1 + "Ogen dobbelsteen");
        System.out.println(str2 + "Vasthouden X = vasthouden O = gooien volgende ronde.");
        return str1;
    }

}
