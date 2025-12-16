class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {
    static Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    static boolean checkIfPrefixExists(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (node.containsKey(ch)) {
                node = node.get(ch);
                if (!node.isEnd()) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public String longestString(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        String longest = "";

        for (String word : words) {
            if (Trie.checkIfPrefixExists(word)) {
                if (word.length() > longest.length() ||
                    (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }

        return longest;
    }
}
