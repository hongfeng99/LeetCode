class Solution {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int begin) {
        if (begin == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int i = begin; i< n; ++i) {
            if (f[begin][i]) {
                ans.add(s.substring(begin, i + 1));
                dfs(s, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/palindrome-partitioning/solutions/639633/fen-ge-hui-wen-chuan-by-leetcode-solutio-6jkv/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。