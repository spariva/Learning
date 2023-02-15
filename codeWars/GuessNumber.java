import java.util.Scanner;
public class GuessNumber{
    public static void main(String[] args) {
        int number = (int) Math.random() * 1001;
        int solution;
        Scanner sc = new Scanner(System.in);
        do {
            
            System.out.println("Guess the number");
            solution = sc.nextInt();
            if(solution<number){
                System.out.println("Try again, next time point higher");
            }else if(solution>number){
                System.out.println("Try again, next time point lower");
            }
        } while (number != solution);
        System.out.println("Congrats, you got it!");
        
    }
}