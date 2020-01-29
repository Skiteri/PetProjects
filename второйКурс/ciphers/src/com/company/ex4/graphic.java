package com.company.ex4;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.*;

public class graphic {
    static Map<Double, Double> a = new TreeMap<>();

    static void addGraph(double count_symbols, double mistakes){
        a.put(count_symbols, mistakes);
    }

    static void draw() {
        double[] xData = new double[a.size()];
        double[] yData = new double[a.size()];
        Iterator<Double> scan = a.keySet().stream().iterator();
        for (int i = 0; i < a.size(); i++) {
            xData[i] = scan.next();
            yData[i] = a.get(xData[i]);
        }

        XYChart chart = QuickChart.getChart("sas","Количество символов", "Количество правильных букв",
                "asd", xData, yData);
        new SwingWrapper(chart).displayChart();
    }
}
