package Maven1.PageObjects;

import Maven1.Utils;
import org.openqa.selenium.By;

public class JewelleryPage extends Utils {

    private By _addToCartButtonForFlowewrGirlBracelet=By.xpath("//div[@data-productid='41']/div[2]/div[3]/div[2]/input[@value='Add to cart']");
    private By _notificationBar=By.xpath("//div[@id='bar-notification']");
    private By _addToCartButtonForVintageStyleEngagementRing=By.xpath("//div[@data-productid='42']/div[2]/div[3]/div[2]/input[@value='Add to cart']");
    private By _shoppingCartLinkInGreenNotificatioBar=By.xpath("//a[text()='shopping cart']");

    public void add1stProductToCart()
    {
        clickOnElement(_addToCartButtonForFlowewrGirlBracelet);//selects Flower girls bracelet to add to the cart
        waitForVisibilityOfElementLocated(_notificationBar,20);//wait for the green bar on the top to be visible
        waitForInvisibilityOfElementsLocated(_notificationBar,20);//waits for green bar on the top to be invisible
    }
    public void add2ndProductToCart()
    {
        clickOnElement(_addToCartButtonForVintageStyleEngagementRing);
        //selects Vintage style engagement ring to add to the cart
        waitForVisibilityOfElementLocated(_notificationBar,20);//wait for the green bar on the top to be visible

    }

    public void clickOnShoppingCart()
    {
        clickOnElement(_shoppingCartLinkInGreenNotificatioBar);//clicks on shopping cart
    }
}
