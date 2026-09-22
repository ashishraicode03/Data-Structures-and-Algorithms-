class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long res = 1;

        for(int i = 0; i <= rowIndex; i++){
            ans.add((int) res);

            res = res * (rowIndex - i) / (i + 1);
        }

        return ans;
    }
}