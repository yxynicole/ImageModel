package images.filters.kernels;

import images.Image;
import images.Pixel;
import images.PixelImpl;

public class FilteringKernel extends AbstractKernel {
  private static final double[][] BLUR_WEIGHTS = {
          {0.0625, 0.1250, 0.0625},
          {0.1250, 0.2500, 0.1250},
          {0.0625, 0.1250, 0.0625},
  };

  private static final double[][] SHARP_WEIGHTS = {
          {-0.1250, -0.1250, -0.1250, -0.1250, -0.1250},
          {-0.1250, 0.25000, 0.25000, 0.25000, -0.1250},
          {-0.1250, 0.25000, 1.00000, 0.25000, -0.1250},
          {-0.1250, 0.25000, 0.25000, 0.25000, -0.1250},
          {-0.1250, -0.1250, -0.1250, -0.1250, -0.1250},
  };

  /**
   * Constructs a new Filtering Kernel by giving a weight matrix.
   *
   * @param weights 2D array which represents a matrix of weight for filtering calculation.
   */
  public FilteringKernel(double[][] weights) {
    super(weights);
  }

  /**
   * Return a preset kernel which used for blurring the image.
   *
   * @return A kernel with preset weight for blurring
   */
  public static Kernel blueKernel() {
    return new FilteringKernel(BLUR_WEIGHTS);
  }

  public static Kernel sharpKernel() {
    return new FilteringKernel(SHARP_WEIGHTS);
  }

  @Override
  public Pixel filterAt(Image image, int x, int y) {
    int redResult = 0;
    int greenResult = 0;
    int blueResult = 0;

    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < weights[0].length; j++) {
        Pixel pixel = getPixelAt(image, x - weights.length / 2 + i, y - weights.length / 2 + j);
        redResult += pixel.getRed() * weights[i][j];
        greenResult += pixel.getGreen() * weights[i][j];
        blueResult += pixel.getBlue() * weights[i][j];
      }
    }
    return new PixelImpl(redResult, greenResult, blueResult);
  }

}
