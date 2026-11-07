class Solution {
    private record State(int w, int idx){}; 
    private record UsedState(int time, int idx){}; 
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<State> server_pool = new PriorityQueue<State>((a, b) -> {
            if(a.w == b.w) return Integer.compare(a.idx, b.idx); 
            return Integer.compare(a.w, b.w); 
        }); 

        PriorityQueue<UsedState> server_occupied = new  PriorityQueue<UsedState>((a, b) -> {
            return Integer.compare(a.time, b.time); 
        }); 
        int n = servers.length, m = tasks.length; 
        for(int i = 0; i < n; i++) server_pool.add(new State(servers[i], i)); 
        int ans[] = new int[m]; 
        int time = 0; 
        for(int i = 0; i < m; i++) {
            time = Math.max(time, i); 
            if(server_pool.isEmpty()) time = Math.max(time, server_occupied.peek().time); 
            while(!server_occupied.isEmpty() && server_occupied.peek().time <= time) { 
                int idx = server_occupied.peek().idx; 
                server_occupied.poll(); 
                server_pool.add(new State(servers[idx], idx)); 
            }
            int idx = server_pool.peek().idx; 
            ans[i] = idx; 
            server_occupied.add(new UsedState(time + tasks[i], idx)); 
            server_pool.poll(); 
        }
        return ans; 
    }
}