import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import images.Pixel;
import images.PixelImpl;

/**
 * Pixel implementation test.
 */

public class PixelImplTest {
  private Pixel pixel;

  @Before
  public void setup() {
    pixel = new PixelImpl(1, 2, 3);
  }

  @Test
  public void testGetRed() {
    Assert.assertEquals(1, pixel.getRed());
  }

  @Test
  public void testGetGreen() {
    Assert.assertEquals(2, pixel.getGreen());
  }

  @Test
  public void testGetBlue() {
    Assert.assertEquals(3, pixel.getBlue());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalValueNegative() {
    new PixelImpl(-1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalValueTooLarge() {
    new PixelImpl(256, 0, 0);
  }
}