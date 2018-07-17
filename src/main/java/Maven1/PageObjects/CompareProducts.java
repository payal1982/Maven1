package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CompareProducts extends Utils {
    LoadProp loadProp=new LoadProp();

    private By _compareText=By.xpath("//h1[text()='Compare products']");
    private By _clearListButton=By.xpath("//a[text()='Clear list']");
    private By _comparelistClearedMessage=By.xpath("//div[@class='no-data']");

    public void verifyProductsAddedToCompareList()
    {
                Assert.assertEquals(getTextFromElement(_compareText),loadProp.getProperty("compareproductsmessage"));
                //verify that both the products are visible in the comparision list
    }

    public void verifyProductCompareListIsCleared()
    {
        clickOnElement(_clearListButton);//clicks on clear list
        Assert.assertEquals(getTextFromElement(_comparelistClearedMessage),loadProp.getProperty("compareListClearMessage"));
        //verify that the compare list is empty
    }

}
