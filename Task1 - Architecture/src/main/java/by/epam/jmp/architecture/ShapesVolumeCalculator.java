package by.epam.jmp.architecture;

/**
 * Created by Maksim_Ruts on 7/7/2016.
 */
public class ShapesVolumeCalculator {
    public static void main(String[] args) {
        try {
            String shape = args[0];
            double volume = 0;
            if ("square".equals(shape)) {
                volume = Math.pow(Double.valueOf(args[1]), 2);
            } else if ("rectangle".equals(shape)) {
                volume = Double.valueOf(args[1]) * Double.valueOf(args[2]);
            } else if ("round".equals(shape)) {
                volume = Math.PI * Math.pow(Double.valueOf(args[1]), 2);
            } else {
                System.err.println("unsupported shape");
            }
            System.out.println("volume of " + shape + " is " + volume);
        } catch (NumberFormatException e) {
            System.err.println("wrong format of sides size");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("to low count of arguments");
        }
    }
}
