package org.example.ficha4;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Botão principal "Developer Tools"
    public SelenideElement devToolsEntry = $x("//*[@data-test-marker='Developer Tools']");

    // Botão "Find Your Tools"
    public SelenideElement exploreToolsLink = $x("//*[@data-test='suggestion-link']");

    // Menu dropdown "Developer Tools"
    public SelenideElement devToolsDropdown = $("[aria-label='Developer Tools: Open submenu']");

    // Botão de pesquisa da navbar
    public SelenideElement searchTrigger = $("[data-test='site-header-search-action']");

    // Campo de input da pesquisa
    public SelenideElement searchBox = $("[data-test-id='search-input']");


    // Abre o painel de pesquisa
    public void openSearch() {
        searchTrigger.click();
    }

    // Escreve no campo de pesquisa
    public void fillSearch(String query) {
        searchBox.setValue(query);
    }

    // Expande o dropdown de Developer Tools
    public void openToolsDropdown() {
        devToolsDropdown.click();
    }

    // Abre "See Developer Tools"
    public void accessDeveloperTools() {
        devToolsEntry.click();
    }

    // Abre "Find Your Tools"
    public void accessToolsFinder() {
        exploreToolsLink.click();
    }
}
