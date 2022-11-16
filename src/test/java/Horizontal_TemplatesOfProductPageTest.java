import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class Horizontal_TemplatesOfProductPageTest extends TestRunner {
    public void navigateToProductPage() {
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'Toshiba BDX2150')]").click();
    }

    @Test
    public void checkBigPictureFlatTemplateOfProductPage() {
        //Включаем Горизонтальный вид
        $("#elm_menu_addons").hover();
        $("#elm_menu_addons_manage_addons").click();
        $("#addon_ab__video_gallery").$(".nowrap.inline-block-basic").click();
        $x("//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'selected_section=settings')]").click();
        WebElement checkbox = $x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]");
        if (checkbox.isSelected()){
            $x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]").click();
            $(By.linkText("Сохранить")).click();
        }
        //Работаем со страницей товара
        navigateToProductPage();
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_bigpicture_flat_template']").click();
        navigateToStorefront(1); //Переходим на витрину
        screenshot("301 Horizontal, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkBigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("302 Horizontal, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkDefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("303 Horizontal, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
        navigateToStorefront(4); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        screenshot("304 Horizontal, 'AB Three columns'");
        $(".ty-text-links-wrapper").scrollTo();
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[contains(@href, 'toshiba-bdx2150-blu-ray-player/')]").hover();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-dialog-title=\"Quick product viewer\"]").shouldBe(Condition.visible).click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".icon-right-open-thin").shouldBe(Condition.enabled);
        screenshot("305 QuickView window");
    }
}
