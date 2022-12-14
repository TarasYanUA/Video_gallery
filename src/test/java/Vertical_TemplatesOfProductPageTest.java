import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class Vertical_TemplatesOfProductPageTest extends TestRunner{
    @Test
    public void checkVertical_BigPictureFlatTemplateOfProductPage() {
        //Включаем Быстрый просмотр
        $(".dropdown-toggle.settings").hover();
        $("#elm_menu_settings_Appearance").click();
        WebElement quickView = $x("//input[contains(@id, 'field___enable_quick_view_')]");
        if (!quickView.isSelected()){
        $x("//input[contains(@id, 'field___enable_quick_view_')]").click();
        $(By.linkText("Сохранить")).click();
        }
        //Работаем со страницей товара
        navigateToProductPage();
        selectBigPictureFlatTemplate();
        navigateToStorefront(1); //Переходим на витрину
        screenshot("211 Vertical, 'AB Big picture, flat'");
        shiftToRTLLanguage();
        screenshot("212 RTL, Vertical, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_BigPictureTemplateOfProductPage() {
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("221 Vertical, 'Big picture'");
        shiftToRTLLanguage();
        screenshot("222 RTL, Vertical, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_DefaultTemplateOfProductPage() {
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("231 Vertical, 'Default'");
        shiftToRTLLanguage();
        screenshot("232 RTL, Vertical, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_ThreeColumnTemplateOfProductPageTest() {
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        screenshot("241 Vertical, 'AB Three columns'");
        shiftToRTLLanguage();
        screenshot("242 RTL, Vertical, 'AB Three columns'");
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-target-id=\"product_quick_view\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".icon-right-open-thin").shouldBe(Condition.enabled);
        screenshot("251 Vertical, QuickView window");
    }
}