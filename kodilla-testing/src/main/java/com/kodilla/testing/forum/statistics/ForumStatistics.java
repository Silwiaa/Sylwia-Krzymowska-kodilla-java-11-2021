package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;

import java.util.ArrayList;
import java.util.List;

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

    public void calculateAdvStatistics(Statistics statistics) {
        forumUserNumber = statistics.userNames().size();
        forumPostsNumber = statistics.postsCount();
        forumCommentNumber = statistics.commentsCount();

        if (forumUserNumber !=0) {
            avgPostsPerUser = forumPostsNumber/forumUserNumber;
            avgCommentsPerUser = forumCommentNumber/forumUserNumber;
            if (forumCommentNumber !=0) {
                avgCommentsPerPost = forumPostsNumber / forumCommentNumber;
            }
        }
    }

    public void showStatistics() {
        System.out.println(
                "Forum User number is: " + forumUserNumber + "\n" +
                "Forum Post Number is: " + forumPostsNumber + "\n" +
                "Forum Comment Number is: " + forumCommentNumber
        );
        if (forumUserNumber !=0) {
            System.out.println(
                    "\n" + "An average number of posts per user is:" + avgPostsPerUser + "\n" +
                    "An average number of comments per user is: " + avgCommentsPerUser
            );
            if (forumCommentNumber !=0) {
                System.out.println( "\n" + "An average number of comments per post is: " + avgCommentsPerPost);
            }

        }
    }


}
