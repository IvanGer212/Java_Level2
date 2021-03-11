package Lesson1_HomeWork;

public class Main {

    public static void main(String[] args) {
        Team[] team = {new Human("Вася",4,500), new Cat("Барсик",2,200), new Robot("XGhky123",6,1500)};
    //Human human = new Human("Вася",4,500);
    //Cat cat = new Cat("Барсик");
    //Robot robot = new Robot("XGhky123");
    Wall wall1 = new Wall(3);

        System.out.println(team[0].toString());
        System.out.println(team[1].toString());
        System.out.println(team[2].toString());

        for (Team team1: team) {
            wall1.needJump(team1);
        }


    }
}
