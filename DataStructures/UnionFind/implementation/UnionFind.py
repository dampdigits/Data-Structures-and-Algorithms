# Implementation of Union Find / Disjoint Set Union (DSU) in python

# DSU object will be instantiated and called as such:
# obj = UnionFind()
# obj.unite(x, y)
# parent = obj.findRootOf(x)
# connected = obj.isConnected(x, y)

class UnionFind:
    def __init__(self, n):
        ''' Create n sets '''
        self.root = [i for i in range(n)]
        self.rank = [1] * n
        self.sets = n

    def findRootOf(self, x):
        ''' Find the root of x '''
        while self.root[x] != x:
            self.root[x] = self.root[self.root[x]]
            x = self.root[x]
        return x

    def unite(self, x, y):
        ''' Unite the sets of x and y '''
        rootX = self.findRootOf(x)
        rootY = self.findRootOf(y)

        # Return if they belong from the same sets
        if rootX == rootY:
            return

        if self.rank[rootY] > self.rank[rootX]:
            self.root[rootX] = rootY
            self.rank[rootY] += self.rank[rootX]
        else:
            self.root[rootY] = rootX
            self.rank[rootX] += self.rank[rootY]

        self.sets -= 1

    def isConnected(self, x, y):
        ''' Check if x and y belong to the same set '''
        return self.findRootOf(x) == self.findRootOf(y)

