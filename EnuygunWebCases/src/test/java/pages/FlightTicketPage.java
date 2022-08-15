package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

import java.util.List;

public class FlightTicketPage extends DriverSetup {
    By originInput = By.id("OriginInput");
    By clickOrigin = By.id("react-autowhatever-OriginInput-section-0-item-0");
    By cookieAlert = By.xpath("//*[@id='CookieAlert']//button");
    By destinationInput = By.id("DestinationInput");
    By clickDestination = By.id("react-autowhatever-DestinationInput-section-0-item-0");
    By departureDay = By.id("DepartureDate");
    By returnDay = By.id("ReturnDate");
    By dateEnabled = By.xpath("//td[@aria-disabled='false']");
    By nextMonthBtn = By.xpath("//*[@aria-label='Move forward to switch to the next month.']");
    By findTicket = By.xpath("//button[@class='primary-btn block']");



    public void enterOrigin(String origin) {
        driver.findElement(cookieAlert).click();
        driver.findElement(originInput).click();
        driver.findElement(originInput).sendKeys(origin);
    }

    public void selectOrigin() {
        driver.findElement(clickOrigin).click();
    }

    public void enterDestination(String destination) {
        driver.findElement(destinationInput).click();
        driver.findElement(destinationInput).sendKeys(destination);
    }

    public void selectDestination() {
        driver.findElement(clickDestination).click();
    }

    public void clickDepartureDay() {
        driver.findElement(departureDay).click();
    }

    public void clickReturnDay() {
        driver.findElement(returnDay).click();
    }

    public String getToday() {
        return driver.findElement(departureDay).getAttribute("value");
    }

    public void selectDepartureDate(int daysAfterToday) {
        //this is the list that lists enable to select dates from date picker
        List<WebElement> allDates = driver.findElements(dateEnabled);

        while (true) {
            if (daysAfterToday == 1) {
                break;
            } else {
                String date = allDates.get(daysAfterToday).getAttribute("aria-label");
                String dateArr[] = date.split(" ");

                boolean month = driver.findElement(By.xpath("//strong[contains(text(),'" + dateArr[2] + " 2022')]")).isDisplayed();
                if (month) {
                    break;
                } else {
                    driver.findElement(nextMonthBtn).click();
                }
            }
        }

        driver.findElement(By.xpath("//td[@aria-label='" + allDates.get(daysAfterToday).getAttribute("aria-label") + "']")).click();

    }

    public void selectReturnDate(int daysAfterDeparture){
        List<WebElement> allDates = driver.findElements(dateEnabled);

        while (true) {
            if (daysAfterDeparture == 1) {
                break;
            } else {
                String date = allDates.get(daysAfterDeparture).getAttribute("aria-label");
                String dateArr[] = date.split(" ");

                boolean month = driver.findElement(By.xpath("//strong[contains(text(),'" + dateArr[2] + " 2022')]")).isDisplayed();
                if (month) {
                    break;
                } else {
                    driver.findElement(nextMonthBtn).click();
                }
            }
        }

        driver.findElement(By.xpath("//td[@aria-label='" + allDates.get(daysAfterDeparture).getAttribute("aria-label") + "']")).click();
    }

    public void clickFindTicket(){
        driver.findElement(findTicket).click();
    }
}
