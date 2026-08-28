class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null){
            if(curr.child == null){
                curr = curr.next;
                continue;
            }
            Node next = curr.next;
            Node child = curr.child;
            curr.next = child;
            child.prev = curr;
            curr.child = null;
            Node temp = child;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = next;
            if(next != null){
                next.prev = temp;
            }
            curr = curr.next;
        }
        return head;
    }
}