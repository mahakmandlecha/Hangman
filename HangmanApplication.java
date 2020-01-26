import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n******************************Welcome to Hangman! I will pick a word and you will guess it character by character******************************\n" +
                            "\t\t- You have only 6 chances to guess the word.\n\n" +
                            "\t\t- You ready? I hope so, because I am!!");
        System.out.println();
        System.out.println("I have picked a word . Below is your current guess " +
                            "That starts as nothing on its body.\nEvery time you guess incorrectly, I will add a body part.\n" +
                            "When it become a full person, you lose.");
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            System.out.println();
            System.out.println("Lets play");
            Hangman game = new Hangman();
            do {
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.println();
  
                // Get the guess
                System.out.println("Enter a character that you think is in the word");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();

                // Check if the character has been guessed before
                if (game.isGuessedAlready(guess)) {
                    System.out.println("Try again. You have guessed this character already");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }                       

                if (game.playGuess(guess)) {
                    System.out.println("Yeahhh you guessed a correct letter");
                }
                else {
			
                    System.out.println("Ooppss this letter is not in the word. Try again");
                }
            }
            while (!game.gameOver());

            System.out.println();
            System.out.println("Do you want to play another game. Enter Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
        }

    }
}
