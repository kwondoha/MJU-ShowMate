package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Cast;
import Matching;
import Play;
import Review;
import Show;
import Ticket;
import TicketAuthentication;
import User;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest2 { // 이름이 일치하지 않아 테스트가 실패하는 경우

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
        assertEquals("햄릿", play.getName());
    }

    @Test
    void getVenue() {
        assertEquals("글로브 극장", play.getVenue());
    }

    @Test
    void getDate() {
        Date newDate = new Date();
        assertEquals(newDate, play.getDate());
    }

    @Test
    void getRating() {
        assertEquals(5.0f, play.getRating());
    }

    @Test
    void displayInfo() {
        String incorrectInfo = "이름: 햄릿, 장소: 글로브 극장, 날짜: " + date + ", 평점: 5.0, 출연: " + play.getCast();
        assertEquals(incorrectInfo, play.displayInfo(1));
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

        // play.match(matching);

        assertTrue(matching.isRequested());
    }

    @Test
    void setName() {
        play.setName("오델로");
        assertEquals("햄릿", play.getName());
    }

    @Test
    void setVenue() {
        play.setVenue("오페라 하우스");
        assertEquals("글로브 극장", play.getVenue());
    }

    @Test
    void setDate() {
        Date newDate = new Date();
        play.setDate(newDate);
        assertEquals(date, play.getDate());
    }


    @Test
    void setRating() {
        play.setRating(3.0f);
    }

    @Test
    void getReviews() {
        List<Review> reviews = play.getReviews();
    }
}
