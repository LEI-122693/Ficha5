package org.example.ficha4;



import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AttachmentUploadTest {

    @BeforeAll
    public static void setupAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 8000; // Esperas mais estáveis
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setup() {
        open("https://intellij-support.jetbrains.com/hc/en-us/requests/new?ticket_form_id=66731");

        // Aceitar banner de cookies caso apareça
        SelenideElement cookieBtn = $("button.ch2-allow-all-btn");
        if (cookieBtn.exists()) {
            cookieBtn.shouldBe(visible).click();
        }
    }

    @Test
    public void shouldUploadAttachmentSuccessfully() {
        SelenideElement uploadInput = $("#request-attachments"); // NÃO visible

        File file = new File("AttachmentFile.txt");
        uploadInput.uploadFile(file);

        // Verifica se aparece o link do ficheiro carregado
        $$("a.upload-link")
                .findBy(text("AttachmentFile.txt"))
                .shouldBe(visible);
    }
}

