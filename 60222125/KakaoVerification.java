public class KakaoVerification {
    private String kakaoId;       // 카카오 ID
    private String verificationCode; // 인증 코드

    // KakaoVerification 클래스 생성자
    public KakaoVerification(String kakaoId) {
        this.kakaoId = kakaoId;
    }

    // 카카오 인증 메시지를 전송하는 메서드
    public void sendKakaoMessage() {
        // 카카오 메시지 전송 로직
        this.verificationCode = generateVerificationCode();
        System.out.println("카카오로 메시지 보냄: " + kakaoId + " 코드: " + verificationCode);
    }

    // 인증 코드를 검증하는 메서드
    public boolean verifyCode(String code) {
        // 카카오 인증 코드 검증 로직
        System.out.println("카카오 인증: " + kakaoId);
        return this.verificationCode.equals(code);
    }

    // 인증 코드를 생성하는 메서드 (예시)
    private String generateVerificationCode() {
        // 실제로는 더 복잡한 로직이 필요할 수 있음
        return "123456";
    }
}
