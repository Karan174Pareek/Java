import java.util.Scanner;

public class RiddleGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        // Defining an array of riddles and their corresponding answers.
        String[] riddles = {
            "I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?",
            "The more you take, the more you leave behind. What am I?",
            "I'm not alive, but I can grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?"
        };

        String[] answers = {
            "An echo",
            "Footsteps",
            "A fire"
        };

        // Defining hints for each riddle.
        String[] hints = {
            "Hint: This thing is known for its ability to reflect sound.",
            "Hint: Think about what you leave behind when you walk.",
            "Hint: It produces heat and light."
        };

        int numRiddles=riddles.length;

        while(true){
            int randomIndex = (int) (Math.random()*numRiddles);
            String slectedRiddle = riddles[randomIndex];
            String correctAnswer = answers[randomIndex];
            String hint = hints[randomIndex];

            //Displaying the riddle to the user
            System.out.println("Riddle: "+ slectedRiddle);

            //Taking User's Answers
            String userAnswer = sc.nextLine();

            if(userAnswer.equalsIgnoreCase(correctAnswer))
            {
                System.out.println("Correct!");
                score++;
            }
            else
            {
                //If the answer is incorrect a hint will be offered
                System.out.println("Wrong! would you like a hint? (yes/no)");
                String giveHint = sc.nextLine().toLowerCase();
                if (giveHint.equals("yes"))
                    {
                        System.out.println(hint);
                    }   
                }
                //Allowing the user to continue or exit
                System.out.println("Continue playing?(yes/no)");
                String playAgain=sc.nextLine().toLowerCase();
                if(!playAgain.equals("yes")){
                    break;
                }
            }
            // Display final score.
            System.out.println("Your final score: " + score);
            System.out.println("Thanks for playing!");
            sc.close();
        }
    }
