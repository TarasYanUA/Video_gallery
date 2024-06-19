package adminPanel;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class VideoGallerySettings {
    public VideoGallerySettings(){super();}

    public SelenideElement setting_EnableVerticalOutput = $(By.id("addon_option_ab__video_gallery_vertical_6052"));
    public SelenideElement button_SaveSettings = $(".cm-addons-save-settings");
}
