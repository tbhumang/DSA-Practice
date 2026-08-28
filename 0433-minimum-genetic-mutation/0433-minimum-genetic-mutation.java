class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        for(String gene : bank){
            set.add(gene);
        }
        if(!set.contains(endGene)){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        int mutations = 0;
        char[] letters = {'A', 'C', 'G', 'T'};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                if(current.equals(endGene)){
                    return mutations;
                }
                char[] gene = current.toCharArray();
                for(int j = 0; j < 8; j++){
                    char original = gene[j];
                    for(char ch : letters){
                        if(ch == original){
                            continue;
                        }
                        gene[j] = ch;
                        String next = new String(gene);
                        if(set.contains(next) && !visited.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    gene[j] = original;
                }
            }
            mutations++;
        }
        return -1;
    }
}