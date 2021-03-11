package Lesson1_HomeWork;

public class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void run (){
        System.out.printf("Человек %s пробежал %n", name);
    }

    public void jump(){
        System.out.printf("Человек %s прыгнул %n", name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
