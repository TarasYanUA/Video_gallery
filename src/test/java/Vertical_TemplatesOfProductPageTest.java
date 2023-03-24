import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class Vertical_TemplatesOfProductPageTest extends TestRunner{
    @Test
    public void checkVertical_BigPictureFlatTemplateOfProductPage() {
        //Работаем со страницей товара
        navigateToProductPage();
        selectBigPictureFlatTemplate();
        navigateToStorefront(1); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("211 Vertical, 'AB Big picture, flat'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("212 RTL, Vertical, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_BigPictureTemplateOfProductPage() {
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("221 Vertical, 'Big picture'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("222 RTL, Vertical, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_DefaultTemplateOfProductPage() {
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("231 Vertical, 'Default'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("232 RTL, Vertical, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkVertical_ThreeColumnTemplateOfProductPageTest() {
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("241 Vertical, 'AB Three columns'");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("242 RTL, Vertical, 'AB Three columns'");
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-target-id=\"product_quick_view\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        Selenide.sleep(1000);
        screenshot("251 Vertical, QuickView window");
    }
}