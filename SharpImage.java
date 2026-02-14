import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a sharpened image
 */
public class SharpImage extends ImagePlus {

  /*
   * Calls the superclass constructor to initialize pixels
   */
  public SharpImage(String filename) {
    super(filename);
  }

  /*
   * Sharpens the image by calculating the difference between the color values of the current
   * and neighboring Pixel objects and adjust the color values to emphasize the edges
   */
  public void sharpen() {
    Pixel[][] pixels = getImagePixels();

    // traverse starting at (1,1), stop 1 less to not go out of bounds
    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];

        // determine the avg RGB difference between the current pixel and the pixel
        // to the topLeft (row - 1, col - 1)
        int redDiff = currentPixel.getRed() - pixels[row - 1][col - 1].getRed();
        int greenDiff = currentPixel.getGreen() - pixels[row - 1][col - 1].getGreen();
        int blueDiff = currentPixel.getBlue() - pixels[row - 1][col - 1].getBlue();
        int averageDiff = (redDiff + greenDiff + blueDiff) / 3;

        // add the avg differnce
        int newRed = currentPixel.getRed() + averageDiff;
        int newGreen = currentPixel.getGreen() + averageDiff;
        int newBlue = currentPixel.getBlue() + averageDiff;

        // force RGB to no exceed 255
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }

        // update RBG values
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
  
}