package org.example.copy;

public class Person implements Cloneable {
    private String name;
    private Address address;

    @Override
    public Person clone() {
        try {
            // 调用默认的浅拷贝
            Person clone = (Person) super.clone();

            // 手动处理引用类型的成员变量，实现深拷贝
            if (this.address != null) {
                clone.address = new Address(this.address.getStreet());
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    static class Address {
        String street;

        public Address(String street) {
            this.street = street;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person() {
    }

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public static void main(String[] args) {
        // 创建原始对象
        Person originalPerson = new Person("John", new Address("123 Street"));

        // 深拷贝
        Person clonedPerson = originalPerson.clone();

        // 修改克隆对象的成员变量，原对象不受影响
        clonedPerson.setName("Jane");
        clonedPerson.getAddress().setStreet("456 Avenue");

        // 输出原对象的成员变量值
        System.out.println(originalPerson.getName());          // 输出: John
        System.out.println(originalPerson.getAddress().getStreet());  // 输出: 123 Street

        // 输出克隆对象的成员变量值
        System.out.println(clonedPerson.getName());            // 输出: Jane
        System.out.println(clonedPerson.getAddress().getStreet());    // 输出: 456 Avenue
    }
}
