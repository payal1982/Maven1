package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class VirtualGiftCardEmailAFriendDetails extends Utils {

    LoadProp loadProp=new LoadProp();
    private By _friendsemailfield= By.id("FriendEmail");
    private By _yourEmailAddressField=By.id("YourEmailAddress");
    private By _personalMessageField=By.id("PersonalMessage");
    private By _sendEmailButton=By.xpath("//input[@name='send-email']");
    private By _errorMessageForUnregisteredUsersText=By.xpath("//div[@class='center-1']/div/div[2]/form/div/ul");
    private By _mailSentSuccessfullMessage=By.xpath("//div[@class='result']");


    public void fillInFriendsEmail()
    {
        email(_friendsemailfield,"Deep");//enters friends email
    }
    public void fillInYourEmailField()
    {
        email(_yourEmailAddressField,"Payal");//enters email address of the user
    }
    public void fillInPersonalMessage()
    {
        enterText(_personalMessageField,"Enjoy the Gift Card!!");//enters personal message
    }
    public void sendEmail()
    {
        clickOnElement(_sendEmailButton);//clicks on send email button
    }
    public void verifyThatUnregiteredUsersCannotUseEmailAFriendFeature()
    {
        Assert.assertEquals(getTextFromElement(_errorMessageForUnregisteredUsersText),
                loadProp.getProperty("unregisteredUsersEmailAFriendErrorMessage"));
        //verifies that error message is displayed if unregistered users tries to use email a friend feature
    }
    public void verifyRegisterdUsersCanSendMailToFriend()
    {
        waitForVisibilityOfElementLocated(_mailSentSuccessfullMessage,20);
        Assert.assertEquals(getTextFromElement(_mailSentSuccessfullMessage),"Your message has been sent.");
    }
}
