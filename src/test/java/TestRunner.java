import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static taras.Constants.BASIC_URL;

/*
Модуль "Видео галерея" + тема Юни2(UltRu)
*/

public class TestRunner {
    @BeforeTest
    public void beforeMethod() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false; //не закрываем браузер пока ведём разработку
        Configuration.screenshots = true; //делаем скриншоты при падении
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

    public void navigateToProductPage(){
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'Toshiba BDX2150')]").click();
    }
}