package procamp;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String path = Main.class.getClassLoader().getResource("test-task_dataset_summer_products.csv").getPath();

        List<RatingSummary> ratingSummaryList = SummerProductsReader.readCsv(path);

        Map<String, List<RatingSummary>> map = ratingSummaryList.stream().collect(Collectors.groupingBy(RatingSummary::getOriginCountry));
        Collection<List<RatingSummary>> values = map.values();
        List<Metrics> metrics = new ArrayList<>();
        for(List<RatingSummary> value : values){
            RatingSummary ratingSummary = new RatingSummary(0f,0,0, value.get(0).getOriginCountry());

           for(RatingSummary summary : value){
               ratingSummary.setPrice(ratingSummary.getPrice() + summary.getPrice());
               ratingSummary.setRatingCount(ratingSummary.getRatingCount() + summary.getRatingCount());
               ratingSummary.setRatingFiveCount(ratingSummary.getRatingFiveCount() + summary.getRatingFiveCount());
            }

            DecimalFormat df = new DecimalFormat("#.###");

            metrics.add(new Metrics(Double.valueOf(df.format(ratingSummary.getPrice() / value.size())),
                    calculateFivePercentage(ratingSummary.getRatingCount(), ratingSummary.getRatingFiveCount()),
                    ratingSummary.getOriginCountry()));
        }

        metrics.sort(Comparator.comparing(Metrics::getOriginCountry));
        System.out.println("avg(price)" + "\t" + "five_percentage" + "\t" + "origin_country");
        metrics.forEach(System.out::println);
    }

    private static Double calculateFivePercentage(Integer ratingCount, Integer ratingFiveCount) {
        DecimalFormat df = new DecimalFormat("#.##");
        try {
            return Double.valueOf(df.format((ratingFiveCount * 100.0) / ratingCount));
        } catch(NumberFormatException e){
            return null;
        }
    }

}
