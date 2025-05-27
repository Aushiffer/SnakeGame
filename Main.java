import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char keyPressed;

        Game game = new Game(20, 50);
        game.initializeGame();

        while (!game.hasCollided()) {
            keyPressed = input.next().charAt(0);
        }

        input.close();
    }
}
