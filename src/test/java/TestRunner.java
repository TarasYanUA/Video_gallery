import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

/*
Модуль "Видео галерея" v3.6.0 + тема Юни2(UltRu) v4.18.1b. Лучше установить весь пакет темы Юни2.

Запустить тесты можно:
 1) Через файл TestNG.xml
 2) Через Surefire отчёт: перейти в "Терминал" и ввести "mvn clean test". После этого в папке "target -> surefire reports"
 открыть файл "index.html" с помощью браузера (правая кнопка мыши -> Open in -> Browser).
*/

public class TestRunner {
    public static final String BASIC_URL = "https://trs.test.abt.team/4181ultru/admin.php?dispatch=addons.manage";

    @BeforeClass
    public void openBrowser() {
        Configuration.browser = "chrome";
        open(BASIC_URL);
        Configuration.holdBrowserOpen = false; //не закрываем браузер пока ведём разработку
        Configuration.screenshots = true; //делаем скриншоты при падении
        WebDriverRunner.getWebDriver().manage().window().maximize(); //окно браузера на весь экран
        $(".btn.btn-primary").click();
        $("#bp_off_bottom_panel").click();
    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }


    public void navigateTo_StorefrontProductPage(int tabNum) {
        $(".dropdown-icon--tools").click();
        $x("//ul[@class='dropdown-menu']//a[contains(text(), 'Предпросмотр')]").click();
        List<String> tabs = new ArrayList<>(Selenide.webdriver().object().getWindowHandles());
        Selenide.switchTo().window(tabs.get(tabNum));
        if ($(".cm-btn-success").exists()) {
            $(".cm-btn-success").click();
        }
    }

    public void navigateToProductPage(){
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        //$(".cm-notification-close").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'adizero Rush Shoes')]").click();
    }
    public void navigateToCategoryPageAndQuickView(){
        $(".ty-text-links-wrapper").scrollTo();
        $x("//a[@class='ty-breadcrumbs__a']//bdi[text()='Apparel']").click();
        $x("//a[@data-ca-view-id='78'][@data-ca-target-id='product_quick_view']").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        Selenide.sleep(1000);
    }
    public void selectBigPictureFlatTemplate() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_bigpicture_flat_template']").click();
    }
    public void selectBigPictureTemplate() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
    }
    public void selectDefaultTemplate() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
    }
    public void selectThreeColumnTemplate() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
    }
    public void shiftLanguage(String arRuEn) {
        $("a[id*='sw_select'][id*='wrap_language']").scrollTo().click();
        $("a[data-ca-name='" + arRuEn + "']").click();
    }
}