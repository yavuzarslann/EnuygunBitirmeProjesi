package testScenarios;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FlightTicketPage;
import utilities.DriverSetup;

public class FlightTicketScenarios extends DriverSetup {
    FlightTicketPage flightTicketPage;

    @BeforeClass
    public void setup(){
        initDriver();
        String url = "https://www.enuygun.com/ucak-bileti/";
        driver.get(url);
        flightTicketPage = new FlightTicketPage();
    }

    @Test
    public void verifySuccessfulBuyFlightTicket(){
        flightTicketPage.enterOrigin("İstanbul");
        flightTicketPage.selectOrigin();
        flightTicketPage.enterDestination("Amsterdam");
        flightTicketPage.selectDestination();
        flightTicketPage.clickDepartureDay();
        flightTicketPage.selectDepartureDate(2);
        flightTicketPage.clickReturnDay();
        flightTicketPage.selectReturnDate(20);
        flightTicketPage.clickFindTicket();



    }
}
