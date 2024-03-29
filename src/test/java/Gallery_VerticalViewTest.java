import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class Gallery_VerticalViewTest extends TestRunner{
    @Test(priority = 1)
    public void checkGallery_VerticalView_BigPictureFlat() {
        //Работаем со страницей товара
        navigateToProductPage();
        selectBigPictureFlatTemplate();
        navigateToStorefront(1); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("211 Gallery, Vertical - Big picture,flat");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("212 Gallery, Vertical - Big picture,flat (RTL)");
    }
    @Test(priority = 2)
    public void checkGallery_VerticalView_BigPicture() {
        switchTo().window(0);
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("221 Gallery, Vertical - Big picture");
        shiftToRTLLanguage();
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("222 Gallery, Vertical - Big picture (RTL)");
    }
    @Test(priority = 3)
    public void checkGallery_VerticalView_Default() {
        switchTo().window(0);
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("231 Gallery, Vertical - Default");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("232 Gallery, Vertical - Default (RTL)");
    }
    @Test(priority = 4)
    public void checkGallery_VerticalView_ThreeColumn() {
        switchTo().window(0);
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("241 Gallery, Vertical - Three columns");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("242 Gallery, Vertical - Three columns (RTL)");
        navigateToCategoryPageAndQuickView();
        screenshot("251 Gallery, Vertical - QuickView (RTL)");
    }
}