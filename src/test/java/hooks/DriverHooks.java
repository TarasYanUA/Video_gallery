package hooks;

import com.codeborne.selenide.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.*;

public class DriverHooks {
    public static final String BASIC_URL = "https://abd-0b5a99a139.demos.abt.team/admin.php?dispatch=addons.manage";
    public static final String PRODUCT_NAME = "adizero Rush Shoes";

    public DriverHooks() {super();}

    @Before()
    public void openBrowser() {
        Configuration.browser = "chrome";
        open(BASIC_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize(); //окно браузера на весь экран
        Configuration.holdBrowserOpen = false; //не закрываем браузер пока ведём разработку
        Configuration.screenshots = true; //делаем скриншоты при падении
        Configuration.timeout = 2000;   //настройка таймаута или Общая задержка

        $(".btn.btn-primary").click();
        $("#bp_off_bottom_panel").click();
    }

    @After
    public void closerBrowser() {
        closeWebDriver();
    }
}