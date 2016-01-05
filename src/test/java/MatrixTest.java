/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import net.jan.sfr.calculation.BasicCalculation;
import net.jan.sfr.calculation.Matrix;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jan
 */
public class MatrixTest {

    double[] testArray = {1,2,3,4};
    double[] testArray2 = {2,4,1,1};
    double[] testArray3 = {3,1,1,2};
    
    public MatrixTest() {
    }

    @Test
    public void matrixTest() {
        Matrix m = new Matrix(testArray, testArray2, testArray3);
        m.calcConvarianceMatrix();
        
        /*
        Covariace Matrix should be:
        (  1.25  -0.75 -0.375  )
        ( -0.75   1.5  -0.25   )
        ( -0.375 -0.25  0.6875 )
        
        For testing: (0;0) should be the variance of Array0; (1;1) the 
        variance of Array1 and so on.
        */
        double[][] covMatrix = m.getCovarianceMatrix();
        
        Assert.assertThat(covMatrix[0][0], Is.is(BasicCalculation.calcVariance(testArray)));
        Assert.assertThat(covMatrix[1][1], Is.is(BasicCalculation.calcVariance(testArray2)));
        Assert.assertThat(covMatrix[2][2], Is.is(BasicCalculation.calcVariance(testArray3)));
    }

}
