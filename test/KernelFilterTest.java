import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import images.Image;
import images.ImageImpl;
import images.Pixel;
import images.PixelImpl;

import images.filters.Filter;
import images.filters.KernelFilter;
import images.filters.kernels.Kernel;

/**
 * Kernel Filter test.
 */

public class KernelFilterTest {
  private Filter filter;
  private Image image;

  @Before
  public void setup() {
    filter = new KernelFilter(new Kernel() {
      @Override
      public Pixel filterAt(Image image, int x, int y) {
        return new PixelImpl(0, 0, 0);
      }

    });
    image = new ImageImpl(new int[][][]{
            {{1, 2, 3}, {3, 4, 5}},
            {{5, 6, 7}, {7, 8, 9}}
    });
  }

  @Test
  public void testApply() {
    Image newImage = filter.apply(image);
    Assert.assertEquals(0, newImage.getElementAt(0, 0).get().getRed());
    Assert.assertEquals(0, newImage.getElementAt(0, 0).get().getGreen());
    Assert.assertEquals(0, newImage.getElementAt(0, 0).get().getBlue());

    Assert.assertEquals(0, newImage.getElementAt(1, 0).get().getRed());
    Assert.assertEquals(0, newImage.getElementAt(1, 0).get().getGreen());
    Assert.assertEquals(0, newImage.getElementAt(1, 0).get().getBlue());

    Assert.assertEquals(0, newImage.getElementAt(0, 1).get().getRed());
    Assert.assertEquals(0, newImage.getElementAt(0, 1).get().getGreen());
    Assert.assertEquals(0, newImage.getElementAt(0, 1).get().getBlue());

    Assert.assertEquals(0, newImage.getElementAt(1, 1).get().getRed());
    Assert.assertEquals(0, newImage.getElementAt(1, 1).get().getGreen());
    Assert.assertEquals(0, newImage.getElementAt(1, 1).get().getBlue());
  }

}
