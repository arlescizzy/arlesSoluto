/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


public class UnionFind2 {

    private int[] id;
    private int[] rank;
    private int[] bigE;

    public UnionFind2(int n) {
        id = new int[n];
        rank = new int[n];
        bigE = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            rank[i] = 0;
            bigE[i] = i;
        }
    }

    public int findR(int p) {
        if (p != id[p]) {
            id[p] = findR(id[p]);
        }
        return id[p];
    }

    public int find(int p) {
        int root = findR(p);
        return bigE[root];
    }

    public void union(int p, int q) {
        int rootP = findR(p);
        int rootQ = findR(q);
        if (rootP == rootQ) return;
        if (rank[rootP] < rank[rootQ]) {
            id[rootP] = rootQ;
            bigE[rootQ] = Math.max(bigE[rootP], bigE[rootQ]);
        }
        else if (rank[rootP] > rank[rootQ]) {
            id[rootQ] = rootP;
            bigE[rootP] = Math.max(bigE[rootP], bigE[rootQ]);
        }
        else {
            id[rootQ] = rootP;
            rank[rootP]++;
            bigE[rootP] = Math.max(bigE[rootP], bigE[rootQ]);
        }
    }

    public boolean connected(int p, int q) {
        return findR(p) == findR(q);
    }

    public static void main(String[] args) {
        UnionFind2 uf2 = new UnionFind2(10);
        uf2.union(4, 3);
        uf2.union(3, 8);
        uf2.union(6, 4);
        uf2.union(9, 4);
        System.out.println(uf2.find(3)); // Should return 9, which is the bigE in {3, 4, 6, 8, 9}
        System.out.println(uf2.find(4)); // Should also return 9
        System.out.println(uf2.find(6)); // Should return 9
        System.out.println(uf2.find(8)); // Should return 9
    }
}
