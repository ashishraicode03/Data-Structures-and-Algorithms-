class Solution:
    def wordPattern(self, pattern, s):
        words = s.split()
        if len(pattern) != len(words): return False
        c2w, w2c = {}, {}
        for c, w in zip(pattern, words):
            if c in c2w and c2w[c] != w: return False
            if w in w2c and w2c[w] != c: return False
            c2w[c] = w; w2c[w] = c
        return True