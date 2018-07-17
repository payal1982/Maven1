package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GuestCheckoutCompleted extends Utils {

    LoadProp loadProp=new LoadProp();
    private By _orderSuccessfullMessage= By.xpath(
            "//div[@class='master-wrapper-page']/child::div[3]/child::div/child::div/child::" +
                    "div/child::div[2]/child::div/child::div/strong");
    private By _continueButtonAfterOrderSuccessfullMessage=By.xpath("//div[@class='buttons']/input");

    public void verifyThatTheUserHasCheckedOutSuccessfullyAsAGuest()
    {
        Assert.assertEquals(getTextFromElement(_orderSuccessfullMessage),
                loadProp.getProperty("guestcheckoutsucccessfullmessage"));
        //verifies that the message order placed successfully is displayed
        Assert.assertEquals(true,isElementPresent(_continueButtonAfterOrderSuccessfullMessage));
        //verifies that continue button is displayed after successful placement of order
        Assert.assertEquals(driver.getCurrentUrl(),loadProp.getProperty("urlonsuccessfullplacedorder"));
        //verifies the current url
    }
}
