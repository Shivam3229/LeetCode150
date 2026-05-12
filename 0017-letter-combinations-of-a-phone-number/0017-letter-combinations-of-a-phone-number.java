class Solution {

    HashMap<Character, String> map = new HashMap<>();

    public void solve(int i, StringBuilder sb, String digits, List<String> ans) {

        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(i));

        for (int j = 0; j < letters.length(); j++) {

            sb.append(letters.charAt(j));

            solve(i + 1, sb, digits, ans);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(0, new StringBuilder(), digits, ans);

        return ans;
    }
}