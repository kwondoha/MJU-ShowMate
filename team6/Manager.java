package org.example;

public abstract class Manager {
}

class ShowManager extends Manager{
    public void addShow(){} // 다이어그램엔 매개변수가 있었으나 뻄
    public void updateShow(Show show){}
    public void deleteShow(Show show){}
}

class UserManager extends Manager{
    public void createUser(){} // 다이어그램엔 매개변수가 있었으나 뻄
    public void deleteUser(User user){}
    public void updateUser(User user){}
}