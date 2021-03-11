package Lesson1_HomeWork;

public class Wall {
    private double heigh;

    public Wall(double heigh) {
        this.heigh = heigh;
    }

    public void needJump (Team team){
        team.jump(heigh);
    }


}
