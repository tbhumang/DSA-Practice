import java.util.*;
class AllOne {
    class Node {
        int count;
        HashSet<String> keys;
        Node prev;
        Node next;
        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }
    HashMap<String, Node> map;
    Node head;
    Node tail;
    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node first = head.next;
            if (first == tail || first.count != 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                addAfter(head, newNode);
                map.put(key, newNode);
            }
            else {
                first.keys.add(key);
                map.put(key, first);
            }
            return;
        }
        Node current = map.get(key);
        Node next = current.next;
        if (next == tail || next.count != current.count + 1) {
            Node newNode = new Node(current.count + 1);
            newNode.keys.add(key);
            addAfter(current, newNode);
            map.put(key, newNode);
        }
        else {
            next.keys.add(key);
            map.put(key, next);
        }
        current.keys.remove(key);
        if (current.keys.isEmpty()) {
            removeNode(current);
        }
    }
    public void dec(String key) {
        Node current = map.get(key);
        if (current.count == 1) {
            current.keys.remove(key);
            map.remove(key);
            if (current.keys.isEmpty()) {
                removeNode(current);
            }
            return;
        }
        Node prev = current.prev;
        if (prev == head || prev.count != current.count - 1) {
            Node newNode = new Node(current.count - 1);
            newNode.keys.add(key);
            addAfter(prev, newNode);
            map.put(key, newNode);
        }
        else {
            prev.keys.add(key);
            map.put(key, prev);
        }
        current.keys.remove(key);
        if (current.keys.isEmpty()) {
            removeNode(current);
        }
    }
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
           return head.next.keys.iterator().next();
    }
    private void addAfter(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }
    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}