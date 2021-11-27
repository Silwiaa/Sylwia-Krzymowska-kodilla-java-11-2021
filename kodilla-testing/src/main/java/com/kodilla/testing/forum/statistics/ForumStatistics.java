package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private Statistics statistics;
    private int forumUserNumber;
    private int forumPostsNumber;
    private int forumCommentNumber;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics( Statistics statistics) {
        forumUserNumber = statistics.userNames().size();
        forumPostsNumber = statistics.postsCount();
        forumCommentNumber = statistics.commentsCount();

        if (forumUserNumber == 0) {
            avgPostsPerUser = 0;
            avgCommentsPerUser = 0;
        } else {
            avgPostsPerUser = (double)forumPostsNumber / forumUserNumber;
            avgCommentsPerUser = (double)forumCommentNumber / forumUserNumber;
        }

        if (forumPostsNumber == 0) {
            avgCommentsPerPost = 0;
        } else {
            avgCommentsPerPost = (double)forumCommentNumber / forumPostsNumber;
        }
    }

    public void showStatistics() {
        System.out.println(
                "Users quantity is: " + forumUserNumber + "\n" +
                        "Posts quantity is: " + forumPostsNumber + "\n" +
                        "Comments quantity is: " + forumCommentNumber + "\n" +
                        "An averadge  posts per user is: " + avgPostsPerUser + "\n" +
                        "An averadge  comments per user is: " + avgCommentsPerUser + "\n" +
                        "An averadge  comments per user post is: " + avgCommentsPerPost + "\n"
        );
    }

    public int getForumUserNumber() {
        return forumUserNumber;
    }

    public int getForumPostsNumber() {
        return forumPostsNumber;
    }

    public int getForumCommentNumber() {
        return forumCommentNumber;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
