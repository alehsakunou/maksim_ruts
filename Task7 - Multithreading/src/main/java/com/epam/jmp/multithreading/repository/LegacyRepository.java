package com.epam.jmp.multithreading.repository;

/**
 * Created by Gambit on 8/20/2016.
 * Legacy implementation of repository
 */
public class LegacyRepository extends AbstractRepository {
    /**
     * Create legacy repository
     * @param path path to folder for repository
     */
    public LegacyRepository(String path) {
        super(path);
    }

    @Override
    protected void load(RepositoryDownloader downloader) {
        new Thread(downloader).start();
    }

    @Override
    protected void save(RepositoryDownloader downloader) {
        new Thread(downloader).start();
    }

    @Override
    public void close() {

    }
}
