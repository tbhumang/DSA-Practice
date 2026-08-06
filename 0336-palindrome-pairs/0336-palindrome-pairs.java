class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);
                if (isPalindrome(prefix)) {
                    String revSuffix = new StringBuilder(suffix).reverse().toString();
                    Integer idx = map.get(revSuffix);
                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(idx, i));
                    }
                }
                if (j != word.length() && isPalindrome(suffix)) {
                    String revPrefix = new StringBuilder(prefix).reverse().toString();
                    Integer idx = map.get(revPrefix);
                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(i, idx));
                    }
                }
            }
        }
        return ans;
    }
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}