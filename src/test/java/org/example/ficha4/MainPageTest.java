package org.example.ficha4;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void beforeAllTests() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void loadPage() {
        open("https://www.jetbrains.com/");

        if ($("button.ch2-allow-all-btn").exists() && $("button.ch2-allow-all-btn").isDisplayed()) {
            $("button.ch2-allow-all-btn").click();
        }
    }

    @Test
    public void searchTest() {
        mainPage.openSearch();
        mainPage.fillSearch("Selenium");

        mainPage.searchBox.shouldBe(visible).shouldHave(value("Selenium"));

        // Pressiona Enter em vez de clicar num botão que já não existe
        mainPage.searchBox.pressEnter();
    }

    @Test
    public void devToolsMenuVisibility() {
        mainPage.openToolsDropdown();
        $("[data-test-marker='Developer Tools']").shouldBe(visible);
    }

    @Test
    public void fullNavigationToProducts() {
        mainPage.accessDeveloperTools();
        mainPage.accessToolsFinder();

        $("#products-page").shouldBe(visible);

        assertEquals(
                "All Developer Tools and Products by JetBrains",
                title()
        );
    }
}
