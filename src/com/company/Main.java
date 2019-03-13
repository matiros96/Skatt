package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Initiering
        Scanner scan = new Scanner(System.in);
        boolean done = false;

        do {
            System.out.println("Hur mycket är din årsinkomst?"); //Fråga användaren om input
            SkatteSatser.inkomst = scan.nextInt();
            SkatteSatser.inkomst = SkatteSatser.inkomst - SkatteSatser.avdrag; // Grundskatteavdrag dras av

            if (SkatteSatser.inkomst < SkatteSatser.low_Skikt) { // Användarens inkomst efter savdrag understiger gränsen för statlig inkomtskatt.
                System.out.println("Din årsinkomst understiger den nedre skiktgränsen och du betalar därför ingen skatt.");
            }
            else if (SkatteSatser.inkomst > SkatteSatser.low_Skikt && SkatteSatser.inkomst < SkatteSatser.high_Skikt) { // Inkomst överstiger lägre skiktgräns men understiger övre.
                System.out.println("Din skatt för detta år är: " + SkatteSatser.inkomst * SkatteSatser.inkomst_Skatt); // Printar produkten av användarens inkomst efter avdragning och multiplikation med skattesats.
            }
            else if (SkatteSatser.inkomst > SkatteSatser.high_Skikt) { // Överstiger båda undre och övre skiktgräns.
                System.out.println("Din skatt för detta år är: " + SkatteSatser.inkomst * SkatteSatser.v_Inkomst_Skatt); // Printar skatt efter avdragoch multiplikation med skattesats och värnskatt.
            }
            else {
                System.out.println("Skrev du en giltig årsinkomst? Försök igen."); // Användaren gav ogiltig input
            }

            boolean valid;
            do {
                System.out.println("Vill du köra programmet igen? j/n"); // frågar om användaren vill köra programmet igen.
                String ja_Nej = scan.next().toLowerCase();
                valid = false;
                if (ja_Nej.startsWith("j") || ja_Nej.startsWith("n")) { // om användarens svar börjar med j/n anses det vara giltig input.
                    valid = true;
                } else {
                    System.out.println("Ogiltig input, endast j/n. Försök igen."); // allt annat antas vara ogiltid input.
                }

                if (ja_Nej.startsWith("j")) { // om användaren svarade ja så körs programmet från början.
                    done = true;
                }

                if (ja_Nej.startsWith("n")) {  // om användaren svarade nej så avslutas programmet.
                    done = false;
                    System.out.println("Programmet avslutas.");

                }
            } while (!valid);



        } while (done);
    }

    static class SkatteSatser {

        // Deklaration och initiering.
        static int inkomst;
        static final int avdrag = 13400;
        static final double v_Skatt = 0.05;
        static final double inkomst_Skatt = 0.20;
        static final double v_Inkomst_Skatt = v_Skatt + inkomst_Skatt;
        static final int low_Skikt = 455300;
        static final int high_Skikt = 662300;


    }
}