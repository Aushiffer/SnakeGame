public class CoordinateTuple<Fst, Snd> {
    private Fst x;
    private Snd y;

    public CoordinateTuple(Fst x, Snd y) {
        this.setX(x);
        this.setY(y);
    }

    public CoordinateTuple() {
    
    }

    public void setX(Fst x) { this.x = x; }
    public void setY(Snd y) { this.y = y; }
    public Fst getX() { return this.x; }
    public Snd getY() { return this.y; }
}
