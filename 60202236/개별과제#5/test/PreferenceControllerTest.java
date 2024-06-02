package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PreferenceControllerTest {
    private Preference preference;
    private PreferenceController controller;

    @BeforeEach
    public void setUp() {
        List<Integer> interests = List.of(1, 2, 3);
        List<Integer> reservationHistory = List.of(101, 102);
        List<String> preferredGenres = List.of("Rock", "Pop");
        List<String> favoriteArtists = List.of("Artist A", "Artist B");
        List<String> preferredDates = List.of("2023-06-01", "2023-06-02");

        preference = new Preference(interests, reservationHistory, preferredGenres, favoriteArtists, preferredDates);
        controller = new PreferenceController();
    }

    @Test // 블랙박스 테스트: public 메소드 호출만 테스트
    public void testCheckPreference() {
        controller.checkPreference(preference);
    }

    @Test // 블랙박스 테스트: 입력 값이 제대로 변경되는지 확인
    public void testChangePreference() {
        controller.changePreference(preference);
        assertEquals(List.of("Rock", "Jazz"), preference.getPreferredGenres());
        assertEquals(List.of("Artist A", "Artist B"), preference.getFavoriteArtists());
    }

    @Test // 블랙박스 테스트: public 메소드 호출만 테스트
    public void testDisplayPreference() {
        controller.displayPreference(preference);
    }

    @Test // 화이트박스 테스트: changePreference() 메소드의 내부 동작 테스트
    public void testSetPreferredGenres() {
        controller.changePreference(preference);
        assertEquals(List.of("Rock", "Jazz"), preference.getPreferredGenres());
    }

    @Test // 화이트박스 테스트: changePreference() 메소드의 내부 동작 테스트
    public void testSetFavoriteArtists() {
        controller.changePreference(preference);
        assertEquals(List.of("Artist A", "Artist B"), preference.getFavoriteArtists());
    }
}
