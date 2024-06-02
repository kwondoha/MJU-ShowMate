import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

public class PreferenceTest {
    private Preference preference;

    @BeforeEach
    public void setUp() {
        // 각 테스트 전에 Preference 인스턴스를 초기화합니다.
        preference = new Preference();
    }

    @Test
    public void testAddAndRemoveInterest() {
        // 테스트 목표: 관심사를 추가하고 제거하는 메서드의 동작을 확인합니다.
        preference.addInterest(1);
        preference.addInterest(2);
        Vector<Integer> interests = preference.getInterests();
        assertEquals(2, interests.size(), "관심사가 2개 추가되었어야 합니다.");
        assertTrue(interests.contains(1), "관심사 목록에 1이 포함되어야 합니다.");
        assertTrue(interests.contains(2), "관심사 목록에 2가 포함되어야 합니다.");

        preference.removeInterest(1);
        interests = preference.getInterests();
        assertEquals(1, interests.size(), "관심사 목록에서 1개가 제거되었어야 합니다.");
        assertFalse(interests.contains(1), "관심사 목록에 1이 제거되었어야 합니다.");
    }

    @Test
    public void testAddAndRemoveReservation() {
        // 테스트 목표: 예약 내역을 추가하고 제거하는 메서드의 동작을 확인합니다.
        preference.addReservation(101);
        preference.addReservation(102);
        Vector<Integer> reservations = preference.getReservationHistory();
        assertEquals(2, reservations.size(), "예약 내역이 2개 추가되었어야 합니다.");
        assertTrue(reservations.contains(101), "예약 내역에 101이 포함되어야 합니다.");
        assertTrue(reservations.contains(102), "예약 내역에 102가 포함되어야 합니다.");

        preference.removeReservation(101);
        reservations = preference.getReservationHistory();
        assertEquals(1, reservations.size(), "예약 내역에서 1개가 제거되었어야 합니다.");
        assertFalse(reservations.contains(101), "예약 내역에 101이 제거되었어야 합니다.");
    }

    @Test
    public void testAddAndRemovePreferredGenre() {
        // 테스트 목표: 선호 장르를 추가하고 제거하는 메서드의 동작을 확인합니다.
        preference.addPreferredGenre("Rock");
        preference.addPreferredGenre("Jazz");
        Vector<String> genres = preference.getPreferredGenres();
        assertEquals(2, genres.size(), "선호 장르가 2개 추가되었어야 합니다.");
        assertTrue(genres.contains("Rock"), "선호 장르 목록에 Rock이 포함되어야 합니다.");
        assertTrue(genres.contains("Jazz"), "선호 장르 목록에 Jazz가 포함되어야 합니다.");

        preference.removePreferredGenre("Rock");
        genres = preference.getPreferredGenres();
        assertEquals(1, genres.size(), "선호 장르 목록에서 1개가 제거되었어야 합니다.");
        assertFalse(genres.contains("Rock"), "선호 장르 목록에 Rock이 제거되었어야 합니다.");
    }

    @Test
    public void testAddAndRemoveFavoriteArtist() {
        // 테스트 목표: 좋아하는 아티스트를 추가하고 제거하는 메서드의 동작을 확인합니다.
        preference.addFavoriteArtist("Artist1");
        preference.addFavoriteArtist("Artist2");
        Vector<String> artists = preference.getFavoriteArtists();
        assertEquals(2, artists.size(), "좋아하는 아티스트가 2명 추가되었어야 합니다.");
        assertTrue(artists.contains("Artist1"), "좋아하는 아티스트 목록에 Artist1이 포함되어야 합니다.");
        assertTrue(artists.contains("Artist2"), "좋아하는 아티스트 목록에 Artist2가 포함되어야 합니다.");

        preference.removeFavoriteArtist("Artist1");
        artists = preference.getFavoriteArtists();
        assertEquals(1, artists.size(), "좋아하는 아티스트 목록에서 1명이 제거되었어야 합니다.");
        assertFalse(artists.contains("Artist1"), "좋아하는 아티스트 목록에 Artist1이 제거되었어야 합니다.");
    }

    @Test
    public void testAddAndRemovePreferredDate() {
        // 테스트 목표: 선호 날짜를 추가하고 제거하는 메서드의 동작을 확인합니다.
        preference.addPreferredDate("2024-01-01");
        preference.addPreferredDate("2024-01-02");
        Vector<String> dates = preference.getPreferredDates();
        assertEquals(2, dates.size(), "선호 날짜가 2개 추가되었어야 합니다.");
        assertTrue(dates.contains("2024-01-01"), "선호 날짜 목록에 2024-01-01이 포함되어야 합니다.");
        assertTrue(dates.contains("2024-01-02"), "선호 날짜 목록에 2024-01-02가 포함되어야 합니다.");

        preference.removePreferredDate("2024-01-01");
        dates = preference.getPreferredDates();
        assertEquals(1, dates.size(), "선호 날짜 목록에서 1개가 제거되었어야 합니다.");
        assertFalse(dates.contains("2024-01-01"), "선호 날짜 목록에 2024-01-01이 제거되었어야 합니다.");
    }
}
