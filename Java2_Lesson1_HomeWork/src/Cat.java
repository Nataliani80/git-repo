public class Cat extends Animal implements Jump {
    private int jumpHeight;

    Cat(int canRunDistance, String name, int jumpHeight) {
        super(canRunDistance, name);
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void doJump(int height) {
        if (this.jumpHeight < height) {
            setOnDistance(false);
        }
    }
}
