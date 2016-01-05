/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jan.sfr.calculation;

/**
 *
 * @author Jan
 */
public class Matrix {

    private int covarianceMatrixLength;
    private double[][] matrices;
    private double[][] covMatrix;

    public Matrix(double[]... matrix) {
        covarianceMatrixLength = matrix.length;
        this.matrices = matrix;
        this.covMatrix = new double[covarianceMatrixLength][covarianceMatrixLength];
    }

    public void calcConvarianceMatrix() {
        for (int x = 0; x < matrices.length; x++) {
            for (int y = 0; y < matrices.length; y++) {
                covMatrix[x][y] = (BasicCalculation.calcCovariance(matrices[x], matrices[y]));
            }
        }
    }

    public double[][] getValues() {
        return this.matrices;
    }

    public double[][] getCovarianceMatrix() {
        return this.covMatrix;
    }

    @Override
    public String toString() {
        return createOutString(matrices);
    }

    public String getCovMatrixAsString() {
        return createOutString(covMatrix);
    }

    private String createOutString(double[][] matrix) {
        String result = "";
        for (int row = 0; row < matrix[0].length; row++) {
            result += "( ";
            for (int col = 0; col < matrix.length; col++) {
                result += matrix[col][row] + " ";
            }
            result += ")\n";
        }
        return result;
    }

}
