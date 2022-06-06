package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    String browserName;
    WebDriver driver;
   // RemoteWebDriver driver;
    Properties env;

    public boolean setDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            System.out.println("Setting Chrome Browser");
            System.setProperty("webdriver.chrome.driver","Webdrivers/chromedriver5");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return true;
        }

        else if(browserName.equalsIgnoreCase("firefox")){
            System.out.println("Setting Firefox Driver Browser");
            System.setProperty("webdriver.gecko.driver","Webdrivers/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return true;
        }
        else{
            System.out.println("The System cannot run the browser "+browserName);
            return false;
        }

    }

    public WebDriver getDriver(){
        System.out.println("Returning the driver");
        return driver;
    }

}
