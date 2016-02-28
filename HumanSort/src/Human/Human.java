package Human;

/**
 * Created by farkh on 24/02/16.
 */
public class Human {
    private final int DEFAULT_AGE = 0;
    private final String DEFAULT_NAME = "unnamed";

    public int age;
    public String name;
    public int count;

    public Human() {
        initHuman(DEFAULT_NAME, DEFAULT_AGE);
    }

    public Human(String name, int age) {
        initHuman(name, age);
    }

    public void initHuman(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + "\n";
    }
}
