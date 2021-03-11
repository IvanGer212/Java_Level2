package Lesson1_HomeWork;

public class Robot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public void run(){
        System.out.printf("Робот %s пробежал %n",name);
    }

    public void jump(){
        System.out.printf("Робот %s прыгнул %n",name);

    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}
