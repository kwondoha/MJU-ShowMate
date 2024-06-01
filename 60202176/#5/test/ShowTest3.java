package team6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest3 { // 리뷰가 존재하지 않는 경우의 테스트케이스

    private Show play;
    private Date date;

    @BeforeEach
    void setUp() {
        Cast cast = new Cast();
        play = new Play(cast);

        play.setName("맥베스");
        play.setVenue("국립극장");
        date = new Date();
        play.setDate(date);
        play.setRating(4.5f);
    }

    @Test
    void getName() {
        assertEquals("맥베스", play.getName());
    }

    @Test
    void getVenue() {
        assertEquals("국립극장", play.getVenue());
    }

    @Test
    void getDate() {
        assertEquals(date, play.getDate());
    }

    @Test
    void getRating() {
        assertEquals(4.5f, play.getRating());
    }

    @Test
    void displayInfo() {
        String info = "이름: 맥베스, 장소: 국립극장, 날짜: " + date + ", 평점: 4.5, 출연: " + play.getCast();
        assertEquals(info, play.displayInfo(1));
    }

    @Test
    void authenticateTicket() {
        TicketAuthentication ta = new TicketAuthentication();
        Ticket ticket = new Ticket(12345);
        play.authenticateTicket(ta);
    }

    @Test
    void match() {
        User user1 = new User();
        User user2 = new User();
        Matching matching = new Matching(user1, user2);

        play.match(matching);
        assertTrue(matching.isRequested());
    }

    @Test
    void setName() {
        play.setName("햄릿");
        assertEquals("햄릿", play.getName());
    }

    @Test
    void setVenue() {
        play.setVenue("글로브 극장");
        assertEquals("글로브 극장", play.getVenue());
    }

    @Test
    void setDate() {
        Date newDate = new Date();
        play.setDate(newDate);
        assertEquals(newDate, play.getDate());
    }

    @Test
    void setState() {
        play.setState("공연중");
    }

    @Test
    void setRating() {
        play.setRating(5.0f);
        assertEquals(5.0f, play.getRating());
    }

    @Test
    void getReviews() {
        List<Review> reviews = play.getReviews();
        System.out.println("리뷰없음");
    }
}
