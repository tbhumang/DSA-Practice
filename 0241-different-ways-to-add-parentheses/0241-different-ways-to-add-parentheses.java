class Solution {
    private Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String leftExpr = expression.substring(0, i);
                String rightExpr = expression.substring(i + 1);
                List<Integer> left = diffWaysToCompute(leftExpr);
                List<Integer> right = diffWaysToCompute(rightExpr);
                for (int a : left) {
                    for (int b : right) {
                        if (ch == '+') {
                            result.add(a + b);
                        } else if (ch == '-') {
                            result.add(a - b);
                        } else {
                            result.add(a * b);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        memo.put(expression, result);
        return result;
    }
}