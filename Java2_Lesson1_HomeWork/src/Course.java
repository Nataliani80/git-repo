public class Course {

    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    void doIt(Team team) {
        for (Obstacle obstacle : obstacles) {
            for (Animal teamMember : team.members) {
                if (teamMember.isOnDistance()) {
                    obstacle.doIt(teamMember);
                }
            }
        }
    }
}
