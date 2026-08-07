public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        index = 0;
        flatten(nestedList);
    }
    private void flatten(List<NestedInteger> nestedList){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                list.add(ni.getInteger());
            } else{
                flatten(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
