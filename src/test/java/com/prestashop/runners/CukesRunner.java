package com.prestashop.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/homepage_search.feature",
        glue = "com/prestashop/step_definitions"
)


public class CukesRunner {
}
