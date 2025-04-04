package mobile.androidStudio;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AndroidActions {
    public void closeChromePopupIfPresent() {
        try {
            $(By.id("com.android.chrome:id/negative_button")).click();
        } catch (Exception e) {
            System.out.println("No notification popup found");
        }
    }

    public void swipeDown() {
        AndroidDriver androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 500, 1500));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), 500, 500));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Arrays.asList(swipe));
    }

    public void waitForElementVisible(String xpath) {
        $x(xpath).shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
