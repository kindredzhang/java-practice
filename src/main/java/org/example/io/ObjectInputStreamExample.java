package org.example.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectInputStreamExample {
    public static void main(String[] args) throws IOException {
        String filePath = "object.dat";
        writeObjectsToFile(filePath);
        readObjectsToFile(filePath);
    }

    private static void writeObjectsToFile(String filePath) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filePath)));
            Person person1 = new Person("John", 25);
            Person person2 = new Person("Alice", 30);

            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(person2);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectsToFile(String filePath) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(filePath)));
            Person person1 = (Person) objectInputStream.readObject();
            Person person2 = (Person) objectInputStream.readObject();

            System.out.println("Read Person 1: " + person1);
            System.out.println("Read Person 2: " + person2);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
