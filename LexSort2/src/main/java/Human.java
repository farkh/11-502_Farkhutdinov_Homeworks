/**
 * Created by farkh on 06/04/16.
 */
public class Human {
    private final int DEFAULT_AGE = 0;
    private final String DEFAULT_NAME = "unnamed";

    private String name;
    private int age;

    public Human() {
        initHuman(DEFAULT_NAME, DEFAULT_AGE);
    }

    public Human(String name, int age) {
        initHuman(name, age);
    }

    private void initHuman(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public boolean equals(Object second) {
        if (second == null) {
            return false;
        }

        if (!(second instanceof Human)) {
            return false;
        }

        if (second == this) {
            return true;
        }

        Human another = (Human) second;
        if (another.toString().equals(this.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
