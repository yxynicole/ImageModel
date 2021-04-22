package images.filters.kernels;

import images.Pixel;
import images.Image;

/**
 * A kernel representing an area of pixel while filtering an image.
 */
public interface Kernel {

  /**
   * Given an image, apply kernel to it and calculates the result of filtering at row x, column y.
   *
   * @param image the image to apply filter kernel
   * @param x     row index
   * @param y     column index
   * @return the new pixel after filtered
   */
  Pixel filterAt(Image image, int x, int y);
}
