package org.example.copy;

import java.io.*;

public class DeepCopy {

    public static <T extends Serializable> T deepCopy(Person object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(object);
        out.flush();
        out.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        T copiedObject = (T) in.readObject();
        in.close();

        return copiedObject;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person originalPerson = new Person("John", new Person.Address("123 Street"));
        Person deepCopiedPerson = deepCopy(originalPerson);

        // 修改克隆对象的成员变量，原对象不受影响
        deepCopiedPerson.setName("Jane");
        deepCopiedPerson.getAddress().setStreet("456 Avenue");

        System.out.println(originalPerson.getName());  // 输出: John
        System.out.println(originalPerson.getAddress().getStreet());  // 输出: 123 Street

    }

}
