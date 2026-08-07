import java.util.*;
class Twitter {
    private static int timeStamp = 0;
    class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
        }
    }
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetMap;
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );
        if (tweetMap.containsKey(userId)) {
            pq.offer(tweetMap.get(userId));
        }
        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                if (tweetMap.containsKey(followee)) {
                    pq.offer(tweetMap.get(followee));
                }
            }
        }
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet cur = pq.poll();
            res.add(cur.id);
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return res;
    }
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}