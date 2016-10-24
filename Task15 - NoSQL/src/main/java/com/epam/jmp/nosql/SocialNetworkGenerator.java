package com.epam.jmp.nosql;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Simple users generator
 */
public final class SocialNetworkGenerator {
    private static final int MAX_FRIENDS_PER_USER = 10;
    private static final int MAX_LIKES_PER_USER = 100;
    private static final int MIN_MESSAGES_REP_USER = 20;

    private SocialNetworkGenerator() {
    }

    /**
     * Generate users for social networks
     * @param usersCount count of users
     */
    public static void generateNew(final int usersCount) {
        FindIterable<Document> persons = generatePersons(MongoManager.getCollection(MongoManager.USERS), usersCount);
        List<ObjectId> idList = getIdList(persons);
        createFriendships(MongoManager.getCollection(MongoManager.USERS), idList);
        createLikes(MongoManager.getCollection(MongoManager.LIKES), idList);
        createMessages(MongoManager.getCollection(MongoManager.MESSAGES), idList);
        createMovies(MongoManager.getCollection(MongoManager.USERS), idList);
    }


    private static FindIterable<Document> generatePersons(final MongoCollection<Document> collection, final int count) {
        for (int i = 0; i < count; i++) {
            Document person = new Document();
            person.put("name", ContentGenerator.getRandomName());
            person.put("surName", ContentGenerator.getRandomSurname());
            person.put("age", ContentGenerator.getRandomAge());
            collection.insertOne(person);
        }
        return collection.find();
    }

    private static List<ObjectId> getIdList(final FindIterable<Document> document) {
        List<ObjectId> idList = new ArrayList<>();
        for (Document person : document) {
            idList.add(person.getObjectId("_id"));
        }
        return idList;
    }

    private static void createFriendships(final MongoCollection<Document> friendship, final List<ObjectId> idList) {
        Random random = new Random();
        idList.forEach(owner -> {
            for (int i = 0; i < MAX_FRIENDS_PER_USER; i++) {
                Date date = ContentGenerator.getRandomDate();
                ObjectId friend = idList.get(random.nextInt(idList.size()));

                Document toOwner = new Document();
                toOwner.put("friend", friend);
                toOwner.put("timestamp", date);

                Document toFriend = new Document();
                toFriend.put("friend", owner);
                toFriend.put("timestamp", date);

                BasicDBObject queryForOwner = new BasicDBObject("_id", owner);
                BasicDBObject queryForFriend = new BasicDBObject("_id", friend);

                Document updatesForOwner = new Document("friends", toOwner);
                Document updatesForFriend = new Document("friends", toFriend);

                friendship.updateOne(queryForOwner, new BasicDBObject("$push", updatesForOwner));
                friendship.updateOne(queryForFriend, new BasicDBObject("$push", updatesForFriend));
            }
        });
    }

    private static void createLikes(final MongoCollection<Document> likes, final List<ObjectId> idList) {
        Random random = new Random();
        idList.forEach(objectId -> {
            for (int i = 0; i < MAX_LIKES_PER_USER; i++) {
                int from = random.nextInt(idList.size());
                Document like = new Document();
                like.put("owner", objectId);
                like.put("from", idList.get(from));
                like.put("timestamp", ContentGenerator.getRandomDate());
                likes.insertOne(like);
            }
        });
    }

    private static void createMessages(final MongoCollection<Document> likes, final List<ObjectId> idList) {
        Random random = new Random();
        idList.forEach(objectId -> {
            for (int i = 0; i < MIN_MESSAGES_REP_USER; i++) {
                int to = random.nextInt(idList.size());
                Document like = new Document();
                like.put("owner", objectId);
                like.put("to", idList.get(to));
                like.put("timestamp", ContentGenerator.getRandomDate());
                like.put("text", "message from " + objectId + " to " + idList.get(to));
                likes.insertOne(like);
            }
        });
    }

    private static void createMovies(final MongoCollection<Document> collection, final List<ObjectId> idList) {
        Random random = new Random();
        for (ObjectId personId : idList) {
            List<Document> movies = new ArrayList<>();
            for (int i = 0; i < Math.abs(random.nextInt(30)); i++) {
                Document movie = new Document();
                movie.put("title", "movie_" + i);
                movies.add(movie);
            }
            BasicDBObject query = new BasicDBObject("_id", personId);
            Document updates = new Document("movies", movies);
            BasicDBObject updateObject = new BasicDBObject("$set", updates);

            collection.updateOne(query, updateObject);
        }
    }
}

