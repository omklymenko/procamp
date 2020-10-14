package procamp;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MetricsCalculator {

    public void calculateMetrics(String path) {
        SummerProductsReader reader = new SummerProductsReader();

        Map<String, List<RatingSummary>> originToSummaryMap = reader.readCsv(path).stream()
                .collect(Collectors.groupingBy(RatingSummary::getOriginCountry));
        List<Metrics> metrics = new ArrayList<>();
        for(List<RatingSummary> value : originToSummaryMap.values()){

            if (!value.isEmpty()) {
                RatingSummary ratingSummary = value.stream().parallel().reduce(RatingSummary::accumulateValues).get();

                DecimalFormat df = new DecimalFormat("#.###");

                metrics.add(new Metrics(Double.valueOf(df.format(ratingSummary.getPrice() / value.size())),
                        calculateFivePercentage(ratingSummary.getRatingCount(), ratingSummary.getRatingFiveCount()),
                        ratingSummary.getOriginCountry()));
            }
        }

        metrics.sort(Comparator.comparing(Metrics::getOriginCountry));
        System.out.println("avg(price)" + "\t" + "five_percentage" + "\t" + "origin_country");
        metrics.forEach(System.out::println);
    }

    private Double calculateFivePercentage(Integer ratingCount, Integer ratingFiveCount) {
        DecimalFormat df = new DecimalFormat("#.##");
        try {
            return Double.valueOf(df.format((ratingFiveCount * 100.0) / ratingCount));
        } catch(NumberFormatException e){
            return null;
        }
    }
}
