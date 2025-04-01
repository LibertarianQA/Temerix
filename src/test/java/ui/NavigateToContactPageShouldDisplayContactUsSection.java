package ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class NavigateToContactPageShouldDisplayContactUsSection {

    @DisplayName("Contact menu item should navigate to the correct section")
    @Tags({@Tag("ui"), @Tag("contact"), @Tag("navigate")})
    @Owner("Zhuravskyi M.")
    @Test
    void navigateToContactPageShouldDisplayContactUsSection(){
        open("https://temerix.com");
        $("[data-menuanchor='contact']").click();
        webdriver().shouldHave(url("https://temerix.com/#contact"));
        $(".page__border--six .section-title").shouldHave(text("Contact Us"));
    }
}
