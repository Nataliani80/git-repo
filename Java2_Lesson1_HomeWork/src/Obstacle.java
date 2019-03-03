public abstract class Obstacle {
    final int size;

    Obstacle(int size) {
        this.size = size;
    }

    public abstract void doIt(Animal a);
}
