package PageObjects;

import Util.WebdriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends WebdriverBase {
 By deliveryTime = By.xpath("//*[@class='css-1daqy1u']");

    public void navigateToInstaPage(){
        System.out.println("Launch Instacard ");
        launchUrl(getEnvUrl());

    }

    public void getDeliverTime(){
     System.out.println("Getting Delivery time from All the Stores");
     //System.out.println(getWebElement(deliveryTime).getText());

        List<WebElement> elements = getWebElements(deliveryTime);
        System.out.println("Elements Found "+elements.size());
        for(WebElement e :elements){
            System.out.println(e.getText());
        }

    }

    public void cleanUp(){
        System.out.println("Shutting down the Browser");
        tearDown();
    }
}
