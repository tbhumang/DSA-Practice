class Solution {
    public boolean checkRecord(String s) {
        int absences = 0;
        int late = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absences++;
                late = 0;
            } else if (c == 'L') {
                late++;
                if (late >= 3) return false;
            } else {
                late = 0;
            }
            if (absences >= 2) return false;
        }
        return true;
    }
}
