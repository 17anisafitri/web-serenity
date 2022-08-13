package starter.pages;

//librar2 untuk elemen
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    //private karena function disini diakai atau dikonsum sama classloginpage aja, jadi tidak
    private By usernameField(){
        return By.id("user-name");
    }

    private By passwordField(){
        return By.id("password");
    }

    private By loginButton(){
        return By.id("login-button");
    } //defini identifier element yang akan berinteraksi dengan automatenya

    private By errorMessage(){
        return By.xpath("//h3[@data-test='error']");
    }


    //memvalidasi kalau sudah ada di halaman Login page yaitu dengan adanya button login Page
    //digunakan untuk membuka urlnya
    @Step
    //mengapa public, karena akan mengkonsum funtion ke dalam Steps atau LoginSteps
    public void openPage(){
        open();
    }

    @Step
    public boolean validateOnLoginPage() {
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputUsername(String username){
        $(usernameField()).type(username);
    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }

    //boolean karena kita mau return true atau false
    @Step
    public boolean errorMessageDisplayed(){
        return $(errorMessage()).isDisplayed();
    }

    //assertion equal atau ngga
    @Step
    public boolean validateEqualErrorMessage(String message){
        return $(errorMessage()).getText().equalsIgnoreCase(message);
    }



}
