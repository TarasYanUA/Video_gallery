package steps.adminPanel;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSettingsSteps {
    ProductSettings productSettings = new ProductSettings();

    @When("Переходим во вкладку АВ: Видео галерея")
    public void navigateToProductTab_AbVideoGallery() {
        productSettings.navigateToProductTab_AbVideoGallery();
    }

    @And("Переходим на витрину страницы товара")
    public void navigateTo_StorefrontProductPage() {
        productSettings.navigateTo_StorefrontProductPage();
    }

    @And("Устанавливаем товару шаблон {string}")
    public void setTemplateForProduct(String templateName) {
        productSettings.setTemplateForProduct(templateName);
    }

    @And("Устанавливаем произвольный шаблон страницы товара")
    public void selectRandomProductTemplate() {
        productSettings.selectRandomProductTemplate();
    }

    @When("{string} настройку: Установить видео как изображение товара по умолчанию")
    public void enableSetting_SetVideoAsDefaultProductImage(String action) {
        productSettings.enableSetting_SetVideoAsDefaultProductImage(action);
    }

    @When("{string} настройку {string} для видео с типом {string}")
    public void toggleSettingInTab_AbVideoGallery(String action, String settingName, String videoType) {
        productSettings.toggleSettingInTab_AbVideoGallery(action, settingName, videoType);
    }

    @When("У настройки `Тип иконки` выбираем значение {string} для видео с типом {string}")
    public void selectValueForSetting_IconType(String iconType, String videoType) {
        productSettings.selectValueForSetting_IconType(iconType, videoType);
    }

    @And("Добавляем изображение для видео")
    public void addImageForVideo() {
        productSettings.addImageForVideo("https://i.artfile.ru/1920x1080_1704830_[www.ArtFile.ru].jpg");
    }

    @Then("Сохраняем страницу товара")
    public void saveProductPage() {
        productSettings.button_SaveProduct.click();
        Selenide.sleep(2000);
    }
}