/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jan.sfr.calculation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jan
 */
public class ImageTransformer {

    public int[] getPixelArray(String pathToImage) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(pathToImage));
        } catch (IOException ex) {
            Logger.getLogger(ImageTransformer.class.getName()).log(Level.SEVERE, null, ex);
        }

        int[] array = new int[image.getHeight() * image.getWidth()];

        int pixelCount = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                array[pixelCount] = image.getRGB(x, y);
                pixelCount++;
            }
        }
        return array;
    }

}
