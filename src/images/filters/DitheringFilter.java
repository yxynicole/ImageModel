package images.filters;

import images.Image;
import images.ImageImpl;
import images.filters.Filter;
import images.Pixel;
import images.PixelImpl;

import java.util.Optional;

/**
 * A Dithering Filter which implements Floyd-Steinberg Dithering.
 */
public class DitheringFilter implements Filter {

  private static final int maxChannel =256;

  private void executeAlgorithm(double[][][] values) {
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values[0].length; j++) {
        for (int k = 0; k < 3; k++) {
          double oldValue = values[i][j][k];
          double newValue = oldValue / maxChannel;
          double error = oldValue - newValue;
          values[i][j][k] = newValue;

          if (j + 1 < values[0].length) {
            values[i][j + 1][k] += error * 7 / 16.0;
          }

          if (i + 1 < values.length && j > 0) {
            values[i + 1][j - 1][k] += error * 3 / 16.0;
          }

          if (i + 1 < values.length) {
            values[i + 1][j][k] += error * 5 / 16.0;
          }

          if (i + 1 < values.length && j + 1 < values[0].length) {
            values[i + 1][j][k] += error / 16.0;
          }

        }
      }
    }
  }

  @Override
  public Image apply(Image originalImage) {
    double[][][] values = new double [originalImage.getHeight()][originalImage.getWidth()][3];
    for(int i = 0; i < values.length; i++){
      for(int j = 0; j <values[0].length; j++){
        Optional<Pixel> pixel = originalImage.getElementAt(i,j);
        if(pixel.isPresent()){
          values[i][j][0] = pixel.get().getRed();
          values[i][j][1] =pixel.get().getGreen();
          values[i][j][2] = pixel.get().getBlue();
        }else{
          throw new RuntimeException(String.format("%d, %d", i, j ));
        }
      }
    }

    executeAlgorithm(values);

    Pixel[][] pixels = new Pixel[values.length][values[0].length];
    for(int i = 0; i <values.length; i++){
      for (int j = 0; j < values[0].length; j++){
        int red = (int) values[i][j][0];
        int green = (int) values[i][j][1];
        int blue = (int) values [i][j][2];
        pixels[i][j] = new PixelImpl(red, green,blue);
      }
    }
    return new ImageImpl(pixels);
  }
}
