import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }

        int[] ans = new int[deck.length];

        for (int num : deck) {
            int index = queue.poll();
            ans[index] = num;

            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return ans;
    }
}