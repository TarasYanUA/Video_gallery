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
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_bigpicture_flat_template']").click();
        navigateToStorefront(1); //Переходим на витрину
        screenshot("201 Vertical, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_BigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("202 Vertical, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_DefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("203 Vertical, 'Default'");
        switchTo().window(0);
    }
     @Test
    public void checkVertical_ThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
        navigateToStorefront(4); //Переходим на витрину
        screenshot("204 Vertical, 'AB Three columns'");
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-dialog-title=\"Quick product viewer\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".icon-right-open-thin").shouldBe(Condition.enabled);
        screenshot("205 Vertical, QuickView window");
    }
}