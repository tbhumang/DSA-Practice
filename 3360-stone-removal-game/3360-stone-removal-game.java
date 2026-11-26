class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean aliceTurn = true;
        while (remove > 0 && n >= remove) {
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }
        return !aliceTurn;
    }
}