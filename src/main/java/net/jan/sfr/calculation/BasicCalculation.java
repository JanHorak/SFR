/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jan.sfr.calculation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jan
 */
public final class BasicCalculation {
    
    private static NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
        
    
    private BasicCalculation(){}
    
    public static double calcAvgerage(double[] spotCheckValues){
        if (spotCheckValues.length == 0){
            throw new IllegalArgumentException("Arraylength is invalid");
        }
        return format((sum(spotCheckValues) / spotCheckValues.length));
    }
    
    public static double calcStandardDeviation(double[] array){
        return format(Math.sqrt(calcVariance(array)));
    }
    
    public static double calcVariance(double[] array){
        double avg = calcAvgerage(array);
        double counterValue = 0.0;
        for (double x : array){
            counterValue += format(Math.pow(x-avg, 2));
        }
        return format(counterValue/array.length);
    }
    
    public static double calcCovariance(double[] array1, double[] array2){
        double avgArrayOne = calcAvgerage(array1);
        double avgArrayTwo = calcAvgerage(array2);
        double sumArray1[] = new double[array1.length];
        double sumArray2[] = new double[array2.length];
        double multipliedResult = 0.0;
        for (int i = 0; i < array1.length; i++){
            sumArray1[i] += format(array1[i] - avgArrayOne);
        }
        for (int i = 0; i < array2.length; i++){
            sumArray2[i] += format(array2[i] - avgArrayTwo);
        }
           
        for (int i = 0; i < array1.length; i++){
            multipliedResult += sumArray1[i]*sumArray2[i];
        }
        
        return format(multipliedResult/array1.length);
    }
    
    public static double expectationValue(){
        return 0.0;
    }
    
    private static double sum(double[] array){
        double result = 0.0;
        for (double val : array){
            result += val;
        }
        return format(result);
    }
    
    private static double format(double value){
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
