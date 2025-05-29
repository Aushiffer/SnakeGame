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

            Snake snake = game.getSnake();
            CoordinateTuple<Integer, Integer> snakeDirection = snake.getDirection();
            CoordinateTuple<Integer, Integer> snakeHead = snake.getBody().getFirst();
            CoordinateTuple<Integer, Integer> stepCoordinates = new CoordinateTuple<Integer, Integer>(snakeHead.getX(), snakeHead.getY());

            if (keyPressed == 'w' && snake.getDirection().getX() != Directions.DOWN.getX() && snake.getDirection().getY() != Directions.DOWN.getY()) {
                stepCoordinates.setX(snakeHead.getX() + Directions.UP.getX());
                snake.setDirection(Directions.UP);
            } else if (keyPressed == 's' && snake.getDirection().getX() != Directions.UP.getX() && snake.getDirection().getY() != Directions.UP.getY()) {
                stepCoordinates.setX(snakeHead.getX() + Directions.DOWN.getX());
                snake.setDirection(Directions.DOWN);
            } else if (keyPressed == 'a' && snake.getDirection().getX() != Directions.RIGHT.getX() && snake.getDirection().getY() != Directions.RIGHT.getY()) {
                stepCoordinates.setY(snakeHead.getY() + Directions.LEFT.getY());
                snake.setDirection(Directions.LEFT);
            } else if (keyPressed == 'd' && snake.getDirection().getX() != Directions.LEFT.getX() && snake.getDirection().getY() != Directions.LEFT.getY()) {
                stepCoordinates.setY(snakeHead.getY() + Directions.RIGHT.getY());
                snake.setDirection(Directions.RIGHT);
            } else {
                stepCoordinates.setX(snakeHead.getX() + snakeDirection.getX());
                stepCoordinates.setY(snakeHead.getY() + snakeDirection.getY());
            }

            snake.moveStep(stepCoordinates);
            game.updateScore();
        } while (!game.hasCollided());

        System.out.println("\nGAME OVER!");
        System.out.println("Final score: " + game.getScore());

        input.close();
    }
}
