import java.util.Random;

public class Game extends Directions {
    private int score, height, width;
    private Snake snake;
    private Apple apple;
    private char[][] board;
    private static final char HEAD_CHAR = '@';
    private static final char BODY_CHAR = 'O';
    private static final char APPLE_CHAR = '*';

    public Game(int height, int width) {
        this.setHeight(height);
        this.setWidth(width);
        this.setScore(0);
        this.board = generateBoard();
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
                    board[i][j] = ' ';
            }
        }
                
        return board;
    }

    public void render() {
        this.updateBoard();

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++)
                System.out.print(this.board[i][j]);

            System.out.println("");
        }
    }

    public void updateBoard() {
        for (int i = 0; i < this.snake.getBody().size(); i++)
            this.board[this.snake.getBody().get(i).getX()][this.snake.getBody().get(i).getY()] = (i == 0) ? HEAD_CHAR : BODY_CHAR;

        if (this.hasObtainedApple()) {
            Random random = new Random();
            int appleX = random.nextInt(1, height - 2);
            int appleY = random.nextInt(1, width - 2);

            this.apple.setCoordinates(new CoordinateTuple<Integer, Integer>(appleX, appleY));
            this.board[this.apple.getCoordinates().getX()][this.apple.getCoordinates().getY()] = '*';
        }
    }

    public boolean hasCollided() {
        if (
            this.board[this.snake.getBody().getFirst().getX()][this.snake.getBody().getFirst().getY()] != ' ' 
            && this.board[this.snake.getBody().getFirst().getX()][this.snake.getBody().getFirst().getY()] != '*'
        )
            return false;
        
        return true;
    }

    public boolean hasObtainedApple() {
        if (!(this.snake.getBody().getFirst().getX() == this.apple.getCoordinates().getX() && this.snake.getBody().getFirst().getY() == this.apple.getCoordinates().getY()))
            return false;

        return true;
    }

    public void initializeGame() {
        Random random = new Random();
        int appleX = random.nextInt(1, height - 2);
        int appleY = random.nextInt(1, width - 2);

        this.snake = new Snake(new CoordinateTuple<Integer, Integer>(10, 25), UP);
        this.apple = new Apple(1, new CoordinateTuple<Integer, Integer>(appleX, appleY));
        this.board[this.apple.getCoordinates().getX()][this.apple.getCoordinates().getY()] = '*';
    }
}