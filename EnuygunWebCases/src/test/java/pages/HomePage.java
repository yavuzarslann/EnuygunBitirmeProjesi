package pages;

import org.openqa.selenium.By;
import utilities.DriverSetup;

public class HomePage extends DriverSetup {
    By cookieAlert = By.xpath("//*[@id='CookieAlert']//button");
    By loginButton = By.id("ctx-LoginBtn");

    public void closeCookieAlert() {
        DriverSetup.driver.findElement(cookieAlert).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
