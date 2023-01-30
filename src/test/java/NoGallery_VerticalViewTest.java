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
    selectBigPictureFlatTemplate();
    navigateToStorefront(1); //Переходим на витрину
    screenshot("511 NoGallery, Vertical, 'AB Big picture, flat'");
    shiftToRTLLanguage();
    screenshot("512 RTL, oGallery, Vertical, 'AB Big picture, flat'");
    switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Vertical_BigPictureTemplateOfProductPage() {
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("521 NoGallery, Vertical, 'Big picture'");
        shiftToRTLLanguage();
        screenshot("522 RTL, NoGallery, Vertical, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Vertical_DefaultTemplateOfProductPage() {
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("531 NoGallery, Vertical, 'Default'");
        shiftToRTLLanguage();
        screenshot("532 RTL, NoGallery, Vertical, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Vertical_ThreeColumnTemplateOfProductPageTest() {
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        screenshot("541 NoGallery, Vertical, 'AB Three columns'");
        shiftToRTLLanguage();
        screenshot("542 NoGallery, Vertical, 'AB Three columns'");
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-target-id=\"product_quick_view\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        screenshot("551 NoGallery, Vertical, QuickView");
    }
}