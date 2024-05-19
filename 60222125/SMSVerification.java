public class SMSVerification {
    private String phoneNumber;      // 전화번호
    private String verificationCode; // 인증 코드

    // SMSVerification 클래스 생성자
    public SMSVerification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // SMS 인증 코드를 전송하는 메서드
    public void sendSMSCode() {
        // SMS 전송 로직
        this.verificationCode = generateVerificationCode();
        System.out.println("SMS로 코드를 보냈습니다: " + phoneNumber + " 코드: " + verificationCode);
    }

    // 인증 코드를 검증하는 메서드
    public boolean verifyCode(String code) {
        // SMS 인증 코드 검증 로직
        System.out.println("SMS 인증: " + phoneNumber);
        return this.verificationCode.equals(code);
    }

    // 인증 코드를 생성하는 메서드 (예시)
    private String generateVerificationCode() {
        // 실제로는 더 복잡한 로직이 필요할 수 있음
        return "654321";
    }
}
