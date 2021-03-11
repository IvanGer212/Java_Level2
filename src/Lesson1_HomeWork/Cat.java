package Lesson1_HomeWork;

public class Cat implements Team {
    private String name;
    private double maxHeighJump;
    private double maxDistance;

    public Cat(String name, double maxHeighJump, double maxDistance) {
        this.name = name;
        this.maxHeighJump = maxHeighJump;
        this.maxDistance = maxDistance;
    }

    public void run(){
        System.out.printf("Кот %s пробежал %n", name);
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
