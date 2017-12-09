package com.rohasoft.www.gcash.Modal;

/**
 * Created by Ayothi selvam on 12/7/2017.
 */

public class User {

    String username,password,shone,phone;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String shone, String phone) {
        this.username = username;
        this.password = password;
        this.shone = shone;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getShone() {
        return shone;
    }

    public String getPhone() {
        return phone;
    }
}
