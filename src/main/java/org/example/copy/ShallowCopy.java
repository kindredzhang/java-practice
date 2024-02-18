package org.example.copy;

public class ShallowCopy {
    public static void main(String[] args) {
        Person originalPerson = new Person("John", new Person.Address("123 Street"));
        Person clonedPerson = originalPerson.clone();

        clonedPerson.setName("Jane");
        clonedPerson.getAddress().setStreet("456 Avenue");

        //浅拷贝后修改原对象内引用类型的值，原始对象的引用类型值也会跟着变化
        System.out.println(originalPerson.getName());  // 输出: Jane
        System.out.println(originalPerson.getAddress().getStreet());  // 输出: 456 Avenue
    }
}
