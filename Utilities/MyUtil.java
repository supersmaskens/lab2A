package Utilities;

public class MyUtil {
    /**
     * Clamp method, not sure where to put it.
     * @param value A double to be clamped.
     * @param lowerBound Lowerbound.
     * @param upperBound Upperbound.
     * @return Clamped value.
     */
    public static double clamp(double value, double lowerBound, double upperBound){
        return Math.max(lowerBound, Math.min(upperBound, value));
    }
}
