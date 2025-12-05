package org.example.ficha5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
//
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 5000; //
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");

        // Fecha overlay de cookies, se existir
        if ($("button.ch2-allow-all-btn").exists() && $("button.ch2-allow-all-btn").isDisplayed()) {
            $("button.ch2-allow-all-btn").click();
        }
        sleep(1000); //
    }

    @Test
    public void search() {
        mainPage.clickSearchButton();

        // Digita o texto e verifica o valor
        mainPage.enterSearchText("Selenium");
        mainPage.searchInput.shouldBe(visible).shouldHave(attribute("value", "Selenium"));

        // Espera o botão de pesquisa completo ficar clicável e clica
        $("button[data-test='full-search-button']").shouldBe(visible, enabled).click();
    }

    @Test
    public void toolsMenu() {
        // Expande o menu e verifica visibilidade
        mainPage.expandToolsMenu();
        mainPage.seeDeveloperToolsButton.shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.clickSeeDeveloperToolsButton();
        mainPage.clickFindYourToolsButton();

        $("#products-page").shouldBe(visible);
        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }
}
