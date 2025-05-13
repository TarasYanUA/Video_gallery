package steps.adminPanel;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;

import static com.codeborne.selenide.Selenide.$;

public class VideoGallerySettings {
    public VideoGallerySettings(){super();}

    SelenideElement setting_EnableVerticalOutput = $("input[id*='addon_option_ab__video_gallery_vertical_']");
    SelenideElement button_SaveSettings = $(".cm-addons-save-settings");

    @And("{string} настройку модуля: Включить вертикальное отображение")
    public void enableHorizontalView(String action) {
        boolean shouldEnable = action.equalsIgnoreCase("Активируем");
        boolean isCurrentlySelected = setting_EnableVerticalOutput.isSelected();

        if (shouldEnable != isCurrentlySelected)
            setting_EnableVerticalOutput.click();

        button_SaveSettings.click();
    }
}