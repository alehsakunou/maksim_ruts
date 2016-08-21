package com.epam.jmp.multithreading.repository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gambit on 8/21/2016.
 * Concurrency implementation of repository
 */
public class ConcurrencyRepository extends AbstractRepository {
    private final ExecutorService service;

    /**
     * Create concurrency repository
     * @param path path to folder for repository
     */
    public ConcurrencyRepository(String path) {
        super(path);
        this.service = Executors.newCachedThreadPool();
    }

    @Override
    protected void load(RepositoryDownloader downloader) {
        service.submit(downloader);
    }

    @Override
    protected void save(RepositoryDownloader downloader) {
        service.submit(downloader);
    }

    @Override
    public void close() {
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
