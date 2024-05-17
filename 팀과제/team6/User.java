package org.example;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String phoneNumber;

    public void login(){} // 다이어그램엔 매개변수가 있었으나 일단 뺌
    public void updateProfile(User user){}
}

class Registration{
    public User registerUser(){
        return new User();
    }
}

class UserAuthentication{
    public boolean authenticateUser(String uid){
        return true;
    }
}
class LoginController{
    public boolean authenticate(UserAuthentication ua){
        return true;
    }
}

class SMSVerification{
    public void sendSMSCode(){}
    public boolean verifySMSCode(){
        return true;
    }
}

class KakaoVerification{
    public void sendKakaoCode(){}
    public boolean verifyKakaoCode(){
        return true;
    }
}