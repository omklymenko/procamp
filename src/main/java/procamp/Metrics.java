package procamp;

class Metrics {

    private Double averagePrice;
    private Double fiveStarPercentage;
    private String originCountry;

    Metrics(Double averagePrice, Double fiveStarPercentage, String originCountry) {
        this.averagePrice = averagePrice;
        this.fiveStarPercentage = fiveStarPercentage;
        this.originCountry = originCountry;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Double getFiveStarPercentage() {
        return fiveStarPercentage;
    }

    public void setFiveStarPercentage(Double fiveStarPercentage) {
        this.fiveStarPercentage = fiveStarPercentage;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @Override
    public String toString() {
        return  String.format("%10s\t%15s\t%14s",
                averagePrice,
                (fiveStarPercentage == null ? "no value" : fiveStarPercentage),
                (originCountry.isEmpty() ? "no value" : originCountry));
    }
}
