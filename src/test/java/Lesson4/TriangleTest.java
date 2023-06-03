package Lesson4;

import org.example.Lesson4.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    void testCalculateArea() {
        // Проверяем вычисление площади для треугольника с сторонами 3, 4 и 5
        assertEquals(6.0, Triangle.calculateArea(3, 4, 5), 0.0001);

        // Дополните тестами для других треугольников
    }
}