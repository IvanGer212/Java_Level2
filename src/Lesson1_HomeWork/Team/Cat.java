package Lesson1_HomeWork.Team;

import Lesson1_HomeWork.Skils.Jumpable;
import Lesson1_HomeWork.Skils.Runable;

public class Cat implements Team,  Runable, Jumpable {
    private final String name;
    private final double maxHeighJump;
    private final double maxDistance;

    public Cat(String name, double maxHeighJump, double maxDistance) {
        this.name = name;
        this.maxHeighJump = maxHeighJump;
        this.maxDistance = maxDistance;
    }

    public boolean run (double distance){
        if (distance<=maxDistance){
            System.out.printf("Кот %s пробежал %s метров %n", name, distance);
            return true;
        } else {
            System.out.printf("Кот %s не смог пробежать %s метров %n", name, distance);
        }
        return false;

    }

    public boolean jump(double height){
        if (height<=maxHeighJump){
            System.out.printf("Кот %s прыгнул на высоту %s метров %n", name, height);
            return true;
        } else{
            System.out.printf("Кот %s не смог прыгнуть на высоту %s метров %n", name, height);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", maxHeighJump=" + maxHeighJump +
                ", maxDistance=" + maxDistance +
                '}';
    }
}
