public class Wall extends Obstacle {

    Wall(int size) {
        super(size);
    }

    @Override
    public void doIt(Animal a) {
        if (a instanceof Jump) {
            ((Jump) a).doJump(size);
        } else {
            a.setOnDistance(false);
        }
    }
}
