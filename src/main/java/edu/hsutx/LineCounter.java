package edu.hsutx;

/**
 * A class for counting lines in text files
 *
 * @author  Terry Sergeant, with minor edits by Todd Dole
 * @version for Data Structures
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

public class LineCounter {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 1) {
            System.out.println("Usage: java LineCounter name_of_directory");
            throw new Exception("Invalid number of arguments");
        }

        File folder = new File(args[0]);
        if (!folder.isDirectory()) {
            System.out.println("Folder does not exist");
            throw new Exception("Folder does not exist");
        }

        // We want to work with .txt files
        FilenameFilter txtFileFilter = (dir, name) -> name.endsWith(".txt");

        // get list of files and display their length
        CodeTimer timer = new CodeTimer();
        File[] files = folder.listFiles(txtFileFilter);

        timer.start();

        if (files != null) {
            for (File file : files) {
                countLines(args[0] + "/" + file.getName());
            }
        }

        timer.stop();

        System.out.println("==========================================");
        System.out.println("Files processed: " + (files==null ? 0 : files.length));
        System.out.println("Time elapsed     : " + timer);
        System.out.println("==========================================");


    }

    public static void countLines(String filename) {
        int count = 0;
        try (BufferedReader f = new BufferedReader(new FileReader(filename))) {
            while (f.readLine() != null) count++;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(filename + " has " + count + " lines");
    }

    public static void mainAlternate(String[] args) throws Exception {
        // TODO - Modify this to use threads
        if (args == null || args.length < 1) {
            System.out.println("Usage: java LineCounter name_of_directory");
            throw new Exception("Invalid number of arguments");
        }

        File folder = new File(args[0]);
        if (!folder.isDirectory()) {
            System.out.println("Folder does not exist");
            throw new Exception("Folder does not exist");
        }

        // We want to work with .txt files
        FilenameFilter txtFileFilter = (dir, name) -> name.endsWith(".txt");

        // get list of files and display their length
        CodeTimer timer = new CodeTimer();
        File[] files = folder.listFiles(txtFileFilter);

        timer.start();

        if (files != null) {
            for (File file : files) {
                countLines(args[0] + "/" + file.getName());
            }
        }

        timer.stop();

        System.out.println("==========================================");
        System.out.println("Files processed: " + (files==null ? 0 : files.length));
        System.out.println("Time elapsed     : " + timer);
        System.out.println("==========================================");
    }
}
