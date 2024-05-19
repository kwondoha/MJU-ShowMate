package org.example;

public class Main {
    public static void main(String[] args) {
        // User-related operations
        User standardUser = new StandardUser();
        standardUser.login("standardUser", "password123");
        standardUser.updateProfile();

        User premiumUser = new PremiumUser();
        premiumUser.login("premiumUser", "password123");
        premiumUser.updateProfile();

        UserManager userManager = new UserManager();
        userManager.createUser(standardUser);
        userManager.updateUser(premiumUser);
        userManager.deleteUser(standardUser);

        // Show-related operations
        Show play = new Play();
        play.displayInfo(1);
        Show concert = new Concert();
        concert.displayInfo(2);

        ShowManager showManager = new ShowManager();
        showManager.addShow();
        showManager.updateShow(play);
        showManager.deleteShow(concert);

        // PathFinder-related operations
        PathFinder walkingPathFinder = new WalkingPathFinder();
        Path path = walkingPathFinder.findPath(new Location("Start", 0, 0), new Location("End", 0, 0));
        
        PathFinder busPathFinder = new BusPathFinder();
        Path busPath = busPathFinder.findPath(new Location("Start", 0, 0), new Location("End", 0, 0));

        // Verification and Authentication
        SMSVerification smsVerification = new SMSVerification();
        smsVerification.sendSMSCode();
        boolean smsVerified = smsVerification.verifySMSCode();

        KakaoVerification kakaoVerification = new KakaoVerification();
        kakaoVerification.sendKakaoCode();
        boolean kakaoVerified = kakaoVerification.verifyKakaoCode();

        VerificationAdapter smsAdapter = new SMSVerificationAdapter();
        boolean smsCodeVerified = smsAdapter.verifyCode("user1", "123456");

        VerificationAdapter kakaoAdapter = new KakaoVerificationAdapter();
        boolean kakaoCodeVerified = kakaoAdapter.verifyCode("user2", "123456");

        UserAuthentication userAuth = new UserAuthentication();
        userAuth.setVerificationAdapter(smsAdapter);
        boolean isAuthenticated = userAuth.authenticateUser(standardUser);

        // Ticket Authentication
        TicketAuthentication ticketAuth = new TicketAuthentication();
        ticketAuth.slectPhoto();
        ticketAuth.takePhoto();
        boolean isTicketAuthenticated = ticketAuth.authenticateTicket();

        // Location and GPS
        GPS gps = new GPS();
        Location currentLocation = gps.getCurrentLocation();

        LocationFactory locationFactory = new LocationFactory();
        LocationFlyweight sharedLocation = locationFactory.getSharedLocation("SharedLocation");

        // Reviews
        ShowReview showReview = new ShowReview();
        showReview.wirte(play);
        showReview.save(play);
        showReview.delete(play);
        showReview.display(play);

        UserReview userReview = new UserReview();
        userReview.wirte(standardUser);
        userReview.save(standardUser);
        userReview.delete(standardUser);
        userReview.display(standardUser);

        // Images
        Image realImage = new RealImage();
        realImage.showImage();

        Image proxyImage = new ProxyImage();
        proxyImage.showImage();
    }
}
