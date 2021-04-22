import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import images.Image;
import images.ImageImpl;

/**
 * Image Implementation test.
 */
public class ImageImplTest {
  private Image image;

  @Before
  public void setup() {
    image = new ImageImpl(new int[][][]{
            {{1, 2, 3}, {4, 5, 6}},
            {{7, 8, 9}, {10, 11, 12}},
    });
  }

  @Test
  public void testGetWidth() {
    Assert.assertEquals(2, image.getWidth());
  }

  @Test
  public void testGetHeight() {
    Assert.assertEquals(2, image.getHeight());
  }

  @Test
  public void testGetElementAt() {
    Assert.assertEquals(1, image.getElementAt(0, 0).get().getRed());
    Assert.assertEquals(2, image.getElementAt(0, 0).get().getGreen());
    Assert.assertEquals(3, image.getElementAt(0, 0).get().getBlue());


    Assert.assertFalse(image.getElementAt(-1, 0).isPresent());
    Assert.assertFalse(image.getElementAt(10, 0).isPresent());
  }

  @Test
  public void testToArray() {
    int[][][] array = image.toArray();
    Assert.assertEquals(new int[]{1, 2, 3}, array[0][0]);
    Assert.assertEquals(new int[]{4, 5, 6}, array[0][1]);
    Assert.assertEquals(new int[]{7, 8, 9}, array[1][0]);
    Assert.assertEquals(new int[]{10, 11, 12}, array[1][1]);
  }

}
