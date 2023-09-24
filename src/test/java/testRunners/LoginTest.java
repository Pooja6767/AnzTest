package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/Features/UserRegistrationAndShoppingCart.feature"},
		glue= {"StepDefination"},
		plugin= {"pretty",
				"json:target/MyReports/report.json",
				"junit:target/MyReports/report.xml"
				},
		
		publish =true,
		monochrome=true
		)

public class LoginTest {



}
