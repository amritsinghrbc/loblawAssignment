package Util;

import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class WebdriverBase {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    Select select;
    Properties env;
    InputStream input;
    DriverFactory driverFactory;
    // Initialze property file to read which driver to set up

    public WebdriverBase(){
        initialize();
        setUpDriver(env.getProperty("browsername"));
        driver = driverFactory.getDriver();

    }

    public void initialize() {
        if (input == null) {
            System.out.println("Initilising the Property File for Environment");
            String root = System.getProperty("user.dir");
            Path path = Paths.get(root + "/src/test/resources/Config/env.properties");
            try (InputStream input = new FileInputStream(String.valueOf(path))) {
                env = new Properties();
                // load a properties file
                env.load(input);
//                // get the property value and print it out
//                System.out.println(env.getProperty("dev"));
//                System.out.println(env.getProperty("stage"));
//

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }


    public String getEnvUrl() {
        String envToRun = env.getProperty("envToRunTest");
        System.out.println("********The Test will be run on this Environment:- ******* " + envToRun);
        return env.getProperty(envToRun);

    }

    public void launchUrl(String url){
        getEnvUrl();
        driver.get(url);
        WebElement e = driver.findElement(By.cssSelector("#landing"));
        Assert.assertNotNull("Landing Page is visible",e);
        Assert.assertEquals("https://www.instacart.ca/",driver.getCurrentUrl());
    }

    public Properties getPropertyFileReference(){
        return env;
    }

    public void setUpDriver(String browserName){
      System.out.println("Setting up Driver factory");
            driverFactory = new DriverFactory();
            driverFactory.setDriver(browserName);

    }

    public WebElement getWebElement(By element){
        if(element != null){
            System.out.println("Retrieving Weblement using "+element.toString());
            WebElement e = driver.findElement(element);
            highLightElement(e);
            return e;
        }
        return null;
    }

    public List<WebElement> getWebElements(By element){
        if(element != null){
            System.out.println("Retrieving Weblement using "+element.toString());
            List<WebElement> elementList = driver.findElements(element);
           for (WebElement ele : elementList){
               highLightElement(ele);
           }
            return elementList;
        }
        return null;
    }



    private void highLightElement(final WebElement element) {

        try {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].setAttribute('style', 'background: coral; border: 2px solid white;');", element);

        } catch (Exception e) {
            if (e instanceof StaleElementReferenceException) {
                // ignore
            } else {
                System.out.println("Error setting background colour of element");
                e.printStackTrace();
            }
        }
    }


    public void tearDown(){
        System.out.println("Calling  Close Methods on Webdrivers");
        driver.quit();
    }
}





