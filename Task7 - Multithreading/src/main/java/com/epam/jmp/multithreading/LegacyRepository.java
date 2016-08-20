package com.epam.jmp.multithreading;

/**
 * Created by Gambit on 8/20/2016.
 */
public class LegacyRepository extends AbstractRepository {
    // todo
    private final ThreadGroup threadGroup;

    public LegacyRepository(String path) {
        super(path);
        threadGroup = new ThreadGroup("Legacy downloaders team");
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
