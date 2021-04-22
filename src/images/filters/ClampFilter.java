package images.filters;

import images.Image;
import images.ImageImpl;
import images.Pixel;
import images.PixelImpl;

/**
 * The ClampFilter ensures that the each value in each channel is between 0 and 255.
 */
public class ClampFilter implements Filter {
  private static final int CLAMPING_MIN = 0;
  private static final int CLAMPING_MAX = 255;

  private static int clamp(int value){
    return Math.max(CLAMPING_MIN, Math.min(CLAMPING_MAX,value));
  }

  @Override
  public Image apply(Image originalImage) {

    Pixel[][] result = new Pixel[originalImage.getHeight()][originalImage.getWidth()];

    for (int row = 0; row < originalImage.getHeight(); row++){
      for(int col = 0; col < originalImage.getWidth(); col++){
        Pixel pixel =originalImage.getElementAt(row,col).get();
        result[row][col] = new PixelImpl(clamp(pixel.getRed()),
                                        clamp(pixel.getGreen()),
                                        clamp(pixel.getBlue()));
      }
    }
    return new ImageImpl(result);
  }
}
