
package guessinggame;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100000);
        int guess;
        int numberOfDollars= 0;
        char hint;        
        boolean isWon = false;        
        Scanner vn = new Scanner(System.in);        
            System.out.println("Want to win a million dollars?");            
            System.out.println("If so, guess the winning number (a number between 0 - 100000)");            
            while (!isWon) {                
                System.out.println("Insert $1.00 and enter your number or 'q' to quit:");            
                try{
                    guess= vn.nextInt();
                    numberOfDollars++;
                    if(guess==numberToGuess){
                        System.out.println("You win");
                        isWon = true;
                        }
                    else{
                        System.out.println("Sorry, good guess, but not quite right. Do you want me to give you a hint (y|n)?");
                        hint=vn.next().charAt(0);
                        if(hint=='y'){
                            System.out.println("Insert $2.00 for the hint!");
                            numberOfDollars=numberOfDollars+2;
                            if(guess<numberToGuess)
                                System.out.println("Your number is too low!");
                            else
                                System.out.println("Your number is too high!");
                            }
                        }
                    }
                catch(Exception ex){
                    System.out.println("You lost $"+numberOfDollars+".00. Thanks for playing. Come again!");
                    isWon = true;
                    }
                }
            }
    }
