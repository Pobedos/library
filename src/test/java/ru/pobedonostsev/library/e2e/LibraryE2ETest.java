package ru.pobedonostsev.library.e2e;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LibraryE2ETest {

    private static final String URL = "http://192.168.49.2:30996";
    private static final SelenideElement BOOK_ELEMENT = $(byXpath("//*[contains(@class, 'book-element')]"));

    @Test
    @Tag("FirstTest")
    @DisplayName("Best test")
    public void testBooks() {
        open(URL);
        BOOK_ELEMENT.shouldBe(visible);
    }
}
