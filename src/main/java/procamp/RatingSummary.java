package procamp;

public class RatingSummary {

    private Float price;
    private Integer ratingCount;
    private Integer ratingFiveCount;
    private String originCountry;


    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getRatingFiveCount() {
        return ratingFiveCount;
    }

    public void setRatingFiveCount(Integer ratingFiveCount) {
        this.ratingFiveCount = ratingFiveCount;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public RatingSummary(Float price, Integer ratingCount, Integer ratingFiveCount, String originCountry) {
        this.price = price;
        this.ratingCount = ratingCount;
        this.ratingFiveCount = ratingFiveCount;
        this.originCountry = originCountry;
    }
}
