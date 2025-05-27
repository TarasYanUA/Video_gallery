package steps.storefront;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hooks.CollectAssertMessages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class AssertsOnStorefront {
    public AssertsOnStorefront() {
        super();
    }

    SoftAssert softAssert = CollectAssertMessages.getSoftAsserts();

    SelenideElement tab_VideoGallery = $(By.id("ab__video_gallery"));
    ElementsCollection videoQuantity = $$(".ab__vg-video");
    SelenideElement videoWithAutoplay = $(".ab__vg-image_gallery_video-autoplay");
    SelenideElement youtubeVideoInTheTab = $(".ab__video_gallery-block img[alt='Музыка, успокаивает нервную систему и радует душу']");
    SelenideElement videoWithAutoplay_CategoryPage = $(".ab__vg-product_list-video .ab__vg-image_gallery_video-autoplay");
    SelenideElement videoIsMainImageOfProduct = $(".ab_vg-replace_image");
    SelenideElement videoWithAutoplay_withHover = $(".ab__vg-product_list-video.hover_image");


    @And("Выполняем проверки на витрине:")
    public void assertsOnProductPage(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> row : rows) {
            String setting = row.get(0); // Ключ (название настройки)
            String value = row.get(1);   // Значение настройки

            switch (setting) {
                case "Вкладка 'Видео галерея' присутствует":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertTrue(tab_VideoGallery.exists(),
                                "There is no tab 'Video gallery' on the product page!");
                    } else {
                        softAssert.assertFalse(tab_VideoGallery.exists(),
                                "There is a tab 'Video gallery' but shouldn't on the product page!");
                    }
                    break;

                case "Количество видео во вкладке товара равно":
                    tab_VideoGallery.scrollIntoCenter().click();
                    softAssert.assertEquals(videoQuantity.size(), Integer.parseInt(value),
                            "Quantity of videos on the tab 'Video gallery' on the product page is not equal to " + value);
                    break;

                case "Видео с автовоспроизведением присутствует среди мини-иконок":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertTrue(videoWithAutoplay.exists(),
                                "There is no video with autoplay at mini-icons gallery!");
                    } else {
                        softAssert.assertFalse(videoWithAutoplay.exists(),
                                "There is a video with autoplay in the mini-icons gallery but shouldn't!");
                    }
                    break;

                case "Youtube видео с автовоспроизведением присутствует во вкладке товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertTrue(youtubeVideoInTheTab.exists(),
                                "There is no Youtube video with autoplay in the product tab!");
                    }
                    else {
                        softAssert.assertFalse(youtubeVideoInTheTab.exists(),
                                "There is a Youtube video with autoplay in the product tab but shouldn't!");
                    }
                    break;

                case "Видео автовоспроизводится на странице категории":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertTrue(videoWithAutoplay_CategoryPage.exists(),
                                "Video is not shown with autoplay in the product list!");
                    } else {
                        softAssert.assertFalse(videoWithAutoplay_CategoryPage.exists(),
                                "Video is shown with autoplay in the product list but shouldn't!");
                    }
                    break;

                case "Видео является главным изображением товара":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertTrue(videoIsMainImageOfProduct.exists(),
                                "Video is not the main image of the product on the product page!");
                    } else {
                        softAssert.assertFalse(videoIsMainImageOfProduct.exists(),
                                "Video is the main image of the product but shouldn't on the product page!");
                    }
                    break;

                case "Видео автовоспроизводится при наведении мыши на странице категории":
                    if (value.equalsIgnoreCase("y")) {
                        softAssert.assertTrue(videoWithAutoplay_withHover.exists(),
                                "Video does not play when hovering a mouse pointer in the product list!");
                    } else {
                        softAssert.assertFalse(videoWithAutoplay_withHover.exists(),
                                "Video plays when hovering a mouse pointer but shouldn't in the product list!");
                    }
                    break;

                default:
                    System.out.println("Неизвестная проверка: " + setting);
                    break;
            }
        }
    }
}