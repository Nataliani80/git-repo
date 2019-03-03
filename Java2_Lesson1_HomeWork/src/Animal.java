public class Animal implements Run {

    private String name;
    private int canRunDistance;
    private boolean onDistance = true;

    public Animal(int canRunDistance, String name) {
        this.canRunDistance = canRunDistance;
        this.name = name;
    }

    boolean isOnDistance() {
        return onDistance;
    }

    void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }

    @Override
    public void run(int dist) {
        if (this.canRunDistance < dist) {
            this.onDistance = false;
        }
    }

    String getName() {
        return name;
    }
}
