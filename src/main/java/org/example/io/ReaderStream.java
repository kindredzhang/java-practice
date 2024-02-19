package org.example.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderStream {
    public static void main(String[] args) {
        //FileInputStream读中文时会出现乱码 所以出现了字符流
        try (FileReader fileReader = new FileReader("input.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int content;
            long skip = bufferedReader.skip(3);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ( (content = bufferedReader.read() ) != -1 ) {
                System.out.println((char)content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
