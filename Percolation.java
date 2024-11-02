/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
//WARNING: The following code is not fully functional yet as I have to make changes to it still.


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static int count = 0;
    private static int n;
    private int[] site;
    private boolean[] sOpen;
    private int[] topRow;
    WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        Percolation.n = n;
        site = new int[n * n];
        sOpen = new boolean[n * n];
        topRow = new int[n * n];

        for (int i = 0, j = 0; i < n * n; i++, j += (i % n)) {
            site[i] = i;
            sOpen[i] = false;
            topRow[i] = j;
        }
    }


    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            sOpen[((row - 1) * n) + col - 1] = true;
            count++;
            if (row == 1) {
                topRow[col - 1] = n;
            }
            if (row > 1 && isOpen(row - 1, col)) {
                int p = site[((row - 1) * n) + col - 1];
                int q = site[((row - 2) * n) + col - 1];
                int rootP = uf.find(p);
                int rootQ = uf.find(q);
                if (rootP != rootQ) {
                    site[rootP] = rootQ;
                    topRow[rootQ] += topRow[rootP];
                }
            }
            if (row < n && isOpen(row + 1, col)) {
                int p = site[((row - 1) * n) + col - 1];
                int q = site[(row * n) + col - 1];
                int rootP = uf.find(p);
                int rootQ = uf.find(q);
                if (rootP != rootQ) {
                    site[rootP] = rootQ;
                    topRow[rootQ] += topRow[rootP];
                }
            }
            if (col > 1 && isOpen(row, col - 1)) {
                int p = site[((row - 1) * n) + col - 1];
                int q = site[((row - 1) * n) + col - 2];
                int rootP = uf.find(p);
                int rootQ = uf.find(q);
                if (rootP != rootQ) {
                    site[rootP] = rootQ;
                    topRow[rootQ] += topRow[rootP];
                }
            }
            if (col < n && isOpen(row, col + 1)) {
                int p = site[((row - 1) * n) + col - 1];
                int q = site[((row - 1) * n) + col];
                int rootP = uf.find(p);
                int rootQ = uf.find(q);
                if (rootP != rootQ) {
                    site[rootP] = rootQ;
                    topRow[rootQ] += topRow[rootP];
                }
            }
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return (sOpen[((row - 1) * n) + col - 1]);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (topRow[((row - 1) * n) + col - 1] == n) return true;
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < n; i++) {
            if (topRow[((n * n) - 1) - i] == n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Percolation pn = new Percolation(3);
        pn.open(2, 2);
        pn.open(3, 3);
        System.out.println(pn.percolates()); // Test percolates function
        System.out.println(pn.topRow[8]); // Test topRow array
        System.out.println(pn.topRow[7]); // Test topRow array
        System.out.println(pn.topRow[6]); // Test topRow array
        System.out.println(count); // Test numberOfOpenSites function
    }
}

