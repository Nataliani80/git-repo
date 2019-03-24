public class Team {

    private String teamName;
    Animal[] members;

    public Team(String teamName, Animal[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    void showTeamInfo() {
        for (Animal teamMember : members) {
            System.out.println(teamMember.getName() + " on distance " + teamMember.isOnDistance());
        }
    }

    void showResults() {
        for (Animal teamMember : members) {
            if (teamMember.isOnDistance()) {
                System.out.println("В команде " + teamName + " участник: " + teamMember.getName() + " прошел всю дистанцию.");
            }
        }
    }


}
