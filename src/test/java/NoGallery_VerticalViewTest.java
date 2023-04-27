import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class NoGallery_VerticalViewTest extends TestRunner{
    @Test(priority = 1)
    public void checkNoGallery_VerticalView_BigPictureFlat() {
    //Включаем Вертикальный вид
    $("#elm_menu_addons").hover();
    $("#elm_menu_addons_downloaded_add_ons").click();
    $("#addon_ab__video_gallery").$(".nowrap.inline-block-basic").click();
    $x("//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'selected_section=settings')]").click();
    SelenideElement checkbox = $x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]");
        if (!checkbox.isSelected()){
            checkbox.click();
        $(By.linkText("Сохранить")).click();
    }
    //Работаем со страницей товара
    navigateToProductPage();
    selectBigPictureFlatTemplate();
    navigateToStorefront(1); //Переходим на витрину
        Selenide.sleep(1000);
    screenshot("511 NoGallery, Vertical, 'AB Big picture, flat'");
    shiftToRTLLanguage();
        Selenide.sleep(1000);
    screenshot("512 RTL, oGallery, Vertical, 'AB Big picture, flat'");
    }
    @Test(priority = 2)
    public void checkNoGallery_VerticalView_BigPicture() {
        switchTo().window(0);
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("521 NoGallery, Vertical, 'Big picture'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("522 RTL, NoGallery, Vertical, 'Big picture'");
    }
    @Test(priority = 3)
    public void checkNoGallery_VerticalView_Default() {
        switchTo().window(0);
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("531 NoGallery, Vertical, 'Default'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("532 RTL, NoGallery, Vertical, 'Default'");
    }
    @Test(priority = 4)
    public void checkNoGallery_VerticalView_ThreeColumn() {
        switchTo().window(0);
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("541 NoGallery, Vertical, 'AB Three columns'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("542 RTL, NoGallery, Vertical, 'AB Three columns'");
        navigateToCategoryPageAndQuickView();
        screenshot("551 RTL, NoGallery, Vertical, QuickView");
    }
}