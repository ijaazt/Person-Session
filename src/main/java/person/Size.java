package person;

import java.util.Objects;

public class Size {
    private int feet;
    private int inch;
    Size(int feet, int inch) {
        this.feet=feet;
        this.inch = inch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return feet == size.feet &&
                inch == size.inch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feet, inch);
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }
}
