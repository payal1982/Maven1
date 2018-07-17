package Maven1.PageObjects;

import Maven1.Utils;
import org.openqa.selenium.By;

public class CheckOutAsGuestPage extends Utils {

    private By _checkOutAsGuestButton=By.xpath("//input[@value='Checkout as Guest']");

    public void checkOutAsGuest()
    {
        waitForVisibilityOfElementLocated(_checkOutAsGuestButton,20);//waits for another page to be loaded
        clickOnElement(_checkOutAsGuestButton);//selects the option check out as guest
    }


}
