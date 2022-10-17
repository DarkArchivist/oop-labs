package common.base;

public abstract class Person extends BaseEntity {
    protected final String firstName;
    protected final String lastName;

    protected int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
