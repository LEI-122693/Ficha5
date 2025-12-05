package org.example.ficha5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckBoxTestingTest {

    @BeforeAll
    public static void globalSetup() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void navigateToForm() {
        open("https://intellij-support.jetbrains.com/hc/en-us/requests/new?ticket_form_id=66731");

        $("button.ch2-allow-all-btn")
                .shouldBe(visible)
                .click(); // aceita cookies
    }

    private SelenideElement privacyPolicyCheckbox() {
        return $("#request_custom_fields_360000004124");
    }

    @Test
    public void shouldTogglePrivacyPolicyCheckbox() {
        SelenideElement checkbox = privacyPolicyCheckbox();

        checkbox.scrollIntoView(true);

        // Verificar que inicialmente está desmarcada
        checkbox.shouldBe(not(checked));

        // Marcar
        checkbox.click();
        checkbox.shouldBe(checked);

        // Desmarcar
        checkbox.click();
        checkbox.shouldBe(not(checked));
    }
}
