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
        screenshot("211 Vertical, 'AB Big picture, flat'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("212 RTL, Vertical, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_BigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("221 Vertical, 'Big picture'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("222 RTL, Vertical, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_DefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("231 Vertical, 'Default'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("232 RTL, Vertical, 'Default'");
        switchTo().window(0);
    }
     @Test
    public void checkVertical_ThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
        navigateToStorefront(4); //Переходим на витрину
        screenshot("241 Vertical, 'AB Three columns'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("242 RTL, Vertical, 'AB Three columns'");
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-dialog-title=\"Quick product viewer\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".icon-right-open-thin").shouldBe(Condition.enabled);
        screenshot("251 Vertical, QuickView window");
    }
}