package Lesson1_HomeWork.Course;

import Lesson1_HomeWork.Skils.Runable;
import Lesson1_HomeWork.Team.Team;

public class Racetrack implements Course{
    private double distance;

    public Racetrack(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean doIt (Team team){
        if (team instanceof Runable){
            return team.run(distance);
        }
     return false;
    }

}
