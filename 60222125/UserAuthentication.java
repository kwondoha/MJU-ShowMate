public class UserAuthentication {
    private VerificationAdapter verificationAdapter; // 인증 어댑터
    private String userId; // 사용자 ID

    // VerificationAdapter를 설정하는 메서드
    public void setVerificationAdapter(VerificationAdapter adapter) {
        this.verificationAdapter = adapter;
    }

    // 사용자를 인증하는 메서드
    public boolean authenticateUser(String userId) {
        // 인증 로직 (예시로 단순하게 true 반환)
        return verificationAdapter.verifyCode(userId, "code예시입니다");
    }

    // VerificationAdapter 인터페이스
    public interface VerificationAdapter {
        boolean verifyCode(String uid, String code);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
