package com.rohasoft.www.gcash.DataBase;

import android.content.Context;
import android.content.SharedPreferences;

import com.rohasoft.www.gcash.Modal.User;


/**
 * Created by Ayothi selvam on 12/7/2017.
 */

public class UserLocalStore {

    public  static final String SP_NAME="userDetails";
    SharedPreferences userlocalDatabase;

    public UserLocalStore(Context context){
        userlocalDatabase=context.getSharedPreferences(SP_NAME,0);
    }
    public void storeUserData(User user){
        SharedPreferences.Editor spEditor=userlocalDatabase.edit();
        spEditor.putString("username",user.getUsername());
        spEditor.putString("password",user.getPassword());
        spEditor.putString("name",user.getShone());
        spEditor.putString("phone",user.getPhone());

        spEditor.commit();
    }
    public User getLoggedUser(){
        String username=userlocalDatabase.getString("username","");
        String password=userlocalDatabase.getString("password","");
        String name=userlocalDatabase.getString("name","");
        String phone=userlocalDatabase.getString("phone","");

        User storedUser=new User(username,password,name,phone);
        return storedUser;
    }
}
