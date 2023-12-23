package com.charlies.Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/Features",glue="com.charlies.stepdefinations",
tags="Regression")
public class TestRunner extends AbstractTestNGCucumberTests {
}
