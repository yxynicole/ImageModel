package images.filters;

import images.Image;

/**
 * The image filterAt to apply on the image
 */
public interface Filter {
  /**
   * Apply a filtering operation to an image to generate a new image.
   *
   * @param originalImage Original Image to apply filterAt with.
   * @return The new genearted image after applied weight matrix on original image
   */
  Image apply(Image originalImage);
}
