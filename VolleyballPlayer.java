package Homework;

public class VolleyballPlayer implements Gettable {
    private String name;
    private int age;
    private String position;
    private int strength;
    private int health;

    public VolleyballPlayer(){

    }

    public VolleyballPlayer(String name, int age, String position, int strength, int health) {
        this.name = name;
        this.age = age;
        this.position = position;
        setStrength(strength);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStrength(int strength) {
        if (strength < 1 || strength > 10) {
            System.out.println("Input number needs to be between 1 to 10");
        } else {
            this.strength = strength;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 1 || health > 5) {
            System.out.println("Input number needs to be between 1 to 5" + this.getName());
        } else {
            this.health = health;
        }
    }

    @Override
    public void train() {
        if (this.getHealth() < 2) {
            System.out.println(this.getName() + " can't play, will have more rest!");
        } else {
            System.out.print(this.getName() + " is training!");
            setStrength(getStrength() + 1);
            setHealth(getHealth() - 1);
        }
    }



    @Override
    public void rest() {
        System.out.print(getName() + " is resting!");
        setHealth(getHealth() + 1);
    }

    @Override
    public String toString() {
        return "\n"+ "-> name=" + name +
                ", age=" + this.age +
                ", position=" + this.position +
                ", skills=" + strength +
                ", condition=" + health +
                "<-";
    }

//    enum Position {
//        S("Setter"),
//        L("Libero"),
//        MB("Middle blocker"),
//        OH("Outside hitter"),
//
//        DS("Defensive specialist"),
//
//        SS("Serving specialist");
//
//        Position(String setter) {
//        }
//    }
}
