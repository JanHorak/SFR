/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jan.sfr.calculation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jan
 */
public class Matrix {

    private int covarianceMatrixLength;
    private double[][] matrixes;
    
    public Matrix(double[]... matrix) {
        covarianceMatrixLength = matrix.length;
        System.out.println(covarianceMatrixLength);   
        this.matrixes = matrix;
    }

    public double[][] getValues() {
        return this.matrixes;
    }

    public List<Double> calcConvarianceMatrix() {
        List<Double> result = new ArrayList<>();
        
        return result;
    }

    public void printCovarianceMatrix() {
        List<Double> result = calcConvarianceMatrix();
    }

}
