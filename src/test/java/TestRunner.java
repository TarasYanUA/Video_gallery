import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import taras.DriverProvider;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static taras.Constants.BASIC_URL;

public class TestRunner {
    @BeforeTest
    public void beforeMethod() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false; //не закрываем браузер пока ведём разработку
        //Configuration.screenshots = true; //делаем скриншоты при падении
        Configuration.browserSize = "1920x1050"; //Увеличиваем размер экрана
        open(BASIC_URL);
        $(".btn.btn-primary").click();
        $("#bp_off_bottom_panel").click();
    }

    public int navigateToStorefront(int tabNumber){
        $(By.linkText("Сохранить")).click();
        $(".btn-bar.btn-toolbar.nav__actions-bar.dropleft").$(".cs-icon.dropdown-icon").click();
        $(By.linkText("Предпросмотр")).click();
        getWebDriver().getWindowHandle(); switchTo().window(tabNumber);
    return tabNumber;
    }
}
