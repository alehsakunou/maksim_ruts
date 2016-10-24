package com.epam.jmp.nosql;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.Date;
import java.util.List;

/**
 * Simple mongo util
 */
public final class MongoStatisticUtil {
    private MongoStatisticUtil() {
    }

    /**
     * Average number of messages by day of week
     * @param from from date
     * @param to to date
     * @return number of messages by day of week
     */
    public static long getMessagesCount(final Date from, final Date to) {
        MongoCollection<Document> collection = MongoManager.getCollection(MongoManager.MESSAGES);
        BasicDBObject query = new BasicDBObject();
        query.put("timestamp", BasicDBObjectBuilder.start("$gte", from).add("$lte", to).get());

        return collection.count(query);
    }

    /**
     * Max number of new friendships from month to month
     * @param from from date
     * @param to to date
     * @return number of new friendships from month to month
     */
    public static long getNewFriendshipCount(final Date from, final Date to) {
        MongoCollection<Document> collection = MongoManager.getCollection(MongoManager.USERS);
        BasicDBObject query = new BasicDBObject();
        query.put("timestamp", BasicDBObjectBuilder.start("$gte", from).add("$lte", to).get());

        return collection.count(query);
    }

    /**
     * Min number of watched movies by users with more than 100 friends
     * @param friendsCount count of friends
     * @return number of watched movies by users with more than 100 friends
     */
    public static long minCountOfMoviesForUserFithFriendsMoreThan(final int friendsCount) {
        MongoCollection<Document> collection = MongoManager.getCollection(MongoManager.USERS);
        BasicDBObject query = new BasicDBObject("$where", "this.friends.length < " + friendsCount);
        BasicDBObject sort = new BasicDBObject("this.movies.length ", 1);
        List<Document> movies = (List<Document>) collection.find(query).sort(sort).first().get("movies");
        return movies.size();
    }
}
