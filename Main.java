import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char keyPressed;

        Game game = new Game(20, 50);

        do {
            game.render();
            System.out.println("Score: " + game.getScore());
            System.out.print("Input: ");
            keyPressed = input.next().charAt(0);

            CoordinateTuple<Integer, Integer> snakeDirection = game.getSnake().getDirection();
            CoordinateTuple<Integer, Integer> snakeHead = game.getSnake().getBody().getFirst();
            CoordinateTuple<Integer, Integer> stepCoordinates = new CoordinateTuple<Integer, Integer>(snakeHead.getX(), snakeHead.getY());

            if (keyPressed == 'w') {
                stepCoordinates.setX(snakeHead.getX() + Directions.UP.getX());
                game.getSnake().moveStep(stepCoordinates);
                game.getSnake().setDirection(Directions.UP);
            } else if (keyPressed == 's') {
                stepCoordinates.setX(snakeHead.getX() + Directions.DOWN.getX());
                game.getSnake().moveStep(stepCoordinates);
                game.getSnake().setDirection(Directions.DOWN);
            } else if (keyPressed == 'a') {
                stepCoordinates.setY(snakeHead.getY() + Directions.LEFT.getY());
                game.getSnake().moveStep(stepCoordinates);
                game.getSnake().setDirection(Directions.LEFT);
            } else if (keyPressed == 'd') {
                stepCoordinates.setY(snakeHead.getY() + Directions.RIGHT.getY());
                game.getSnake().moveStep(stepCoordinates);
                game.getSnake().setDirection(Directions.RIGHT);
            } else {
                stepCoordinates.setX(snakeHead.getX() + snakeDirection.getX());
                stepCoordinates.setY(snakeHead.getY() + snakeDirection.getY());
                game.getSnake().moveStep(stepCoordinates);
            }

            game.updateScore();
        } while (!game.hasCollided());

        System.out.println("GAME OVER!");
        System.out.println("Final score: " + game.getScore());

        input.close();
    }
}
