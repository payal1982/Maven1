package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResult extends Utils {
LoadProp loadProp=new LoadProp();
private By _registrationText=By.xpath("//div[@class='result']");
private By _continueButtonAfterRegistrationComplete=By.xpath("//input[@name='register-continue']");

    public void confirmRegistration()
{
    Assert.assertEquals(getTextFromElement(_registrationText),loadProp.getProperty("registrationresult"));
}
    public void wrongMessage()
    {
        Assert.assertEquals(getTextFromElement(_registrationText),"You regist complete");
    }
    public void clickOnContinue()
    {
        clickOnElement(_continueButtonAfterRegistrationComplete);//clicks on continue after registration
    }
}

