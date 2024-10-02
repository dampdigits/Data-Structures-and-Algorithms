// Implementation of Union Find / Disjoint Set Union (DSU) in C++

/*
 * DSU object will be instantiated and called as such:
 * UnionFind uf(n);
 * uf.unite(x, y);
 * int parent = uf.findRootOf(x);
 * bool connected = uf.isConnected(x, y);
*/

#include <vector>
using namespace std;

class UnionFind {
private:
    vector<int> root;
    vector<int> rank;
    int sets;

public:
    // Constructor to create n sets
    UnionFind(int n) {
        root.resize(n);
        rank.resize(n, 1);
        sets = n;
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }
    }

    // Find the root of x (with path compression)
    int findRootOf(int x) {
        if (root[x] != x) {
            root[x] = findRootOf(root[x]); // Path compression
        }
        return root[x];
    }

    // Unite the sets containing x and y
    void unite(int x, int y) {
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
    bool isConnected(int x, int y) {
        return findRootOf(x) == findRootOf(y);
    }
};

