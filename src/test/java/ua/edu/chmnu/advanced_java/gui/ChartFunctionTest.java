package ua.edu.chmnu.advanced_java.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChartFunctionTest {

    @Test
    void testF() {

        double x = 2.5;
        double expected = ChartFunction.f(x);
        expected = ChartFunction.f(x) * 100;
        expected = Math.round(expected) / 100.0;
        assertEquals(-0.43, expected);
        }

}