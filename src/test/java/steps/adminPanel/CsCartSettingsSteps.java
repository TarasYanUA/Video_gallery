package steps.adminPanel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CsCartSettingsSteps {

    public CsCartSettingsSteps() {super();}

    CsCartSettings csCartSettings = new CsCartSettings();

    @When("Переходим на страницу редактирования товара")
    public void navigateTo_ProductPage() {
        csCartSettings.navigateTo_ProductPage();
    }

    @When("Переходим во вкладку АВ: Видео галерея")
    public void navigateToProductTab_AbVideoGallery() {
        csCartSettings.navigateToProductTab_AbVideoGallery();
    }

    @And("Переходим на витрину страницы товара")
    public void navigateTo_StorefrontProductPage() {
        csCartSettings.navigateTo_StorefrontProductPage();
    }

    @And("Устанавливаем товару шаблон {string}")
    public void setTemplateForProduct(String templateName) {
        csCartSettings.setTemplateForProduct(templateName);
    }

    @And("Устанавливаем произвольный шаблон страницы товара")
    public void selectRandomProductTemplate() {
        csCartSettings.selectRandomProductTemplate();
    }

    @When("Активируем настройку: Установить видео как изображение товара по умолчанию")
    public void enableSetting_SetVideoAsDefaultProductImage() {
        csCartSettings.enableSetting_SetVideoAsDefaultProductImage();
    }

    @When("{string} настройку {string} для видео с типом {string}")
    public void toggleSettingInTab_AbVideoGallery(String action, String settingName, String videoType) {
        csCartSettings.toggleSettingInTab_AbVideoGallery(action, settingName, videoType);
    }

    @When("У настройки `Тип иконки` выбираем значение {string} для видео с типом {string}")
    public void selectValueForSetting_IconType(String iconType, String videoType) {
        csCartSettings.selectValueForSetting_IconType(iconType, videoType);
    }

    @And("Добавляем изображение для видео")
    public void addImageForVideo() {
        csCartSettings.addImageForVideo("https://i.artfile.ru/1920x1080_1704830_[www.ArtFile.ru].jpg");
    }

    @And("Сохраняем страницу товара")
    public void saveProductPage() {
        csCartSettings.saveProductPage();
    }

    @And("Переходим в настройки модуля")
    public void navigateTo_VideoGallerySettings() {
        csCartSettings.navigateTo_VideoGallerySettings();
    }

    @And("Переходим на страницу настроек темы UniTheme")
    public UniThemeSettings navigateTo_UniThemeSettings() {
        return csCartSettings.navigateTo_UniThemeSettings();
    }

    @And("CS-Cart настройки: Показывать мини-иконки {string} галереи, Показывать информацию о товаре {string} вкладок, Включить быстрый просмотр")
    public void setCsCartSettings_WithOrWithoutOptions(String galleryOption, String tabsOption) {
        csCartSettings.setCsCartSettings_WithOrWithoutOptions(galleryOption, tabsOption);
    }
}