package org.example.ficha5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DynamicLoadingTest {

    DynamicLoadingPage page = new DynamicLoadingPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 10000; // espera máxima de 10s
    }

    @BeforeEach
    public void setup() {
        open("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    public void testDynamicLoading() {
        // Clica no botão Start.
        page.clickStart();

        // Espera até o texto aparecer
        page.finishText.shouldBe(visible);

        // Verifica se o texto correto apareceu
        assertEquals("Hello World!", page.getFinishText());
    }
}
