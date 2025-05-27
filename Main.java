public class Main {
    public static void main(String[] args) {
        Game game = new Game(20, 50);
        game.initializeGame();

        System.out.println("OLD TUPLES");

        for (CoordinateTuple<Integer, Integer> segment : game.getSnake().getBody()) {
            System.out.println("(" + segment.getX() + ", " + segment.getY() + ")");
        }

        game.getSnake().moveStep(new CoordinateTuple<Integer, Integer>(10, 26));
        game.getSnake().moveStep(new CoordinateTuple<Integer, Integer>(10, 27));

        System.out.println("\nNEW TUPLES");

        for (CoordinateTuple<Integer, Integer> segment : game.getSnake().getBody()) {
            System.out.println("(" + segment.getX() + ", " + segment.getY() + ")");
        }

        game.render();
        System.out.println("COLLISION: " + game.hasCollided());
        System.out.println("OBTAINED APPLE: " + game.hasObtainedApple());
    }
}
