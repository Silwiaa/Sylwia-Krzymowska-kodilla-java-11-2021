package com.kodilla.newStream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int identifier;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int publicatedPstsNo;

    public ForumUser(final int identifier, final String userName, final char sex, final int year, final int month, final int day, final int publicatedPstsNo) {
        this.identifier = identifier;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.publicatedPstsNo = publicatedPstsNo;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPublicatedPstsNo() {
        return publicatedPstsNo;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "identifier=" + identifier +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", publicatedPstsNo=" + publicatedPstsNo +
                '}';
    }
}

