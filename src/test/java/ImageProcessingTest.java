/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import net.jan.sfr.calculation.ImageTransformer;
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
        String pathToImage = getClass().getClassLoader().getResource("testimages/iu.jpeg").getFile();
        assertThat(pathToImage, IsNull.notNullValue());
        int[] array = new ImageTransformer().getPixelArray(pathToImage);
        assertThat(array.length, is(1024*768));
    }
    
}
