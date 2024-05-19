import java.util.Map;
import java.util.List;

public class Preference{
    private List<Integer> interests;
    private List<Integer> reservationHistory;
    private List<String> preferredGenres;
    private List<String> favoriteArtists;
    private List<String> preferredDates;

    public void attach(Observer observer) {}

    public void detach(Observer observer) {}

    public void notifyObservers() {}

} 

class Observer {
    void update(Preference preference){};
}

class PreferenceController{
    void checkPreference(Preference prefer){};
    void changePreference(Preference prefer){};
    void displayPreference(Preference prefer){};
}

class ShowRecommendation{
    private Map<Integer, Object> showData;

    public List<Integer> recommendShow(Preference userData, Map<Integer, Object> showData) {
        return null;
    }

    public void update(Preference preference) {};
}