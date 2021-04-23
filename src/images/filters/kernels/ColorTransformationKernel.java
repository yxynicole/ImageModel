package images.filters.kernels;

import images.PixelImpl;
import images.Image;
import images.Pixel;
import images.utils.ImageUtilities;

public class ColorTransformationKernel extends AbstractKernel {
  private static final double[][] GREY_SCALE_WEIGHT = {
          {0.2126, 0.7152, 0.0722},
          {0.2126, 0.7152, 0.0722},
          {0.2126, 0.7152, 0.0722},
  };

  private static final double[][] SEPIA_TONE_WEIGHTS = {
          {0.393, 0.769, 0.189},
          {0.349, 0.686, 0.168},
          {0.272, 0.534, 0.232},
  };

  /**
   * Construct a new Color transformation kernel with given weight matrix.
   *
   * @param weights the weight matrix of the kernel.
   */
  public ColorTransformationKernel(double[][] weights) {
    super(weights);
  }

  /**
   * A preset kernel used for Grey Scale filtering.
   *
   * @return Kernel object used for grey scale filtering.
   */
  public static Kernel greyScaleKernel() {
    return new ColorTransformationKernel(GREY_SCALE_WEIGHT);
  }

  /**
   * A preset kernel used for Sepia Tone filtering.
   *
   * @return Kernel object used for Sepia Tone filtering.
   */
  public static Kernel sepiaToneKernel() {
    return new ColorTransformationKernel(SEPIA_TONE_WEIGHTS);
  }

  @Override
  public Pixel filterAt(Image image, int x, int y) {
    Pixel pixel = getPixelAt(image, x, y);
    int[] oldRGB = {pixel.getRed(), pixel.getGreen(), pixel.getBlue()};
    int[] newRGB = {0, 0, 0};

    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < weights[0].length; j++) {
        newRGB[i] += weights[i][j] * oldRGB[j];
      }
    }
    return new PixelImpl(ImageUtilities.clamp(newRGB[0]), ImageUtilities.clamp(newRGB[1]), ImageUtilities.clamp(newRGB[2]));
  }

}
