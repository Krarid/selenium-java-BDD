package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				plugin = {"pretty", "html:target/report/bug_report.html", "json:target/report/cucu_json_bug_report.json", "junit:target/report/cucumber_junit_bug_report.xml"},
				features = {"@target/report/failed.txt"},
				glue = {"steps"}
				)
public class FailedRunner extends AbstractTestNGCucumberTests {

}