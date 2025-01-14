package userinterface;

import strategies.ConversionStrategy;
import strategies.distance.KilometerToMileStrategy;
import strategies.distance.MileToKilometerStrategy;
import strategies.temperatur.CelsiusToFahrenheitStrategy;
import strategies.temperatur.FahrenheitToCelsiusStrategy;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private final List<ConversionStrategy> strategies = List.of(
            new CelsiusToFahrenheitStrategy(),
            new FahrenheitToCelsiusStrategy(),
            new KilometerToMileStrategy(),
            new MileToKilometerStrategy()
    );

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to convert?");
            for (int i = 0; i < this.strategies.size(); i++) {
                System.out.println((i + 1) + ": " + this.strategies.get(i).getDescription());
            }

            System.out.println("0: Exit");

            int choice = scanner.nextInt();

            if (choice == 0)
                return;

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid value");
                continue;
            }

            System.out.println("Enter the value to convert:");
            float value = scanner.nextFloat();

            ConversionStrategy strategy = this.strategies.get(choice - 1);

            float result = strategy.convert(value);

            System.out.println("Result: " + result);
        }
    }
}
