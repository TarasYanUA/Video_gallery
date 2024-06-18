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
    screenshot("511 NoGallery, Vertical - Big picture,flat");
    shiftLanguage("ar");
        Selenide.sleep(1000);
    screenshot("512 NoGallery, Vertical - Big picture,flat (RTL)");
    }
    @Test(priority = 2)
    public void checkNoGallery_VerticalView_BigPicture() {
        switchTo().window(0);
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("521 NoGallery, Vertical - Big picture");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("522 NoGallery, Vertical - Big picture (RTL)");
    }
    @Test(priority = 3)
    public void checkNoGallery_VerticalView_Default() {
        switchTo().window(0);
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("531 NoGallery, Vertical - Default");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("532 NoGallery, Vertical - Default (RTL)");
    }
    @Test(priority = 4)
    public void checkNoGallery_VerticalView_ThreeColumn() {
        switchTo().window(0);
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("541 NoGallery, Vertical - Three columns");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("542 NoGallery, Vertical - Three columns (RTL)");
        navigateToCategoryPageAndQuickView();
        screenshot("551 NoGallery, Vertical - QuickView (RTL)");
    }
}