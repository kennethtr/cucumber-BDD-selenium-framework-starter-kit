package demosite.impl;

import demosite.service.TestStepsService;
import demosite.ui.common.CommonURLauncher;
import demosite.ui.config.WebDriverFactory;

import demosite.ui.pages.studentdetails.DemoSiteLoginPageWeb;
import demosite.ui.pages.studentdetails.AddStudentPageWeb;
import demosite.ui.pages.studentdetails.EnterStudentDetailsPageWeb;
import org.openqa.selenium.WebDriver;

public class TestStepsImpl implements TestStepsService {

    public WebDriver webDriver = WebDriverFactory.webDriver;

    DemoSiteLoginPageWeb demoSiteLoginPageWeb = new DemoSiteLoginPageWeb(webDriver);
    AddStudentPageWeb addStudentPageWeb = new AddStudentPageWeb(webDriver);
    EnterStudentDetailsPageWeb enterStudentDetailsPageWeb = new EnterStudentDetailsPageWeb(webDriver);
    CommonURLauncher commonURLauncher = new CommonURLauncher(webDriver);


    public void login(String username, String password) {
        commonURLauncher.launchURL();
        demoSiteLoginPageWeb.login(username, password);
    }

    public void addNewStudent()
    {
        addStudentPageWeb.addStudent();
    }

    public void verifyEnterStudentDetailsPage()
    {
        enterStudentDetailsPageWeb.verifyEnterStudentDetailsPage();
    }

}