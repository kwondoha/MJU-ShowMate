package org.example;

public abstract class User {
    private String userId;
    private String userName;
    private String password;
    private String phoneNumber;

    public void login(String id, String password) { }

    public void updateProfile() { }
}


public class StandardUser extends User {
    private String membershipLevel;
}

public class PremiumUser extends User {
    private String membershipLevel;
}


class Registration{
    public User registerUser(){
        return new User();
    }
}

public class UserAuthentication {
    private VerificationAdapter verificationAdapter;

    public boolean authenticateUser(User user) { 
        return true; 
    }

    public void setVerificationAdapter(VerificationAdapter adapter) { }
}

public class LoginController {
    public boolean authenticate(UserAuthentication ua, User user) { 
        return true; 
    }

    public void findPW(userId uid) { }

    public String resetPW() { 
        return ""; 
    }
}

public interface VerificationAdapter {
    boolean verifyCode(userId uid, String code);
}

public interface AuthenticationStrategy {
    boolean authenticateUser(userId uid);
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

public class SMSVerificationAdapter implements VerificationAdapter {
    private SMSVerification smsVerification;

    @Override
    public boolean verifyCode(userId uid, String code) {
        return true;
    }
}

public class KakaoVerificationAdapter implements VerificationAdapter {
    private KakaoVerification kakaoVerification;

    @Override
    public boolean verifyCode(userId uid, String code) {
        return true;
    }
}
