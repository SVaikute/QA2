package CucumberStepDefinitions;

import cucumber.api.java.en.Given;

public class StepDefs {
    @Given("Print test annotation(.*)")
    public void print_test_annotation(String annotation) {
        System.out.println(annotation);
    }

}
