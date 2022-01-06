package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbManagerTestSuite {
    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTANE") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException{
        //Given
        DbManager dbManager2 = DbManager.getInstance();

        //When
        String sqlQuery2 = "SELECT u.FIRSTANE, u.LASTNAME FROM USERS u JOIN POSTS p ON u.ID = p.USER_ID GROUP BY p.USER_ID HAVING COUNT(*) > 1";
        Statement statement2 = dbManager2.getConnection().createStatement();
        ResultSet rs2 = statement2.executeQuery(sqlQuery2);

        //Then
        int counter = 0;
        while (rs2.next()) {
            System.out.println(rs2.getString("FIRSTANE") + ", " +
                    rs2.getString("LASTNAME"));
            counter++;
        }
        rs2.close();
        statement2.close();
        assertEquals(1, counter);
    }
}
