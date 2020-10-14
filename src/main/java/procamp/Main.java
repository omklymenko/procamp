package procamp;

public class Main {

    public static void main(String[] args) {

        String path = Main.class.getClassLoader().getResource("test-task_dataset_summer_products.csv").getPath();

        MetricsCalculator calculator = new MetricsCalculator();
        calculator.calculateMetrics(path);
    }

}