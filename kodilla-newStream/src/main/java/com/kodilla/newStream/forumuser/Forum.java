package com.kodilla.newStream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    public List<ForumUser> getForumUserList() {
        List<ForumUser> forumUserList = new ArrayList<>();

        forumUserList.add(new ForumUser(101, "JonyX", 'M', 1975, 6, 12, 18));
        forumUserList.add(new ForumUser(102, "DannyZ", 'M', 2002, 9, 13, 5));
        forumUserList.add(new ForumUser(103, "MadMax", 'M', 2008, 12, 10, 16));
        forumUserList.add(new ForumUser(104, "Yoda123", 'K', 1998, 11, 26, 26));
        forumUserList.add(new ForumUser(105, "MasterPlaster", 'K', 2010, 4, 17, 12));
        forumUserList.add(new ForumUser(106, "Naxi", 'K', 1980, 9, 25, 55));
        forumUserList.add(new ForumUser(107, "PexTex", 'M', 1999, 4, 12, 1));
        forumUserList.add(new ForumUser(108, "XoXo", 'M', 2001, 7, 30, 17));
        forumUserList.add(new ForumUser(109, "Jumbo89", 'M', 2002, 11, 16, 5));
        forumUserList.add(new ForumUser(110, "JimmyJam", 'M', 1987, 8, 6, 0));

        return new ArrayList<>(forumUserList);
    }
}
