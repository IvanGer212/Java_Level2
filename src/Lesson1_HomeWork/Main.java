package Lesson1_HomeWork;

public class Main {

    public static void main(String[] args) {
    Human human = new Human("Вася");
    Cat cat = new Cat("Барсик");
    Robot robot = new Robot("XGhky123");

        System.out.println(human.toString());
        System.out.println(cat.toString());
        System.out.println(robot.toString());

    human.run();
    cat.jump();
    robot.run();
    robot.jump();

    }
}
