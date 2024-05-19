import java.util.Date;
import java.util.List;
import java.util.Scanner;


public abstract class Show {
    private String name;
    private String venue;
    private Date date;
    private String state;
    private int showId;
    private float rating;
    private List<Review> reviews;

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

    public Date getDate() {
        return date;
    }

    public float getRating() {
        return rating;
    }

    public String displayInfo(int showId) {
        return null;
    }
    public void authenticateTicket(TicketAuthentication ta) {}
    public void match(Matching matching) {}
    public void recommend(ShowRecommendation sr) {}
    public void findPath(PathFinder pf) {}

    public void setName(String name) {
        this.name=name;
    }

    public void setVenue(String venue) {
        this.venue=venue;
    }

    public void setDate(Date date) {
        this.date=date;
    }

    public void setState(String state) {
        this.state=state;
    }

    public void setRating(float rating) {
        this.rating=rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}

class MyShow{
    private List<Show> myShow;
    public void displayShowList(){
        // myShow 리스트에 쇼가 없는 경우 예외 처리
        if (myShow == null || myShow.isEmpty()) {
            System.out.println("현재 등록된 쇼가 없습니다.");
            return;
        }

        System.out.println("나의 쇼 리스트:");

        // 모든 쇼의 이름 출력
        for (Show show : myShow) {
            System.out.println(show.getName());
        }
    }
}

class Cast{}
class Host{}
class Artist{}

class ShowFactory {
    public Cast createCast(){
        return new Cast();
    }

    public Host createHost(){
        return new Host();
    }

    public Artist createArtist(){
        return new Artist();
    }

    public Play createPlay() {
        return new Play(createCast());
    }

    public Musical createMusical() {
        return new Musical(createCast());
    }

    public Concert createConcert() {
        return new Concert(createCast());
    }

    public Opera createOpera() {
        return new Opera(createCast());
    }

    public Museum createMuseum() {
        return new Museum(createHost(), createArtist());
    }

    public Exhibition createExhibition() {
        return new Exhibition(createHost(), createArtist());
    }
}


class Play extends Show {
    private Cast cast;

    public Play(Cast cast) {
        this.cast = cast;
    }

    public Cast getCast() {
        return cast;
    }

    @Override
    public String displayInfo(int showId) {
        return "이름: " + getName() + ", 장소: " + getVenue() + ", 날짜: " + getDate() + ", 평점: " + getRating() + ", 출연: " + getCast();
    }
}

class Musical extends Show {
    private Cast cast;

    public Musical(Cast cast) {
        this.cast = cast;
    }

    public Cast getCast() {
        return cast;
    }

    @Override
    public String displayInfo(int showId) {
        return "이름: " + getName() + ", 장소: " + getVenue() + ", 날짜: " + getDate() + ", 평점: " + getRating() + ", 출연: " + getCast();
    }
}

class Concert extends Show {
    private Cast cast;

    public Concert(Cast cast) {
        this.cast = cast;
    }

    public Cast getCast() {
        return cast;
    }

    @Override
    public String displayInfo(int showId) {
        return "이름: " + getName() + ", 장소: " + getVenue() + ", 날짜: " + getDate() + ", 평점: " + getRating() + ", 출연: " + getCast();
    }
}

class Opera extends Show {
    private Cast cast;

    public Opera(Cast cast) {
        this.cast = cast;
    }

    public Cast getCast() {
        return cast;
    }

    @Override
    public String displayInfo(int showId) {
        return "이름: " + getName() + ", 장소: " + getVenue() + ", 날짜: " + getDate() + ", 평점: " + getRating() + ", 출연: " + getCast();
    }
}

class Museum extends Show {
    private Host host;
    private Artist artist;

    public Museum(Host host, Artist artist) {
        this.host = host;
        this.artist = artist;
    }

    public Host getHost() {
        return host;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String displayInfo(int showId) {
        return "이름: " + getName() + ", Venue: " + getVenue() + ", 날짜: " + getDate() + ", 평점: " + getRating() + ", 주최: " + getHost() + ", 아티스트: " + getArtist();
    }
}

class Exhibition extends Show {
    private Host host;
    private Artist artist;

    public Exhibition(Host host, Artist artist) {
        this.host = host;
        this.artist = artist;
    }

    public Host getHost() {
        return host;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String displayInfo(int showId) {
        return "이름: " + getName() + ", 장소: " + getVenue() + ", 날짜: " + getDate() + ", 평점: " + getRating() + ", 주최: " + getHost() + ", 아티스트: " + getArtist();
    }
}




class TicketAuthentication {
    public void selectPhoto() {}
    public void takePhoto() {}

    public boolean authenticateTicket(Ticket ticket) {
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();// 실제 사용자의 선택에 따라 0 또는 1 반환

        switch (choice) {
            case 0:
                selectPhoto();
                break;
            case 1:
                takePhoto();
                break;
            default:
                return false;
        }

        boolean isAuthenticated = performAuthenticationLogic(ticket);
        ticket.setAuthenticated(isAuthenticated);
        return isAuthenticated;
    }

    private boolean performAuthenticationLogic(Ticket ticket) {
        // 실제 티켓 인증 로직 구현
        return true;
    }
}


class Ticket {
    private int ticketNumber;
    private boolean isAuthenticated;

    public Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
        this.isAuthenticated = false;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
}


class Mate {
    private User user1;
    private User user2;

    public Mate(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Chatting chat() {
        // 새로운 채팅 클래스 생성
        return new Chatting();
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }
}

class Matching {
    private User user1;
    private User user2;
    private Mate mate;
    private boolean isRequested;

    public Matching(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.isRequested = false;
    }


    // 매칭 요청 메소드
    public void request() {
        if (!isRequested) {
            isRequested = true;
            System.out.println(user2.getName() + "님에게 매칭 요청을 보냈어요.");
        } else {
            System.out.println("이미 매칭 요청을 보냈어요!");
        }
    }

    // 매칭 수락 메소드
    public void accept() {
        if (isRequested) {
            mate = new Mate(user1, user2);
            user1.addMate(mate);
            user2.addMate(mate);
            isRequested = false;
            System.out.println(user1.getName() + "님의 매칭 요청을 수락했어요!");
        } else {
            System.out.println("요청을 수락할 수 없어요.");
        }
    }

    // 매칭 거절 메소드
    public void reject() {
        if (isRequested) {
            isRequested = false;
            System.out.println(user1.getName() + "님의 요청을 거절했어요.");
        } else {

        }
    }

    // 매칭 취소 메소드
    public void cancel() {
        if (mate != null) {
            user1.getMates().remove(mate);
            user2.getMates().remove(mate);
            mate = null;
            System.out.println(user1.getName() + "님과의 매칭을 취소할게요.");
        } else{

        }
    }
}

// 채팅 클래스
class Chatting {
    private List<String> Message;

   // 메시지 출력 메소드
    public void printMessage(String sender, String message) {
        // 화면에 메시지를 출력하는 로직
        System.out.println(sender + ": " + message);
    }

    // 메시지 전송 메소드
    public void sendMessage(String sender, String receiver, String message) {
        printMessage(sender, message);
    }

    // 메시지 삭제 메소드
    public void deleteMessage(String message) {
        // 메시지 삭제 로직 구현
    }

    // 이모티콘 전송 메소드
    public void sendEmoticon(String sender, String receiver, String emoticon) {
        // 이모티콘 전송 로직
    }

    // 사진 전송 메소드
    public void sendPhoto(String sender, String receiver, String photoUrl) {
        // 사진 전송 로직
    }
}
