package com.example.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
                 tags="@SmokeScenario",
                 monochrome = true,
                 plugin={"pretty","html:target/HtmlReport"},
                 glue={"com.example.cucumber"} // Useful when runner class is in different folder
                 )

public class cucumberexample {
}
