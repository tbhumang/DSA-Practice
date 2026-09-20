class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        java.util.ArrayList<String> ans = new java.util.ArrayList<>();

        for (String word : words) {
            String s = word.toLowerCase();
            int row = -1;

            for (int i = 0; i < 3; i++) {
                if (rows[i].indexOf(s.charAt(0)) != -1) {
                    row = i;
                    break;
                }
            }

            boolean ok = true;
            for (int i = 1; i < s.length(); i++) {
                if (rows[row].indexOf(s.charAt(i)) == -1) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans.add(word);
        }

        return ans.toArray(new String[0]);
    }
}