package Lesson1_HomeWork;

import Lesson1_HomeWork.Course.Course;
import Lesson1_HomeWork.Course.Racetrack;
import Lesson1_HomeWork.Course.Wall;
import Lesson1_HomeWork.Team.Cat;
import Lesson1_HomeWork.Team.Human;
import Lesson1_HomeWork.Team.Robot;
import Lesson1_HomeWork.Team.Team;

public class Main {

    public static void main(String[] args) {
        Team[] team = { new Human("Вася",4,500),
                        new Cat("Барсик",2,200),
                        new Robot("XGhky123",6,1500)};

        Course[] course = { new Wall(3),
                            new Racetrack(800)};

        System.out.println(team[0].toString());
        System.out.println(team[1].toString());
        System.out.println(team[2].toString());

        for (Team team1: team) {
            for (Course course1: course) {
                course1.doIt(team1);
            }
        }


    }
}
