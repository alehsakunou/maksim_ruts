import by.epam.jmp.classloading.player.MediaPlayer;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;

/**
 * Created by Gambit on 8/7/2016.
 */
public class Runner {
    private static final String SEPARATOR = "-----------------------------------------------------";

    private static final String CONSOLE_PLAY_WINDOWS = "play windows";
    private static final String CONSOLE_PLAY_IOS = "play ios";
    private static final String CONSOLE_PLAY_ANDROID = "play android";
    private static final String CONSOLE_HELP = "help";
    private static final String CONSOLE_CLOSE = "close";

    private static String DIR = System.getProperty("user.dir");
    private static String PLAYER_ANDROID = DIR + "\\Task5 - Classloading\\Player for Android\\target\\player.android-1.0.jar";
    private static String PLAYER_WINDOWS = DIR + "\\Task5 - Classloading\\Player for Windows\\target\\player.windows-1.0.jar";
    private static String PLAYER_IOS = DIR + "\\Task5 - Classloading\\Player for IOS\\target\\player.ios-1.0.jar";

    public static void main(String[] args) throws Exception {
        System.out.println(
                MessageFormat.format("Cross-platform media player started!!! Enter ''{0}'' " +
                        "for list of commands", CONSOLE_HELP));
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                System.out.println(SEPARATOR);
                if (CONSOLE_CLOSE.equals(s)) {
                    break;
                } else if (CONSOLE_HELP.equals(s)) {
                    help();
                } else if (CONSOLE_PLAY_WINDOWS.equals(s)) {
                    playWin();
                } else if (CONSOLE_PLAY_IOS.equals(s)) {
                    playIos();
                } else if (CONSOLE_PLAY_ANDROID.equals(s)) {
                    playDroid();
                } else {
                    System.out.println("ooops!! wrong command");
                }
            }
        }

        System.out.println("See you later!!!");
    }

    private static void help() {
        System.out.println("Player supports next commands:");
        System.out.println(MessageFormat.format("''{0}'' - close player", CONSOLE_CLOSE));
        System.out.println(MessageFormat.format("''{0}'' - show help", CONSOLE_HELP));
        System.out.println(MessageFormat.format("''{0}'' - play song on windows player", CONSOLE_PLAY_WINDOWS));
        System.out.println(MessageFormat.format("''{0}'' - play song on ios player", CONSOLE_PLAY_IOS));
        System.out.println(MessageFormat.format("''{0}'' - play song on android player", CONSOLE_PLAY_ANDROID));
    }

    private static void playWin() {
        play(new MediaPlayer(PLAYER_WINDOWS));
    }

    private static void playIos() {
        play(new MediaPlayer(PLAYER_IOS));
    }

    private static void playDroid() {
        play(new MediaPlayer(PLAYER_ANDROID));
    }

    private static void play(MediaPlayer mediaPlayer) {
        mediaPlayer.play();
        try {
            mediaPlayer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
        }
    }

}