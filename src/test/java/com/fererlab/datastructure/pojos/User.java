package com.fererlab.datastructure.pojos;

import com.fererlab.datastructure.list.array.ArrayList;

import java.util.Date;

/**
 * User class for complex type testing
 */
public class User {

    private String username;
    private Date registerDate;
    private Integer age;
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();

    public User(String username, Date registerDate, Integer age) {
        this.username = username;
        this.registerDate = registerDate;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
