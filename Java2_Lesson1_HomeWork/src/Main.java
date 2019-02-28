public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat(5, "Кот Борис", 3),
                new Cat(7, "Кот Мурзик", 4),
                new Dog(5, "Пес Шарик",10, 3),
                new Duck(3, "Утка Кряква",10)
        };
        Team dreamTeam = new Team ("DreamTeam", animals);

        Obstacle[] obstacles = {new Road(8), new Water(3), new Wall(3)};
        Course course = new Course(obstacles);

        course.doIt(dreamTeam);

        dreamTeam.showTeamInfo();
        System.out.println();
        dreamTeam.showResults();
    }

}
