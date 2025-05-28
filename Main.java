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

            if (keyPressed == 'w') {
                stepCoordinates.setX(snakeHead.getX() + Directions.UP.getX());
                snake.setDirection(Directions.UP);
            } else if (keyPressed == 's') {
                stepCoordinates.setX(snakeHead.getX() + Directions.DOWN.getX());
                snake.setDirection(Directions.DOWN);
            } else if (keyPressed == 'a') {
                stepCoordinates.setY(snakeHead.getY() + Directions.LEFT.getY());
                snake.setDirection(Directions.LEFT);
            } else if (keyPressed == 'd') {
                stepCoordinates.setY(snakeHead.getY() + Directions.RIGHT.getY());
                snake.setDirection(Directions.RIGHT);
            } else {
                stepCoordinates.setX(snakeHead.getX() + snakeDirection.getX());
                stepCoordinates.setY(snakeHead.getY() + snakeDirection.getY());
            }

            snake.moveStep(stepCoordinates);
            game.updateScore();
        } while (!game.hasCollided());

        System.out.println("GAME OVER!");
        System.out.println("Final score: " + game.getScore());

        input.close();
    }
}
