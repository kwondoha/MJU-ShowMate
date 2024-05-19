public class User {
    private String userId;
    private String userName;
    private String password;
    private String phoneNumber;

    public User(String userId, String userName, String password, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // 로그인 메서드
    public void login(String id, String password) {
        if (this.userId.equals(id) && this.password.equals(password)) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("로그인 실패");
        }
    }

    // 프로필 업데이트 메서드
    public void updateProfile(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        System.out.println("프로필 업데이트가 되었습니다");
    }

    // Getter and Setter methods for completeness, though not shown in the diagram
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
