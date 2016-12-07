package com.android.toma.homework_23;

import java.util.ArrayList;
import java.util.List;

public class Parabola {

    private double a;
    private double b;
    private double c;
    private double x;
    private double y;
    private double diskriminant;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double countD(){
        diskriminant = b * b - 4 * a * (c - y);
        return diskriminant;
    }

    public List<Double> countXRoots(){
        ArrayList<Double> roots = new ArrayList<>();
        double disk = countD();
        if (b == 0 && c == 0){
            roots.add(Math.sqrt(y / a));
            roots.add(Math.sqrt(y / a) * -1);
        }
        if (b == 0 && c != 0){
            roots.add(Math.sqrt((y - c) / a));
            roots.add(Math.sqrt((y - c) / a) * -1);
        }
        if (b != 0 && c == 0){
            roots.add(0.0);
            roots.add((y - b) / a);
        }else{
            if (disk > 0){
                roots.add((-b + Math.sqrt(disk)) / 2 * a);
                roots.add((-b - Math.sqrt(disk)) / 2 * a);
            }
            if (disk == 0){
                roots.add(-b / 2 * a);
            }
            if (disk < 0){
                throw new IllegalArgumentException("Парабола не пересекает ось Х!");
            }
        }
        return roots;
    }

    public double countY(){
        return y = a * x * x + b * x + c;
    }
}
