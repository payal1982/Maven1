package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class JewelleryShoppingCart extends Utils {

    LoadProp loadProp=new LoadProp();
    private By _itemQuantityField=By.xpath("//tbody/tr/td[6]/input");
    private By _QuantityChange=By.xpath("//tbody/tr/child::td[6]/input");
    private By _updateCartButton=By.xpath("//div[@class='common-buttons']/input[@name='updatecart']");
    private By _checkOutButton=By.id("checkout");
    private By _termsOfServiceCheckBox=By.xpath("//div[@id='terms-of-service-warning-box']/p");
    private By _closeTermsOfServiceBox=By.xpath("//button[@title='close']");
    private By _acceptTermsOfServiceSelectionBox =By.id("termsofservice");


    public void cleadDataFromQuantityFieldAndUpdateQuantityTo2()
    {
        clearDataFromElement(_itemQuantityField);//clears the quantity field
        enterText(_QuantityChange,"2");//enter quantity 2
    }
    public void updateShoppingcart()
    {
        clickOnElement(_updateCartButton);//clicks on update cart button
    }
    public void clickOnCheckout()
    {
        clickOnElement(_checkOutButton);//clicks on the check out button
    }
    public void verifyThatWindowIsDispalyedToInformUserToCheckTheTermsAndServices()
    {
        Assert.assertEquals(getTextFromElement(_termsOfServiceCheckBox),loadProp.getProperty("termsOfServiceMessage"));
        //verifying that the alert pops up if we do not accept the terms of service before checking out
    }
    public void closetermsOfSericeCheckBox()
    {
        clickOnElement(_closeTermsOfServiceBox);//closes the terms of service box
    }
    public void acceptTermsOfService()
    {
        clickOnElement(_acceptTermsOfServiceSelectionBox);//selects the terms of service checkbox
    }

}
