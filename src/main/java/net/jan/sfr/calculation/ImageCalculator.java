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
public class ImageCalculator {
    
    public int[] calcAverageFace(int[][] imageMatrix){
        int[] avgFace = new int[ImageTransformer.IMAGE_MAX_HEIGHT*ImageTransformer.IMAGE_MAX_WIDTH];
        
        for (int x = 0; x < imageMatrix.length; x++){
            for (int val = 0; val < imageMatrix[x].length; val++){
                avgFace[val] += imageMatrix[x][val]; 
            }
        }
        
        for (int x = 0; x < imageMatrix.length; x++){
            for (int val = 0; val < imageMatrix[x].length; val++){
                avgFace[val] = avgFace[val] / imageMatrix.length;
            }
        }
        return avgFace;
    }
    
}
