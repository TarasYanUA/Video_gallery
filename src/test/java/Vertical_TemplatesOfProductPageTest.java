import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class Vertical_TemplatesOfProductPageTest extends TestRunner{
    public void navigateToProductPage(){
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        $("#bp_off_bottom_panel").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'Toshiba BDX2150')]").click();
    }
    @Test
    public void checkBigPictureFlatTemplateOfProductPage() {
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
    public void checkBigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("202 Vertical, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkDefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("203 Vertical, 'Default'");
        switchTo().window(0);
    }
     @Test
    public void checkThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
        navigateToStorefront(4); //Переходим на витрину
        screenshot("204 Vertical, 'AB Three columns'");
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-dialog-title=\"Quick product viewer\"]").click();
        screenshot("205 QuickView window");
    }
}