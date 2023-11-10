package leetcode.beginner;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-recent-calls/description/">
 *     933. Number of Recent Calls</a>
 */
public class RecentCounter {
    public static final int PERIOD = 3000;
    Queue<Integer> requests;

    public RecentCounter() {
        this.requests = new LinkedList<>();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

    public int ping(int t) {
        int start = t - PERIOD;
        requests.add(t);//period t-3000,t
        while (!requests.isEmpty() && requests.peek()<start){
            requests.poll();
        }

        return requests.size();
    }
}
