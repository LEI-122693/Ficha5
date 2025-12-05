package Database;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieDatabaseTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1280x800";
        Configuration.pageLoadTimeout= 10000;
        Configuration.timeout = 10000;
    }

    MovieDatabase page = new MovieDatabase();

    @BeforeEach
    public void openPage() {
        page.open();
    }

    @Test
    public void testFirstMovie() throws InterruptedException {

        String nome = page.grelha.get(0).getText();

        String ano = page.grelha.get(1).getText();

        String director = page.grelha.get(2).getText();

        String linkText = page.grelha.get(3).getText();

        Assertions.assertEquals("Law Abiding Citizen", nome);

        Assertions.assertEquals("2009", ano);

        Assertions.assertEquals("F. Gardy Gray", director);

        Assertions.assertEquals("Click to IMBD site", linkText);
    }

}