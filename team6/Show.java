package org.example;

import java.util.Date;

public abstract class Show {
    private String name;
    private String venue;
    private Date date;
    private String state;
    private int showId;
    private float rating;

    public String displayInfo(int showId) {
        return null;
    }
    public void authenticateTicket(TicketAuthentication ta) {}
    //public void match(Matching matching) {}
    //public void recommend(ShowRecommendation sr) {}
    //public void findPath(PathFinder pf) {}
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

class CastFactory {}
class HostFactory {}
class ArtistFactory {}

class Play extends Show { }
class Musical extends Show { }
class Concert extends Show { }
class Opera extends Show { }
class Museum extends Show { }
class Exhibition extends Show { }


class TicketAuthentication {
    public void slectPhoto() {}
    public void takePhoto() {}
    public boolean authenticateTicket() {
        return true;
    }

}

class Ticket {
    private int ticketNumber;
    private boolean isAuthenticated;
}
