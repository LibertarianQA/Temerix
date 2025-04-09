package web;

import helpers.WebTestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class СlickFacebookIcon_ShouldNavigateToCorrectPage extends WebTestBase {

    @DisplayName("User should be redirected to the Facebook page after clicking the icon")
    @Tags({@Tag("web"), @Tag("footer")})
    @Owner("Zhuravskyi M.")

    @Test
    void navigateToContactPageShouldDisplayContactUsSection() {

        step("Open the home page", () -> {
            open("https://temerix.com");
        });

        step("Click on the Contact menu item", () -> {
            $("[data-menuanchor='contact']").click();
        });

        step("Verify that the URL changed to the Contact section", () -> {
            webdriver().shouldHave(url("https://temerix.com/#contact"));
        });

        step("Verify that the Contact Us section is displayed", () -> {
            $(".page__border--six .section-title").shouldHave(text("Contact Us"));
        });
    }
}
