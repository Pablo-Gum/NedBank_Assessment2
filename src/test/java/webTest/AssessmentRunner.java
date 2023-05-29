package webTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(value= Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Assessment.feature",
        tags = "@run1 or @run2 or @run3",
        glue = {"stepDefinitions"}
)
public class AssessmentRunner {
}
