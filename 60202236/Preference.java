import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Preference {
    private List<Integer> interests;
    private List<Integer> reservationHistory;
    private List<String> preferredGenres;
    private List<String> favoriteArtists;
    private List<String> preferredDates;
    private List<Observer> observers = new ArrayList<>();

    public Preference(List<Integer> interests, List<Integer> reservationHistory, List<String> preferredGenres, List<String> favoriteArtists, List<String> preferredDates) {
        this.interests = interests;
        this.reservationHistory = reservationHistory;
        this.preferredGenres = preferredGenres;
        this.favoriteArtists = favoriteArtists;
        this.preferredDates = preferredDates;
    }

    public List<Integer> getInterests() {
        return interests;
    }

    public void setInterests(List<Integer> interests) {
        this.interests = interests;
        notifyObservers();
    }

    public List<Integer> getReservationHistory() {
        return reservationHistory;
    }

    public void setReservationHistory(List<Integer> reservationHistory) {
        this.reservationHistory = reservationHistory;
        notifyObservers();
    }

    public List<String> getPreferredGenres() {
        return preferredGenres;
    }

    public void setPreferredGenres(List<String> preferredGenres) {
        this.preferredGenres = preferredGenres;
        notifyObservers();
    }

    public List<String> getFavoriteArtists() {
        return favoriteArtists;
    }

    public void setFavoriteArtists(List<String> favoriteArtists) {
        this.favoriteArtists = favoriteArtists;
        notifyObservers();
    }

    public List<String> getPreferredDates() {
        return preferredDates;
    }

    public void setPreferredDates(List<String> preferredDates) {
        this.preferredDates = preferredDates;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

abstract class Observer {
    abstract void update(Preference preference);
}

class PreferenceController {
    void checkPreference(Preference prefer) {
        System.out.println("선호도 체크중");
        displayPreference(prefer);
    }

    void changePreference(Preference prefer) {
        // Preference를 변경하는 로직 (예: 사용자 입력을 받아 선호도를 변경)
        prefer.setPreferredGenres(List.of("Rock", "Jazz"));
        prefer.setFavoriteArtists(List.of("Artist A", "Artist B"));
    }

    void displayPreference(Preference prefer) {
        System.out.println("Interests: " + prefer.getInterests());
        System.out.println("Reservation History: " + prefer.getReservationHistory());
        System.out.println("Preferred Genres: " + prefer.getPreferredGenres());
        System.out.println("Favorite Artists: " + prefer.getFavoriteArtists());
        System.out.println("Preferred Dates: " + prefer.getPreferredDates());
    }
}


class ShowRecommendation extends Observer {
    private Map<Integer, Object> showData;

    public ShowRecommendation(Map<Integer, Object> showData) {
        this.showData = showData;
    }

    public List<Integer> recommendShow(Preference userData, Map<Integer, Object> showData) {
        // 간단한 추천 로직 구현 (예: 선호하는 장르와 일치하는 쇼 추천)
        List<Integer> recommendations = new ArrayList<>();
        for (Map.Entry<Integer, Object> entry : showData.entrySet()) {
            // 이 예제에서는 쇼 데이터가 단순히 ID와 장르를 포함한다고 가정합니다.
            if (userData.getPreferredGenres().contains(entry.getValue())) {
                recommendations.add(entry.getKey());
            }
        }
        return recommendations;
    }

    @Override
    public void update(Preference preference) {
        // Preference가 업데이트될 때 추천을 다시 계산하거나 필요한 작업을 수행합니다.
        System.out.println("Preferences updated. Recalculating recommendations...");
        List<Integer> recommendations = recommendShow(preference, showData);
        System.out.println("Recommended Shows: " + recommendations);
    }
}
