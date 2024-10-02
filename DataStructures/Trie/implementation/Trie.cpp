// Implementation of Trie data structure in C++.

/*
 * Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_0 = obj->search(word);
 * bool param_0 = obj->startsWith(word);
*/

#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

// Create Trie node
class TrieNode {
public:
    char val;
    unordered_map<char, TrieNode*> children;
    bool is_end;

    // Constructor
    TrieNode(char val = '\0', bool is_end = false) : val(val), is_end(is_end) {}
};

class Trie {
private:
    TrieNode* root;

public:
    // Create root node
    Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    void insert(const string& word) {
        TrieNode* node = root;

        for (char c : word) {
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode(c);
            }
            node = node->children[c];
        }
        node->is_end = true;  // Mark the end of a word
    }

    // Search for a word in the Trie
    bool search(const string& word) {
        TrieNode* node = root;

        for (char c : word) {
            if (node->children.find(c) == node->children.end()) {
                return false;
            }
            node = node->children[c];
        }

        return node->is_end;
    }

    // Check if a word in Trie starts with prefix
    bool startsWith(const string& prefix) {
        TrieNode* node = root;

        for (char c : prefix) {
            if (node->children.find(c) == node->children.end()) {
                return false;
            }
            node = node->children[c];
        }

        return true;
    }
};

