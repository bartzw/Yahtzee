package nl.qien.WeekopdrachtYahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
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
                System.out.println("worp = " + worp);
                if (worp < 2) {
                System.out.println("Welke posities wilt u vasthouden? 0 voor geen anders bv 124");
                String vasthoudenInput = reader1.nextLine();
                if (vasthoudenInput.equals("x")) {
                    Speler.setVolgendeRonde(false);
                    Dobbelsteen.gooiDobbelsteenNogEenKeer(Speler.getSpelerNr());
                    // scoreboard
                }
                else if (vasthoudenInput.equals("0")) {
                    Dobbelsteen.gooiDobbelsteenNogEenKeer(Speler.getSpelerNr());
                    worp++;
                    output(Speler.getSpelerNr());

                } else {
                    Dobbelsteen.setVasthouden(vasthoudenInput, Speler.getSpelerNr());
                    output(Speler.getSpelerNr());
                }
                } else {
                    System.out.println("Je bent al klaar pik");
                    break;
                }
            }
        });

    }

    void output(int spelerNr) {
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
    }

}
