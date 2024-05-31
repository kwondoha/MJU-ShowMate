import java.util.Vector;

public class Preference {
    private Vector<Integer> interests;            // 관심사 목록
    private Vector<Integer> reservationHistory;   // 예약 내역
    private Vector<String> preferredGenres;       // 선호 장르
    private Vector<String> favoriteArtists;       // 좋아하는 아티스트
    private Vector<String> preferredDates;        // 선호 날짜

    // Preference 클래스 생성자
    public Preference() {
        this.interests = new Vector<>();
        this.reservationHistory = new Vector<>();
        this.preferredGenres = new Vector<>();
        this.favoriteArtists = new Vector<>();
        this.preferredDates = new Vector<>();
    }

    // 관심사 목록을 반환하는 메서드
    public Vector<Integer> getInterests() {
        return interests;
    }

    // 관심사 목록을 설정하는 메서드
    public void setInterests(Vector<Integer> interests) {
        this.interests = interests;
    }

    // 예약 내역을 반환하는 메서드
    public Vector<Integer> getReservationHistory() {
        return reservationHistory;
    }

    // 예약 내역을 설정하는 메서드
    public void setReservationHistory(Vector<Integer> reservationHistory) {
        this.reservationHistory = reservationHistory;
    }

    // 선호 장르를 반환하는 메서드
    public Vector<String> getPreferredGenres() {
        return preferredGenres;
    }

    // 선호 장르를 설정하는 메서드
    public void setPreferredGenres(Vector<String> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    // 좋아하는 아티스트를 반환하는 메서드
    public Vector<String> getFavoriteArtists() {
        return favoriteArtists;
    }

    // 좋아하는 아티스트를 설정하는 메서드
    public void setFavoriteArtists(Vector<String> favoriteArtists) {
        this.favoriteArtists = favoriteArtists;
    }

    // 선호 날짜를 반환하는 메서드
    public Vector<String> getPreferredDates() {
        return preferredDates;
    }

    // 선호 날짜를 설정하는 메서드
    public void setPreferredDates(Vector<String> preferredDates) {
        this.preferredDates = preferredDates;
    }

    // 관심사를 추가하는 메서드
    public void addInterest(int interest) {
        this.interests.add(interest);
    }

    // 관심사를 제거하는 메서드
    public void removeInterest(int interest) {
        this.interests.remove(Integer.valueOf(interest));
    }

    // 예약 내역을 추가하는 메서드
    public void addReservation(int reservation) {
        this.reservationHistory.add(reservation);
    }

    // 예약 내역을 제거하는 메서드
    public void removeReservation(int reservation) {
        this.reservationHistory.remove(Integer.valueOf(reservation));
    }

    // 선호 장르를 추가하는 메서드
    public void addPreferredGenre(String genre) {
        this.preferredGenres.add(genre);
    }

    // 선호 장르를 제거하는 메서드
    public void removePreferredGenre(String genre) {
        this.preferredGenres.remove(genre);
    }

    // 좋아하는 아티스트를 추가하는 메서드
    public void addFavoriteArtist(String artist) {
        this.favoriteArtists.add(artist);
    }

    // 좋아하는 아티스트를 제거하는 메서드
    public void removeFavoriteArtist(String artist) {
        this.favoriteArtists.remove(artist);
    }

    // 선호 날짜를 추가하는 메서드
    public void addPreferredDate(String date) {
        this.preferredDates.add(date);
    }

    // 선호 날짜를 제거하는 메서드
    public void removePreferredDate(String date) {
        this.preferredDates.remove(date);
    }

    // 객체 정보를 문자열로 반환하는 메서드
    @Override
    public String toString() {
        return "Preference{" +
                "interests=" + interests +
                ", reservationHistory=" + reservationHistory +
                ", preferredGenres=" + preferredGenres +
                ", favoriteArtists=" + favoriteArtists +
                ", preferredDates=" + preferredDates +
                '}';
    }
}
