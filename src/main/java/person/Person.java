package person;

import java.util.Objects;

public class Person {
    private Name name;
    private String eyeColor;
    private String hairColor;
    private String height;
    private String weight;

    public Person(Name name, String eyeColor, String hairColor, String height, String weight) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.height = height;
        this.weight = weight;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
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
        return name.equals(person.name) &&
                eyeColor.equals(person.eyeColor) &&
                hairColor.equals(person.hairColor) &&
                height.equals(person.height) &&
                weight.equals(person.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eyeColor, hairColor, height, weight);
    }

    public String getHashCode() {
        return String.valueOf(hashCode());
    }
}

