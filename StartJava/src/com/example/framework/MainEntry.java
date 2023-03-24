package com.example.framework;


public class MainEntry {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        User users = userManager.addUser();
        System.out.println(users);

    }
}
