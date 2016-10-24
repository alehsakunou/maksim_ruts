package com.epam.jmp.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Simple mongo manager
 */
public final class MongoManager {
    private static volatile MongoDatabase DATA_BASE;

    private MongoManager() {
    }

    /**
     * Collections of users
     */
    public static final String USERS = "users";
    /**
     * Collections of likes
     */
    public static final String LIKES = "likes";
    /**
     * Collections of messages
     */
    public static final String MESSAGES = "messages";

    private static MongoDatabase getInstance() {
        if (DATA_BASE == null) {
            synchronized (MongoManager.class) {
                if (DATA_BASE == null) {
                    MongoClient mongoClient = new MongoClient();
                    DATA_BASE = mongoClient.getDatabase("local");
                }
            }
        }
        return DATA_BASE;
    }

    /**
     * Get specific collection
     * @param collectionName name of requested collection
     * @return requested colelction
     */
    public static MongoCollection<Document> getCollection(final String collectionName) {
        MongoCollection<Document> collection = getInstance().getCollection(collectionName);
        if (collection == null) {
            getInstance().createCollection(collectionName);
            collection = getInstance().getCollection(collectionName);
        }
        return collection;
    }
}
