import java.util.*;

public class MasterBlok1Les5Gamble {

    public static void main(String[] args) {
        boolean runGame = true;

        Scanner scan = new Scanner(System.in);

        String input = "";
        String[] commandos = {"hoger", "lager", "exit"};
        double getalStart = 0;
        double getalfind = 0;
        int lifes = 5; // levens
        int score = 0; // Score
        System.out.println("Welkom at high of the low!, je hebt 5 levens, probeer zo veel mogelijk punten te halen!");
        while (runGame == true) // (runs de game)
        {

            getalStart = Math.ceil(Math.random() * 10); // Getal van 1 tot 10

            System.out.println("Getal is: " + getalStart);


            // Input control

            boolean geldigeInput = false;

            while (geldigeInput == false) {
                input = scan.nextLine();
                input = input.toLowerCase();

                for (int i = 0; i < commandos.length; i++) {
                    if (input.equals(commandos[i])) { // input is true
                        geldigeInput = true;

                        break;
                    }
                }
            }

            // Input validate
            getalfind = Math.ceil(Math.random() * 10); // Getal van 1 tot 10

            boolean win = false;
            if (input.equals(commandos[0])) //higher
            {
                if (getalfind > getalStart) { // Win
                    win = true;
                }
            } else if (input.equals(commandos[1])) // lower
            {
                if (getalfind < getalStart) {
                    win = true;
                }
            } else { // Exit the game
                runGame = false;
                continue;
            }

            System.out.println("Getal start getal was: " + getalStart); // Eindresult
            System.out.println("Getal eind getal is: " + getalfind);

            if (getalfind != getalStart) { // Win
                if (win) {
                    System.out.println("Je hebt gewonnen! 1 punt erbij.");
                    score++;
                    System.out.println("Je hebt nu " + score + " punt(en)");

                } else { // Lose
                    System.out.println("Je hebt verloren! Probeer het nog een keer.");
                    lifes--;
                    System.out.println("Je hebt nog " + lifes + " levens!");

                }
            }
            if (lifes == 0) {
                System.out.println("Je hebt verloren helaas.");
                System.out.println("Jouw score is: " + score);

                break;
            }
        }


    }
}