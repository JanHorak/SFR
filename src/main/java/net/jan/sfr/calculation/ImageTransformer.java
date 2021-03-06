/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jan.sfr.calculation;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
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

    public static final int IMAGE_MAX_HEIGHT = 600;
    public static final int IMAGE_MAX_WIDTH = 500;

    /**
     * Returns a 1D array of the image which for the path is passed.
     *
     * @param pathToImage
     * @return Pixelarray of the Image
     */
    public int[] getPixelArray(String pathToImage) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(pathToImage));
        } catch (IOException ex) {
            Logger.getLogger(ImageTransformer.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] pixelArray = new int[IMAGE_MAX_HEIGHT * IMAGE_MAX_WIDTH];
        PixelGrabber pg = new PixelGrabber(image, 0, 0, IMAGE_MAX_WIDTH, 
                IMAGE_MAX_HEIGHT, pixelArray, 0, IMAGE_MAX_WIDTH);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Error: Interrupted Waiting for Pixels");
        }

        return pixelArray;
    }

    /**
     * Returns an Imagematrix (nxm) for the passed folder. The returned
     * matrix[x][y] has the following values:
     * <li>x -> Image</li>
     * <li>y -> ImagePixelArray</li>
     * So accesing the pixel 3000 of Image 5 by: int[5][3000]
     *
     * @param pathToFolder
     * @return ImageMatrix
     */
    public int[][] getImageMatrix(String pathToFolder) {
        int[][] imageList = null;
        String[] fileList = new File(pathToFolder).list();
        imageList = new int[fileList.length][IMAGE_MAX_HEIGHT * IMAGE_MAX_WIDTH];
        int imageCounter = 0;
        for (String path : fileList) {
            imageList[imageCounter] = getPixelArray(pathToFolder + path);
            imageCounter++;
        }
        return imageList;
    }

}
