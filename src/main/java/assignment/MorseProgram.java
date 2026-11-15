package assignment;

import java.util.Scanner;

public class MorseProgram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MorseConverter converter = new MorseConverter();

        // Användaren får välja vilket håll programmet ska översätta åt.
        System.out.println("1. Engelska till morsekod");
        System.out.println("2. Morsekod till engelska");
        System.out.print("Välj 1 eller 2: ");

        String choice = scan.nextLine();

        // Om användaren skriver något annat än 1 eller 2 blir det fel.
        // Då avslutar vi programmet i stället för att försöka göra en översättning.
        if (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Fel val. Skriv 1 eller 2.");
            scan.close();
            return;
        }

        try {
            // Om användaren väljer 1 översätter vi från engelska till morsekod.
            if (choice.equals("1")) {
                System.out.print("Skriv engelska bokstäver: ");
                String text = scan.nextLine();

                // Exempel: "F" blir "..-.".
                String morse = converter.toMorse(text);
                System.out.println("Morsekod: " + morse);
            } else {
                // Annars har användaren valt 2 och vi översätter från morsekod.
                System.out.println("Skriv morsekod med mellanslag mellan bokstäverna:");
                String morse = scan.nextLine();

                // Exempel: ".... . .---" blir "HEJ".
                String text = converter.toEnglish(morse);
                System.out.println("Engelska: " + text);
            }
        } catch (IllegalArgumentException e) {
            // Om inmatningen är fel visar vi ett meddelande i stället för att programmet kraschar.
            System.out.println("Fel: " + e.getMessage());
        }

        scan.close();
    }
}