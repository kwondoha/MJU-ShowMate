package org.example;

import java.util.ArrayList;
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
}

class MyShow{
    private List<Show> myShow;
    public void displayShowList(){}
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
}


class Play extends Show {
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
        return "Musical Info: " + getName() + ", Venue: " + getVenue() + ", Date: " + getDate() + ", Rating: " + getRating() + ", Cast: " + getCast();
    }
}

class Concert extends Show {
}

class Opera extends Show {
}

class Museum extends Show {
}

class Exhibition extends Show {
}




class TicketAuthentication {
    public void selectPhoto() {}
    public void takePhoto() {}

    public boolean authenticateTicket(Ticket ticket) {
        return true;
    }

    private boolean performAuthenticationLogic(Ticket ticket) {
        return true;
    }
}


class Ticket {
    private int ticketNumber;
    private boolean isAuthenticated;

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

    public void chat() {
        // 실제로 채팅 로직
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

    public void request() {
    }

    public void accept() {
    }

    public void reject() {
    }

    public void cancel() {
    }
}

