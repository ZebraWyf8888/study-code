package macleetcode.code2.p1;

import java.util.*;

class Twitter {

    /**
     * @Description: 健是用户，值是文章
     */
    Map<Integer, LinkedList<Integer>> word;
    /**
     * @Description: 健是用户，值是关注他的人
     */
    Map<Integer, LinkedList<Integer>> connect;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        word = new HashMap<>();
        connect = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (word.get(userId) != null) {
            LinkedList linkedList = word.get(userId);
            linkedList.offer(tweetId);
            LinkedList<Integer> linkedList1 = connect.get(userId);
            if (linkedList1 != null) {
                for (int i = 0; i < linkedList.size(); i++) {

                    try {
                        Integer integer = null;
                        integer = linkedList1.get(i);
                        LinkedList<Integer> linkedList2 = word.get(integer);
                        linkedList2.add(tweetId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        return;
                    }

                }
            }

        } else {
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.offer(tweetId);
            word.put(userId, linkedList);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> linkedList = word.get(userId);
        LinkedList<Integer> clone = (LinkedList<Integer>) linkedList.clone();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer poll = clone.poll();
            a.add(poll);
        }
        return a;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (connect.get(followeeId) != null) {
            LinkedList linkedList = connect.get(followeeId);
            linkedList.offer(followerId);
        } else {
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.offer(followerId);
            connect.put(followeeId, linkedList);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (connect.get(followeeId) != null) {
            LinkedList linkedList = connect.get(followeeId);
            Iterator<Integer> listIt = linkedList.iterator();
           while (listIt.hasNext()){
               Integer next = listIt.next();
               if (next.equals(followeeId)) {
                   listIt.remove();
               }
           }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 7);
        twitter.postTweet(1, 8);
        twitter.postTweet(1, 9);
        twitter.postTweet(2, 5);
        List<Integer> newsFeed = twitter.getNewsFeed(1);
        for (Integer integer:
             newsFeed) {
            System.out.println(integer);
        }
        System.out.println("-------------");
        twitter.postTweet(2, 9);
        twitter.follow(1, 2);
        twitter.postTweet(2, 5);
        List<Integer> newsFeed2 = twitter.getNewsFeed(1);
        for (Integer integer:
                newsFeed2) {
            System.out.println(integer);
        }
    }
}





