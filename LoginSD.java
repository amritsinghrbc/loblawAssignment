package StepDefinations;

import PageObjects.LandingPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {
    public LandingPage landingPage = new LandingPage() ;

    @Given("^Navigate to the Instacard Page$")
    public void navigateToInstaPage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Launch The Insta Page");
        // launch the instacart page
        landingPage.navigateToInstaPage();
    }
    @When("^Get Delivery Times and print it on Screen$")
    public void getDeliveryTimes() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.getDeliverTime();

    }

    @When("^user enters Test Hooks Page$")
    public void testHooksPage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user enters Test Hooks Page");

    }
    @Then("^user is navigated to home page$")
    public void user_is_navigated_to_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user is navigated to home page");

    }

    @After
    public void cleanUp(){
       System.out.println("Closing the Driver ");
       landingPage.cleanUp();

    }
}
