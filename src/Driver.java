import images.filters.DitheringFilter;
import images.utils.Filters;
import images.utils.ImageUtilities;
import images.filters.ClampFilter;
import images.filters.KernelFilter;
import images.filters.kernels.ColorTransformationKernel;
import images.filters.kernels.FilteringKernel;
import images.Image;
import images.ImageImpl;

import java.io.IOException;

public class Driver{

  private static Image load(String filename){
    int[][][] rawImageData = null;
    try {
      rawImageData = ImageUtilities.readImage(filename);
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    return new ImageImpl(rawImageData);
  }

  private static void save(String filename, Image image){
    try{
      ImageUtilities.writeImage(image.toArray(), image.getWidth(), image.getHeight(), filename);
    } catch (IOException e){
      e.printStackTrace();
      System.exit(1);
    }
  }

  public static void main(String[] args){
    if(args.length<1){
      System.err.println("Missing Argument: filename");
    }

    String filename = args[0].trim();
    Image image = load(filename);

    Filters filters = null;

    filters = new Filters.FiltersBuilder()
                  .add(new KernelFilter(FilteringKernel.blueKernel()))
                  .add(new ClampFilter())
                  .build();
    save("blur_" + filename, filters.apply(image));

    filters = new Filters.FiltersBuilder()
                  .add(new KernelFilter(FilteringKernel.sharpKernel()))
                  .add(new ClampFilter())
                  .build();
    save("sharp_" + filename, filters.apply(image));

    filters = new Filters.FiltersBuilder()
            .add(new KernelFilter(ColorTransformationKernel.greyScaleKernel()))
            .add(new ClampFilter())
            .build();
    save("grey_" + filename, filters.apply(image));

    filters = new Filters.FiltersBuilder()
            .add(new KernelFilter(ColorTransformationKernel.sepiaToneKernel()))
            .add(new ClampFilter())
            .build();
    save("sepia_" + filename, filters.apply(image));

    filters = new Filters.FiltersBuilder()
            .add(new DitheringFilter())
            .add(new ClampFilter())
            .build();
    save("dithering_" + filename, filters.apply(image));
  }
}