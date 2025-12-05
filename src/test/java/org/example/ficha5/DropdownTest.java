package org.example.ficha5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DropdownTest {

    @BeforeAll
    static void init() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure-listener", new AllureSelenide());
    }

    @BeforeEach
    void openPage() {
        open("https://intellij-support.jetbrains.com/hc/en-us/requests/new?ticket_form_id=66731");

        // Aceitar cookies quando visível
        SelenideElement acceptCookies = $("button.ch2-allow-all-btn");
        acceptCookies.should(appear).click();
    }

    @Test
    void testDropdownSelections() {

        // Localizador da dropdown
        SelenideElement osDropdown = $("#request_custom_fields_28151042_label")
                .parent()
                .$("a.nesty-input")
                .shouldBe(visible);

        // Selecionar três opções diferentes
        selecionarOpcaoDaDropdown(osDropdown, 1);
        selecionarOpcaoDaDropdown(osDropdown, 4);
        selecionarOpcaoDaDropdown(osDropdown, 6);
    }

    private void selecionarOpcaoDaDropdown(SelenideElement dropdown, int opcaoIndex) {
        dropdown.click();
        $$(".nesty-panel li")
                .get(opcaoIndex)
                .shouldBe(visible)
                .click();
    }
}
