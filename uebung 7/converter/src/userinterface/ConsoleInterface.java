package userinterface;

import strategies.ConversionStrategy;
import strategies.distance.KilometerToMileStrategy;
import strategies.distance.MileToKilometerStrategy;
import strategies.temperatur.CelsiusToFahrenheitStrategy;
import strategies.temperatur.FahrenheitToCelsiusStrategy;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    public void start() {
        List<ConversionStrategy> strategies = List.of(
            new CelsiusToFahrenheitStrategy(),
            new FahrenheitToCelsiusStrategy(),
            new KilometerToMileStrategy(),
            new MileToKilometerStrategy()
        );

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to convert?");
            System.out.println("1: Celsius to Fahrenheit");
            System.out.println("2: Fahrenheit to Celsius");
            System.out.println("3: Kilometers to Miles");
            System.out.println("4: Miles to Kilometers");

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

            ConversionStrategy strategy = strategies.get(choice - 1);

            float result = strategy.convert(value);

            System.out.println("Result: " + result);
        }
    }
}
