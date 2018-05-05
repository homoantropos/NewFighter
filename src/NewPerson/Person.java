package NewPerson;

import java.util.Objects;

public class Person implements Comparable <Person> {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public int compareTo (Person p) {
        return this.age.compareTo(p.getAge());
    }

    public void printTitle () {
        System.out.println(String.format("%-35s %3s", "               П.І. по Б", "  ВІК"));
        System.out.println(String.format("%-35s %3s", "-------------------------------------", "---"));
    }


    @Override
    public String toString() {
        return (String.format("%-35s %3d", name, age));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
                Objects.equals(getAge(), person.getAge());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAge());
    }
}
