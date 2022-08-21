package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSetup;

import java.util.ArrayList;
import java.util.List;

public class FlightTicketPage extends DriverSetup {
    List<WebElement> selectedFlightList;

    By originInput = By.id("OriginInput");
    By clickOrigin = By.id("react-autowhatever-OriginInput-section-0-item-0");
    By destinationInput = By.id("DestinationInput");
    By clickDestination = By.id("react-autowhatever-DestinationInput-section-0-item-0");
    By departureDay = By.id("DepartureDate");
    By returnDay = By.id("ReturnDate");
    By dateEnabled = By.xpath("//td[@aria-disabled='false']");
    By nextMonthBtn = By.xpath("//*[@aria-label='Move forward to switch to the next month.']");
    By findTicket = By.xpath("//button[@class='primary-btn block']");
    By transitFilter = By.id("transitFilter");
    By provider = By.xpath("//div[contains(@class,'flight-list-body')]/div/div/div/div/div/label/div[2][@data-booking-provider='sabre-pegasus']");
    By selectFlightBtn = By.xpath("//button[@id='tooltipTarget_0']");
    By selectFlightBtn2 = By.cssSelector("#tooltipTarget_0");
    By selectedFlights = By.xpath("//*[@class='flight-item round-trip tr  active']");

    public void enterOrigin(String origin) {
        DriverSetup.driver.findElement(originInput).click();
        DriverSetup.driver.findElement(originInput).sendKeys(origin);
    }

    public void selectOrigin() {
        DriverSetup.driver.findElement(clickOrigin).click();
    }

    public boolean isDisplayedOriginCity() {
        return DriverSetup.driver.findElement(clickOrigin).isDisplayed();
    }

    public String selectedOrigin() {
        String value = driver.findElement(originInput).getAttribute("value");
        String[] parts = value.split(",");
        return parts[0];
    }

    public void enterDestination(String destination) {
        DriverSetup.driver.findElement(destinationInput).click();
        DriverSetup.driver.findElement(destinationInput).sendKeys(destination);
    }

    public boolean isDisplayedDestinationCity() {
        return DriverSetup.driver.findElement(clickDestination).isDisplayed();
    }

    public void selectDestination() {
        DriverSetup.driver.findElement(clickDestination).click();
    }

    public String selectedDestination() {
        String value = driver.findElement(destinationInput).getAttribute("value");
        String[] parts = value.split(",");
        return parts[0];
    }

    public void clickDepartureDay() {
        DriverSetup.driver.findElement(departureDay).click();
    }

    public boolean isDisplayedEnabledDays() {
        if (DriverSetup.driver.findElements(dateEnabled).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void clickReturnDay() {
        DriverSetup.driver.findElement(returnDay).click();
    }

    public void selectDepartureDate(int daysAfterToday) {
        //this is the list that lists enable to select dates from date picker
        List<WebElement> allDates = DriverSetup.driver.findElements(dateEnabled);

        while (true) {
            if (daysAfterToday == 1) {
                break;
            } else {
                String date = allDates.get(daysAfterToday).getAttribute("aria-label");
                String dateArr[] = date.split(" ");

                boolean month = DriverSetup.driver.findElement(By.xpath("//strong[contains(text(),'" + dateArr[2] + " 2022')]")).isDisplayed();
                if (month) {
                    break;
                } else {
                    DriverSetup.driver.findElement(nextMonthBtn).click();
                }
            }
        }

        DriverSetup.driver.findElement(By.xpath("//td[@aria-label='" + allDates.get(daysAfterToday).getAttribute("aria-label") + "']")).click();

    }

    public void selectReturnDate(int daysAfterDeparture) {
        List<WebElement> allDates = DriverSetup.driver.findElements(dateEnabled);

        while (true) {
            if (daysAfterDeparture == 1) {
                break;
            } else {
                String date = allDates.get(daysAfterDeparture).getAttribute("aria-label");
                String dateArr[] = date.split(" ");

                boolean month = DriverSetup.driver.findElement(By.xpath("//strong[contains(text(),'" + dateArr[2] + " 2022')]")).isDisplayed();
                if (month) {
                    break;
                } else {
                    DriverSetup.driver.findElement(nextMonthBtn).click();
                }
            }
        }

        DriverSetup.driver.findElement(By.xpath("//td[@aria-label='" + allDates.get(daysAfterDeparture).getAttribute("aria-label") + "']")).click();
    }

    public void selectDirectFlight(boolean isDirect) {
        if (isDirect) {
            driver.findElement(transitFilter).click();
        }
    }

    public boolean isSelectedDirect() {
        return driver.findElement(transitFilter).isSelected();
    }

    public void clickFindTicket() {
        DriverSetup.driver.findElement(findTicket).click();
    }

    public List<WebElement> selectProvider(String provider) {
        List<WebElement> webElementList = new ArrayList();

        webElementList = driver.findElements(By.xpath("//div[contains(@class,'flight-list-body')]/div/div/div/div/div/label/div[2][@data-booking-provider='" + provider + "']"));
        return webElementList;
    }

    public void selectDepartureFlight(String provider) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(selectProvider(provider).get(0)));
            selectProvider(provider).get(0).click();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please give a valid provider as parameter");
        }

        /*WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(selectProvider(provider).get(0)));

        wait.click();*/
        //selectProvider(provider).get(0).click();
        //webElementList.get(0).click();
    }

    public String getSelectedDepartureFlightProvider() {
        selectedFlightList = DriverSetup.driver.findElements(selectedFlights);
        return selectedFlightList.get(0).getAttribute("data-booking-provider");
    }

    public void selectReturnFlight(String provider) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(selectProvider(provider).get(1)));
        selectProvider(provider).get(1).click();
    }

    public String getSelectedReturnFlightProvider() {
        selectedFlightList = DriverSetup.driver.findElements(selectedFlights);
        return selectedFlightList.get(0).getAttribute("data-booking-provider");
    }

    public void selectFlight() {
        DriverSetup.driver.findElement(selectFlightBtn2).click();
    }
}
