/*****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 ****************************************************************************/


public class UnionFind {

    private int[] id;
    private int[] rank;

    public UnionFind(int n, int m) {
        id = new int[n * n];
        rank = new int[n * n];
        for (int i = 0; i < n * m; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return id[p];
    }


    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (rank[i] < rank[j]) id[i] = j;
        else if (rank[i] > rank[j]) id[j] = i;
        else {
            id[i] = j;
            rank[j]++;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void main(String[] args) {
        UnionFind uf = new UnionFind(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println(uf.find(Integer.parseInt(args[2])));
    }
}

