package com.epam.jmp.nosql;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Mongo demo
 */
public final class Demo {
    /**
     * Entrance point
     * @param args args
     */
    public static void main(String[] args) {
        SocialNetworkGenerator.generateNew(1000);
        Date from = Date.valueOf(LocalDate.of(1990, 1, 1));
        Date to = Date.valueOf(LocalDate.of(2010, 1, 1));

        MongoStatisticUtil.getMessagesCount(from, to);
        MongoStatisticUtil.getNewFriendshipCount(from, to);
        MongoStatisticUtil.minCountOfMoviesForUserFithFriendsMoreThan(15);
    }
}
