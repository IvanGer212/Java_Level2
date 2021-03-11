package Lesson1_HomeWork;

public class Robot implements Team{
    private String name;
    private double maxHeighJump;
    private double maxDistance;

    public Robot(String name, double maxHeighJump, double maxDistance) {
        this.name = name;
        this.maxHeighJump = maxHeighJump;
        this.maxDistance = maxDistance;
    }

    public void run(){
        System.out.printf("Робот %s пробежал %n",name);
    }

    public boolean jump(double height){
        if (height<=maxHeighJump){
            System.out.printf("Робот %s прыгнул на высоту %s метров %n", name, height);
            return true;
        } else{
            System.out.printf("Робот %s не смог прыгнуть на высоту %s метров %n", name, height);
        }
        return false;

    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", maxHeightJump=" + maxHeighJump +
                ", maxDistance=" + maxDistance +
                '}';
    }
}
