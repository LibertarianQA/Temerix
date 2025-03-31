package ui;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Test1 {

    @Test
    void openHomePage_ShouldDisplayCorrectTitle(){
        open("https://temerix.com");
        $(".page-one__title").shouldHave(text("WE IMPLEMENT YOUR IDEA"));
    }

    @Test
    void openHomePage_ShouldContainMainMenuItems(){
        open("https://temerix.com");
        $$("#main-menu li").shouldHave(texts("Services", "About Us", "Recent Projects", "Our Team", "Contact Us"));
    }

    @Test
    void navigateToContactPage_ShouldDisplayContactUsSection(){
        open("https://temerix.com");
        $("[data-menuanchor='contact']").click();
        webdriver().shouldHave(url("https://temerix.com/#contact"));
        $(".page__border--six .section-title").shouldHave(text("Contact Us"));
    }
}
