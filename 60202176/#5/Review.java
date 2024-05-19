import java.util.List;
import java.util.Scanner;

public abstract class Review {
    private int reviewId;
    private String content;
    private int rating;
    private Image image;
    private boolean isReported;

    protected void setContent(String content) {
        this.content=content;
    }

    protected void setRating(int rating) {
        this.rating=rating;
    }

    // 리뷰 신고 메소드
    public void report() {
        this.isReported = true;
        // 리뷰를 신고하는 로직 구현
        System.out.println("리뷰가 신고되었습니다.");
    }

    protected String getContent() {
        return this.content;
    }

    protected int getRating() {
        return this.rating;
    }
}

class ShowReview extends Review{
    public void wirte(Show show){
        Scanner scanner = new Scanner(System.in);
        System.out.println("리뷰 입력");
        String content = scanner.nextLine();
        System.out.println("평점 입력");
        int rating = scanner.nextInt();

        // ShowReview 객체 생성
        ShowReview review = new ShowReview();
        review.setContent(content);
        review.setRating(rating);
    }
    public void save(Show show){}
    public void delete(ShowReview review) {
        review=null;
        System.out.println("쇼 리뷰 삭제");
    }
    public void display(Show show) {
        List<Review> userReviews = show.getReviews();

        // 쇼의 리뷰가 없는 경우 예외 처리
        if (userReviews.isEmpty()) {
            System.out.println("해당 공연의 리뷰가 없습니다.");
            return;
        }

        // 쇼의 모든 리뷰를 화면에 출력합니다.
        System.out.println(show.getName() + " 공연의 리뷰 목록:");
        for (Review review : userReviews) {
            // 각 리뷰의 정보 출력
            System.out.println(review.getContent());
            System.out.println("평점: " + review.getRating());
        }
    }
}

class UserReview extends Review{
    public void wirte(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("리뷰 입력");
        String content = scanner.nextLine();
        System.out.println("평점 입력");
        int rating = scanner.nextInt();

        // UserReview 객체 생성
        UserReview review = new UserReview();
        review.setContent(content);
        review.setRating(rating);
    }
    public void save(User user){}
    public void delete(UserReview review) {
        review=null;
        System.out.println("사용자 리뷰 삭제");
    }
    public void display(User user) {
        List<Review> userReviews = user.getReviews();

        // 유저의 리뷰가 없는 경우 예외 처리
        if (userReviews.isEmpty()) {
            System.out.println("해당 유저의 리뷰가 없습니다.");
            return;
        }

        // 유저의 모든 리뷰를 화면에 출력합니다.
        System.out.println(user.getName() + "님의 리뷰 목록:");
        for (Review review : userReviews) {
            // 각 리뷰의 정보 출력
            System.out.println(review.getContent());
            System.out.println("평점: " + review.getRating());
        }
    }
}

interface ReviewIterator {
    boolean hasNext();
    Review next();
}

class ReviewList implements ReviewIterator {
    private List<Review> reviews;
    private int position;

    public ReviewList(List<Review> reviews) {
        this.reviews = reviews;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < reviews.size();
    }

    @Override
    public Review next() {
        if (!hasNext()) {
            // 예외 처리 로직
            System.out.println("마지막 리뷰입니다.");
        }
        Review review = reviews.get(position);
        position++;
        return review;
    }
}


interface Image{
    void showImage();
}

class RealImage implements Image {
    private String imageUrl;

    public RealImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void showImage(){
        //imageUrl의 사진을 출력하는 로직
    }
}

class ProxyImage implements Image{
    private String imageUrl;

    private Image imageProxy;

    @Override
    public void showImage(){
        imageProxy = new RealImage(imageUrl);
        imageProxy.showImage();
    }
}