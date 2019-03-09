package com.jayce;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ZhaoCong
 * @Date: 2018-12-09
 * @Description:
 */
class Twitter {
    /**
     * userList
     * followedList (userId,followList)
     * postTweet (userId,postedList)
     */
//    List<Integer> allUserId=new LinkedList<>();
    Map<Integer, List> allFollowedList = new HashMap<>();
    Map<Integer, List> allPostedTweet = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {


    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
//        if(!allUserId.contains(userId)){
//            allUserId.add(userId);
//        }
        if (!allPostedTweet.containsKey(userId)) {
            allPostedTweet.put(userId, new LinkedList());
        }
        List<Integer> temp = allPostedTweet.get(userId);
        temp.add(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();
        List<Integer> result2 = new LinkedList<>();
        if(allPostedTweet.containsKey(userId))
        result.addAll(allPostedTweet.get(userId));
        List<Integer> follwed = allFollowedList.get(userId);
        for (int i = 0; follwed!=null&&i<follwed.size()&&result.size() < 10; i++) {
            int tempId = follwed.get(i);
            if(allPostedTweet.containsKey(tempId))
            result.addAll(allPostedTweet.get(tempId));
        }
        for(int i=1;i<=result.size()&&i<=10;i++){
            if(!result2.contains(result.get(result.size()-i)))
            result2.add(result.get(result.size()-i));
        }
        return result2;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!allFollowedList.containsKey(followerId)) {
            allFollowedList.put(followerId, new LinkedList());
        }
        List<Integer> temp = allFollowedList.get(followerId);
        temp.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!allFollowedList.containsKey(followerId)) {
            allFollowedList.put(followerId, new LinkedList());
        }
        List<Integer> temp = allFollowedList.get(followerId);
        if (temp.contains(followeeId)) {
            temp.remove((Integer) followeeId);

        }
    }
//    public static void main(String[] args) {
//        Twitter twitter = new Twitter();
//
//        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//        twitter.postTweet(1, 5);
//
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        List test=twitter.getNewsFeed(1);
//
//        // 用户1关注了用户2.
//        twitter.follow(1, 2);
//
//        // 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        test=twitter.getNewsFeed(1);
//
//        // 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        // 因为用户1已经不再关注用户2.
//        test=twitter.getNewsFeed(1);
//    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */