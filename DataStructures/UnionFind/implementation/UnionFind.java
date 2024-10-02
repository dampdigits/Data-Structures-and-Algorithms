// Implementation of Union Find / Disjoint Set Union (DSU) in java

/*
 * DSU object will be instantiated and called as such:
 * UnionFind uf = new UnionFind(n);
 * uf.unite(x, y);
 * int parent = uf.findRootOf(x);
 * boolean connected = uf.isConnected(x, y);
*/

class UnionFind {
    private int[] root;
    private int[] rank;
    private int sets;

    // Constructor to create n sets
    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        sets = n;

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // Find the root of x (with path compression)
    public int findRootOf(int x) {
        if (root[x] != x) {
            root[x] = findRootOf(root[x]); // Path compression
        }
        return root[x];
    }

    // Unite the sets containing x and y
    public void unite(int x, int y) {
        int rootX = findRootOf(x);
        int rootY = findRootOf(y);

        // If they are already in the same set, return
        if (rootX == rootY) {
            return;
        }

        // Union by rank
        if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
            rank[rootY] += rank[rootX];
        } else {
            root[rootY] = rootX;
            rank[rootX] += rank[rootY];
        }

        sets--;  // Decrease number of sets
    }

    // Check if x and y are connected (belong to the same set)
    public boolean isConnected(int x, int y) {
        return findRootOf(x) == findRootOf(y);
    }

    // Optional: Return the number of disjoint sets remaining
    public int getNumberOfSets() {
        return sets;
    }
}

