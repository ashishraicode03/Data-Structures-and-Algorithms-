class Solution {
    public int calculate(String s) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int res=0, sign = 1, num = 0; 
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '+' || ch == '-') {
                res += num * sign;
                num=0;
                sign = ch=='+' ? 1: -1;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0; sign = 1;
            } else if (ch == ')') {
                res += num * sign;
                num=0;
                res *= st.pop();
                res += st.pop();
            }
        }

        return res + sign * num;
    }
}