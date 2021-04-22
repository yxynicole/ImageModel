package images.filters;

import images.ImageImpl;
import images.Image;
import images.filters.kernels.Kernel;
import images.Pixel;

/**
 * A Kernel Filter that can be used to filter the image. The kernel filter will apply filter
 * algorithm per pixel, and the new pixel value is calculated based on the other pixels within the
 * kernel.
 */
public class KernelFilter implements Filter {
  private final Kernel kernel;

  /**
   * Constructs a kernel filer with a kernel object.
   *
   * @param kernel Kernel object which will be applied to the pixels.
   */
  public KernelFilter(Kernel kernel) {
    this.kernel = kernel;
  }

  @Override
  public Image apply(Image originalImage) {
    int height = originalImage.getHeight();
    int width = originalImage.getWidth();

    Pixel[][] result = new Pixel[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        result[row][col] = this.kernel.filterAt(originalImage, row, col);
      }
    }
    return new ImageImpl(result);
  }
}
