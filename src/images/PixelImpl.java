package images;

/**
 * PixelImpl implementation represents a single pixel on the image.
 */
public class PixelImpl implements Pixel {
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Constructs a pixel object.
   *
   * @param r red color value
   * @param g green color value
   * @param b blue color value
   */
  public PixelImpl(int r, int g, int b) {
    red = validate(r);
    green = validate(g);
    blue = validate(b);
  }

  private static int validate(int channel) {
    if (channel < 0 || channel > 255) {
      throw new IllegalArgumentException();
    } else {
      return channel;
    }
  }

  @Override
  public int getRed() {
    return this.red;
  }

  @Override
  public int getGreen() {
    return this.green;
  }

  @Override
  public int getBlue() {
    return this.blue;
  }

}
