package Lesson1_HomeWork.Course;

import Lesson1_HomeWork.Skils.Jumpable;
import Lesson1_HomeWork.Team.Team;

public class Wall implements Course{
    private final double heigh;

    public Wall(double heigh) {
        this.heigh = heigh;
    }

    @Override
    public boolean doIt (Team team){
        if (team instanceof Jumpable){
            return ((Jumpable)team).jump(heigh);
        }
        return false;
    }

}
