package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

class MainTest {

    @Test
    void calculateItem() {
        assertEquals(10, Main.calculateItem(5, 2));
    }

    @Test
    void calculateCartTotal() {
        assertEquals(60, Main.calculateCartTotal(new ArrayList<>(java.util.List.of(10.0, 20.0, 30.0))));
    }

    @Test
    void getLocalePrice() {
        assertEquals("$10.0", Main.getLocalePrice(10.0, ResourceBundle.getBundle("MessagesBundle", new Locale("en", "US"))));

        assertEquals("23.0€", Main.getLocalePrice(23.0, ResourceBundle.getBundle("MessagesBundle", new Locale("fi", "FI"))));

        assertEquals("15.0kr", Main.getLocalePrice(15.0, ResourceBundle.getBundle("MessagesBundle", new Locale("sv", "SE"))));

        assertEquals("15.0¥", Main.getLocalePrice(15.0, ResourceBundle.getBundle("MessagesBundle", new Locale("ja", "JP"))));
    }
}
