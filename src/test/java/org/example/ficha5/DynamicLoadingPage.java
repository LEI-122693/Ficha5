package org.example.ficha5;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class DynamicLoadingPage {

    // Botão para iniciar o carregamento
    public SelenideElement startButton = $("#start button");

    // Texto que aparece após carregamento
    public SelenideElement finishText = $("#finish");

    // Clica no botão "Start"
    public void clickStart() {
        startButton.click();
    }

    // Retorna o texto que aparece após carregamento
    public String getFinishText() {
        return finishText.getText();
    }
}