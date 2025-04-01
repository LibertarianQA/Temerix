package ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class HeaderShouldContainMainMenuItems {

    @DisplayName("Main menu in the header should contain expected sections")
    @Tags({@Tag("ui"), @Tag("header"), @Tag("navigate")})
    @Owner("Zhuravskyi M.")

    @Test
    void headerShouldContainMainMenuItems(){
        open("https://temerix.com");
        $$("#main-menu li").shouldHave(texts("Services", "About Us", "Recent Projects", "Our Team", "Contact Us"));
    }
}
