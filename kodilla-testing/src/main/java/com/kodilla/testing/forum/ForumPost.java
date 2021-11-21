package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumPost {
    private String postBody;
    private String author;

    public ForumPost(String postBody, String author) {
        this.postBody = postBody;
        this.author = author;
    }

    public String getPostBody() {
        return postBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumPost forumPost = (ForumPost) o;

        if (getPostBody() != null ? !getPostBody().equals(forumPost.getPostBody()) : forumPost.getPostBody() != null)
            return false;
        return getAuthor() != null ? getAuthor().equals(forumPost.getAuthor()) : forumPost.getAuthor() == null;
    }

    @Override
    public int hashCode() {
        int result = getPostBody() != null ? getPostBody().hashCode() : 0;
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        return result;
    }
}
