import java.util.*;

public class Solution {
    private static final int R = 0, C = 1;
    private final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; 
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0)
            return Collections.emptyList();

        int m = board.length, n = board[0].length;
        TrieNode root = buildTrie(words);
        Set<String> found = new HashSet<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int idx = board[i][j] - 'a';
                if (idx >= 0 && idx < 26 && root.children[idx] != null) {
                    dfs(board, i, j, root, found);
                }
            }
        }
        return new ArrayList<>(found);
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, Set<String> found) {
        char ch = board[r][c];
        int ci = ch - 'a';
        TrieNode node = parent.children[ci];
        if (node == null) return;

        if (node.word != null) {
            found.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        for (int[] d : DIRS) {
            int nr = r + d[R], nc = c + d[C];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            char nxt = board[nr][nc];
            if (nxt == '#') continue;
            int nxtIdx = nxt - 'a';
            if (nxtIdx < 0 || nxtIdx >= 26) continue;
            if (node.children[nxtIdx] != null) {
                dfs(board, nr, nc, node, found);
            }
        }

        board[r][c] = ch;

        if (node.word == null && noChildren(node)) {
            parent.children[ci] = null;
        }
    }

    private boolean noChildren(TrieNode node) {
        for (TrieNode ch : node.children) {
            if (ch != null) return false;
        }
        return true;
    }
}