package testScenarios;

import listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FlightTicketPage;
import utilities.DriverSetup;


@Slf4j
@Listeners({Listener.class})
public class BuyFlightTicket extends DriverSetup {
    FlightTicketPage flightTicketPage;
    String origin = "İstanbul";
    String destination = "Amsterdam";
    int departureDay = 2;
    int returnDay = 10;
    boolean isDirect = false;
    String provider = "galileo-pegasus";

    @BeforeClass
    public void setup() {
        initializeDriver();
        flightTicketPage = new FlightTicketPage();

        flightTicketPage.closeCookieAlert();
    }

    @Test(description = "Verify successfully selecting origin")
    public void verifyOriginInputField() {
        flightTicketPage.enterOrigin(origin);
        Assert.assertTrue(flightTicketPage.isDisplayedOriginCity());

        flightTicketPage.selectOrigin();
        String selectedOrigin = flightTicketPage.selectedOrigin();

        Assert.assertNotNull(selectedOrigin);
        Assert.assertEquals(selectedOrigin, origin, "Selected origin is verified");
    }

    @Test(priority = 1, description = "Verify successfully selecting destination")
    public void verifyDestinationInputField() {
        flightTicketPage.enterDestination(destination);
        Assert.assertTrue(flightTicketPage.isDisplayedDestinationCity());

        flightTicketPage.selectDestination();
        String selectedDestination = flightTicketPage.selectedDestination();

        Assert.assertNotNull(selectedDestination);
        Assert.assertEquals(selectedDestination,destination,"Selected destination is verified");
    }

    @Test(priority = 2,description = "Verify successfully selecting departure date")
    public void verifyDepartureDateField(){
        flightTicketPage.clickDepartureDay();
        Assert.assertTrue(flightTicketPage.isDisplayedEnabledDays());

        flightTicketPage.selectDepartureDate(departureDay);
        Assert.assertFalse(flightTicketPage.isDisplayedEnabledDays());
    }

    @Test(priority = 3, description = "Verify successfully selecting return date")
    public void verifyReturnDateField(){
        flightTicketPage.clickReturnDay();
        Assert.assertTrue(flightTicketPage.isDisplayedEnabledDays());

        flightTicketPage.selectReturnDate(returnDay);
        Assert.assertFalse(flightTicketPage.isDisplayedEnabledDays());
    }

    @Test(priority = 4, description = "Verify successfully selecting direct or non direct flight")
    public void verifyIsDirectCheckBox(){
        flightTicketPage.selectDirectFlight(isDirect);
        if(isDirect){
            Assert.assertTrue(flightTicketPage.isSelectedDirect());
        }else {
            Assert.assertFalse(flightTicketPage.isSelectedDirect());
        }
    }

    @Test(priority = 5, description = "Verify successfully click find ticket")
    public void verifyFindTicketButton(){
        flightTicketPage.clickFindTicket();
    }

    @Test(priority = 6, description = "Verify successfully selecting departure flight")
    public void verifyDepartureFlight(){
        flightTicketPage.selectDepartureFlight(provider);
        String selectedFlightProvider = flightTicketPage.getSelectedDepartureFlightProvider();

        Assert.assertNotNull(selectedFlightProvider);
        Assert.assertEquals(selectedFlightProvider,provider);
    }

    @Test(priority = 7, description = "Verify successfully selecting return flight")
    public void verifyReturnFlight(){
        flightTicketPage.selectReturnFlight(provider);
        String selectedFlightProvider = flightTicketPage.getSelectedReturnFlightProvider();

        Assert.assertNotNull(selectedFlightProvider);
        Assert.assertEquals(selectedFlightProvider,provider);
    }

    @Test(priority = 8, description = "Verify successfully clicking select button")
    public void verifySelectButton(){
        flightTicketPage.selectFlight();
    }


    /*@Test(description = "Verify successfully buying flight ticket")
    public void verifySuccessfulBuyFlightTicket(){
        flightTicketPage.enterOrigin(origin);
        flightTicketPage.selectOrigin();
        String selectedOrigin = flightTicketPage.selectedOrigin();

        Assert.assertEquals(selectedOrigin,origin,"Selected origin is verified");

        flightTicketPage.enterDestination(destination);
        flightTicketPage.selectDestination();
        String selectedDestination = flightTicketPage.selectedDestination();

        Assert.assertEquals(selectedDestination,destination,"Selected destination is verified");

        flightTicketPage.clickDepartureDay();
        flightTicketPage.selectDepartureDate(departureDay);

        flightTicketPage.clickReturnDay();
        flightTicketPage.selectReturnDate(returnDay);

        flightTicketPage.selectDirectFlight(isDirect);

        flightTicketPage.clickFindTicket();

        flightTicketPage.selectDepartureFlight(provider);

        flightTicketPage.selectReturnFlight(provider);

        flightTicketPage.selectFlight();

    }*/

}
