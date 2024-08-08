package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UniThemeSettings {
    public UniThemeSettings() {super();}

    SelenideElement tab_Product = $(By.id("products"));
    SelenideElement setting_NumberOfDisplayedImagesOfProductGallery_BigPicture = $(By.id("settings.abt__ut2.products.bigpicture_template.multiple_product_images.desktop"));
    SelenideElement button_Save = $(".btn.btn-primary.cm-submit");

    @And("Настройки темы UniTheme: Товар -- Настройка для шаблона карточки товара `Большая картинка` -- {string}")
    public void themeSetting_BigPicture_NumberOfDisplayedImages(String value) {
        tab_Product.click();
        setting_NumberOfDisplayedImagesOfProductGallery_BigPicture.selectOption(value);
        button_Save.click();
    }
}
