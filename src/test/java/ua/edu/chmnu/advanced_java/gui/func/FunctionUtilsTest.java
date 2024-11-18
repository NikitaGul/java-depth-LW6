package ua.edu.chmnu.advanced_java.gui.func;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionUtilsTest {

    @Test
    void resolveExtremeType1(){
       double[] y1 = {2.4, 2.5, 6.3};
       assertEquals(ExtremeType.NONE, FunctionUtils.resolveExtremeType(y1));
    }

    @Test
    void resolveExtremeType2() {
        double[] y2 = {2.5, 4.5, 2.5};
        assertEquals(ExtremeType.MAX, FunctionUtils.resolveExtremeType(y2));
    }

    @Test
    void resolveExtremeType3(){
        double[] y3 = {4.6, 2.4, 5.5};
        assertEquals(ExtremeType.MIN, FunctionUtils.resolveExtremeType(y3));
    }

    @Test
    void generateBy() {
        Point[] res = new Point[2];
        res[0] = new Point(1.0, 2.0, ExtremeType.NONE);
        res[1] = new Point(2.0, 3.0, ExtremeType.NONE);

        FunctionUtils.generateBy(x -> x + 1,0.0, 3.0, 1.0);

        assertArrayEquals(res, FunctionUtils.getfX());
    }
}