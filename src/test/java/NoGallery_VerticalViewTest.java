import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class NoGallery_VerticalViewTest extends TestRunner{
    @Test
    public void checkNoGallery_Vertical_BigPictureFlatTemplateOfProductPage() {
    //Включаем Вертикальный вид
    $("#elm_menu_addons").hover();
    $("#elm_menu_addons_manage_addons").click();
    $("#addon_ab__video_gallery").$(".nowrap.inline-block-basic").click();
    $x("//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'selected_section=settings')]").click();
    WebElement checkbox = $x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]");
        if (!checkbox.isSelected()){
        $x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]").click();
        $(By.linkText("Сохранить")).click();
    }
    //Работаем со страницей товара
    navigateToProductPage();
    $("#elm_details_layout").click();
    $x("//option[@value='abt__ut2_bigpicture_flat_template']").click();
    navigateToStorefront(1); //Переходим на витрину
    screenshot("501 NoGallery, Vertical, 'AB Big picture, flat'");
    switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Vertical_BigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("502 NoGallery, Vertical, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Vertical_DefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("503 NoGallery, Vertical, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Vertical_ThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
        navigateToStorefront(4); //Переходим на витрину
        screenshot("504 NoGallery, Vertical, 'AB Three columns'");
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-dialog-title=\"Quick product viewer\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        screenshot("505 NoGallery, Vertical, QuickView");
    }
}