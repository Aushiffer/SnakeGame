import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char keyPressed;
        CoordinateTuple<Integer, Integer> stepCoordinates;

        Game game = new Game(20, 50);

        do {
            game.render();
            System.out.print("Input: ");
            keyPressed = input.next().charAt(0);

            switch (keyPressed) {
                case 'w':

                break;
                
                case 'a':

                break;
                
                case 's':

                break;
                
                case 'd':

                break;

                default:

                break;
            }
        } while (!game.hasCollided());

        input.close();
    }
}
