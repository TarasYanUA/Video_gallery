package steps.adminPanel;

import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class Utils {

    public static void waitForElementAndClick(By locator) {
        try {
            $(locator).shouldBe(exist, Duration.ofSeconds(8)).click();
        } catch (com.codeborne.selenide.ex.UIAssertionError e) {
        }
    }
}