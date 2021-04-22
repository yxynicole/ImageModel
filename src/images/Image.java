package images;

/**
 * The representation of an image, which consists of m * n pixels.
 */
public interface Image extends Matrix<Pixel> {
  /**
   * Converts the image into 3D array.
   *
   * @return 3D array represents row, column and channel.
   */
  int[][][] toArray();
}
