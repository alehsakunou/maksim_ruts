package com.epam.jmp.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gambit on 8/21/2016.
 */
public class ConcurrencyRepository extends AbstractRepository {
    private final ExecutorService service;

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
