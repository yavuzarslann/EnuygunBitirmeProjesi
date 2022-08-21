package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.slf4j.Slf4j;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

@Slf4j
public class Listener implements ITestListener, IReporter {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest test;

    public void onStart(ITestContext iTestContext) {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        log.info("OnStart for " + iTestContext.getName());
        log.info(iTestContext.getHost());
        log.info(iTestContext.getName());
        log.info(String.valueOf(iTestContext.getStartDate()));
    }

    public void onTestStart(ITestResult iTestResult) {
        log.info(iTestResult.getName()+" test case started");
        if (iTestResult.getMethod().isBeforeClassConfiguration()) {
            log.info(iTestResult.getMethod().getMethodName());
        }
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(iTestResult.getName()+" test is passed");
        test = extentReports.createTest(
                iTestResult.getMethod().getDescription(), String.valueOf(iTestResult.getStatus()));
        test.log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info(iTestResult.getName()+" test is failed");
        test = extentReports.createTest(
                iTestResult.getMethod().getDescription(), String.valueOf(iTestResult.getStatus()));
        test.log(Status.FAIL, "Test failed because of: "+iTestResult.getThrowable().getMessage());
    }

    public void onFinish(ITestContext iTestContext) {
        log.info(String.valueOf(iTestContext.getFailedTests()));
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Enuygun Web Case Test Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extentReports.flush();
    }
}
