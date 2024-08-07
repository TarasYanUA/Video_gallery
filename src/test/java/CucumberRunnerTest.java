import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps"},
        tags = "@70_Autoplay_Everywhere",   //@10_AddVideo or @20_Gallery01 or @30_Gallery02 or @40_NoGallery01 or @50_NoGallery02 or @60_Autoplay_NoProductList or @70_Autoplay_Everywhere
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"}
)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}