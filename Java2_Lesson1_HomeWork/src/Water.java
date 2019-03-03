public class Water extends Obstacle {

    Water(int size) {
        super(size);
    }

    @Override
    public void doIt(Animal a) {
        if (a instanceof Swimable) {
            ((Swimable) a).swim(size);
        } else {
            a.setOnDistance(false);
        }
    }
}
