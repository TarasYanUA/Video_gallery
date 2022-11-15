import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Horizontal_TemplatesOfProductPageTest extends TestRunner {
    public void navigateToProductPage() {
        $x("//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']").hover();
        $x("//span[text()='Товары']").click();
        $("#bp_off_bottom_panel").click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), 'Toshiba BDX2150')]").click();
    }

    @Test
    public void checkBigPictureFlatTemplateOfProductPage() {
        $("#elm_menu_addons").hover();
        $("#elm_menu_addons_manage_addons").click();
        $("#addon_ab__video_gallery").$(".nowrap.inline-block-basic").click();
        $x("//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'selected_section=settings')]").click();
        $("#bp_off_bottom_panel").click();
        if ($x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]").equals(Condition.checked)) {
            $x("//input[contains(@id, 'addon_option_ab__video_gallery_vertical')]").click();
        }
    }
}
