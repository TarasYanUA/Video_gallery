import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class Gallery_HorizontalViewTest extends TestRunner {
    @Test
    public void checkGallery_HorizontalView_BigPictureFlat() {
        //Включаем Горизонтальный вид
        $("#elm_menu_addons").hover();
        $("#elm_menu_addons_downloaded_add_ons").click();
        $("#addon_ab__video_gallery").$(".nowrap.inline-block-basic").click();
        $x("//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'selected_section=settings')]").click();
        SelenideElement checkbox = $x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]");
        if (checkbox.isSelected()){
            checkbox.click();
            $(By.linkText("Сохранить")).click();
        }
        //Работаем со страницей товара
        navigateToProductPage();
        selectBigPictureFlatTemplate();
        navigateToStorefront(1); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("310 Horizontal, 'AB Big picture, flat'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("312 RTL, Horizontal, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkGallery_HorizontalView_BigPicture() {
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("321 Horizontal, 'Big picture'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("322 RTL, Horizontal, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkGallery_HorizontalView_Default() {
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        $(".ty-thumbnails_gallery").scrollTo();
        Selenide.sleep(1000);
        screenshot("331 Horizontal, 'Default'");
        shiftToRTLLanguage();
        $(".ty-thumbnails_gallery").scrollTo();
        Selenide.sleep(1000);
        screenshot("332 RTL, Horizontal, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkGallery_HorizontalView_ThreeColumn() {
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("341 Horizontal, 'AB Three columns'");
        shiftToRTLLanguage();
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("342 RTL, Horizontal, 'AB Three columns'");
        $(".ty-text-links-wrapper").scrollTo();
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-target-id=\"product_quick_view\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".icon-right-open-thin").shouldBe(Condition.enabled);
        Selenide.sleep(1000);
        screenshot("351 RTL, Horizontal, QuickView");
    }
}
