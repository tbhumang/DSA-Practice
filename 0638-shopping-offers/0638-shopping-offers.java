class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return solve(price, special, needs, new HashMap<>());
    }

    private int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp) {
        if (dp.containsKey(needs)) return dp.get(needs);
        int cost = 0;
        for (int i = 0; i < needs.size(); i++) cost += needs.get(i) * price.get(i);

        for (List<Integer> s : special) {
            List<Integer> next = new ArrayList<>(needs);
            int i = 0;
            for (; i < needs.size(); i++) {
                if (next.get(i) < s.get(i)) break;
                next.set(i, next.get(i) - s.get(i));
            }
            if (i == needs.size()) cost = Math.min(cost, s.get(i) + solve(price, special, next, dp));
        }

        dp.put(new ArrayList<>(needs), cost);
        return cost;
    }
}