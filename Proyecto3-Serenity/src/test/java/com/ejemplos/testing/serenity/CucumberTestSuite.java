package com.ejemplos.testing.serenity;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin =  {
                "pretty", "html:target/serenity-reports//serenity-html-report",
                "json:target/serenity-reports/cucumber_report.json",
                "rerun:target/serenity-reports/rerun.txt"
        },
        features = "src/test/resources/features"
        //Si solo quisieramos usar un escenario concreto, podemos usar
        //features = "src/test/resources/features/search/search_by_keyword.feature"
)
public class CucumberTestSuite {}
