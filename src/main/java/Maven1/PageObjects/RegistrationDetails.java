package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;

public class RegistrationDetails extends Utils {
    LoadProp loadProp=new LoadProp();
    private By _femaleRadioButton=By.xpath("//input[@value='F']");
    private By _firstName=By.xpath("//input[@id='FirstName']");
    private By _lastName=By.xpath("//input[@name='LastName']");
    private By _dateOfBirthDayDropDown=By.xpath("//select[@name='DateOfBirthDay']");
    private By _dateOfBirthMonthDropDown=By.xpath("//select[@name='DateOfBirthMonth']");
    private By _dateOfBirthYearDropDown =By.xpath("//select[@name='DateOfBirthYear']");
    private By _email=By.id("Email");
    private By _companyName=By.xpath("//input[@name='Company']");
    private By _newsletter=By.xpath("//input[@id='Newsletter']");
    private By _password=By.xpath("//input[@id='Password']");
    private By _confirmPassword=By.xpath("//input[@id='ConfirmPassword']");
    private By _registerButton=By.xpath("//input[@id='register-button']");

    public void fillRegistrationDetails()
    {
        clickOnElement(_femaleRadioButton);
        enterText(_firstName,loadProp.getProperty("firstname"));
        enterText(_lastName,loadProp.getProperty("lastname"));
        selectByVisibleText(_dateOfBirthDayDropDown,loadProp.getProperty("dateofbirthday"));
        selectByVisibleText(_dateOfBirthMonthDropDown,loadProp.getProperty("dateofbirthmonth"));
        selectByValue(_dateOfBirthYearDropDown,loadProp.getProperty("dateofbirthyear"));
        email(_email,loadProp.getProperty("email"));
        enterText(_companyName,loadProp.getProperty("companyName"));
        clickOnElement(_newsletter);
        enterText(_password,loadProp.getProperty("password"));
        enterText(_confirmPassword,loadProp.getProperty("confirmpassword"));
        clickOnElement(_registerButton);
    }

    public void fillIncorrectDetails()
    {
        clickOnElement(_femaleRadioButton);
        enterText(_firstName,"");
        enterText(_lastName,loadProp.getProperty("lastname"));
        selectByVisibleText(_dateOfBirthDayDropDown,loadProp.getProperty("dateofbirthday"));
        selectByVisibleText(_dateOfBirthMonthDropDown,loadProp.getProperty("dateofbirthmonth"));
        selectByValue(_dateOfBirthYearDropDown,loadProp.getProperty("dateofbirthyear"));
        email(_email,loadProp.getProperty("email"));
        enterText(_companyName,loadProp.getProperty("companyName"));
        clickOnElement(_newsletter);
        enterText(_password,loadProp.getProperty("password"));
        enterText(_confirmPassword,loadProp.getProperty("confirmpassword"));
        clickOnElement(_registerButton);
    }

}
