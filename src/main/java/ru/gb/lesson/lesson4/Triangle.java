package ru.gb.lesson.lesson4;

import lombok.Data;
import org.junit.jupiter.api.*;

@Data
public class Triangle {
    private double a;
    private double b;
    private double c;
    private double p;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.p = (a + b + c) / 2;
    }

    public boolean isValid() {
        double maxSide = Math.max(a, Math.max(b, c));
        return maxSide < (a + b + c - maxSide);
    }

    public boolean hasPositiveSides() {
        return a > 0 && b > 0 && c > 0;

    }

    @DisplayName("Площадь треугольника по формуле Герона")
    public double countArea() {
        return Math.sqrt((p * (p - a) * (p - b) * (p - c)));
    }

}