import java.util.ArrayList;

public class Snake {
    private CoordinateTuple<Integer, Integer> direction;
    private ArrayList<CoordinateTuple<Integer, Integer>> body = new ArrayList<CoordinateTuple<Integer, Integer>>();
    private final int STARTING_SNAKE_SIZE = 4;

    public Snake(CoordinateTuple<Integer, Integer> startPosition, CoordinateTuple<Integer, Integer> startDirection) {
        if (startDirection != null && startDirection != null) {
            this.direction = startDirection;
            
            for (int i = 0; i < STARTING_SNAKE_SIZE; i++) {
                this.addSegment(startPosition);
                
                startPosition.setX(startPosition.getX() + 1);
            }
        }
    }

    public void setDirection(CoordinateTuple<Integer, Integer> direction) {
        if (direction != null) this.direction = direction;
    }

    public CoordinateTuple<Integer, Integer> getDirection() { return this.direction; }
    public ArrayList<CoordinateTuple<Integer, Integer>> getBody() { return this.body; }

    public void addSegment(CoordinateTuple<Integer, Integer> coordinates) {
        if (coordinates != null) 
            this.body.add(new CoordinateTuple<Integer, Integer>(coordinates.getX(), coordinates.getY()));
    }

    public void moveStep(CoordinateTuple<Integer, Integer> position) {
        if (position != null) {
            CoordinateTuple<Integer, Integer> previous = new CoordinateTuple<Integer, Integer>(this.body.getFirst().getX(), this.body.getFirst().getY());

            this.body.getFirst().setX(position.getX());
            this.body.getFirst().setY(position.getY());
            
            for (int i = 1; i < this.body.size(); i++) {
                CoordinateTuple<Integer, Integer> current = new CoordinateTuple<Integer, Integer>(this.body.get(i).getX(), this.body.get(i).getY());

                this.body.get(i).setX(previous.getX());
                this.body.get(i).setY(previous.getY());

                previous = current;
            }
        }
    }
}