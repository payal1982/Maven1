package Maven1.PageObjects;

import Maven1.Utils;
import org.openqa.selenium.By;

public class ElectronicsPage extends Utils {

    private By _cameraAndPhotoPicture=By.xpath("//div[@class='item-grid']//child::div[1]//a[contains(text(),'Camera & photo')]");

    public void clickOnCameraAndPhoto()
    {
        clickOnElement(_cameraAndPhotoPicture);//clicks on camera and photo in the list
    }

}
