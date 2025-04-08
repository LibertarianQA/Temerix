package web;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.WebTestBase;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HeaderShouldContainMainMenuItems extends WebTestBase {

    @DisplayName("Main menu in the header should contain expected sections")
    @Tags({@Tag("web"), @Tag("header"), @Tag("navigate")})
    @Owner("Zhuravskyi M.")

    @Test
    void headerShouldContainMainMenuItems() {

        step("Open the home page", () -> {
            open("https://temerix.com");
        });

        step("Check that the main menu contains expected sections", () -> {
            $$("#main-menu li").shouldHave(texts("Services", "About Us", "Recent Projects", "Our Team", "Contact Us"));
        });
    }
}
