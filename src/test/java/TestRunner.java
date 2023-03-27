import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

/*
Модуль "Видео галерея" v3.2.1 + тема Юни2(UltRu) v4.16.1b. Можно установить весь пакет темы Юни2.
Запустить тесты можно:
 1) Через файл testng.xml
 2) Через Surefire отчёт: перейти в "Терминал" и ввести "mvn clean test". После этого в папке "target -> surefire reports"
 открыть файл "index.html" с помощью браузера (правая кнопка мыши -> Open in -> Browser).
*/

public class TestRunner {
    public static final String BASIC_URL = "https://trs.test.abt.team/4161ultru_seo_filters/admin.php";

    @BeforeClass
    public void openBrowser() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false; //не закрываем браузер пока ведём разработку
        Configuration.screenshots = true; //делаем скриншоты при падении
        Configuration.browserSize = "1920x1050"; //Увеличиваем размер экрана
        open(BASIC_URL);
        $(".btn.btn-primary").click();
        $("#bp_off_bottom_panel").click();
        $(".cm-notification-close").click();
    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    public void navigateToStorefront(int tabNumber){
        $(By.linkText("Сохранить")).click();
        $(".btn-bar.btn-toolbar.nav__actions-bar.dropleft").$(".cs-icon.dropdown-icon").click();
        $(By.linkText("Предпросмотр")).click();
        switchTo().window(tabNumber);
        if($(".cm-btn-success").exists()){
            $(".cm-btn-success").click();
        }
    }
    public void navigateToProductPage(){
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        //$(".cm-notification-close").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'Toshiba BDX2150')]").click();
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
    public void shiftToRTLLanguage() {
        $("a[id*='sw_select_en_wrap_language']").click();
        $("a[data-ca-name='ar']").click();
    }
}