package com.epam.jmp.multithreading;

import com.epam.jmp.multithreading.repository.ConcurrencyRepository;
import com.epam.jmp.multithreading.repository.LegacyRepository;
import com.epam.jmp.multithreading.repository.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Created by Gambit on 8/20/2016.
 * Demo for multithreading task
 */
public class ConsoleRepositoryDemo {

    private static final int UPLOAD = 1;
    private static final int DOWNLOAD = 2;
    private static final int SHOW_FILES = 3;
    private static final int CLOSE = 4;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean isClosing = false;
        Repository repository = selectRepository(scanner);

        while (!isClosing) {
            switch (choiceAction(scanner)) {
                case UPLOAD: {
                    System.out.println("enter path to file:");
                    String path = scanner.nextLine();
                    File file = new File(path);
                    repository.saveAsync(file.getName(), new FileInputStream(file));
                    System.out.println("Uploading started in background mode");
                    break;
                }
                case DOWNLOAD: {
                    System.out.println("enter file for download:");
                    String filename = scanner.nextLine();
                    System.out.println("enter path to store downloaded file:");
                    String path = scanner.nextLine();
                    FileOutputStream fos = new FileOutputStream(new File(path + File.separator + filename));
                    repository.loadAsync(filename, fos);
                    System.out.println("Downloading started in background mode");
                    break;
                }
                case SHOW_FILES:
                    System.out.println("Files at repository:");
                    repository.files().forEach(file -> System.out.println("   " + file));
                    break;
                case CLOSE:
                    System.out.println("Bye!");
                    repository.close();
                    isClosing = true;
                    break;
                default:
                    System.out.println("Unknown case, please, try again.");
                    break;
            }
        }
    }

    private static Repository selectRepository(Scanner scanner) {
        Repository repository;
        System.out.println("Multithread file download manager started!");
        System.out.println("Enter repository path:");
        String path = scanner.nextLine();
        System.out.println("Choose type of manager: ");
        System.out.println(" 1 - legacy");
        System.out.println(" 2 - concurrency");

        int type;
        try {
            type = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            type = -1;
        }
        while (true) {
            switch (type) {
                case 1:
                    repository = new LegacyRepository(path);
                    break;
                case 2:
                    repository = new ConcurrencyRepository(path);
                    break;
                default:
                    System.out.println("Wrong data did enter. Please try again.");
                    continue;
            }
            break;
        }
        System.out.println(repository.getClass().getSimpleName() + " was created");
        return repository;
    }

    private static int choiceAction(Scanner scanner) {
        System.out.println("choiceAction action: ");
        System.out.println(" 1 - upload");
        System.out.println(" 2 - download");
        System.out.println(" 3 - show files");
        System.out.println(" 4 - close app");

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}