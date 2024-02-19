package org.example.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStreamExample {
    public static void main(String[] args) {

        //input
        try (InputStream fis = new FileInputStream("input.txt")) {
            System.out.println("Number of remaining bytes:"
                    + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        //output
//        try (OutputStream fileOutputStream = Files.newOutputStream(Paths.get("output.txt"));
//             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
//
//            // 明确指定字符编码
//            byte[] array = "111我是中文".getBytes();
//            bufferedOutputStream.write(array);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}
