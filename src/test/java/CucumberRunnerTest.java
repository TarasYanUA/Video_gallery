import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps"},
        tags = "@10",   // or @20 or @30 or @40 or @50
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}