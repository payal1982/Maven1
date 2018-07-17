package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BooksPage extends Utils {

    LoadProp loadProp=new LoadProp();
    private By _sortByDropDown=By.xpath("//select[@id='products-orderby']");
    private By _displayDropDown =By.xpath("//select[@id='products-pagesize']");
    private By _priceOfBook1=By.xpath("//div[@data-productid='39']/child::div[2]/child::div[3]/child::div/span[@class='price actual-price']");
    private By _priceOFBook2=By.xpath("//div[@data-productid='38']/child::div[2]/child::div[3]/child::div/span[@class='price actual-price']");

    public void sortInAscendingOrderOfPrice() {
        sortByVisibleText(_sortByDropDown, loadProp.getProperty("bookssortbyprice"));//sorts the books in the ascending order of price from drop down menu

    }
    public void selectNumberOfBooksTRoBeDisplayed()
    {
        display(_displayDropDown, loadProp.getProperty("displaybooks"));//selects the option to display 3 books

    }
    public void verifyThatBooksAreSortAndDisplayedAsSelected()
    {
        String a=getTextFromElement(_priceOfBook1);
        //stores actual price of the product in a string
        String a1=a.replace("$"," ");//removes $ and replaces with space
        String a2=a1.trim();//removes the spaces
        Double a3=Double.parseDouble(a2);//converts string to double
        String b =getTextFromElement(_priceOFBook2);
        String b1=b.replace("$"," ");//removes $ and replaces with space
        String b2=b1.trim();//removes the blank spaces from the string
        Double b3=Double.parseDouble(b2);//converts string to double
        Assert.assertTrue(a3<b3);//compares the condition
    }

}
