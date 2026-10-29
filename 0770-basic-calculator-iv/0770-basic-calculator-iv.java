import java.util.*;

class Solution {
    Map<String, Integer> values = new HashMap<>();
    List<String> tokens;
    int pos;

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        for (int i = 0; i < evalvars.length; i++)
            values.put(evalvars[i], evalints[i]);

        tokens = Arrays.asList(expression.replace("(", "( ").replace(")", " )").split(" "));
        pos = 0;

        Map<String, Integer> poly = parse();
        List<String> ans = new ArrayList<>(poly.keySet());
        ans.sort((a, b) -> {
            int d = degree(b) - degree(a);
            return d != 0 ? d : a.compareTo(b);
        });

        List<String> res = new ArrayList<>();
        for (String key : ans) {
            int c = poly.get(key);
            if (c == 0) continue;
            res.add(key.isEmpty() ? String.valueOf(c) : c + "*" + key);
        }
        return res;
    }

    Map<String, Integer> parse() {
        Map<String, Integer> res = term();
        while (pos < tokens.size() && !tokens.get(pos).equals(")")) {
            String op = tokens.get(pos++);
            Map<String, Integer> next = term();
            res = add(res, next, op.equals("+") ? 1 : op.equals("-") ? -1 : 0);
        }
        return res;
    }

    Map<String, Integer> term() {
        Map<String, Integer> res = factor();
        while (pos < tokens.size() && tokens.get(pos).equals("*")) {
            pos++;
            res = multiply(res, factor());
        }
        return res;
    }

    Map<String, Integer> factor() {
        String t = tokens.get(pos++);
        if (t.equals("(")) {
            Map<String, Integer> res = parse();
            pos++;
            return res;
        }
        if (Character.isDigit(t.charAt(0))) {
            Map<String, Integer> res = new HashMap<>();
            res.put("", Integer.parseInt(t));
            return res;
        }
        if (values.containsKey(t)) {
            Map<String, Integer> res = new HashMap<>();
            res.put("", values.get(t));
            return res;
        }
        Map<String, Integer> res = new HashMap<>();
        res.put(t, 1);
        return res;
    }

    Map<String, Integer> add(Map<String, Integer> a, Map<String, Integer> b, int sign) {
        Map<String, Integer> res = new HashMap<>(a);
        for (String k : b.keySet())
            res.merge(k, b.get(k) * sign, Integer::sum);
        return res;
    }

    Map<String, Integer> multiply(Map<String, Integer> a, Map<String, Integer> b) {
        Map<String, Integer> res = new HashMap<>();
        for (String x : a.keySet()) {
            for (String y : b.keySet()) {
                List<String> vars = new ArrayList<>();
                if (!x.isEmpty()) vars.addAll(Arrays.asList(x.split("\\*")));
                if (!y.isEmpty()) vars.addAll(Arrays.asList(y.split("\\*")));
                Collections.sort(vars);
                String key = String.join("*", vars);
                res.merge(key, a.get(x) * b.get(y), Integer::sum);
            }
        }
        return res;
    }

    int degree(String s) {
        return s.isEmpty() ? 0 : s.split("\\*").length;
    }
}