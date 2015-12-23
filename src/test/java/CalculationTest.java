/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import net.jan.sfr.calculation.BasicCalculation;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan
 */
public class CalculationTest {

    public CalculationTest() {
    }

    double[] testArray = {1.20, 2.20, 3.30, 4.12, 5.00, 6.00, 7.00};
    
    double[] testArray4 = {12.00, 11.00, 14.00, 15.00, 16.00};

    double[] testArray2 = {0.00, 0.00, 0.00, 14.00, 25.00, 46.00, 27.00};

    double[] testArray3 = {0, 0, 0, 14.3, 25.0, 46.2, 27.1};
    
    double[] testArray5 = {5.0, 6.0, 11.0, 8.0, 13.0, 8.0, 10.0, 16.0, 13.0};
    
    double[] testArray6 = {8.0, 7.0, 9.0, 10.0, 11.0, 10.0, 11.0, 12.0, 12.0};
    
    double[] testArray7 = {1.6,  1.9,  2.1,  3.2 , 0.5 , 0.4 , 0.6};
    
    double[] testArray8 = {2.0, 2.4, 2.6, 3.6, 0.9, 0.8, 1.0};


    @Test
    public void testAverage() throws ParseException {
        double result = BasicCalculation.calcAvgerage(testArray);
        assertThat(result, is(4.1171));

        result = BasicCalculation.calcAvgerage(testArray2);
        assertThat(result, is(16.0));

        result = BasicCalculation.calcAvgerage(testArray3);
        assertThat(result, is(16.0857));
        
        result = BasicCalculation.calcAvgerage(testArray4);
        assertThat(result, is(13.6));
    }

    @Test
    public void testStandardDeviation() {
         double result = BasicCalculation.calcStandardDeviation(testArray4);
         assertThat(result, is(1.8547));
    }
    
    @Test
    public void testCoviance() {
         double result = BasicCalculation.calcCovariance(testArray7, testArray8);
         assertThat(result, is(0.9343));
    }

}
