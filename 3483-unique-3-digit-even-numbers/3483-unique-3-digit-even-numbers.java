class Solution {
    public int totalNumbers(int[] d) {
        int ans = 0;
        for (int i = 1; i <= 9; i++)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= 8; k += 2) {
                    int[] need = new int[10];
                    need[i]++;
                    need[j]++;
                    need[k]++;

                    int[] have = new int[10];
                    for (int x : d) have[x]++;

                    boolean ok = true;
                    for (int x = 0; x < 10; x++)
                        if (need[x] > have[x]) ok = false;

                    if (ok) ans++;
                }

        return ans;
    }
}

