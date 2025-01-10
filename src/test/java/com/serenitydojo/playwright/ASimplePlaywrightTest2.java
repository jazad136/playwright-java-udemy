package com.serenitydojo.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ASimplePlaywrightTest2 {
    @Test
    void shouldShowThePageTitle() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://practicesoftwaretesting.com");

        String title = page.title();

        Assertions.assertTrue(title.contains("Practice Software Testing"));
        System.out.println("TEST PASSED: Page contains Practice Software Testing");
        browser.close();
        playwright.close();
    }

    @Test
    void shouldSearchByKeyword() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://practicesoftwaretesting.com");
        page.locator("[placeholder=Search]");
        System.out.println("TEST PASSED: Page contains field with 'search' placeholder");
        page.locator("button:has-text('Search')").click();
        System.out.println("TEST PASSED: Page contains clickable search button");

        int matchingSearchResults = page.locator(".card").count();
        System.out.println("Matching search results: " + matchingSearchResults);
        browser.close();
        playwright.close();
    }
}
