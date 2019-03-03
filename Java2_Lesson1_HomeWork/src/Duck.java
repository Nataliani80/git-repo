public class Duck extends Animal implements Swimable {
    int canSwimDistance;

    public Duck(int canRunDistance, String name, int canSwimDistance) {
        super(canRunDistance, name);
        this.canSwimDistance = canSwimDistance;

    }

    @Override
    public void swim(int distance) {
        if (this.canSwimDistance < distance) {
            setOnDistance(false);
        }
    }
}
