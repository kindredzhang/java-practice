package org.example.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataInputStreamExample {
    public static void main(String[] args) {
        // 文件路径
        String filePath = "data.dat";

        // 写入数据到文件
        writeDataToFile(filePath);

        // 从文件读取数据
        readDataFromFile(filePath);
    }

    private static void writeDataToFile(String filePath) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(Paths.get(filePath)))) {
            // 写入基本数据类型到文件
            dataOutputStream.writeInt(42);
            dataOutputStream.writeDouble(3.14);
            dataOutputStream.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readDataFromFile(String filePath) {
        try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(Paths.get(filePath)))) {
            // 从文件读取基本数据类型
            int intValue = dataInputStream.readInt();
            double doubleValue = dataInputStream.readDouble();
            boolean booleanValue = dataInputStream.readBoolean();

            // 输出读取的数据
            System.out.println("Read int value: " + intValue);
            System.out.println("Read double value: " + doubleValue);
            System.out.println("Read boolean value: " + booleanValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
