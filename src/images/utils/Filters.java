package images.utils;

import images.Image;
import images.filters.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Helper class to collect the filters and apply them to the image all at once.
 * The filter will be applied to the image sequentially based on the order that filters are added into builder.
 */
public class Filters {
  /**
   * Builderclass for Filters class.
   */
  public static class FiltersBuilder{
    private List<Filter> filters = new ArrayList<>();

    /**
     * Adds a new filter into builder.
     *
     * @param filter
     * @return
     */
    public FiltersBuilder add(Filter filter){
      Objects.requireNonNull(filter);
      filters.add(filter);
      return this;
    }

    /**
     * Builds the Filters object from builder.
     *
     * @return Filters object which contains all the filters added.
     */
    public Filters build(){
      return new Filters (filters);
    }
  }

  private final List<Filter> filters;

  private Filters(List<Filter> filters){
    this.filters = filters;
  }

  /**
   * Applies all the filters within Filters to the image all at once.
   *
   * @param image The image to be filtered.
   * @return the image object after being filtered.
   */
  public Image apply(Image image){
    for(Filter filter : filters){
      image = filter.apply(image);
    }
    return image;
  }
}

