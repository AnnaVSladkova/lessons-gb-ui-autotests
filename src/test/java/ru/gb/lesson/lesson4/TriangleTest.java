package ru.gb.lesson.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Треугольник")
public class TriangleTest {
    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(3, 3, 3), 3.897114317029974),
                Arguments.of(new Triangle(3, 4, 6), 5.332682251925386));
    }

    @ParameterizedTest(name = "Площадь треугольника по формуле Герона {0} равна {1}")
    @MethodSource("triangles")
    public void countAreaTriangle(Triangle triangle, double expectedArea) {
        double area = triangle.countArea();
        assertEquals(expectedArea, area);
    }

    @ParameterizedTest(name = "Проверка допустимости сторон треугольника")
    @MethodSource("triangles")
    public void validateTriangleSides(Triangle triangle) {
        assertEquals(triangle.isValid(), true);
        assertEquals(triangle.hasPositiveSides(), true);
    }
  }
