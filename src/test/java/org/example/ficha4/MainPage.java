package org.example.ficha4;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
    public SelenideElement findYourToolsButton = $x("//*[@data-test='suggestion-link']");
    public SelenideElement toolsMenu = $("[aria-label='Developer Tools: Open submenu']");
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement searchInput = $("[data-test-id='search-input']");

    // Clica no botão "See Developer Tools"
    public void clickSeeDeveloperToolsButton() {
        seeDeveloperToolsButton.click();
    }

    // Clica no botão "Find Your Tools"
    public void clickFindYourToolsButton() {
        findYourToolsButton.click();
    }

    // Expande o menu "Developer Tools"
    public void expandToolsMenu() {
        toolsMenu.click();
    }

    // Clica no botão de pesquisa
    public void clickSearchButton() {
        searchButton.click();
    }

    // Digita um texto na caixa de pesquisa
    public void enterSearchText(String text) {
        searchInput.setValue(text);
    }

    // Pesquisa um texto e pressiona Enter
    public void searchFor(String text) {
        searchInput.setValue(text).pressEnter();
    }

    // Verifica se o menu de ferramentas está visível
    public boolean isToolsMenuVisible() {
        return toolsMenu.isDisplayed();
    }
}
