package Lesson1_HomeWork;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void run(){
        System.out.printf("Кот %s пробежал %n", name);
    }

    public void jump(){
        System.out.printf("Кот %s прыгнул %n", name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
