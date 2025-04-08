package mobile.androidStudio;

import com.codeborne.selenide.Condition;
import helpers.AndroidTestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class VerifyMobileAppsDevelopmentTextAppearsAfterScrolling extends AndroidTestBase {

    @DisplayName("Verify 'Mobile apps development' text appears after scrolling")
    @Tags({@Tag("mobile"), @Tag("android")})
    @Owner("Zhuravskyi M.")
    @Test
    void verifyMobileAppsDevelopmentTextAppearsAfterScrolling() {

        step("Open temerix.com in mobile browser", () -> {
            open("https://temerix.com/");
        });

        step("Close Chrome popup if present", () -> {
            androidActions.closeChromePopupIfPresent();
        });

        step("Wait for 'WHAT DO WE DO?' section to be visible", () -> {
            androidActions.waitForElementVisible("//android.widget.TextView[@text='WHAT DO WE DO?']");
        });

        step("Scroll down twice", () -> {
            androidActions.swipeDown();
            androidActions.swipeDown();
        });

        step("Verify 'Mobile apps development' text is visible", () -> {
            $x("//android.widget.TextView[@text='Mobile apps development']")
                    .shouldBe(Condition.visible);
        });
    }
}