class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';}
    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String s = words[i];

            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);

            if (isVowel(first) && isVowel(last)) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            ans[i] = prefix[r + 1] - prefix[l];
        }

        return ans;
    }

   
    }
