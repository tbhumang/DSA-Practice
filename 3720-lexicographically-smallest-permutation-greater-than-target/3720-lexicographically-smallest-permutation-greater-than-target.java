class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++){
            int targetChar = target.charAt(i) - 'a';
            if(freq[targetChar] > 0){
                ans.append(target.charAt(i));
                freq[targetChar]--;
            } else{
                int greater = -1;
                for(int c = targetChar + 1; c < 26; c++){
                    if(freq[c] > 0){
                        greater = c;
                        break;
                    }
                }
                if(greater != -1){
                    ans.append((char) ('a' + greater));
                    freq[greater]--;
                    appendRemaining(ans, freq);
                    return ans.toString();
                }
                break;
            }
        }
        while(ans.length() > 0){
            int pos = ans.length() - 1;
            char current = ans.charAt(pos);
            freq[current - 'a']++;
            ans.deleteCharAt(pos);
            int currentValue = current - 'a';
            int greater = -1;
            for(int c = currentValue + 1; c < 26;  c++){
                if(freq[c] > 0){
                    greater = c;
                    break;
                }
            }
            if(greater != -1){
                ans.append((char)('a' + greater));
                freq[greater]--;
                appendRemaining(ans, freq);
                return ans.toString();
            }        
            }
            return "";
    }
    private void appendRemaining(StringBuilder ans, int[] freq){
        for(int c = 0; c < 26; c++){
            while(freq[c] > 0){
                ans.append((char)('a' + c));
                freq[c]--;
            }
        }
    }
}