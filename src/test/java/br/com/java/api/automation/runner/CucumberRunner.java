package br.com.java.api.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
	dryRun = false,
	features = "src/test/resources/features/api",
	glue =
	{
		"br.com.java.api.automation.runner",
		"br.com.java.api.automation.step.definition"
	},
	monochrome = true,
	plugin =
	{
        "html:target/cucumber-reports/cucumber.html",
        // -Dcucumber.options="(replace this for 2 hyphens)plugin io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        // Execution command Cucumber Maven, the same thing below in this class...
		"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
		"pretty",
        "rerun:target/cucumber-reports/rerun.txt",
		"summary"
	},
	snippets = SnippetType.CAMELCASE,
	stepNotifications = true,
	strict = true
)
public class CucumberRunner {
}