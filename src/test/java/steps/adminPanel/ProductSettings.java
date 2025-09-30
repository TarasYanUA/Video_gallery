package steps.adminPanel;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.webdriver;

public class ProductSettings implements CheckMenuToBeActive {
    SelenideElement tab_VideoGallery = $(By.id("ab__video_gallery"));
    SelenideElement productTemplate = $(By.id("elm_details_layout"));
    SelenideElement gearWheelOnTop = $(".dropdown-icon--tools");
    SelenideElement button_Preview = $x("//a[contains(text(), 'Предпросмотр')]");
    SelenideElement setting_SetVideoAsDefaultProductImage = $(By.id("ab__vg__replace_image"));
    SelenideElement button_SaveProduct = $(".cm-product-save-buttons");


    public void navigateToProductTab_AbVideoGallery() {
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        tab_VideoGallery.click();
    }

    public void navigateTo_StorefrontProductPage() {
        Selenide.sleep(1500);
        gearWheelOnTop.click();
        button_Preview.click();
        List<String> tabs = new ArrayList<>(Selenide.webdriver().object().getWindowHandles());
        Selenide.switchTo().window(tabs.get(1));
        Utils.waitForElementAndClick(By.cssSelector(".cm-btn-success"));
    }

    public void setTemplateForProduct(String templateName) {
        productTemplate.selectOptionByValue(templateName);
        button_SaveProduct.click();
    }

    public void selectRandomProductTemplate() {
        // Получаем все доступные опции
        SelenideElement selectElement = $(By.id("elm_details_layout"));
        ElementsCollection templateValues = selectElement.$$("option");

        // Заполняем список, исключая опции с текстом, содержащим "Родительское"
        List<String> listOfValues = new ArrayList<>();
        for (SelenideElement option : templateValues) {
            String optionText = option.getText().toLowerCase();
            String optionValue = option.getValue();
            if (!optionText.contains("родительское") && !optionText.contains("─────────────"))
                listOfValues.add(optionValue);
        }

        // Выбор случайного элемента
        Random random = new Random();
        int randomIndex = random.nextInt(listOfValues.size());
        String randomValue = listOfValues.get(randomIndex);
        System.out.println("Случайно выбранный шаблон: " + randomValue);

        // Выбор опции по значению
        selectElement.selectOptionByValue(randomValue);
    }

    public void enableSetting_SetVideoAsDefaultProductImage(String action) {
        boolean shouldEnable = action.equalsIgnoreCase("Активируем");
        boolean isCurrentlySelected = setting_SetVideoAsDefaultProductImage.isSelected();

        if (shouldEnable != isCurrentlySelected)
            setting_SetVideoAsDefaultProductImage.click();
    }

    public void toggleSettingInTab_AbVideoGallery(String action, String settingName, String videoType) {
        SelenideElement checkbox = $x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@id, '" + settingName + "')]");

        boolean shouldEnable = action.equalsIgnoreCase("Активируем");
        boolean isCurrentlySelected = checkbox.isSelected();

        if (shouldEnable != isCurrentlySelected)
            checkbox.click();
    }

    public void selectValueForSetting_IconType(String iconType, String videoType) {
        $x("//option[@selected='' and text()='" +
                videoType + "']/../../../..//input[contains(@name, 'product_data[ab__vg_videos]')][@value='" + iconType + "']").click();
    }

    public void addImageForVideo(String image) {
        $("div[id^='link_container_'] a[id^='url_']").click();
        Alert alert = webdriver().driver().switchTo().alert();
        sleep(1500);
        alert.sendKeys(image);
        alert.accept();
    }
}