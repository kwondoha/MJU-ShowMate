import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KakaoVerificationTest {
    private KakaoVerification kakaoVerification;

    @BeforeEach
    public void setUp() {
        // 각 테스트 전에 KakaoVerification 인스턴스를 초기화합니다.
        kakaoVerification = new KakaoVerification("testKakaoId");
    }

    @Test
    public void testSendKakaoMessage() {
        // 테스트 목표: sendKakaoMessage 메서드가 호출되었을 때 verificationCode가 설정되는지 확인합니다.
        kakaoVerification.sendKakaoMessage();
        String code = getVerificationCode(kakaoVerification);
        assertNotNull(code, "카카오 인증 코드가 null이어서는 안 됩니다.");
        assertEquals("123456", code, "생성된 카카오 인증 코드는 '123456'이어야 합니다.");
    }

    @Test
    public void testVerifyCodeCorrect() {
        // 테스트 목표: 올바른 코드가 검증될 때 true를 반환하는지 확인합니다.
        kakaoVerification.sendKakaoMessage();
        assertTrue(kakaoVerification.verifyCode("123456"), "올바른 코드를 입력했을 때 true를 반환해야 합니다.");
    }

    @Test
    public void testVerifyCodeIncorrect() {
        // 테스트 목표: 잘못된 코드가 검증될 때 false를 반환하는지 확인합니다.
        kakaoVerification.sendKakaoMessage();
        assertFalse(kakaoVerification.verifyCode("654321"), "잘못된 코드를 입력했을 때 false를 반환해야 합니다.");
    }

    @Test
    public void testVerifyCodeBeforeSending() {
        // 테스트 목표: 인증 코드를 보내기 전에 verifyCode를 호출하면 false를 반환하는지 확인합니다.
        assertFalse(kakaoVerification.verifyCode("123456"), "인증 코드를 보내기 전에 호출하면 false를 반환해야 합니다.");
    }

    @Test
    public void testSendKakaoMessageMultipleTimes() {
        // 테스트 목표: sendKakaoMessage가 여러 번 호출될 때 verificationCode가 제대로 갱신되는지 확인합니다.
        kakaoVerification.sendKakaoMessage();
        String firstCode = getVerificationCode(kakaoVerification);
        kakaoVerification.sendKakaoMessage();
        String secondCode = getVerificationCode(kakaoVerification);
        assertNotNull(secondCode, "두 번째 카카오 인증 코드가 null이어서는 안 됩니다.");
        assertEquals("123456", secondCode, "두 번째로 생성된 카카오 인증 코드는 '123456'이어야 합니다.");
    }

    // Reflection을 사용하여 private 필드 verificationCode에 접근하기 위한 헬퍼 메서드
    private String getVerificationCode(KakaoVerification kakaoVerification) {
        try {
            var field = KakaoVerification.class.getDeclaredField("verificationCode");
            field.setAccessible(true);
            return (String) field.get(kakaoVerification);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
