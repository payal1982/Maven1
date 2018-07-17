package Maven1.PageObjects;

import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartAppleIcam extends Utils {

    private By _appleIcamName=By.xpath("//table[@class='cart']/tbody/tr/child::td[4]/a");


    public void vefiryTheProductIsInTheShoppingcart()
    {
        Assert.assertEquals(getTextFromElement(_appleIcamName),"Apple iCam");
        //verify that the selected product is added in the shopping cart
    }
}
