package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils
{
    LoadProp loadProp=new LoadProp();
    private By _registerbutton=By.xpath("//a[text()='Register']");
    private By _buildYourownComputerAddToCompareButton =By.xpath("//div[@data-productid='1']/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to compare list']");
    private By _notificationBar=By.xpath("//div[@id='bar-notification']");
    private By _virtualGiftCardAddToCompareButton =By.xpath("//div[@data-productid='43']/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to compare list']");
    private By _productComparisionLink=By.xpath("//a[contains(text(),'product comparison')]");
    private By _booksLinkHeaderMenu=By.xpath("//div[@class='header-menu']//ul[@class='top-menu']/li[5]/a[contains(text(),'Books')]");
    private By _electronicsLinkHeaderMenu=By.xpath("//div[@class='header-menu']/child::ul[1]/li[2]");
    private By _jewelleryLinkHeaderMenu=By.xpath("//div[@class='header-menu']/ul[1]/child::li[6]/a[contains(text(),'Jewelry')]");
    private By _currencySelectorDropDownMenu=By.id("customerCurrency");
    private By _currencySymbolAfterChange=By.xpath("//div[@data-productid='1']/div[2]/div[3]/div/span");
    private By _virtualGiftCardPicture=By.xpath("//div[@data-productid='43']/div/a");

    public void clickOnRegister()

    {
        clickOnElement(_registerbutton);
    }

    public void addTwoProductsToTheCart()
    {
        clickOnElement(_buildYourownComputerAddToCompareButton);//1st product added to compare list
        waitForVisibilityOfElementLocated(_notificationBar,20);//waiting for the visibility of the green bar on the top
        waitForInvisibilityOfElementsLocated(_notificationBar,20);//waiting for the invisibility of the green bar on the top
        clickOnElement(_virtualGiftCardAddToCompareButton);//2nd product added to compare list
        waitForVisibilityOfElementLocated(_notificationBar,20);//waiting for the visibility of the green bar on the top
        clickOnElement(_productComparisionLink);//clicks on the product comparision list
    }
    public void selectBooks()
    {
        clickOnElement(_booksLinkHeaderMenu);
        //clicks on books in the top bar
    }

    public void clickOnElectronicsInHeaderMenu()
    {
        clickOnElement(_electronicsLinkHeaderMenu);//clicks on electronics from the header menu
    }
    public void clickOnJewellery()
    {
        clickOnElement(_jewelleryLinkHeaderMenu);//selects Jewelery from top menu
    }
    public void changeCurrencyFromDollarToEuro()
    {
        selectByVisibleText(_currencySelectorDropDownMenu,loadProp.getProperty("currencyChangeTo"));//selects Euro as currency
    }

    public void verifyThatTheCurrencyHasChangedFromDollarToEuro()
    {
        Assert.assertTrue(getTextFromElement(_currencySymbolAfterChange).contains("€"),loadProp.getProperty("selectedCurrencySymbol"));
        //verifies that the price is changed to euro
    }
    public void selectGiftCard()
    {
        clickOnElement(_virtualGiftCardPicture);//selects virtual gift card

    }
}

