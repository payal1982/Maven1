package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CameraAndPhotoPage extends Utils {
    LoadProp loadProp=new LoadProp();
    private By _appleIcamAddToCartButton=By.xpath("//div[@class='item-grid']/child::div[2]/child::div/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to cart']");
    private By _productAddedToCartConfirmationMessage=By.xpath("//div[@id='bar-notification']/p");
    private By _shoppingCartLink=By.xpath("//div[@id='bar-notification']/p/a");


    public void addAppleIcamToCart()
    {
        clickOnElement(_appleIcamAddToCartButton);
        //clicks on add to cart for Apple Icam
    }

    public void verifyProductHasBeenAddedToCart()
    {
        Assert.assertEquals(getTextFromElement(_productAddedToCartConfirmationMessage),loadProp.getProperty("productAddedToCartConfirmation"));
        //verifies the green bar on the top as a confirmation that the product has been added to the cart
    }

    public void clickOnShoppingCartInNotificationBar()
    {
        clickOnElement(_shoppingCartLink);//clicks on the shopping cart iin the green bar
    }

}
