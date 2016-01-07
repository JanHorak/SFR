/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jan.sfr.helper;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.MemoryImageSource;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;
import net.jan.sfr.calculation.ImageCalculator;
import net.jan.sfr.calculation.ImageTransformer;

/**
 *
 * @author Jan
 */
public class ImageHelper {

    public void storeImageFromPixelArray(int[] array, String path) {
        BufferedImage bufferedImage = new BufferedImage(500, 600, BufferedImage.TYPE_INT_RGB);
        Image piximg = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(ImageTransformer.IMAGE_MAX_WIDTH,
                ImageTransformer.IMAGE_MAX_HEIGHT, array, 0, ImageTransformer.IMAGE_MAX_WIDTH));
        bufferedImage.getGraphics().drawImage(piximg, 0, 0, null);

        try {
            ImageIO.write(bufferedImage, "png", new File(path));
        } catch (IOException ex) {
            Logger.getLogger(ImageHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
