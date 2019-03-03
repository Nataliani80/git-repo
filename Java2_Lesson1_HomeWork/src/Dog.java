public class Dog extends Animal implements Swimable, Jump {
    private final int canSwimDistance;
    private int jumpHeight;

    protected Dog(int canSwimDistance, String name, int runDistance, int jumpHeight) {
        super(runDistance, name);
        this.canSwimDistance = canSwimDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void swim(int canSwimDistance) {
        if (this.canSwimDistance < canSwimDistance) {
            setOnDistance(false);
        }
    }

    @Override
    public void doJump(int height) {
        if (this.jumpHeight < height) {
            setOnDistance(false);
        }
    }

    @Override
    public void run(int dist) {
        super.run(dist);
        //dosomehting
    }
}
