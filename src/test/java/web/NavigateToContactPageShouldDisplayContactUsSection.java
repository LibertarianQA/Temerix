package web;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.WebTestBase;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class NavigateToContactPageShouldDisplayContactUsSection extends WebTestBase {

    @DisplayName("Contact menu item should navigate to the correct section")
    @Tags({@Tag("web"), @Tag("contact"), @Tag("navigate")})
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
