import java.util.Random;

public class Game {
    private int score, height, width;
    private Snake snake;
    private Apple apple;
    private char[][] board;
    private static final char HEAD_CHAR = '@';
    private static final char BODY_CHAR = 'O';
    private static final char APPLE_CHAR = '*';
    private static final char BLANK = ' ';

    public Game(int height, int width) {
        Random random = new Random();

        this.setHeight(height);
        this.setWidth(width);
        this.setScore(0);
        this.board = generateBoard();

        int appleX = random.nextInt(1, height - 2);
        int appleY = random.nextInt(1, width - 2);

        this.snake = new Snake(new CoordinateTuple<Integer, Integer>(5, 5), Directions.UP);
        this.apple = new Apple(1, new CoordinateTuple<Integer, Integer>(appleX, appleY));
        this.board[appleX][appleY] = APPLE_CHAR;
    }

    public void setHeight(int height) { 
        if (height > 0)
            this.height = height;
    }

    public void setWidth(int width) {
        if (width > 0)
            this.width = width;
    }

    public void setScore(int score) {
        if (score >= 0)
            this.score = score;
    }

    public int getHeight() { return this.height; }
    public int getWidth() { return this.width; }
    public int getScore() { return this.score; }
    public Snake getSnake() { return this.snake; }
    public Apple getApple() { return this.apple; }
    public char[][] getBoard() { return this.board; }

    public char[][] generateBoard() {
        char[][] board = new char[this.height][this.width];

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if ((i == 0 && (j == width - 1 || j == i)) || (i == height - 1 && (j == width - 1 || j == 0)))
                    board[i][j] = '+';
                else if ((j == 0 || j == this.width - 1) && i != 0 && i != height - 1) 
                    board[i][j] = '|';
                else if ((i == 0 || i == this.height - 1) && j != 0 && j != width - 1)
                    board[i][j] = '-';
                else
                    board[i][j] = BLANK;
            }
        }
                
        return board;
    }

    public void render() {
        this.updateSnake();
        this.updateBoard();

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++)
                System.out.print(this.board[i][j]);

            System.out.println("");
        }
    }

    public void updateBoard() {
        for (int i = 0; i < this.snake.getBody().size(); i++) {
            CoordinateTuple<Integer, Integer> currentSegment = this.snake.getBody().get(i);

            if (i == 0)
                this.board[currentSegment.getX()][currentSegment.getY()] = HEAD_CHAR;
            else if (i == this.snake.getBody().size() - 1)
                this.board[currentSegment.getX()][currentSegment.getY()] = BLANK;
            else
                this.board[currentSegment.getX()][currentSegment.getY()] = BODY_CHAR;
        }

        if (this.hasObtainedApple()) {
            Random random = new Random();
            int appleX = random.nextInt(1, height - 2);
            int appleY = random.nextInt(1, width - 2);

            this.apple.setCoordinates(new CoordinateTuple<Integer, Integer>(appleX, appleY));
            this.board[appleX][appleY] = APPLE_CHAR;
        }
    }

    public void updateScore() {
        if (this.hasObtainedApple())
            this.score += this.getApple().getPoints();
    }

    public void updateSnake() {
        if (this.hasObtainedApple()) {
            CoordinateTuple<Integer, Integer> snakeTail = this.snake.getBody().getLast();

            this.getSnake().addSegment(new CoordinateTuple<Integer, Integer>(snakeTail.getX(), snakeTail.getY()));
        }
    }

    public boolean hasCollided() {
        CoordinateTuple<Integer, Integer> snakeHead = this.snake.getBody().getFirst();

        for (int i = 1; i < this.snake.getBody().size(); i++) {
            CoordinateTuple<Integer, Integer> currentSegment = this.snake.getBody().get(i);

            if (
                (snakeHead.getX() == currentSegment.getX() && snakeHead.getY() == currentSegment.getY())
                || (this.board[snakeHead.getX()][snakeHead.getY()] == '-' || this.board[snakeHead.getX()][snakeHead.getY()] == '|')
            )
                return true;
        }
        
        return false;
    }

    public boolean hasObtainedApple() {
        CoordinateTuple<Integer, Integer> snakeHead = this.snake.getBody().getFirst();
        CoordinateTuple<Integer, Integer> appleCoordinates = this.apple.getCoordinates();

        if (snakeHead.getX() == appleCoordinates.getX() && snakeHead.getY() == appleCoordinates.getY())
            return true;

        return false;
    }
}