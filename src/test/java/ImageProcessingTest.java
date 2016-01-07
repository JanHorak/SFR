/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import net.jan.sfr.calculation.ImageCalculator;
import net.jan.sfr.calculation.ImageTransformer;
import net.jan.sfr.helper.ImageHelper;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan
 */
public class ImageProcessingTest {
    
    @Test
    public void build1DArrayFromImage(){
        String pathToImage = getClass().getClassLoader().getResource("testimages/pic1_500x600.png").getFile();
        assertThat(pathToImage, IsNull.notNullValue());
        int[] array = new ImageTransformer().getPixelArray(pathToImage);
        assertThat(array.length, is(ImageTransformer.IMAGE_MAX_HEIGHT*ImageTransformer.IMAGE_MAX_WIDTH));
        new ImageHelper().storeImageFromPixelArray(array, "test.png");
    }
    
    @Test
    public void buildImageMatrixFromFolder(){
        String pathToImage = getClass().getClassLoader().getResource("testimages/").getFile();
        assertThat(pathToImage, IsNull.notNullValue());
        int[][] imageMatrix = new ImageTransformer().getImageMatrix(pathToImage);
        assertThat(imageMatrix.length, is(3));
        assertThat(imageMatrix[0].length, is(ImageTransformer.IMAGE_MAX_HEIGHT*ImageTransformer.IMAGE_MAX_WIDTH));
    }
    
    @Test
    public void buildAvgFace(){
        String pathToImage = getClass().getClassLoader().getResource("testimages/").getFile();
        assertThat(pathToImage, IsNull.notNullValue());
        int[][] imageMatrix = new ImageTransformer().getImageMatrix(pathToImage);
        assertThat(imageMatrix.length, is(3));
        assertThat(imageMatrix[0].length, is(ImageTransformer.IMAGE_MAX_HEIGHT*ImageTransformer.IMAGE_MAX_WIDTH));
        
        ImageCalculator imageCalculator = new ImageCalculator();
        int[] avgFace = imageCalculator.calcAverageFace(imageMatrix);
    }
    
}
