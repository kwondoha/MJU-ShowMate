import java.util.List;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private List<Mate> mates;
    private List<Review> reviews;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Mate> getMates() {
        return mates;
    }

    public void setUserName(String name){
        this.userName=name;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public void setMates(List<Mate> mates){
        this.mates=mates;
    }
    public void addMate(Mate mate) {
        this.mates.add(mate);
    }

    public void login(){}
    public void updateProfile(User user){}

    public String getName() {
        return this.userName;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
class StandardUser extends User {
    private String membershipLevel;
}

class PremiumUser extends User {
    private String membershipLevel;
}


class Registration{
    public User registerUser(){
        return new User();
    }
}

class UserAuthentication {
    private VerificationAdapter verificationAdapter;

    public boolean authenticateUser(User user) {
        return true;
    }

    public void setVerificationAdapter(VerificationAdapter adapter) { }
}

class LoginController {
    public boolean authenticate(UserAuthentication ua, User user) {
        return true;
    }

    public void findPW(String uid) { }

    public String resetPW() {
        return null;
    }
}

interface VerificationAdapter {
    boolean verifyCode(String uid, String code);
}

interface AuthenticationStrategy {
    boolean authenticateUser(String uid);
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

class SMSVerificationAdapter implements VerificationAdapter {
    private SMSVerification smsVerification;

    @Override
    public boolean verifyCode(String uid, String code) {
        return true;
    }
}

class KakaoVerificationAdapter implements VerificationAdapter {
    private KakaoVerification kakaoVerification;

    @Override
    public boolean verifyCode(String uid, String code) {
        return true;
    }
}