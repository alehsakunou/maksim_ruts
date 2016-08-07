package by.epam.jmp.classloading.player;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Gambit on 8/7/2016.
 */
public class MediaPlayer implements Player, Closeable {
    public static final String PLAYER_CLASS = "by.epam.jmp.classloading.player.PlayerImpl";
    private static Logger LOGGER = LogManager.getLogger();

    private String pathToPlayer;
    private Player player = null;
    private ClassLoader classLoader;

    public MediaPlayer(String pathToPlayer) {
        this.pathToPlayer = pathToPlayer;
    }

    public void play() {
        if (player == null) {
            try {
                loadPlayer();
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
        player.play();
    }

    public void close() throws IOException {
        LOGGER.debug("Strong links to player and classLoader destroyed");
        player = null;
        classLoader = null;
    }

    private void loadPlayer() throws Exception {
        LOGGER.debug("Create new instance for URLClassLoader");
        classLoader = new URLClassLoader(new URL[]{new File(pathToPlayer).toURL()}, ClassLoader.getSystemClassLoader());
        LOGGER.debug("Load class " + PLAYER_CLASS);
        Class<?> clazz = classLoader.loadClass(PLAYER_CLASS);
        LOGGER.debug("Create new instance of class " + PLAYER_CLASS);
        player = (Player) clazz.newInstance();
    }


}
