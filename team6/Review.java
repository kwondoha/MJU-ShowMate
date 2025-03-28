import java.util.List;

public abstract class Review {
    private int reviewId;
    private String content;
    private int rating;
    private Image image;
}

class ShowReview extends Review{
    public void wirte(Show show){}
    public void save(Show show){}
    public void delete(Show show){}
    public void display(Show show){}
}

class UserReview extends Review{
    public void wirte(User user){}
    public void save(User user){}
    public void delete(User user){}
    public void display(User user){}
}

interface ReviewIterator {
    boolean hasNext();
    Review next();
}

class ReviewList implements ReviewIterator {
    private List<Review> reviews;
    private int position;

    @Override
    public boolean hasNext() {
        return position < reviews.size();
    }

    @Override
    public Review next() {
        return null;
    }
}

interface Image{
    void showImage();
}

class RealImage implements Image {
    private String imageUrl;

    @Override
    public void showImage(){
        //imageUrl을 출력하는 로직
    }
}

class ProxyImage implements Image{
    private Image imageProxy;

    @Override
    public void showImage(){
        imageProxy = new RealImage();
        imageProxy.showImage();
    }
}