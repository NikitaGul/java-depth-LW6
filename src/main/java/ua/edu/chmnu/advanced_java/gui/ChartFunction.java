package ua.edu.chmnu.advanced_java.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ua.edu.chmnu.advanced_java.gui.func.FunctionUtils;
import ua.edu.chmnu.advanced_java.gui.func.Point;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

public class ChartFunction extends JFrame {

    private final JFreeChart chart;

    private final ChartPanel panel;

    private final XYSeries xySeries = new XYSeries("e^(-a * x) * cos(b * c + c) + e^(a * x) * sin(c * x - 1)");

    private final XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
    private final Point[] points;

    public ChartFunction(String title, Point[] points) throws HeadlessException {
        this.points = points;

        setTitle(title);

        xySeriesCollection.addSeries(xySeries);

        chart = ChartFactory.createXYLineChart("y=f(x)", "x", "y", xySeriesCollection);

        fillSeriousCollection(xySeries);

        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(600, 480));

        setContentPane(panel);

        pack();

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static double f(double x) {
        double a = 0.01, b = 5.0, c = 4.1;
        double e = Math.exp(a * x);
        return  Math.cos(b * x + c) / e + e * Math.sin(c * x - 1);
    }


    private void fillSeriousCollection(XYSeries series) {
        for(var point: points) {
            series.add(point.x(), point.y());
        }
    }


    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        FunctionUtils.generateBy(x -> f(x), -10.0, 10.0, 0.1);
        ua.edu.chmnu.advanced_java.gui.func.Point[] points1 = FunctionUtils.getfX();
        EventQueue.invokeAndWait(() -> new ChartFunction("Графік функції", points1));
    }
}
