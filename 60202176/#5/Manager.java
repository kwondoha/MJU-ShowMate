
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Manager {
}

class ShowManager extends Manager {
    private List<Show> shows;

    public ShowManager() {
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
        System.out.println("쇼 추가 :" + show.getName());
    }

    public void updateShow(Show show, String name, String venue, Date date, String state, float rating) {
        // 실제 매니저가 정보를 수정하는 로직
        if (shows.contains(show)) {
            show.setName(name);
            show.setVenue(venue);
            show.setDate(date);
            show.setState(state);
            show.setRating(rating);
            System.out.println("쇼 정보 업데이트 :" + show.getName());
        } else {
            System.out.println("해당하는 쇼를 찾을 수 없습니다.");
        }
    }

    public void deleteShow(Show show) {
        System.out.println("쇼 삭제 :" + show.getName());
        shows.remove(show);
    }
}

class UserManager extends Manager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void createUser(User user) {
        users.add(user);
        System.out.println("사용자 추가 :" + user.getName());
    }

    public void deleteUser(User user) {
        System.out.println("사용자 삭제 :" + user.getName());
        users.remove(user);
    }

    public void updateUser(User user, String name, String password, String phoneNumber, List<Mate> mates) {
        // 실제 매니저가 정보를 업데이트하는 로직
        if (users.contains(user)) {
            user.setUserName(name);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            user.setMates(mates);
            System.out.println("사용자 정보 업데이트 :" + user.getName());
        } else {
            System.out.println("해당하는 사용자를 찾을 수 없습니다.");
        }
    }

    // 리뷰 매니저 추가
    class ReviewMager extends Manager {
        private List<Review> reviews;

        // 리뷰 삭제 메소드
        public void deleteReview(Review review) {
            reviews.remove(review);
        }
    }
}