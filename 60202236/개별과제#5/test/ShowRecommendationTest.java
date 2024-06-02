package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShowRecommendationTest {
    private ShowRecommendation showRecommendation;
    private Preference preference;

    @BeforeEach
    public void setUp() {
        Map<Integer, Object> showData = new HashMap<>();
        showData.put(1, "Rock");
        showData.put(2, "Jazz");
        showData.put(3, "Pop");

        showRecommendation = new ShowRecommendation(showData);

        List<Integer> interests = List.of(1, 2, 3);
        List<Integer> reservationHistory = List.of(101, 102);
        List<String> preferredGenres = List.of("Rock", "Pop");
        List<String> favoriteArtists = List.of("Artist A", "Artist B");
        List<String> preferredDates = List.of("2023-06-01", "2023-06-02");

        preference = new Preference(interests, reservationHistory, preferredGenres, favoriteArtists, preferredDates);
    }

    @Test // 블랙박스 테스트: 입력 값에 따른 출력 값만 확인
    public void testRecommendShow() {
        List<Integer> recommendations = showRecommendation.recommendShow(preference, showRecommendation.showData);
        assertEquals(List.of(1, 3), recommendations);
    }

    @Test // 화이트박스 테스트: update() 메소드의 내부 동작 테스트
    public void testUpdate() {
        showRecommendation.update(preference);
    }

    @Test // 블랙박스 테스트: 입력 값에 따른 출력 값만 확인
    public void testEmptyRecommendation() {
        preference.setPreferredGenres(List.of("Classical"));
        List<Integer> recommendations = showRecommendation.recommendShow(preference, showRecommendation.showData);
        assertTrue(recommendations.isEmpty());
    }

    @Test // 화이트박스 테스트: Preference 객체 변경 시 update() 메소드 호출을 테스트
    public void testPreferenceChangeRecalculate() {
        preference.attach(showRecommendation);
        preference.setPreferredGenres(List.of("Jazz"));
    }

    @Test // 블랙박스 테스트: 입력 값에 따른 출력 값만 확인
    public void testMultiplePreferredGenres() {
        preference.setPreferredGenres(List.of("Rock", "Jazz"));
        List<Integer> recommendations = showRecommendation.recommendShow(preference, showRecommendation.showData);
        assertEquals(List.of(1, 2), recommendations);
    }
}
