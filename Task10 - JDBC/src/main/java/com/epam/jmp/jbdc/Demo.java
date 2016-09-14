package com.epam.jmp.jbdc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Entry point for demo
 * Created by Gambit on 9/14/2016.
 */
public class Demo {
    private static final int BATCH_SIZE = 100;
    private static final int USERS_COUNT = 1_000;
    private static final int POSTS_PER_USER = 10;
    private static final int FRIENDS_PER_USER = 10;
    private static final int LIKES_PER_POST = 30;


    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        createTables(connection);
        createUsers(connection);
        List<Integer> userIdList = getIdList(connection, Queries.Users.SELECT);
        createPosts(connection, userIdList);
        List<Integer> postIdList = getIdList(connection, Queries.Posts.SELECT);
        createFriendships(connection, userIdList);
        createLikes(connection, userIdList, postIdList);

        try(PreparedStatement selectPosts = connection.prepareStatement(
                "select U.name, U.surname " +
                "from users U " +
                "inner JOIN LIKES L ON U.ID = L.USER_ID " +
                "inner JOIN friendships F ON U.ID = F.USER1_ID " +
                "where F.timestamp < '2015-03-01' " +
                "and F.timestamp < '2015-03-01' " +
                "group by U.id, U.name, U.surname " +
                "HAVING COUNT (L.user_id) > 100 and count (F.user2_id) > 100");
            ResultSet resultSet = selectPosts.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                System.out.println(name + " " + surname);
            }
        }
    }

    private static void createLikes(Connection connection, List<Integer> userIdList, List<Integer> postIdList) {
        postIdList.forEach(id -> {
            DBUtils.transactional(connection, (Connection conn) -> {
                Random random = new Random();
                try (PreparedStatement insertPosts = conn.prepareStatement(Queries.Likes.INSERT)) {
                    for (int i = 0; i < random.nextInt(LIKES_PER_POST) + 1; i++) {
                        insertPosts.setInt(1, id);
                        insertPosts.setInt(2, userIdList.get(random.nextInt(userIdList.size())));
                        insertPosts.setDate(3, ContentGenerator.getRandomDate());
                        insertPosts.addBatch();
                    }
                    insertPosts.executeBatch();
                } catch (SQLException e) {
                    throw new RuntimeException(); // todo: create exception
                }
            });
        });
    }

    private static void createFriendships(Connection connection, List<Integer> userIdList) {
        userIdList.forEach(id -> {
            Random random = new Random();
            DBUtils.transactional(connection, (Connection conn) -> {
                try (PreparedStatement insertPosts = conn.prepareStatement(Queries.Friendships.INSERT)) {
                    for (int i = 0; i < random.nextInt(FRIENDS_PER_USER) + 1; i++) {
                        insertPosts.setInt(1, id);
                        insertPosts.setInt(2, userIdList.get(random.nextInt(userIdList.size())));
                        insertPosts.setDate(3, ContentGenerator.getRandomDate());
                        insertPosts.addBatch();
                    }
                    insertPosts.executeBatch();
                } catch (SQLException e) {
                    throw new RuntimeException(); // todo: create exception
                }
            });
        });
    }

    private static void createPosts(Connection connection, List<Integer> userIdList) throws SQLException {
        userIdList.forEach(id -> {
            DBUtils.transactional(connection, (Connection conn) -> {
                Random random = new Random();
                try (PreparedStatement insertPosts = conn.prepareStatement(Queries.Posts.INSERT)) {
                    for (int i = 0; i < random.nextInt(POSTS_PER_USER) + 1; i++) {
                        insertPosts.setInt(1, id);
                        insertPosts.setString(2, ContentGenerator.getRandomPost());
                        insertPosts.setDate(3, ContentGenerator.getRandomDate());
                        insertPosts.addBatch();
                    }
                    insertPosts.executeBatch();
                } catch (SQLException e) {
                    throw new RuntimeException(); // todo: create exception
                }
            });
        });

    }

    private static void createUsers(Connection connection) {
        for (int k = 0; k < USERS_COUNT; k+= BATCH_SIZE) {
            DBUtils.transactional(connection, (Connection conn) -> {
                try (PreparedStatement insertUsers = conn.prepareStatement(Queries.Users.INSERT)){
                    for (int i = 0; i < BATCH_SIZE; i++) {
                        insertUsers.setString(1, ContentGenerator.getRandomName());
                        insertUsers.setString(2, ContentGenerator.getRandomSurname());
                        insertUsers.setDate(3, ContentGenerator.getRandomDate());
                        insertUsers.addBatch();
                    }
                    insertUsers.executeBatch();
                } catch (SQLException e) {
                    throw new RuntimeException(); // todo: create exception
                }
            });
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        PreparedStatement createUsers = connection.prepareStatement(Queries.Users.CREATE);
        createUsers.executeUpdate();
        PreparedStatement createPosts = connection.prepareStatement(Queries.Posts.CREATE);
        createPosts.executeUpdate();
        PreparedStatement createLikes = connection.prepareStatement(Queries.Likes.CREATE);
        createLikes.executeUpdate();
        PreparedStatement createFriendship = connection.prepareStatement(Queries.Friendships.CREATE);
        createFriendship.executeUpdate();
    }

    private static List<Integer> getIdList(Connection connection, String query) throws SQLException {
        List<Integer> idList;
        idList = new ArrayList<>();
        try (PreparedStatement selectUsers = connection.prepareStatement(query)) {
            ResultSet resultSet = selectUsers.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                idList.add(id);
            }
        }
        return idList;
    }

}
