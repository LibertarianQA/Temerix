package mobile.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class LocalMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(System.getProperty("AppiumURL", "http://localhost:4723"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
//public static URL getAppiumServerUrl() {
//    String url = System.getProperty("JenkinsAppium", "http://localhost:4723/");
//    System.out.println(">>> Using Appium server URL: " + url);
//    try {
//        return new URL(url);
//    } catch (MalformedURLException e) {
//        throw new RuntimeException(e);
//    }
//}


    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName("Pixel 8 API 33")
                .setPlatformVersion("13.0")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }
}
