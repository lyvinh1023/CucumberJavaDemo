package steps;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "steps" }, monochrome = true,
tags = "@smoke",
plugin = {"pretty", "html:target/report.html", "json:target/report.json", "junit:target/report.xml"})
public class TestRunner {
}
