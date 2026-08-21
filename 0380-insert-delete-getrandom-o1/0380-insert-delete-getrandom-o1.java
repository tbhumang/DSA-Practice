import java.util.*;
class RandomizedSet {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);
        list.set(index, lastValue);
        map.put(lastValue, index);
        list.remove(lastIndex);
        map.remove(val);
        return true;
    }
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}