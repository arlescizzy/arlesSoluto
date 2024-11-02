/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static int n;
    private double[] thrVal;


    // monte carlo time letsogooo
    // perform independent t on an n-by-n grid
    public PercolationStats(int n, int t) {
        if (n <= 0 || t <= 0) throw new IllegalArgumentException();
        PercolationStats.n = n;
        thrVal = new double[t];
        for (int i = 0; i < t; i++) {
            Percolation xy = new Percolation(n);
            int count = 0;
            while (!xy.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                if (!xy.isOpen(row, col)) {
                    xy.open(row, col);
                    count++;
                }
            }
            thrVal[i] = (double) count / (n * n);
        }
    }

    private static double invSqrt(double number) {
        double xhalf = 0.5d * number;
        long i = Double.doubleToLongBits(number);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        double v = Double.longBitsToDouble(i);
        for (int it = 0; it < 4; it++) {
            v = v * (1.5d - xhalf * v * v);
        }
        return v;
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thrVal);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thrVal);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() * invSqrt(n);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() * invSqrt(n);
    }

    // main client (see below)
    public static void main(String[] args) {
        PercolationStats pn = new PercolationStats(Integer.parseInt(args[0]),
                                                   Integer.parseInt(args[1]));
        System.out.printf("mean = [%.16f] \n", pn.mean());
        System.out.printf("Deviation = [%.16f] \n", pn.stddev());
        System.out.printf("95%% confidence interval = [%.16f, %.16f]", pn.confidenceLo(),
                          pn.confidenceHi());
    }

}
