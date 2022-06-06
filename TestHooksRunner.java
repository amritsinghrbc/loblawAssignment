package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/TestHooks.feature",glue= {"StepDefinations"},
        monochrome = true,plugin = {"pretty", "html:results.html"})
public class TestHooksRunner {

}
