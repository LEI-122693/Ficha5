package Database;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class MovieDatabase {

    public ElementsCollection grelha = $$("vaadin-grid-cell-content");

    public ElementsCollection getCollection(){
        return grelha;
    }

    public void open(){
        Selenide.open("https://vaadin-database-example.demo.vaadin.com/");
    }


}