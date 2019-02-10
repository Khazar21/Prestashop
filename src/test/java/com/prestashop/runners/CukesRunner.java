package com.prestashop.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/prestashop/step_definitions",
        dryRun = false,
        tags = "@signIn"
)
public class CukesRunner {
}
