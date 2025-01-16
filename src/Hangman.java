import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws Exception {
        
        
        // NEXT TIME IT WILL ALLOW TO RANDOMIZE THE WORD FROM A THOUSAND WORDS 
        // (Countries, Cities, City places, Planets, Animals, School stuff, Languages, Famous places, Famous people, verbs, adjectives, etc).
        String secretWord = "STRANGER";
        int fails = 0;
        int maxFails = 10;
        boolean isRightWord = false;

        System.out.println("There's a secret word you must find. It has " + secretWord.length() + " letters");
        char[] rightLetters = new char[secretWord.length()];

        for (int i = 0; i < rightLetters.length; i++) {
            rightLetters[i] = '_';
            System.out.print(rightLetters[i]);
        }

        System.out.println( " I dare you to solve it ");
        
        Scanner scanner = new Scanner(System.in);

        // Using !isRightWord this way to get true.
        while (!isRightWord && maxFails > fails) { 
            System.out.println("\nSolved at the moment: " + String.valueOf(rightLetters));
            
            System.out.print("Please, enter a letter, then press ENTER: ");
            char letter = Character.toUpperCase(scanner.nextLine().charAt(0));
            
            boolean rightLetter = false;

            for (int i = 0; i < secretWord.length(); i++ ) {
                if (secretWord.charAt(i) == letter) {
                    rightLetter = true;
                    rightLetters[i] = letter;
                }
            }
            if (!rightLetter) {
                fails++;
                System.out.println("Wrong!! " + (maxFails - fails) + " chances left\n");
            }

            if (String.valueOf(rightLetters).equals(secretWord)) {
                isRightWord = true;
                System.out.println("\nCongratulations! You solved it!! --> " + String.valueOf(rightLetters));
                System.out.println("YOU OWN \"" + secretWord.toUpperCase() + "\"");
            }
        }

        if (!isRightWord) {
            System.out.println("GAME OVER, YOU'VE LOST YOUR CHANCES. The word was " + secretWord.toUpperCase());
        }

        scanner.close();
    }
}
