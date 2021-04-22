package images;

import java.util.Optional;

/**
 * Generic object to represent a matrix.
 *
 * @param <E> element type.
 */
public interface Matrix<E> {
  /**
   * Retrieves the width of the matrix.
   *
   * @return the width of the matrix.
   */
  int getWidth();

  /**
   * Retrieves the height of the matrix.
   *
   * @return the height of the matrix.
   */
  int getHeight();

  /**
   * Retrieves the element at the row x and column y. If row or column is out of boundary, then
   * result will be empty.
   *
   * @param x index of the row of the elements in the image.
   * @param y index of the column of the elements in the image.
   * @return The optional element object at row x and columne.
   */
  Optional<E> getElementAt(int x, int y);
}
