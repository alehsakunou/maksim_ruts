package com.epam.jmp.jbdc;

/**
 * Queries for entities
 * Created by Gambit on 9/14/2016.
 */
public class Queries {
    /**
     * ID
     */
    public static final String ID = "    id BIGINT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),";

    /**
     * Queries for Users
     */
    public static class Users {
        /**
         * Create table Users
         */
        public static String CREATE = "CREATE TABLE USERS " +
                "(" +
                ID +
                "    name VARCHAR(50)," +
                "    surname VARCHAR(50)," +
                "    birthday DATE" +
                ")";

        /**
         * Insert into Users
         */
        public static String INSERT = "INSERT INTO USERS " +
                "(name, surname, birthday) " +
                "values (?, ?, ?)";

        /**
         * Select from users
         */
        public static String SELECT = "SELECT * FROM USERS";
    }

    /**
     * Queries for Posts
     */
    public static class Posts {
        /**
         * Create table Posts
         */
        public static String CREATE = "CREATE TABLE POSTS " +
                "(" +
                ID +
                "    user_id BIGINT," +
                "    text VARCHAR(50)," + // todo increase size
                "    timestamp DATE," +
                "    CONSTRAINT POSTS_USER_ID_fk FOREIGN KEY (user_id) REFERENCES USERS (ID)" +
                ")";

        /**
         * Insert to Posts
         */
        public static String INSERT = "INSERT INTO POSTS " +
                "(user_id, text, timestamp) " +
                "values (?, ?, ?)";

        /**
         * Select from Posts
         */
        public static String SELECT = "SELECT * FROM POSTS";
    }

    /**
     * Queries for table Friendships
     */
    public static class Friendships {
        /**
         * Create table Friendships
         */
        public static String CREATE = "CREATE TABLE FRIENDSHIPS " +
                "(" +
                "    user1_id BIGINT," +
                "    user2_id BIGINT," +
                "    timestamp DATE," +
                "    CONSTRAINT FRIENDSHIPS_USER1_ID_fk FOREIGN KEY (user1_id) REFERENCES USERS (ID)," +
                "    CONSTRAINT FRIENDSHIPS_USER2_ID_fk FOREIGN KEY (user2_id) REFERENCES USERS (ID)" +
                ")";

        /**
         * Insert to Friendships
         */
        public static String INSERT = "INSERT INTO FRIENDSHIPS " +
                "(user1_id, user2_id, timestamp) " +
                "values (?, ?, ?)";

        /**
         * Select from Friendships
         */
        public static String SELECT = "SELECT * FROM FRIENDSHIPS";
    }

    /**
     * Queries for table Likes
     */
    public static class Likes {
        /**
         * Create table Likes
         */
        public static String CREATE = "CREATE TABLE LIKES " +
                "(" +
                "    post_id BIGINT," +
                "    user_id BIGINT," +
                "    timestamp DATE," +
                "    CONSTRAINT LIKES_USER_ID_fk FOREIGN KEY (user_id) REFERENCES USERS (ID)," +
                "    CONSTRAINT LIKES_POST_ID_fk FOREIGN KEY (post_id) REFERENCES POSTS (ID)" +
                ")";

        /**
         * Insert to Likes
         */
        public static String INSERT = "INSERT INTO LIKES " +
                "(post_id, user_id, timestamp) " +
                "values (?, ?, ?)";

        /**
         * Select from Likes
         */
        public static String SELECT = "SELECT * FROM LIKES";
    }
}
