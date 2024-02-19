package org.example.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcurrentFileReader {

    public static void main(String[] args) {
        String filePath = "input.txt";

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            readLines(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readLines(BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(Thread.currentThread().getName() + ": " + line);
        }
    }
}
