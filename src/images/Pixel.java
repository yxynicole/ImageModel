package images;

/**
 * The class represents a pixel on an image. The pixel should consist of three channel:red, green,
 * and blue.
 */
public interface Pixel {
  /**
   * Returns the red value of pixel.
   *
   * @return integer value of the red color between 0 and 255.
   */
  int getRed();

  /**
   * Returns the green value of pixel.
   *
   * @return integer value of the green color between 0 and 255.
   */
  int getGreen();

  /**
   * Returns the blue value of pixel.
   *
   * @return integer value of the blue color between 0 and 255.
   */
  int getBlue();

}
