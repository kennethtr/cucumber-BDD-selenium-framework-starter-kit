package demosite.glue;

import demosite.impl.TestStepsImpl;
import demosite.service.TestStepsService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepsGlue {

    TestStepsService testStepsServices = new TestStepsImpl();


    @Given("^user logs in with username \"([^\"]*)\" and \"([^\"]*)\" logs in to demo site$")
    public void loginToDemoSite(String username, String password) {
        testStepsServices.login(username, password);
    }

    @When("^user adds a student on Student Details page$")
    public void clickAddStudent() {
        testStepsServices.addNewStudent();
    }

    @When("^user sees the Enter Student Details page$")
    public void verifyStudentDetailsPage() {
        testStepsServices.verifyEnterStudentDetailsPage();
    }

}
