package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PreferenceTest {
    private Preference preference;

    @BeforeEach
    public void setUp() {
        List<Integer> interests = List.of(1, 2, 3);
        List<Integer> reservationHistory = List.of(101, 102);
        List<String> preferredGenres = List.of("Rock", "Pop");
        List<String> favoriteArtists = List.of("Artist A", "Artist B");
        List<String> preferredDates = List.of("2023-06-01", "2023-06-02");

        preference = new Preference(interests, reservationHistory, preferredGenres, favoriteArtists, preferredDates);
    }

    @Test // 블랙박스 테스트: 객체의 내부 상태에 의존하지 않고 퍼블릭 메소드의 출력만 확인.
    public void testGetInterests() {
        assertEquals(List.of(1, 2, 3), preference.getInterests());
    }

    @Test // 블랙박스 테스트: 입력값이 제대로 설정되는지 확인
    public void testSetInterests() {
        List<Integer> newInterests = List.of(4, 5, 6);
        preference.setInterests(newInterests);
        assertEquals(newInterests, preference.getInterests());
    }

    @Test // 객체의 내부 상태에 의존하지 않고 퍼블릭 메소드의 출력만 확인.
    public void testGetPreferredGenres() {
        assertEquals(List.of("Rock", "Pop"), preference.getPreferredGenres());
    }

    @Test // 블랙박스 테스트: 입력값이 제대로 설정되는지 확인.
    public void testSetPreferredGenres() {
        List<String> newGenres = List.of("Jazz", "Classical");
        preference.setPreferredGenres(newGenres);
        assertEquals(newGenres, preference.getPreferredGenres());
    }

    @Test // 화이트박스 테스트: notifyobservers() 메소드의 내부 동작을 테스트
    public void testNotifyObservers() {
        MockObserver observer = new MockObserver();
        preference.attach(observer);

        preference.setInterests(List.of(7, 8, 9));

        assertTrue(observer.isUpdated());
    }

    private static class MockObserver extends Observer {
        private boolean updated = false;

        @Override
        public void update(Preference preference) {
            updated = true;
        }

        public boolean isUpdated() {
            return updated;
        }
    }
}
