import java.util.*;

class Solution {

    private void backtrack(int open, int close, int n, StringBuilder sb, List<String> result) {

        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }

       
        if (open < n) {
            sb.append("(");
            backtrack(open + 1, close, n, sb, result);
            sb.deleteCharAt(sb.length() - 1); // undo the above step
        }

        
        if (close < open) {
            sb.append(")");
            backtrack(open, close + 1, n, sb, result);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), result);
        return result;
    }
}