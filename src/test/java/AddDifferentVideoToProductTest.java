import adminPanel.CsCartSettings;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class AddDifferentVideoToProductTest extends TestRunner {
    @Test
    public void verifyAddingDifferentVideosToProduct() {
        //Переходим на страницу редактирования товара
        CsCartSettings csCartSettings = new CsCartSettings();
        csCartSettings.navigateTo_ProductPage("adizero Rush Shoes");
        csCartSettings.tab_VideoGallery.click();

        if ($$("tr[id*='ab__vg_video_extra']").size() == 1) {
            //Добавляем видео с YouTube
            $x("//input[@name='product_data[ab__vg_videos][1][pos]']").click();
            $x("//input[@name='product_data[ab__vg_videos][1][pos]']").setValue("10");
            $(By.name("product_data[ab__vg_videos][1][title]")).click();
            $(By.name("product_data[ab__vg_videos][1][title]")).setValue("Музыка, успокаивает нервную систему и радует душу");
            $("#ab__vg__video_path__1").click();
            $("#ab__vg__video_path__1").setValue("ayjzgSwtzbY");

            //Добавляем видео с Vimeo
            $("#add_ab__vg_video").click();
            $(By.name("product_data[ab__vg_videos][2][pos]")).click();
            $(By.name("product_data[ab__vg_videos][2][pos]")).setValue("20");
            $(By.name("product_data[ab__vg_videos][2][title]")).click();
            $(By.name("product_data[ab__vg_videos][2][title]")).setValue("Disney Channel/ABC Oscar");
            $(By.name("product_data[ab__vg_videos][2][type]")).click();
            $(By.name("product_data[ab__vg_videos][2][type]")).selectOption("Vimeo");
            $("#ab__vg__video_path__1_1").click();
            $("#ab__vg__video_path__1_1").setValue("154625007");

            //Добавляем видео типа "Ссылка"
            $("#add_ab__vg_video_1").click();
            $(By.name("product_data[ab__vg_videos][4][pos]")).click();
            $(By.name("product_data[ab__vg_videos][4][pos]")).setValue("30");
            $(By.name("product_data[ab__vg_videos][4][title]")).click();
            $(By.name("product_data[ab__vg_videos][4][title]")).setValue("Ego TV serial");
            $(By.name("product_data[ab__vg_videos][4][type]")).click();
            $(By.name("product_data[ab__vg_videos][4][type]")).selectOption("Ссылка");
            $("#ab__vg__video_path__1_1_2").click();
            $("#ab__vg__video_path__1_1_2").setValue("https://ashdi.vip/vod/91121");

            //Добавляем видео типа "Ресурс"
            $("#add_ab__vg_video_1_2").click();
            $(By.name("product_data[ab__vg_videos][7][pos]")).click();
            $(By.name("product_data[ab__vg_videos][7][pos]")).setValue("40");
            $(By.name("product_data[ab__vg_videos][7][title]")).click();
            $(By.name("product_data[ab__vg_videos][7][title]")).setValue("Fire Long name: Значение этой настройки будет напрямую встроено в код. Будьте внимательны, заполняя её значение");
            $(By.name("product_data[ab__vg_videos][7][type]")).click();
            $(By.name("product_data[ab__vg_videos][7][type]")).selectOption("Ресурс");
            $("#ab__vg__video_path__1_1_2_3").click();
            $("#ab__vg__video_path__1_1_2_3").setValue("https://unitheme.net/images/ut2_banner_videos/33_52_ABSTRACT.mp4");
        }

        //Переходим на витрину
        csCartSettings.navigateTo_StorefrontProductPage(1);
        //Проверяем, что вкладка "Видео галерея" присутствует на странице товара
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!$$("#ab__video_gallery").isEmpty(),
                "There is no tab 'Video gallery' on the product page!");
        //Проверяем, что во вкладке ровно 4 видео
        $("#ab__video_gallery").click();
        softAssert.assertTrue($$(".ab__vg-video").size() == 4,
                "There is no 4 videos on the tab 'Video gallery' on the product page!");
        Selenide.sleep(1500);
        screenshot("101 Videos are added on the product page");
        softAssert.assertAll();
        System.out.println("AddDifferentVideoToProductTest has passed successfully!");
    }
}