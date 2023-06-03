package org.example.Lesson4;

public class Triangle {
    public static double calculateArea(int a, int b, int c) {
        // Проверяем, является ли треугольник допустимым
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Invalid side length");
        }

        double s = (a + b + c) / 2.0;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        return area;
    }
}

