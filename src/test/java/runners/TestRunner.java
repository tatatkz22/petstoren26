package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/Pet.feature",
    glue = {"stepdefs"},
    plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
)
public class TestRunner {

    private static ExtentReports extent;
//printing the report using extent Reports
    @BeforeClass
    public static void setup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterClass
    public static void teardown() {
        if (extent != null) {
            extent.flush();
        }
    }
}
