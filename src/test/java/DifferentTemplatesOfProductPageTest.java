import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class DifferentTemplatesOfProductPageTest extends TestRunner{
    public void navigateToProductPage(){
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        $("#bp_off_bottom_panel").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'Toshiba BDX2150')]").click();
    }
    @Test
    public void checkBigPictureFlatTemplateOfProductPage() {
        navigateToProductPage();
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_bigpicture_flat_template']").click();
        $(By.linkText("Сохранить")).click();
        navigateToStorefront(1); //Переходим на витрину
        screenshot("201 Template 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkBigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        $(By.linkText("Сохранить")).click();
        navigateToStorefront(2); //Переходим на витрину
        screenshot("202 Product page with template 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkDefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        $(By.linkText("Сохранить")).click();
        navigateToStorefront(3); //Переходим на витрину
        screenshot("203 Product page with template 'Default'");
        switchTo().window(0);
    }
     @Test
    public void checkThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
         $(By.linkText("Сохранить")).click();
        navigateToStorefront(4); //Переходим на витрину
        screenshot("204 Product page with template 'AB Three columns'");
    }
}