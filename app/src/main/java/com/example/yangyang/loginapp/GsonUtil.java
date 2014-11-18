package com.example.yangyang.loginapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by yangyang on 11/18/14.
 */
public class GsonUtil {


    public void parsonSingleGsonObject(String jsonStr){

        Gson gson = new Gson();
        UserModel user = gson.fromJson(jsonStr,UserModel.class);
        System.out.println("name === " + user.getName());
        System.out.println("age === " + user.getAge());

    }


    public void parsonArrayGsonObject(String jsonStr){

        Type listType = new TypeToken<ArrayList<UserModel>>(){}.getType();
        Gson gson = new Gson();

    }
}
