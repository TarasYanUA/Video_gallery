package steps.adminPanel;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class AddDifferentVideosToProduct {
    @And("Добавляем разные виды видео товару")
    public void addDifferentVideosToProduct() {
        CsCartSettings csCartSettings = new CsCartSettings();
        csCartSettings.tab_VideoGallery.click();

        if ($$("tr[id*='ab__vg_video_extra']").size() == 1) {
            //Добавляем видео с YouTube
            $x("//input[@name='product_data[ab__vg_videos][1][pos]']").setValue("10");
            $(By.name("product_data[ab__vg_videos][1][title]")).setValue("Музыка, успокаивает нервную систему и радует душу");
            $("#ab__vg__video_path__1").setValue("ayjzgSwtzbY");

            //Добавляем видео с Vimeo
            $("#box_add_ab__vg_video .btn-add").click();
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[pos]')])[2]").setValue("20");
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[title]')])[2]").setValue("Disney Channel/ABC Oscar");
            $x("(//select[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[type]')])[2]").selectOption("Vimeo");
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[video_path]')])[2]").setValue("154625007");

            //Добавляем видео типа "Ссылка"
            $x("(//tbody[contains(@id, 'box_add_ab__vg_video_')]//a[@class='btn btn-add'])[1]").click();
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[pos]')])[3]").setValue("30");
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[title]')])[3]").setValue("Ego TV serial");
            $x("(//select[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[type]')])[3]").selectOption("Ссылка");
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[video_path]')])[3]")
                    .setValue("https://ashdi.vip/vod/91121");

            //Добавляем видео типа "Ресурс"
            $x("(//tbody[contains(@id, 'box_add_ab__vg_video_')]//a[@class='btn btn-add'])[2]").click();
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[pos]')])[4]").setValue("40");
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[title]')])[4]")
                    .setValue("Fire Long name: Значение этой настройки будет напрямую встроено в код. Будьте внимательны, заполняя её значение");
            $x("(//select[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[type]')])[4]").selectOption("Ресурс");
            $x("(//input[contains(@name, 'product_data[ab__vg_videos]')][contains(@name, '[video_path]')])[4]")
                    .setValue("https://unitheme.net/images/ut2_banner_videos/33_52_ABSTRACT.mp4");
        }
    }
}