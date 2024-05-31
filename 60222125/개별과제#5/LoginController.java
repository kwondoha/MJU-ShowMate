public class LoginController {
     // 사용자를 인증하는 메서드
    public boolean authenticate(UserAuthentication ua) {
        return ua.authenticateUser(ua.getUserId());
    }

    // 사용자의 비밀번호를 찾는 메서드
    public void findPW(String userId) {
        // 비밀번호 찾기 로직
        System.out.println("비밀번호 찾기 위해서: " + userId);
    }

    // 비밀번호를 재설정하는 메서드
    public String resetPW() {
        // 비밀번호 재설정 로직
        String newPassword = "새로운 비밀번호"; // 예시로 새로운 비밀번호 설정
        System.out.println("비밀번호 리셋: " + newPassword);
        return newPassword;
    }
}
