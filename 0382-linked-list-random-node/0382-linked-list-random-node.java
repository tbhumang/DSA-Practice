class Solution {
    private ListNode head;
    private Random random;
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    public int getRandom() {
        int result = 0;
        ListNode curr = head;
        int count = 1;
        while (curr != null) {
            if (random.nextInt(count) == 0) {
                result = curr.val;
            }
            curr = curr.next;
            count++;
        }
        return result;
    }
}