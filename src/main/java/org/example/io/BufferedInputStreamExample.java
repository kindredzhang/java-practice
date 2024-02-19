package org.example.io;

import java.io.*;

public class BufferedInputStreamExample {
    public static void main(String[] args) throws IOException {
        // print result
        // FileInputStream read cost: 853355
        // BufferedInputStream read cost: 20549
        //一般我们是不会直接单独使用 FileInputStream ，通常会配合 BufferedInputStream 效率更高

        int b = 0;
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("/home/syl/Downloads/ubuntu.iso");
        while ((b = fis.read()) != -1) {
        }
        System.out.println("FileInputStream read cost: " + (System.currentTimeMillis() - start));
        fis.close();


        start = System.currentTimeMillis();
        fis = new FileInputStream("/home/syl/Downloads/ubuntu-c1.iso");
        BufferedInputStream bis = new BufferedInputStream(fis);
        while ((b = bis.read()) != -1) {
        }
        System.out.println("BufferedInputStream read cost: " + (System.currentTimeMillis() - start));
        bis.close();

    }
}
