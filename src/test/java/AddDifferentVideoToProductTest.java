import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class AddDifferentVideoToProductTest extends TestRunner{
    @Test
    public void VerifyAddingDifferentVideoToProduct(){
        /*
        //Классы PageObject в Селенид 55:33
        */
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        $("#bp_off_bottom_panel").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'Toshiba BDX2150')]").click();
        $("#ab__video_gallery").click();

        //Добавляем видео с YouTube
        $x("//input[@name='product_data[ab__vg_videos][1][pos]']").click();
        $x("//input[@name='product_data[ab__vg_videos][1][pos]']").setValue("1");
        $(By.name("product_data[ab__vg_videos][1][title]")).click();
        $(By.name("product_data[ab__vg_videos][1][title]")).setValue("Музыка, успокаивает нервную систему и радует душу");
        $("#ab__vg__video_path__1").click();
        $("#ab__vg__video_path__1").setValue("ayjzgSwtzbY");

        //Добавляем видео с Vimeo
        $("#add_ab__vg_video").click();
        $(By.name("product_data[ab__vg_videos][2][pos]")).click();
        $(By.name("product_data[ab__vg_videos][2][pos]")).setValue("2");
        $(By.name("product_data[ab__vg_videos][2][title]")).click();
        $(By.name("product_data[ab__vg_videos][2][title]")).setValue("Disney Channel/ABC Oscar");
        $(By.name("product_data[ab__vg_videos][2][type]")).click();
        $(By.name("product_data[ab__vg_videos][2][type]")).selectOption("Vimeo");
        $("#ab__vg__video_path__1_1").click();
        $("#ab__vg__video_path__1_1").setValue("154625007");

        //Добавляем видео с другого ресурса
        $("#add_ab__vg_video_1").click();
        $(By.name("product_data[ab__vg_videos][4][pos]")).click();
        $(By.name("product_data[ab__vg_videos][4][pos]")).setValue("3");
        $(By.name("product_data[ab__vg_videos][4][title]")).click();
        $(By.name("product_data[ab__vg_videos][4][title]")).setValue("Dug Days - Science (Clip)");
        $(By.name("product_data[ab__vg_videos][4][type]")).click();
        $(By.name("product_data[ab__vg_videos][4][type]")).selectOption("Ссылка");
        $("#ab__vg__video_path__1_1_2").click();
        $("#ab__vg__video_path__1_1_2").setValue("https://www.vidlii.com/watch?v=y5XmL9dJ2kN");
        navigateToStorefront(1); //Переходим на витрину

        //Проверяем, что вкладка "Видео галерея присутствует на странице товара
        $x("//li[@id=\"ab__video_gallery\"][@class=\"ty-tabs__item cm-js\"]").shouldBe(Condition.exist);
        $x("//li[@id=\"ab__video_gallery\"][@class=\"ty-tabs__item cm-js\"]").click();
        //Проверяем, что во вкладке больше одного видео
        $$("#tabs_content").shouldHave(CollectionCondition.size(1));
        screenshot("101 Two videos on product page");
    }
}
