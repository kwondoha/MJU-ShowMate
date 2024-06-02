import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SMSVerificationTest {
    private SMSVerification smsVerification;

    @BeforeEach
    public void setUp() {
        // 각 테스트 전에 호출되며, SMSVerification 인스턴스를 초기화합니다.
        smsVerification = new SMSVerification("123-456-7890");
    }

    @Test
    public void testSendSMSCode() {
        // 테스트 목표: sendSMSCode 메서드가 호출되었을 때 verificationCode가 설정되는지 확인합니다.
        smsVerification.sendSMSCode();
        String code = getVerificationCode(smsVerification);
        assertNotNull(code, "SMS 코드가 null이어서는 안 됩니다.");
        assertEquals("654321", code, "생성된 SMS 코드는 '654321'이어야 합니다.");
    }

    @Test
    public void testVerifyCodeCorrect() {
        // 테스트 목표: 올바른 코드가 검증될 때 true를 반환하는지 확인합니다.
        smsVerification.sendSMSCode();
        assertTrue(smsVerification.verifyCode("654321"), "올바른 코드를 입력했을 때 true를 반환해야 합니다.");
    }

    @Test
    public void testVerifyCodeIncorrect() {
        // 테스트 목표: 잘못된 코드가 검증될 때 false를 반환하는지 확인합니다.
        smsVerification.sendSMSCode();
        assertFalse(smsVerification.verifyCode("123456"), "잘못된 코드를 입력했을 때 false를 반환해야 합니다.");
    }

    @Test
    public void testVerifyCodeBeforeSending() {
        // 테스트 목표: 인증 코드를 보내기 전에 verifyCode를 호출하면 false를 반환하는지 확인합니다.
        assertFalse(smsVerification.verifyCode("654321"), "인증 코드를 보내기 전에 호출하면 false를 반환해야 합니다.");
    }

    @Test
    public void testSendSMSCodeMultipleTimes() {
        // 테스트 목표: sendSMSCode가 여러 번 호출될 때 verificationCode가 제대로 갱신되는지 확인합니다.
        smsVerification.sendSMSCode();
        String firstCode = getVerificationCode(smsVerification);
        smsVerification.sendSMSCode();
        String secondCode = getVerificationCode(smsVerification);
        assertNotNull(secondCode, "두 번째 SMS 코드가 null이어서는 안 됩니다.");
        assertEquals("654321", secondCode, "두 번째로 생성된 SMS 코드는 '654321'이어야 합니다.");
    }

    // Reflection을 사용하여 private 필드 verificationCode에 접근하기 위한 헬퍼 메서드
    private String getVerificationCode(SMSVerification smsVerification) {
        try {
            var field = SMSVerification.class.getDeclaredField("verificationCode");
            field.setAccessible(true);
            return (String) field.get(smsVerification);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
