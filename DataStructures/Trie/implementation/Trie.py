# Implementation of Trie data structure in python.

# Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_0 = obj.search(word)
# param_1 = obj.startsWith(prefix)

class TrieNode:
    def __init__(self, val='', is_end=False):
        ''' Create a Trie node '''
        self.val = val
        self.children = {}
        self.is_end = is_end

class Trie:
    def __init__(self):
        ''' Create the root node '''
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        ''' Insert word in Trie '''
        node = self.root

        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode(c)
            node = node.children[c]
        
        node.is_end = True

    def search(self, word: str) -> bool:
        ''' Search for word in Trie '''
        node = self.root

        for c in word:
            if c not in node.children: return False
            node = node.children[c]
        
        return node.is_end

    def startsWith(self, prefix: str) -> bool:
        ''' Check if a word in Trie starts with prefix '''
        node = self.root

        for c in prefix:
            if c not in node.children: return False
            node = node.children[c]
        
        return True

