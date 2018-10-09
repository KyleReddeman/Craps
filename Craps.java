

import java.util.*;
public class Craps
{
    public static void main(String[] args) 
    {
        greeting();
        do
        {
            int sum=getSum();
            int rollValue=interpetRoll(sum);
            gameRules(rollValue, sum);
        } while (playAgain()==true);
        System.out.println("\nGoodBye");
    }
    private static final Random random=new Random();
    private static final Scanner input=new Scanner(System.in);
    
    private static final int SNAKE_EYES=2;
    private static final int TREY=3;
    private static final int BOX_CARS=12;
    private static final int SEVEN=7;
    private static final int YO_LEVEN=11;
    public static void greeting()
    {
        System.out.println("Would You Care To Roll?");
        String answer=input.nextLine();
    }
    public static int getSum() 
    {
        int firstDie, secondDie, sum;
        firstDie=1+random.nextInt(6);
        secondDie=1+random.nextInt(6);
        sum=firstDie+secondDie;
        System.out.println("Die one=  "+firstDie+"\nDie two=  "+secondDie+"\n\nYour Roll=  "+sum);
        return sum;
    }
    public static int interpetRoll(int sum)
    {
        switch (sum)
        {
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                return 1;
            case YO_LEVEN:
            case SEVEN:
                return 0;
            default:
                return 2;      
        }
    }
    public static void gameRules(int rollValue, int pointValue)
    {
        if (rollValue==0)
            System.out.println("You Win!");
        if (rollValue==1)
            System.out.println("You Lose");
        while (rollValue==2)
        {
            System.out.println("\nROLL!");
            String answer=input.nextLine();
            int sum=getSum();
            System.out.println("Point= "+pointValue+"\n");
            if (sum==pointValue)
            {
                System.out.println("You Found a Match!\nYou Win!");
                rollValue=0;
            }
            if (sum==7)
            {
                System.out.println("You Lose!");
                rollValue=0;
            }
        }           
    }
    public static boolean playAgain()
    {
      System.out.println("\nWould you like to play again?");
      String answer = input.nextLine();
      return answer.compareToIgnoreCase("yes") == 0;
// 
//         String answer;
//         do
//         {
//             System.out.println("\nWould you like to play again?");
//             answer=input.nextLine();
//             if (answer.compareToIgnoreCase("yes")==0)
//                 return true;
//             if (answer.compareToIgnoreCase("no")==0)
//                 return false;
//             else System.out.println("\nIncorrect Response\nThe Correct Responses are yes, or no");
//         } while (answer.compareToIgnoreCase("yes")!=0 && answer.compareToIgnoreCase("no")!=0);
//         return false;
    }
}
