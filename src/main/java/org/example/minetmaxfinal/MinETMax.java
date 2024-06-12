package org.example.minetmaxfinal;

import java.util.Arrays;

public class MinETMax {
    public double min(double[] numbers) {
        return Arrays.stream(numbers).min().orElse(Double.NaN);
    }

    public double max(double[] numbers) {
        return Arrays.stream(numbers).max().orElse(Double.NaN);
    }
}
