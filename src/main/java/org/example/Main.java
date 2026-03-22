package org.example;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Locale enLocale = new Locale("en", "US");
        ResourceBundle enBundle = ResourceBundle.getBundle("MessagesBundle", enLocale);

        String selectedLocale = "en-US";

        boolean selected = false;

        while (!selected) {
            System.out.println(enBundle.getString("choose_language"));
            System.out.println(enBundle.getString("option_1"));
            System.out.println(enBundle.getString("option_2"));
            System.out.println(enBundle.getString("option_3"));
            System.out.println(enBundle.getString("option_4"));

            int languageChoise = Integer.parseInt(scanner.nextLine());

            switch(languageChoise) {
                case 1:
                    selectedLocale = "en-US";
                    selected = true;
                    break;
                case 2:
                    selectedLocale = "fi-FI";
                    selected = true;
                    break;
                case 3:
                    selectedLocale = "sv-SE";
                    selected = true;
                    break;
                case 4:
                    selectedLocale = "ja-JP";
                    selected = true;
                    break;
                default:
                    System.out.println(enBundle.getString("invalid_choice"));
            }
        }

        String[] parts = selectedLocale.split("-");
        Locale locale = new Locale(selectedLocale);

        if (parts.length == 2) {
            locale = new Locale(parts[0], parts[1]);
        }

        ResourceBundle selectedBundle = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(selectedBundle.getString("start"));
        double items = Double.parseDouble(scanner.nextLine());

        ArrayList<Double> cartItems = new ArrayList<>();

        for (int i = 0; i < items; i++) {
            System.out.println(selectedBundle.getString("price"));
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println(selectedBundle.getString("quantity"));
            int quantity = Integer.parseInt(scanner.nextLine());

            double itemTotal = calculateItem(price, quantity);

            cartItems.add(itemTotal);
        }

        double cartTotal = calculateCartTotal(cartItems);

        System.out.println(selectedBundle.getString("cost") + " " + getLocalePrice(cartTotal, selectedBundle));
    }

    public static String getLocalePrice(double price, ResourceBundle selectedBundle) {
        if (selectedBundle.getLocale().toLanguageTag().equals("en-US")) {
            return selectedBundle.getString("currency") + price;
        } else {
            return price + selectedBundle.getString("currency");
        }
    }

    public static double calculateCartTotal(ArrayList<Double> cartItems) {
        double itemTotal = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            itemTotal += cartItems.get(i);
        }
        return itemTotal;
    }

    public static double calculateItem(double price, int quantity) {
        return price * quantity;
    }
}
