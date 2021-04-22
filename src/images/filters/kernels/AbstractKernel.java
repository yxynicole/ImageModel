package images.filters.kernels;

import images.Image;
import images.PixelImpl;
import images.Pixel;

/**
 * Abstract Kernel class to share the some code between subclass.
 */

public abstract class AbstractKernel implements Kernel {
  private static Pixel defaultPixel = new PixelImpl(0, 0, 0);
  protected double[][] weights;

  protected AbstractKernel(double[][] weights) {
    this.weights = weights;
  }

  /**
   * Get an pixel of image at row x column y. If index x or y out of bound, a default color value
   * will be returned.
   *
   * @param image Image where to retrieve the pixel.
   * @param x     row number
   * @param y     column number
   * @return A pixel on image row x column y, or a default pixel if x or y out of bound
   */

  Pixel getPixelAt(Image image, int x, int y) {
    return image.getElementAt(x, y).orElse(defaultPixel);
  }
}
