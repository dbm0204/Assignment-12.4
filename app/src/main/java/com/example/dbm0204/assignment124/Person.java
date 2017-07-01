package com.example.dbm0204.assignment124;

/**
 * Created by dbm0204 on 7/1/17.
 */

public class Person {
    public String name;
    public String phoneNumber;
    public String dateBirth;

    public Person() {}
    public Person(String name, String phoneNumber, String dateBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateBirth = dateBirth;
    }
    public Person(Person p1){
        this.name=p1.name;
        this.phoneNumber=p1.phoneNumber;
        this.dateBirth=p1.dateBirth;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
}
