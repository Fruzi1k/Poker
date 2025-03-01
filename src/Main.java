import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Chouse the game 1 or 2 -> ");
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()) {
            int choice = input.nextInt();
            if (choice == 1) {
                game.start();
            }else if (choice == 2) {
                game.start2();
            }else{
                System.out.println("Hmmm i think it is not game for you");
            }
        }

    }
}
