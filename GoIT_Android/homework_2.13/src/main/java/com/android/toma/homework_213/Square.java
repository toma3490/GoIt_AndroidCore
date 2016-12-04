package com.android.toma.homework_213;

public class Square {
    private int side;
    private long area;
    private long perimeter;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public long getArea() {
        return area = side * side;
    }

    public long getPerimeter() {
        return perimeter = side * 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (side != square.side) return false;
        if (area != square.area) return false;
        return perimeter == square.perimeter;

    }

    @Override
    public int hashCode() {
        int result = side;
        result = 31 * result + (int) (area ^ (area >>> 32));
        result = 31 * result + (int) (perimeter ^ (perimeter >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Square{" +
                " side = " + side +
                ", area = " + area +
                ", perimeter = " + perimeter +
                '}';
    }
}
