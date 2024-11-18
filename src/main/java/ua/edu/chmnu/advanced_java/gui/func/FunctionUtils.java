package ua.edu.chmnu.advanced_java.gui.func;

import org.jfree.data.json.JSONUtils;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionUtils {

    private static Point[] fX;

    public static ExtremeType resolveExtremeType(double[] y) {
        if (y[1] > y[0] && y[1] > y[2]) {
            return ExtremeType.MAX;
        }

        if (y[1] < y[0] && y[1] < y[2]) {
            return ExtremeType.MIN;
        }

        return ExtremeType.NONE;
    }

    private static void printExtreme(ExtremeType type)
    {
        if(type == ExtremeType.MAX) {
            System.out.println("Max is:");
        }
        if(type == ExtremeType.MIN) {
            System.out.println("Min is:");
        }
    }

    public static void generateBy(Function<Double, Double> function, double a, double b, double h) {
        Point[] temp = new Point[2000000];
        int count = 0;
        for (double x = a; x < b - h; x += h) {
            double[] y = {
                    function.apply(x),
                    function.apply(x + h),
                    function.apply(x + 2 * h)
            };
            ExtremeType extremeType = resolveExtremeType(y);
            printExtreme(extremeType);
            System.out.printf("x = %.2f y = " + y[0] + "\n", x);
            if(x >= b - 2 * h)
            {
                System.out.printf("x = %.2f y = " + y[1], x + h);
            }
            temp[count++] = new Point(x + h, y[1], extremeType);
        }
        fX = Arrays.copyOf(temp, count);
    }

    public static Point[] getfX() {
        return fX;
    }

    public static void setfX(Point[] fX) {
        FunctionUtils.fX = fX;
    }
}
