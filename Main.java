public class Main {
    public static void main(String[] args) {
        Game game = new Game(20, 50);
        game.initializeGame();

        System.out.println("OLD TUPLES");

        for (CoordinateTuple<Integer, Integer> segment : game.getSnake().getBody()) {
            System.out.println("(" + segment.getX() + ", " + segment.getY() + ")");
        }

        char[][] board = game.generateBoard();

        game.getSnake().moveStep(new CoordinateTuple<Integer, Integer>(10, 26));

        System.out.println("\nNEW TUPLES");

        for (CoordinateTuple<Integer, Integer> segment : game.getSnake().getBody()) {
            System.out.println("(" + segment.getX() + ", " + segment.getY() + ")");
        }
        
        board[game.getApple().getCoordinates().getX()][game.getApple().getCoordinates().getY()] = '*';
        game.render(board);
    }
}
