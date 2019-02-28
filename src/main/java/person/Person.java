package person;

import java.util.Objects;

public class Person {
    private Name name;
    private String eyeColor;
    private String hairColor;
    private Size height;
    private String weight;
    final private Long id;

    public Person(Name name, String eyeColor, String hairColor, Size height, String weight, long id) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.height = height;
        this.weight = weight;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public Size getHeight() {
        return height;
    }

    public void setHeight(Size height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(eyeColor, person.eyeColor) &&
                Objects.equals(hairColor, person.hairColor) &&
                Objects.equals(height, person.height) &&
                Objects.equals(weight, person.weight) &&
                Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eyeColor, hairColor, height, weight, id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name=").append(name);
        sb.append(", eyeColor='").append(eyeColor).append('\'');
        sb.append(", hairColor='").append(hairColor).append('\'');
        sb.append(", height=").append(height);
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

