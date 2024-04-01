package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Login.feature",
        glue = {"steps", "utility"},
        tags = "@sl_1 or @sl_2 or @sl_3"
)
public class TestRunner {

}
