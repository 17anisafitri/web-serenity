package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.HomePage;
import starter.pages.LoginPage;


public class LoginSteps {
    @Steps
   LoginPage loginPage;

    @Steps
    HomePage homePage;

    @Given("I am on the login page")
    public void onTheLoginPage(){
        loginPage.openPage();
        loginPage.validateOnLoginPage();
    }

    @When("I input valid username")
    public void InputValidUsername(){
        loginPage.inputUsername("standard_user");

    }
    @And("I input valid password")
    public void inputValidPassword(){
        loginPage.inputPassword("secret_sauce");
    }

    @And("I click Login button")
    public void clickLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("I am on the home page")
    public void onTheHomePage(){
        homePage.validateOnHomePage();
    }


    @When("I input locked username")
    public void iInputLockedUsername() {
        loginPage.inputUsername("locked_out_user");
        
    }

    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String message) {
        //ada 2 validate, eror msg displaye
        loginPage.errorMessageDisplayed();
        loginPage.validateEqualErrorMessage(message);
    }

    @When("I input {string} username")
    public void iInputUsername(String username) {
        loginPage.inputUsername(username);
    }
}
