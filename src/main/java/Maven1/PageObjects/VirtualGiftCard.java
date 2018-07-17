package Maven1.PageObjects;

import Maven1.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class VirtualGiftCard extends Utils {
   private By _emailAfriendButton=By.className("email-a-friend");
    private By _recipientsnamefield=By.xpath("//input[@id='giftcard_43_RecipientName']");
    private By _recipientsemail=By.xpath("//input[@id='giftcard_43_RecipientEmail']");
    private By _messsageArea=By.xpath("//textarea[@id='giftcard_43_Message']");

   public void selectOptionEmailAFriend()
   {
       clickOnElement(By.className("email-a-friend"));//clicks on button email a friend
   }
   public void fillInGiftCardDetailsMainPage()
   {
    enterText(_recipientsnamefield,"Deep");
    email(_recipientsemail,"deep");
    enterText(_messsageArea,"This is a good Idea!");
   }


}
