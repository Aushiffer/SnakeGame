import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char keyPressed;

        Game game = new Game(20, 50);

        do {
            game.render();
            System.out.print("Input: ");
            keyPressed = input.next().charAt(0);
        } while (!game.hasCollided());

        input.close();
    }
}
