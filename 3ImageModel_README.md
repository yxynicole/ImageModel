## ImageModel
### About/Overview.
This model can be used to produce some images with interesting effects by manipulating different filters. The default filters are `clampFilter`, `KernelFilter`, and `DitheringFilter`.  `Filter` interface is designed in a generic way so that customized filters can be extended for different effects. 

`clampingFilter` ensures that each value in each channel on each pixel is between 0-255. 

KernelFilter uses its kernel to modify an image. There are two different types of kernel: `colorTransformation` kernel and `Filtering` kernel. The former coverts the image to greyscale or sepia. The latter is able to blur or sharpen the image.  

DitheringFilter intends to reduce the number of colors in the image by applying Floyd-Steinberg algorithm.  
### List of features
- Apply a filter to an image to generate a new image.
- Given a user-specified Kernel, a customized filtering operation can be executed on the image.
- Filter can be extended with filter interface
- KernelFilter can be extended with kernel interface.
### How To Run
```bash
java -jar ImageModel.jar [example.jpg]
```
The above command generates 5 types of filtered image outputs, including blurred, sharped, greyscale, sepia tone and dithered image.
### How to Use the Program
1. Load an image represented in 3D-array into `ImageImpl`
2. Build `filters` with FilterBuilder and add default filter like blur/sharp/greyscale/etc. 
3. Apply `filters` to the image and save the output into a new file.
### Description of Example Runs
1. Program gets command line arguments
2. Program loads image from a given filename.
3. Program creates 5 different types of filters.
4. Each filter is applied to the image.
5. The filtered image is saved into a new file.
#### Filtering process:
1. Image is stored in a 2D array consisting of pixels
2. `Pixel` consists of 3 different color values—red, green, blue.
3. For KernelFilter, every single pixel is calculated by a specific kernel process.
	- colorTransformation kernel modifies the color of a pixel based on its own color, while filtering kernel modifies the value of a pixel depending on the values of its neighbors.  
### Assumptions.
1. The value of color channels is always between 0 and 255.
2. Clamping operation is always required at the last step of filtering.
3. The output of the filters is always the same size as the input.
### Limitations
1. DitheringFilter doesn't seem to work properly.
2. It is not very handy to apply multiple filters on the same image.
