package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;

import static com.codeborne.selenide.Selenide.$;

public class VideoGallerySettings {
    public VideoGallerySettings(){super();}

    SelenideElement setting_EnableVerticalOutput = $("input[id*='addon_option_ab__video_gallery_vertical_']");
    SelenideElement button_SaveSettings = $(".cm-addons-save-settings");

    @And("Настройки модуля: Включить вертикальное отображение")
    public void enableVerticalView() {
        if(!setting_EnableVerticalOutput.isSelected()) {
            setting_EnableVerticalOutput.click();
            button_SaveSettings.click();
        }
    }

    @And("Настройки модуля: Включить горизонтальное отображение")
    public void enableHorizontalView() {
        if(setting_EnableVerticalOutput.isSelected()) {
            setting_EnableVerticalOutput.click();
            button_SaveSettings.click();
        }
    }
}