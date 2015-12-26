/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jan.sfr.calculation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jan
 */
public final class BasicCalculation {

    private static NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);

    private BasicCalculation() {
    }

    public static double calcAvgerage(double[] spotCheckValues) {
        if (spotCheckValues.length == 0) {
            throw new IllegalArgumentException("Arraylength is invalid");
        }
        return format((sum(spotCheckValues) / spotCheckValues.length));
    }

    public static double calcStandardDeviation(double[] array) {
        return format(Math.sqrt(calcVariance(array)));
    }

    public static double calcVariance(double[] array) {
        double avg = calcAvgerage(array);
        double counterValue = 0.0;
        for (double x : array) {
            counterValue += format(Math.pow(x - avg, 2));
        }
        return format(counterValue / array.length);
    }

    /**
     * The covariance describes the linear relationship between different
     * dimensions. The returnvalue describes the relationship.
     * <li> a <b>positive return value </b> means that both dimentions have a
     * same linear relationship. Both are growing with same strength. It's a
     * positive correlation.</li>
     * <li> a <b>negative return value </b> means that both dimentions have
     * different linear relationship. One is able to grow during the other is
     * falling.</li>
     * <li> a <b>zero value </b> means that both dimentions haven't a linear
     * relationship.</li>
     *
     * @param matrixes
     * @return value for covariance
     */
    public static double calcCovariance(double[]... matrixes) {
        double[] avgs = new double[matrixes.length];
        for (int i = 0; i < matrixes.length; i++) {
            avgs[i] = calcAvgerage(matrixes[i]);
        }

        List<Double> sums = new ArrayList<>();
        List<Double> mult = new ArrayList<>();
        for (int row = 0; row < matrixes[0].length; row++) {
            for (int col = 0; col < matrixes.length; col++) {
                mult.add(matrixes[col][row] - avgs[col]);
            }
            sums.add(multiply(mult));
            mult.clear();
        }
        return format(sum(sums) / matrixes[0].length);
    }

    public static double expectationValue() {
        return 0.0;
    }

    private static double sum(double[] array) {
        double result = 0.0;
        for (double val : array) {
            result += val;
        }
        return format(result);
    }
    
    private static double sum(List<Double> array) {
        double result = 0.0;
        for (double val : array) {
            result += val;
        }
        return format(result);
    }
    
    private static double multiply(List<Double> array) {
        double result = 1.0;
        for (double val : array) {
            result *= val;
        }
        return format(result);
    }

    private static double format(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#####.####");
        String tmp = decimalFormat.format(value);
        try {
            double myNumber = nf.parse(tmp).doubleValue();
            return myNumber;
        } catch (ParseException ex) {
            Logger.getLogger(BasicCalculation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 99999;
    }

}
