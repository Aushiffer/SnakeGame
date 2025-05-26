public class Apple {
    private int points;
    private CoordinateTuple<Integer, Integer> coordinates;

    public Apple(int points, CoordinateTuple<Integer, Integer> startCoords) {
        this.setPoints(points);
        this.coordinates = startCoords;
    }

    public void setPoints(int points) {
        if (points > 0)
            this.points = points;
    }

    public void setCoordinates(CoordinateTuple<Integer, Integer> coordinates) {
        if (coordinates != null)
            this.coordinates = coordinates;
    }

    public int getPoints() { return this.points; }
    public CoordinateTuple<Integer, Integer> getCoordinates() { return this.coordinates; }
}